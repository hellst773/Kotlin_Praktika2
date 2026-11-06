package com.example.firstcomposeproject

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlin.random.Random

data class Product(val id: Int, val name: String, val price: Int)

@Composable
fun ShoppingCartScreen() {
    val context = LocalContext.current
    var products by remember {
        mutableStateOf(
            listOf(
                Product(0, "Товар #1", 100),
                Product(1, "Товар #2", 150),
                Product(2, "Товар #3", 56)
            )
        )
    }
    // сумма вычисляется из состояния, а не накапливается
    val totalSum = products.sumOf { it.price }

    Column(Modifier.padding(16.dp)) {
        for (product in products) {
            Text(text = "${product.name} - ${product.price} рублей")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Товаров на сумму: $totalSum рублей")

        AddProductSection {
            val nextId = (products.maxOfOrNull { it.id } ?: -1) + 1
            val newProduct = Product(nextId, "Товар #${nextId + 1}", Random.nextInt(0, 100))
            products = products + newProduct
            // Toast – реакция на действие, а не часть композиции
            if (products.sumOf { it.price } > 500) {
                Toast.makeText(context, "Доставка бесплатная!", Toast.LENGTH_SHORT).show()
            }
        }
        RemoveProductSection(visible = products.isNotEmpty()) {
            products = products.dropLast(1)
        }
    }
}

@Composable
fun AddProductSection(onAdd: () -> Unit) {
    Button(onClick = onAdd) { Text("Добавить товар") }
}

@Composable
fun RemoveProductSection(visible: Boolean, onRemove: () -> Unit) {
    if (visible) {
        Button(onClick = onRemove) { Text("Удалить товар") }
    }
}
