package com.salihakbas.animatedtoast.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit

data class ToastModel(
    val message: String,
    val type: ToastType,
    val durationMillis: Long,
    val backgroundColor: Color,
    val textColor: Color,
    val fontSize: TextUnit,
    val fontWeight: FontWeight,
    val textAlign: TextAlign,
    val leadingIcon: ToastIcon = ToastIcon.VectorIcon(
        when (type) {
            ToastType.SUCCESS -> Icons.Filled.CheckCircle
            ToastType.ERROR -> Icons.Filled.Warning
            ToastType.INFO -> Icons.Filled.Info
        }
    )
)