package com.salihakbas.animatedtoast.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.salihakbas.animatedtoast.model.ToastIcon
import com.salihakbas.animatedtoast.model.ToastType
import com.salihakbas.animatedtoast.state.ToastState
import com.salihakbas.animatedtoast.util.ToastDefaults

@Composable
fun AnimatedToastHost() {

    val isVisible by ToastState.isVisible
    val message by ToastState.message
    val type by ToastState.type

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn() + slideInHorizontally(),
            exit = fadeOut() + slideOutHorizontally { 100 }
        ) {
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (ToastState.backgroundColor.value != Color.Unspecified) {
                        ToastState.backgroundColor.value
                    } else when (type) {
                        ToastType.SUCCESS -> ToastDefaults.successColor
                        ToastType.ERROR -> ToastDefaults.errorColor
                        ToastType.INFO -> ToastDefaults.infoColor
                    }
                )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp, horizontal = 24.dp)
                ) {
                    when (val icon = ToastState.leadingIcon.value) {
                        is ToastIcon.VectorIcon -> {
                            Icon(
                                imageVector = icon.imageVector,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimary,
                                modifier = Modifier
                                    .size(24.dp)
                                    .align(Alignment.CenterStart)
                            )
                        }

                        is ToastIcon.PainterIcon -> {
                            Icon(
                                painter = icon.painter,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimary,
                                modifier = Modifier
                                    .size(24.dp)
                                    .align(Alignment.CenterStart)
                            )
                        }
                    }

                    Text(
                        text = message,
                        fontSize = ToastState.textFontSize.value,
                        fontWeight = ToastState.textFontWeight.value,
                        color = ToastState.textColor.value,
                        textAlign = ToastState.textAlign.value,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(horizontal = 48.dp)
                    )

                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .align(Alignment.CenterEnd)
                            .background(
                                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                                shape = CircleShape
                            )
                            .clickable { ToastState.dismissCurrentToast() },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }
        }
    }
}