package com.m2f.engine.model

import com.m2f.engine.Canvas

//region Bounds
interface Bounds : Position, Size

internal data class BoundsData(private val position: Position, private val size: Size) : Bounds {
    override val x: Float = position.x
    override val y: Float = position.y
    override val width: Float = size.width
    override val height: Float = size.height

}

fun bounds(position: Position, size: Size): Bounds = BoundsData(position, size)
//endregion

//region Position
sealed interface Position {
    val x: Float
    val y: Float
}

internal data class PositionData(
    override val x: Float,
    override val y: Float
) : Position

fun position(x: Float = 0f, y: Float = 0f): Position = PositionData(x, y)
//endregion

//region Size
sealed interface Size {
    val width: Float
    val height: Float
}

internal data class SizeData(override val width: Float, override val height: Float) : Size

fun size(width: Float, height: Float): Size = SizeData(width, height)
//endregion

//region Color
sealed interface Color {
    val background: Long
}

internal data class ColorData(override val background: Long) : Color

fun color(background: Long): Color = ColorData(background)
//endregion

//region Padding
sealed interface Padding {
    val paddingTop: Float
    val paddingBottom: Float
    val paddingLeft: Float
    val paddingRight: Float
}

internal data class FullPadding(val padding: Float) : Padding {
    override val paddingTop: Float
        get() = padding
    override val paddingBottom: Float
        get() = padding
    override val paddingLeft: Float
        get() = padding
    override val paddingRight: Float
        get() = padding

}

internal data class VerticalPadding(val padding: Float) : Padding {
    override val paddingTop: Float
        get() = padding
    override val paddingBottom: Float
        get() = padding
    override val paddingLeft: Float
        get() = 0f
    override val paddingRight: Float
        get() = 0f

}

internal data class HorizontalPadding(val padding: Float) : Padding {
    override val paddingTop: Float
        get() = 0f
    override val paddingBottom: Float
        get() = 0f
    override val paddingLeft: Float
        get() = padding
    override val paddingRight: Float
        get() = padding
}

internal data class TopPadding(val padding: Float) : Padding {
    override val paddingTop: Float
        get() = padding
    override val paddingBottom: Float
        get() = 0f
    override val paddingLeft: Float
        get() = 0f
    override val paddingRight: Float
        get() = 0f

}

internal data class BottomPadding(val padding: Float) : Padding {
    override val paddingTop: Float
        get() = 0f
    override val paddingBottom: Float
        get() = padding
    override val paddingLeft: Float
        get() = 0f
    override val paddingRight: Float
        get() = 0f

}

internal data class LeftPadding(val padding: Float) : Padding {
    override val paddingTop: Float
        get() = 0f
    override val paddingBottom: Float
        get() = 0f
    override val paddingLeft: Float
        get() = padding
    override val paddingRight: Float
        get() = 0f

}

internal data class RightPadding(val padding: Float) : Padding {
    override val paddingTop: Float
        get() = 0f
    override val paddingBottom: Float
        get() = 0f
    override val paddingLeft: Float
        get() = 0f
    override val paddingRight: Float
        get() = padding
}

internal data class ComposedPadding(
    override val paddingTop: Float,
    override val paddingBottom: Float,
    override val paddingLeft: Float,
    override val paddingRight: Float
) : Padding

fun noPadding(): Padding = fullPadding(0f)
fun fullPadding(value: Float): Padding = FullPadding(value)
fun verticalPadding(value: Float): Padding = VerticalPadding(value)
fun horizontalPadding(value: Float): Padding = HorizontalPadding(value)
fun topPadding(value: Float): Padding = TopPadding(value)
fun bottomPadding(value: Float): Padding = BottomPadding(value)
fun leftPadding(value: Float): Padding = LeftPadding(value)
fun rightPadding(value: Float): Padding = RightPadding(value)
fun padding(
    paddingTop: Float,
    paddingBottom: Float,
    paddingLeft: Float,
    paddingRight: Float
): Padding = ComposedPadding(paddingTop, paddingBottom, paddingLeft, paddingRight)
//endregion

//region Anchor
sealed interface Anchor

sealed interface AnchorX : Anchor
object Left : AnchorX
object CenterX : AnchorX
object Right : AnchorX

sealed interface AnchorY : Anchor
object Top : AnchorY
object CenterY : AnchorY
object Bottom : AnchorY
//endregion

data class Item internal constructor(
    val position: Position,
    val size: Size,
    val color: Color,
    val padding: Padding,
    val anchorX: AnchorX,
    val anchorY: AnchorY
) : Bounds by bounds(position, size),
    Color by color,
    Padding by padding,
    AnchorX by anchorX,
    AnchorY by anchorY

fun item(
    size: Size,
    color: Color,
    position: Position = position(),
    padding: Padding = noPadding(),
    anchorX: AnchorX = Left,
    anchorY: AnchorY = Bottom
): Item = Item(position, size, color, padding, anchorX, anchorY)