package com.laninim.jetpackindicator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.laninim.jetpackindicator.ui.theme.JetpackIndicatorTheme
import com.laninim.jetpack_indicator.ArcIndicator
import com.laninim.jetpack_indicator.CircleIndicator

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
                    val pageSelected = remember {
                        mutableStateOf(0)
                    }

                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        if(pageSelected.value == 0){
                            arcIndicator()
                            Row {
                                Button(onClick = { pageSelected.value = 0 }) {
                                    Text(text = "Arc Indicator")
                                }

                                Spacer(modifier = Modifier.width(10.dp))

                                Button(onClick = { pageSelected.value = 1 }) {
                                    Text(text = "Circle Indicator")
                                }
                            }
                        }else{
                            CircleIndicator()
                            Row {
                                Button(onClick = { pageSelected.value = 0 }) {
                                    Text(text = "Arc Indicator")
                                }

                                Spacer(modifier = Modifier.width(10.dp))

                                Button(onClick = { pageSelected.value = 1 }) {
                                    Text(text = "Circle Indicator")
                                }
                            }
                        }

                    }
                }
            }
        }
    }


}

@Composable
fun arcIndicator() {
    Column(
        modifier = Modifier.padding(top = 64.dp, bottom = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArcIndicator(
            indicatorSize = 100.dp,
            progressValue = 50,
            maxProgressValue = 100,
            foregroundColor = Color.Green,
            glowLight = true,
            showPercentage = true,
            indicatorStrokeWidth = 30f,
            textStyle = TextStyle(
                color = Color.White
            )

        )

        Box(modifier = Modifier, contentAlignment = Alignment.Center){
            ArcIndicator(
                indicatorSize = 150.dp,
                progressValue = 23,
                maxProgressValue = 100,
                foregroundColor = Color.Green,
                glowLight = true,
                showPercentage = false,
                indicatorStrokeWidth = 34f

            )
            Text("23 GB", style = TextStyle(
                color = Color.White,
                fontSize = 30.sp,
            )
            )
        }

        ArcIndicator(
            indicatorSize = 100.dp,
            progressValue = 23,
            maxProgressValue = 100,
            foregroundColor = Color.Green,
            glowLight = true,
            showPercentage = true,
            textStyle = TextStyle(
                fontSize = 20.sp,
                color = Color.White
            ),
            indicatorStrokeWidth = 25f
        )

        ArcIndicator(
            indicatorSize = 150.dp,
            progressValue = 23,
            maxProgressValue = 100,
            foregroundColor = Color.Green,
            glowLight = true,
            showPercentage = true,
            textStyle = TextStyle(
                fontSize = 34.sp,
                color = Color.Green,
                fontFamily = FontFamily.Monospace
            )
        )

        ArcIndicator(
            indicatorSize = 150.dp,
            progressValue = 23,
            maxProgressValue = 100,
            foregroundColor = Color.Red,
            backgroundColor = Color.Yellow,
            glowLight = true,
            showPercentage = true,
            textStyle = TextStyle(
                fontSize = 34.sp,
                color = Color.White
            )
        )
    }
}

@Composable
fun CircleIndicator() {
    Column(
        modifier = Modifier.padding(top = 64.dp, bottom = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircleIndicator(
            indicatorSize = 100.dp,
            progressValue = 50,
            maxProgressValue = 100,
            foregroundColor = Color.Green,
            glowLight = true,
            showPercentage = true,
            indicatorStrokeWidth = 30f,
            textStyle = TextStyle(
                color = Color.White
            )

        )

        Box(modifier = Modifier, contentAlignment = Alignment.Center){
            CircleIndicator(
                indicatorSize = 150.dp,
                progressValue = 23,
                maxProgressValue = 100,
                foregroundColor = Color.Green,
                glowLight = true,
                showPercentage = false,
                indicatorStrokeWidth = 34f

            )
            Text("23 GB", style = TextStyle(
                color = Color.White,
                fontSize = 30.sp,
            )
            )
        }

        CircleIndicator(
            indicatorSize = 100.dp,
            progressValue = 23,
            maxProgressValue = 100,
            foregroundColor = Color.Green,
            glowLight = true,
            showPercentage = true,
            textStyle = TextStyle(
                fontSize = 20.sp,
                color = Color.White
            ),
            indicatorStrokeWidth = 25f
        )

        CircleIndicator(
            indicatorSize = 150.dp,
            progressValue = 23,
            maxProgressValue = 100,
            foregroundColor = Color.Green,
            glowLight = true,
            showPercentage = true,
            textStyle = TextStyle(
                fontSize = 34.sp,
                color = Color.Green,
                fontFamily = FontFamily.Monospace
            )
        )

        CircleIndicator(
            indicatorSize = 150.dp,
            progressValue = 23,
            maxProgressValue = 100,
            foregroundColor = Color.Red,
            backgroundColor = Color.Yellow,
            glowLight = true,
            showPercentage = true,
            textStyle = TextStyle(
                fontSize = 34.sp,
                color = Color.White
            )
        )
    }
}

