package com.example

import io.kotest.matchers.string.shouldStartWith
import org.junit.Test

internal class ExampleTest {

    @Test
    fun testSum() {
        Greeting.sayHi()
        assert(2 + 2 == 4)
        "foobar".shouldStartWith("foo")
        "qux" shouldStartWith "q"
    }
}