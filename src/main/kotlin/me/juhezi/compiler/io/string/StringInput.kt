package me.juhezi.compiler.io.string

import me.juhezi.compiler.io.Input
import java.util.NoSuchElementException

/**
 * 从字符串中获取内容
 * Created by Juhezi on 2017/11/14.
 */
class StringInput : Input, Iterator<Char> {

    private var mStringBuilder: StringBuilder = StringBuilder()
    var mCursor = 0

    override fun read(): Char = next()

    override fun hasNext() = mCursor != mStringBuilder.length

    override fun next(): Char {
        val i = mCursor
        if (i >= mStringBuilder.length) {
            throw NoSuchElementException()
        }
        mCursor = i + 1
        return mStringBuilder[i]
    }

    fun build(function: StringBuilder.() -> Unit) = mStringBuilder.apply(function)

}