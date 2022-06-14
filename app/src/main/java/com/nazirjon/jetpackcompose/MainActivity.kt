package com.nazirjon.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nazirjon.jetpackcompose.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeLearningTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val innerPadding = PaddingValues(top = mTop30, start = mStart30)

    Text(
        text = "Hello $name!",
        fontSize = 22.sp,
        color = mGreen,
        modifier = Modifier
            .size(width = 300.dp, height = 200.dp)
            .padding(mPadding30)
            .offset(x = 20.dp, y = 25.dp)
            .background(color = mBackground)
            .widthIn(min = 100.dp, max = mWidth)
            .heightIn(min = 50.dp, max = mHeight)
            .padding(innerPadding)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeLearningTheme {
        Greeting("Android")
    }
}