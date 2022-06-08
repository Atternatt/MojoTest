package com.m2f.engine

import android.util.Log
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.*
import com.m2f.engine.model.*
import com.m2f.engine.model.Color as EngineColor


actual class Canvas(
    scope: DrawScope,
    bounds: Bounds = bounds(
        position = position(
            x = (scope.center.x - (scope.size.width / 2)) / scope.size.width,
            y = (scope.center.y - (scope.size.height / 2)) / scope.size.height
        ),
        size = size(
            width = 1f,
            height = 1f
        )
    )
) : Bounds by bounds, DrawScope by scope {

    actual fun drawRect(color: EngineColor, padding: Padding, bounds: Bounds) {
        val canvasW = this@Canvas.width * size.width
        val canvasH = this@Canvas.height * size.height

        val canvasX = (this@Canvas.x * size.width)
        val canvasY = (this@Canvas.y * size.height)

        val boundsWithPadding: Bounds = bounds.calculateBoundWithPadding(padding)
        scale(1f, -1f) {

            val w = boundsWithPadding.width * canvasW
            val h = boundsWithPadding.height * canvasH
            val x = boundsWithPadding.x * canvasW + canvasX
            val y = boundsWithPadding.y * canvasH + canvasY

            Log.d("Rel Bounds", "w= $w, h= $h, x= $x, y= $y, " +
                    "canvasW= $canvasW " +
                    "canvasH= $canvasH " +
                    "canvasX= $canvasX " +
                    "canvasY= $canvasY ")
             drawRect(
                color = Color(color.background),
                size = Size(
                    w,
                    h
                ),
                topLeft = Offset(
                    x,
                    y
                )
            )
        }
    }

    actual fun copy(bounds: Bounds): Canvas = Canvas(this, bounds)
}