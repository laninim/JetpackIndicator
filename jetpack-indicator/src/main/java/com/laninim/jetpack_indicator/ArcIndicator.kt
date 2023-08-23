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
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.Dp
import com.laninim.jetpack_indicator.exception.MissingTextStyle


/**
 * A composable function to create an arc indicator with customizable properties.
 *
 * @param modifier The modifier to apply to the composable.
 * @param indicatorSize The size of the indicator.
 * @param backgroundColor The color of the background arc.
 * @param foregroundColor The color of the foreground arc.
 * @param indicatorStrokeWidth The stroke width of the arcs.
 * @param progressValue The current progress value.
 * @param maxProgressValue The maximum progress value.
 * @param glowLight Set to true to enable a glowing effect around the arc.
 * @param showPercentage Set to true to show the percentage text in the center of the indicator.
 * @param textStyle The text style for the percentage text.
 */

@OptIn(ExperimentalTextApi::class)
@Composable
fun ArcIndicator(
    modifier : Modifier = Modifier,
    indicatorSize : Dp,
    backgroundColor : Color = Color.Gray,
    foregroundColor : Color = Color.Red,
    indicatorStrokeWidth: Float = 70f,
    progressValue : Int,
    maxProgressValue : Int,
    glowLight : Boolean? = null,
    showPercentage : Boolean,
    textStyle: TextStyle? = null

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

    val textMeasurer = rememberTextMeasurer()


    Canvas(modifier = modifier.size(indicatorSize)){
        val componentSize = this.size / 1.25f
        backgroundIndicator(
            componentSize = componentSize,
            indicatorStrokeWidth = indicatorStrokeWidth,
            backgroundColor = backgroundColor
        )

        if(glowLight != null && glowLight == true){
            drawBlur(
                componentSize = componentSize,
                indicatorStrokeWidth = indicatorStrokeWidth,
                backgroundColor = foregroundColor,
                sweepAngle = sweepAngle
            )
        }


        foregroundIndicator(
            componentSize = componentSize,
            foregroundColor = foregroundColor,
            sweepAngle = sweepAngle,
            indicatorStrokeWidth = indicatorStrokeWidth
        )

        if(showPercentage){
            //se la percentuale è attiva ma non è stato definito un textstyle.
            if(textStyle == null){
                throw MissingTextStyle("If u want show percentage.. need define a textstyle")
            }
            textPercentage(percentage.toInt(), textMeasurer, textStyle = textStyle
            )
        }

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

private fun DrawScope.drawBlur(
    componentSize : Size,
    indicatorStrokeWidth : Float,
    backgroundColor: Color,
    sweepAngle: Float

    ) {
    for(i in 0..200){
        drawArc(
            color = backgroundColor.copy(alpha =  i / 900f),
            useCenter = false,
            startAngle = 150f,
            sweepAngle = sweepAngle,
            size = componentSize,
            topLeft = Offset(
                x = (size.width - componentSize.width) / 2 ,
                y = (size.height - componentSize.height) / 2
            ),
            style = Stroke(
                width = indicatorStrokeWidth + ( 15 - i) * 20,
                cap = StrokeCap.Round
            )
        )
    }
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

@OptIn(ExperimentalTextApi::class)
private fun DrawScope.textPercentage(
    percentage : Int,
    textMeasurer: TextMeasurer,
    textStyle : TextStyle
) {
    val textLayoutResult =  textMeasurer.measure("$percentage%", style = textStyle)

    drawText(
        textLayoutResult = textLayoutResult,
        topLeft = Offset(
            x = (size.width - textLayoutResult.size.width) / 2f,
            y = (size.height - textLayoutResult.size.height) / 2f
        )
    )
}

