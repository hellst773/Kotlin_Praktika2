package com.example.firstcomposeproject

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Hello(name: String?) {
    Text(
        text = if (name != null) "Привет, $name!" else "Имя не задано",
        modifier = Modifier.padding(16.dp)
    )
}

@Preview(showSystemUi = true)
@Composable
fun HelloNamePreview() {
    Hello("Мария")
}

@Preview(showSystemUi = true)
@Composable
fun HelloNullPreview() {
    Hello(null)
}
