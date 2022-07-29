package com.example

import org.slf4j.Logger

class DependencyTestKotlin {
    fun LogMe(l: Logger): Boolean {
        l.debug("xxx")
        return true
    }
}