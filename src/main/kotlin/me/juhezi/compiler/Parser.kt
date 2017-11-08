package me.juhezi.compiler

/**
 * Created by Juhezi on 2017/11/8.
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
