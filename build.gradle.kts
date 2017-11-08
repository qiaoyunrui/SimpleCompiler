plugins {
    application
    kotlin("jvm") version "1.1.51"
}

application {
    mainClassName = "demo.AppKt"
}

dependencies {
    compile(kotlin("stdlib"))
}

repositories {
    jcenter()
}