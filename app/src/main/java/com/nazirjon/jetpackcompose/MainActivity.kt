package com.nazirjon.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nazirjon.jetpackcompose.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeLearningTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentHeight(),
                    ) {
                        InitColumn()
                        Spacer(modifier = Modifier.height(30.dp))
                        InitRow()
                        Spacer(modifier = Modifier.height(30.dp))
                        UsingVariables()
                        Spacer(modifier = Modifier.height(30.dp))
                        IfCont()
                        Spacer(modifier = Modifier.height(30.dp))
                        ForFun()
                        Spacer(modifier = Modifier.height(30.dp))
                        UsingFun()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val innerPadding = PaddingValues(top = mTop30, start = mStart30)
    Box(
        contentAlignment = Alignment.CenterEnd,
        modifier = Modifier
            .wrapContentWidth()
            .background(Color.Blue)
    ) {
        Text(
            text = "Hello $name!",
            fontSize = 22.sp,
            color = mGreen,
            modifier = Modifier
                .size(width = 120.dp, height = 80.dp)
                .padding(innerPadding)
                //.offset(x = 4.dp, y = 2.dp)
                .background(color = mBackground)
                .widthIn(min = 120.dp, max = mWidth)
                .heightIn(min = 50.dp, max = mHeight)
        )
    }
}

@Composable
fun ScrollStateCompose() {
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .width(200.dp)
            .background(Color.DarkGray)
    ) {
        Text(
            "What is Lorem Ipsum?\n" +
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                    "\n" +
                    "...............",
            fontSize = 22.sp,
            modifier = Modifier
                .background(color = Color.Yellow)
                .verticalScroll(rememberScrollState())
                .horizontalScroll(rememberScrollState())
        )
    }
}

@Composable
fun EventClick() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .wrapContentWidth()
            .background(Color.Green)
    ) {
        val count = remember { mutableStateOf(0) }
        Text(
            "Clicks: ${count.value}",
            fontSize = 28.sp,
            modifier = Modifier
                .clickable(onClick = { count.value += 1 })
                .size(width = 200.dp, height = 60.dp)
        )
    }
}

@Composable
fun InitColumn() {
    Column(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight(),
        verticalArrangement = Arrangement.Top
    ) {
        Greeting("Android")
        ScrollStateCompose()
        EventClick()
    }
}

@Composable
fun InitRow() {
    Row(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.Start
    ) {
        Greeting("Android")
        ScrollStateCompose()
        EventClick()
    }
}

@Composable
fun UsingVariables() {
    val message = "Hello Test"
    val size: TextUnit = 24.sp
    Text(
        text = message,
        fontSize = size
    )
}

@Composable
fun IfCont() {
    val hour = 19
    if (hour < 18) {
        Text(text = "Добрый день", fontSize = 28.sp)
    } else {
        Column {
            Text(text = "Добрый", fontSize = 23.sp)
            Text(text = "вечер", fontSize = 23.sp)
        }
    }
}

@Composable
fun ForFun() {
    val langs = listOf("Kotlin", "Java", "JavaScript", "Scala")
    Column {
        langs.forEach { lang ->
            Text(text = lang, fontSize = 24.sp)
        }
    }
}

@Composable
fun UsingFun() {
    Column {
        Text(text = createMessage(5), fontSize = 28.sp)
        Text(text = createMessage(15), fontSize = 28.sp)
        Text(text = createMessage(20), fontSize = 28.sp)
    }
}
fun createMessage(hour: Int): String =
    if (hour > 18) {
        "Добрый вечер"
    } else if (hour > 10) {
        "Добрый день"
    } else {
        "Доброе утро"
    }

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeLearningTheme {
        Column() {
            Greeting("Android")
            ScrollStateCompose()
            EventClick()
        }
    }
}