package com.salihakbas.animatedtoast.model

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ToastIcon {
    data class VectorIcon(val imageVector: ImageVector) : ToastIcon()
    data class PainterIcon(val painter: Painter) : ToastIcon()
}