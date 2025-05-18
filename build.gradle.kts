import com.github.spotbugs.snom.Confidence
import com.github.spotbugs.snom.Effort

plugins {
    id("java")
    id("application")
    id("checkstyle")
    id("com.diffplug.spotless") version "7.0.3"
    id("com.github.spotbugs") version "6.1.11"
    id("pmd")
    id("jacoco")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

application {
    mainClass.set("org.example.Main")
}

checkstyle {
    toolVersion = "10.23.1"
    configFile = file("config/checkstyle/checkstyle.xml")
    isShowViolations = true
}

spotless {
    java {
        removeUnusedImports()
        cleanthat()
        googleJavaFormat()
            .aosp()
        endWithNewline()
        trimTrailingWhitespace()
        target("src/**/*.java")
    }
}

pmd {
    isConsoleOutput = true
    toolVersion = "7.0.0"
    rulesMinimumPriority = 5
    ruleSetFiles = files("config/pmd/ruleset.xml")
}

spotbugs {
    toolVersion = "4.8.6"
    spotbugs.effort.set(Effort.MAX)
    spotbugs.reportLevel.set(Confidence.LOW)

}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(deps.slf4j.api)
    runtimeOnly(deps.logback.classic)

    testImplementation(platform(deps.junit.bom))
    testImplementation(deps.junit.jupiter)
}

tasks.test {
    useJUnitPlatform()

    testLogging {
        events("passed", "skipped", "failed")
        showStandardStreams = true
    }

    finalizedBy(tasks.jacocoTestReport)
}

tasks.check {
    dependsOn(tasks.spotlessCheck)
    dependsOn(tasks.spotbugsMain)
    dependsOn(tasks.pmdMain)
    dependsOn(tasks.checkstyleMain)
    dependsOn(tasks.spotbugsTest)
    dependsOn(tasks.pmdTest)
    dependsOn(tasks.checkstyleTest)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
}
