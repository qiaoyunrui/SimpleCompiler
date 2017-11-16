package me.juhezi.compiler

import me.juhezi.compiler.io.Input
import me.juhezi.compiler.io.Output
import me.juhezi.compiler.io.string.StringInput
import me.juhezi.compiler.io.string.StringOutput

/**
 * 中缀表达式变后缀表达式
 * Created by Juhezi on 2017/11/8.
 */
/**
 * expr -> term rest
 * rest -> + term { print('+') } rest
 *      |  - term { print('-') } rest
 *      |  e
 * term -> 0 { print('0') }
 *      |  1 { print('1') }
 *      ...
 *      |  9 { print('9') }
 *
 * 9 - 5 + 2
 */
class Parser {

    private var lookahead: Char = 0.toChar()
    lateinit var input: Input
    var output: Output = StringOutput()
        private set

    fun expr() {
        lookahead = input.read()
        term()
        rest()
    }

    private fun rest() {
        when (lookahead) {
            '+' -> {
                match('+')
                term()
                output.write('+')
                rest()
            }
            '-' -> {
                match('-')
                term()
                output.write('-')
                rest()
            }
            else -> {
                /*不做任何处理*/
            }
        }
    }

    private fun term() {
        if (Character.isDigit(lookahead)) {
            output.write(lookahead)
            match(lookahead)
        } else throw Error("syntax error")
    }

    private fun match(t: Char) {
        if (lookahead == t) {
            lookahead = input.read()
        } else throw Error("syntax error")
    }

}
