package com.m2f.engine

import com.m2f.engine.model.*

fun Canvas.rebound(bound: Bounds, onDraw: Canvas.() -> Unit) {
    onDraw(copy(bound))
}

fun Bounds.calculateBoundWithPadding(padding: Padding): Bounds {
    val left = padding.paddingLeft * width
    val right = padding.paddingRight * width
    val top = padding.paddingTop * height
    val bottom = padding.paddingBottom * height

    return bounds(
        position = position(x + left, y + bottom),
        size = size(width - right - left, height - top - bottom)
    )
}