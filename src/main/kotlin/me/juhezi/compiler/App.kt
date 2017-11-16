package me.juhezi.compiler

import me.juhezi.compiler.io.string.StringInput

/**
 * Created by Juhezi on 2017/11/8.
 */
fun main(args: Array<String>) {
    val parser = Parser()
    parser.input = StringInput().build { append("3+5-2") }
    parser.expr()
    println(parser.output)
}
