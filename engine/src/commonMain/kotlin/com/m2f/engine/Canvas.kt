package com.m2f.engine

import com.m2f.engine.model.Bounds
import com.m2f.engine.model.Color
import com.m2f.engine.model.Padding

expect class Canvas: Bounds {
    fun drawRect(color: Color, padding: Padding, bounds: Bounds)
    fun copy(bounds: Bounds): Canvas
}