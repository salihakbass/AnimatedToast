package com.salihakbas.animatedtoast.state

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.salihakbas.animatedtoast.model.ToastIcon
import com.salihakbas.animatedtoast.model.ToastModel
import com.salihakbas.animatedtoast.model.ToastType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object ToastState {
    val isVisible = mutableStateOf(false)
    val message = mutableStateOf("")
    val type = mutableStateOf(ToastType.INFO)
    val backgroundColor = mutableStateOf(Color.Companion.Unspecified)
    val textColor = mutableStateOf(Color.Companion.White)
    val textFontSize = mutableStateOf(16.sp)
    val textFontWeight = mutableStateOf(FontWeight.Companion.SemiBold)
    val textAlign = mutableStateOf(TextAlign.Companion.Center)
    val leadingIcon = mutableStateOf<ToastIcon>(ToastIcon.VectorIcon(Icons.Default.Info))

    private val toastQueue = mutableListOf<ToastModel>()
    private var currentJob: Job? = null
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    fun enqueueToast(toast: ToastModel) {
        toastQueue.add(toast)
        if (!isVisible.value) {
            showNextToast()
        }
    }

    private fun showNextToast() {
        if (toastQueue.isNotEmpty()) {
            val nextToast = toastQueue.removeAt(0)
            message.value = nextToast.message
            type.value = nextToast.type
            backgroundColor.value = nextToast.backgroundColor
            textColor.value = nextToast.textColor
            textFontSize.value = nextToast.fontSize
            textFontWeight.value = nextToast.fontWeight
            textAlign.value = nextToast.textAlign
            leadingIcon.value = nextToast.leadingIcon
            isVisible.value = true

            currentJob?.cancel()
            currentJob = scope.launch {
                delay(nextToast.durationMillis)
                isVisible.value = false
                delay(600)
                showNextToast()
            }
        }
    }

    fun dismissCurrentToast() {
        currentJob?.cancel()
        currentJob = null
        isVisible.value = false
        scope.launch {
            delay(600)
            if (toastQueue.isNotEmpty()) {
                showNextToast()
            }
        }
    }
}