# Jetpack Indicators 



Jetpack indicator is a small library for drawing arc and circle indicators to track progress

## Features

- Create arc or circular percentage markers
- change the color and size of the indicators
- show the percentage and customize the text style

## Installation



```
implementation("com.github.laninim:JetpackIndicator:1.0")
```

remember to add jitpack in your settings gradle

```sh
maven { url = uri("https://jitpack.io") }
```

# Example

```
ArcIndicator(
            indicatorSize = 150.dp,
            progressValue = 24,
            maxProgressValue = 100,
            showPercentage = true,
            indicatorStrokeWidth = 15f,
            foregroundColor = Color.Green,
            textStyle = TextStyle(
                fontSize = 20.sp,
                color = Color.White
            )
        )
```

enabling the showpercentage value will require the textstyle parameter or an exception will be thrown

```
CircleIndicator(
            indicatorSize = 150.dp,
            progressValue = 24,
            maxProgressValue = 100,
            showPercentage = true,
            indicatorStrokeWidth = 15f,
            foregroundColor = Color.Green,
            textStyle = TextStyle(
                fontSize = 20.sp,
                color = Color.White
            )
        )
```
