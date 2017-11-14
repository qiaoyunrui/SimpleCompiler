package me.juhezi.compiler.io.string

import me.juhezi.compiler.io.Output

/**
 * 把内容写入到字符串中
 * Created by Juhezi on 2017/11/14.
 */
class StringOutput : Output {

    private var mStringBuilder: StringBuilder = StringBuilder()

    override fun write(char: Char) {
        mStringBuilder.append(char)
    }

    fun size() = mStringBuilder.length

    override fun toString() = mStringBuilder.toString()

}
