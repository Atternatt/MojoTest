package com.m2f.mojoeditor.components

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.m2f.engine.calculateBoundWithPadding
import com.m2f.engine.model.Item
import com.m2f.engine.rebound
import com.m2f.engine.Canvas as EngineCanvas

@Composable
fun MojoCanvas(modifier: Modifier, onDraw: EngineCanvas.() -> Unit) {
    Canvas(modifier = modifier) {
        onDraw(EngineCanvas(this))
    }
}

fun Item.draw(canvas: EngineCanvas, onDrawInBounds: EngineCanvas.() -> Unit = {}) {
    canvas.drawRect(color, padding, this)
    val bounds = calculateBoundWithPadding(padding)
    canvas.rebound(bounds) {
        onDrawInBounds(this)
    }
}