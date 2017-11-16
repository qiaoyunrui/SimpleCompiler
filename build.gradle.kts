// PluginDependenciesSpec
plugins {
    application     //org.gradle.application
    kotlin("jvm") version "1.1.51"
}

// ApplicationPluginConvention
application {
    mainClassName = "me.juhezi.compiler.AppKt"
    applicationName = "SimpleCompiler"
}

// DependencyHandlerScope -> DependencyHandler
dependencies {
    compile(kotlin("stdlib"))   // DependencyHandler 的扩展方法
    testCompile("junit:junit:4.12")
}

repositories {
    jcenter()
}

//Should Read the Source Code