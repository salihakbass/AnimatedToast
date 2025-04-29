package com.salihakbas.animatedtoast.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector

enum class ToastType(
    val icon: ImageVector
) {
    SUCCESS(icon = Icons.Filled.CheckCircle),
    ERROR(icon = Icons.Filled.Warning),
    INFO(icon = Icons.Filled.Info)
}