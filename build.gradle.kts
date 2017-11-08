plugins {
    application
    kotlin("jvm") version "1.1.51"
}

application {
    mainClassName = "me.juhezi.compiler.AppKt"
}

dependencies {
    compile(kotlin("stdlib"))
}

repositories {
    jcenter()
}

//Should Read the Source Code