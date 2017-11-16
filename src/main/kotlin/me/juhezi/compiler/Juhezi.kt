package me.juhezi.compiler

/**
 * 中缀表达式变后缀表达式
 * Created by Juhezi on 2017/11/14.
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

var lookahead = ""

fun expr() {
    term()
    rest()
}

fun rest() {
    when (lookahead) {
        "+" -> {
            match("+")
            term()
            print("+")
            rest()
        }
        "-" -> {
            match("-")
            term()
            print("-")
            rest()
        }
        else -> {
            /*不对输入做任何处理*/
        }
    }
}

fun term() {
    if (lookahead.length == 1) {    //这里的代码仅仅是作为一个站位符，真实的意义是是一个数字
        val t = lookahead
        match(lookahead)
        print(t)
    } else {
        throw Error("语法错误")
    }
}

fun match(content: String) {}