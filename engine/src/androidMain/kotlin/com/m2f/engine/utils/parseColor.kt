package com.m2f.engine.utils

actual fun String.parseColor(): Long {
    if (this[0] == '#') { // Use a long to avoid rollovers on #ffXXXXXX
        var color = substring(1).toLong(16)
        if (length == 7) { // Set the alpha value
            color = color or -0x1000000
        } else require(length == 9) { "Unknown color" }
        return color
    }
    throw IllegalArgumentException("Unknown color")
}