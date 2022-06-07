package com.m2f.engine.model

sealed interface Bounds : Position, Size

internal data class BoundsData(private val position: Position, private val size: Size) : Bounds {
    override val x: Float = position.x
    override val y: Float = position.y
    override val width: Float = size.width
    override val height: Float = size.height

}

fun bounds(position: Position, size: Size): Bounds = BoundsData(position, size)

sealed interface Position {
    val x: Float
    val y: Float
}

internal data class PositionData(
    override val x: Float,
    override val y: Float
) : Position

fun position(x: Float, y: Float): Position = PositionData(x, y)

sealed interface Size {
    val width: Float
    val height: Float
}

internal data class SizeData(override val width: Float, override val height: Float) : Size

fun size(width: Float, height: Float): Size = SizeData(width, height)

sealed interface Color {
    val background: String
}

internal data class ColorData(override val background: String) : Color

fun color(background: String): Color = ColorData(background)

class Item(
    private val position: Position,
    private val size: Size,
    private val color: Color
) : Bounds by bounds(position, size),
    Color by color