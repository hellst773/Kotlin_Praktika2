package com.example.firstcomposeproject

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "portrait", showSystemUi = true,
    device = "spec:width=411dp,height=891dp,orientation=portrait"
)
@Preview(
    name = "landscape", showSystemUi = true,
    device = "spec:width=891dp,height=411dp,orientation=landscape"
)
@Preview(
    name = "round", showSystemUi = true,
    device = "spec:width=200dp,height=200dp,isRound=true",
    showBackground = true, backgroundColor = 0xFFFFFF00
)
@Composable
fun HelloPreview() {
    Hello("Android")
}
