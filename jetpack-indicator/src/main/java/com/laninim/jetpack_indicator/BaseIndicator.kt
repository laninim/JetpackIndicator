package com.laninim.jetpack_indicator


import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp



@Composable
fun CustomComponents(
    modifier : Modifier = Modifier,
    indicatorSize : Dp,
    backgroundColor : Color = Color.Gray,
    foregroundColor : Color = Color.Red,
    indicatorStrokeWidth: Float = 70f,
    progressValue : Int,
    maxProgressValue : Int,

) {

    val animatedIndicatorValue = remember { Animatable(initialValue = 0f) }

    LaunchedEffect(key1 = progressValue){
        animatedIndicatorValue.animateTo(progressValue.toFloat())
    }

    val percentage = (animatedIndicatorValue.value / maxProgressValue) * 100

    val sweepAngle by animateFloatAsState(
        targetValue = (2.4 * percentage).toFloat(),
        animationSpec = tween(1000), label = "sweepangleanimation"
    )


    Canvas(modifier = modifier.size(indicatorSize)){
        val componentSize = this.size / 1.25f
        backgroundIndicator(
            componentSize = componentSize,
            indicatorStrokeWidth = indicatorStrokeWidth,
            backgroundColor = backgroundColor
        )


        foregroundIndicator(
            componentSize = componentSize,
            foregroundColor = foregroundColor,
            sweepAngle = sweepAngle,
            indicatorStrokeWidth = indicatorStrokeWidth
        )
    }
}

private fun DrawScope.backgroundIndicator(
    componentSize : Size,
    indicatorStrokeWidth : Float,
    backgroundColor: Color,

    ) {
    drawArc(
        color = backgroundColor,
        useCenter = false,
        startAngle = 150f,
        sweepAngle = 240f,
        size = componentSize,
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2 ,
            y = (size.height - componentSize.height) / 2
        ),
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Round
        )
    )
}

private fun DrawScope.foregroundIndicator(
    componentSize : Size,
    sweepAngle : Float,
    foregroundColor: Color,
    indicatorStrokeWidth: Float
){
    drawArc(
        color = foregroundColor,
        useCenter = false,
        startAngle = 150f,
        sweepAngle = sweepAngle,
        size = componentSize,
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2 ,
            y = (size.height - componentSize.height) / 2
        ),
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Round
        )
    )
}

