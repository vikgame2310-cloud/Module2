
package com.example.module2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.module2.ui.theme.Module2Theme
import kotlin.random.Random

data class Product(
    val id: Int,
    val name: String,
    val price: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Module2Theme {
                ShoppingCartScreen()
            }
        }
    }
}

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

    val totalSum = products.sumOf { it.price }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp, start = 16.dp, end = 16.dp)
    ) {
        Text("Корзина магазина", fontSize = 24.sp)

        Spacer(Modifier.height(16.dp))

        for (product in products) {
            Text("${product.name} — ${product.price} рублей")
        }

        Spacer(Modifier.height(16.dp))

        Text("Товаров на сумму: $totalSum рублей")

        Spacer(Modifier.height(16.dp))

        Button(onClick = {
            val id = products.size

            products = products + Product(
                id = id,
                name = "Товар #${id + 1}",
                price = Random.nextInt(0, 100)
            )

            if (products.sumOf { it.price } > 500) {
                Toast.makeText(
                    context,
                    "Доставка бесплатная!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }) {
            Text("Добавить товар")
        }

        if (products.isNotEmpty()) {
            Button(onClick = {
                products = products.dropLast(1)
            }) {
                Text("Удалить товар")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShoppingCartPreview() {
    Module2Theme {
        ShoppingCartScreen()
    }
}
