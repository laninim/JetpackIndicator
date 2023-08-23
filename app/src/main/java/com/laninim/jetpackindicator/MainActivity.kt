package com.laninim.jetpackindicator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.laninim.jetpackindicator.ui.theme.JetpackIndicatorTheme
import com.laninim.jetpack_indicator.ArcIndicator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackIndicatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    Column(
                        modifier = Modifier.padding(top = 64.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ArcIndicator(
                            indicatorSize = 150.dp,
                            progressValue = 23,
                            maxProgressValue = 100,
                            foregroundColor = Color.Green,
                            glowLight = true,
                            showPercentage = true,
                            textStyle = TextStyle(
                                fontSize = 34.sp,
                                color = Color.White
                            )
                        )
                    }
                }
            }
        }
    }
}

