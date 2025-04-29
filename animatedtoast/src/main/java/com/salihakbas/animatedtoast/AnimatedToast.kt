package com.salihakbas.animatedtoast

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.salihakbas.animatedtoast.model.ToastIcon
import com.salihakbas.animatedtoast.model.ToastModel
import com.salihakbas.animatedtoast.model.ToastType
import com.salihakbas.animatedtoast.state.ToastState
import com.salihakbas.animatedtoast.util.ToastDefaults

object AnimatedToast {

    fun showSuccess(
        message: String,
        durationMillis: Long = 2500L,
        backgroundColor: Color = ToastDefaults.successColor,
        textColor: Color = Color.Companion.White,
        fontSize: TextUnit = 16.sp,
        fontWeight: FontWeight = FontWeight.Companion.SemiBold,
        textAlign: TextAlign = TextAlign.Companion.Center,
        leadingIcon: ToastIcon = ToastIcon.VectorIcon(Icons.Default.CheckCircle)
    ) {
        enqueueToast(
            message,
            ToastType.SUCCESS,
            durationMillis,
            backgroundColor,
            textColor,
            fontSize,
            fontWeight,
            textAlign,
            leadingIcon
        )
    }

    fun showError(
        message: String,
        durationMillis: Long = 2500L,
        backgroundColor: Color = ToastDefaults.errorColor,
        textColor: Color = Color.Companion.White,
        fontSize: TextUnit = 16.sp,
        fontWeight: FontWeight = FontWeight.Companion.SemiBold,
        textAlign: TextAlign = TextAlign.Companion.Center,
        leadingIcon: ToastIcon = ToastIcon.VectorIcon(Icons.Default.Warning)
    ) {
        enqueueToast(
            message,
            ToastType.ERROR,
            durationMillis,
            backgroundColor,
            textColor,
            fontSize,
            fontWeight,
            textAlign,
            leadingIcon
        )
    }

    fun showInfo(
        message: String,
        durationMillis: Long = 2500L,
        backgroundColor: Color = ToastDefaults.infoColor,
        textColor: Color = Color.Companion.White,
        fontSize: TextUnit = 16.sp,
        fontWeight: FontWeight = FontWeight.Companion.SemiBold,
        textAlign: TextAlign = TextAlign.Companion.Center,
        leadingIcon: ToastIcon = ToastIcon.VectorIcon(Icons.Default.Info)
    ) {
        enqueueToast(
            message,
            ToastType.INFO,
            durationMillis,
            backgroundColor,
            textColor,
            fontSize,
            fontWeight,
            textAlign,
            leadingIcon
        )
    }

    private fun enqueueToast(
        message: String,
        type: ToastType,
        durationMillis: Long,
        backgroundColor: Color,
        textColor: Color,
        fontSize: TextUnit,
        fontWeight: FontWeight,
        textAlign: TextAlign,
        leadingIcon: ToastIcon
    ) {
        ToastState.enqueueToast(
            ToastModel(
                message = message,
                type = type,
                durationMillis = durationMillis,
                backgroundColor = backgroundColor,
                textColor = textColor,
                fontSize = fontSize,
                fontWeight = fontWeight,
                textAlign = textAlign,
                leadingIcon = leadingIcon
            )
        )
    }
}