package me.juhezi.compiler

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

    companion object {
        var lookahead = 0
    }

    init {
        lookahead = System.`in`.read()
    }

    fun expr() {
        term()
        while (true) {
            when (lookahead) {
                '+'.toInt() -> {
                    match('+'.toInt())
                    term()
                    print('+')
                }
                '-'.toInt() -> {
                    match('-'.toInt())
                    term()
                    print('-')
                }
                else -> return
            }
        }
    }

    private fun term() {
        if (Character.isDigit(lookahead.toChar())) {
            print(lookahead.toChar()) //Need Change
            match(lookahead)
        } else throw Error("syntax error")
    }

    private fun match(t: Int) {
        if (lookahead == t) {
            lookahead = System.`in`.read()
        } else throw Error("syntax error")
    }

}
