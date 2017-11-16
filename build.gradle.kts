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

val rome_gson = "com.google.code.gson:gson:2.8.2"   //就是要返回一个字符串，通过 task 的方式返回

// DependencyHandlerScope -> DependencyHandler
dependencies {
    compile(kotlin("stdlib"))   // DependencyHandler 的扩展方法
    compile(rome_gson)
}

repositories {
    jcenter()
}

task("hello") {
    println("Hello World")
    println(pluginManager.hasPlugin("org.gradle.application"))
}

exec{

}

//Should Read the Source Code