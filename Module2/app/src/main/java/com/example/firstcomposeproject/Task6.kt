package com.example.firstcomposeproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// 1. Круг исходного размера в правом верхнем углу, чёрный фон 240x120
@Preview(showSystemUi = true)
@Composable
fun CircleTopEndPreview() {
    Box(Modifier.size(240.dp, 120.dp).background(Color.Black)) {
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = null,
            modifier = Modifier.align(Alignment.TopEnd)
        )
    }
}

// 2. Синий фон, круг по центру, растянут, фиолетовый цвет
@Preview(showSystemUi = true)
@Composable
fun CircleStretchPreview() {
    Box(Modifier.size(240.dp, 120.dp).background(Color.Blue)) {
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = null,
            modifier = Modifier.fillMaxSize().align(Alignment.Center),
            contentScale = ContentScale.FillBounds,
            colorFilter = ColorFilter.tint(Color(0xFF800080))
        )
    }
}
