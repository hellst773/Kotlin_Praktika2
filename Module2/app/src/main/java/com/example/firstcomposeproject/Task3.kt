package com.example.firstcomposeproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview(showSystemUi = true)
@Composable
fun Text1Preview() {
    Text(
        text = stringResource(R.string.compose_desc),
        color = Color(0xFF008000),
        fontSize = 16.sp,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(showSystemUi = true)
@Composable
fun Text2Preview() {
    Text(
        text = stringResource(R.string.compose_desc),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Preview(showSystemUi = true)
@Composable
fun Text3Preview() {
    Text(
        text = stringResource(R.string.compose_desc),
        fontSize = 24.sp,
        color = Color.Black,
        textDecoration = TextDecoration.Underline,
        style = TextStyle(textIndent = TextIndent(firstLine = 48.sp)),
        modifier = Modifier.background(Color.Green)
    )
}
