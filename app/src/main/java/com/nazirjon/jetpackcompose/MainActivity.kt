package com.nazirjon.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nazirjon.jetpackcompose.ui.theme.*
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeLearningTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentHeight(),
                    ) {
//                        InitColumn()
//                        Spacer(modifier = Modifier.height(30.dp))
//                        InitRow()
//                        Spacer(modifier = Modifier.height(30.dp))
//                        UsingVariables()
//                        Spacer(modifier = Modifier.height(30.dp))
//                        IfCont()
//                        Spacer(modifier = Modifier.height(30.dp))
//                        ForFun()
//                        Spacer(modifier = Modifier.height(30.dp))
//                        UsingFun()
//                        Spacer(modifier = Modifier.height(30.dp))
//                        StateComponent()
//                        Spacer(modifier = Modifier.height(30.dp))
//                        MText()
//                        Spacer(modifier = Modifier.height(30.dp))
//                        MButton()
//                        Spacer(modifier = Modifier.height(30.dp))
//                        MOutlinedButton()
//                        Spacer(modifier = Modifier.height(30.dp))
//                        MTextButton()
//                        Spacer(modifier = Modifier.height(30.dp))
//                        MTextField()
//                        Spacer(modifier = Modifier.height(30.dp))
//                        MOutlinedTextField()
//                        Spacer(modifier = Modifier.height(30.dp))
//                        MModifierToggleable()
//                        Spacer(modifier = Modifier.height(30.dp))
//                        MCheckbox()
//                        Spacer(modifier = Modifier.height(30.dp))
//                        MSelectable()
//                        Spacer(modifier = Modifier.height(30.dp))
//                        MRadioButton()
//                        Spacer(modifier = Modifier.height(30.dp))
//                        MIconButton()
//                        Spacer(modifier = Modifier.height(30.dp))
//                        MFloatingActionButton()
//                        Spacer(modifier = Modifier.height(30.dp))
//                        MTopBottomBar()
//                        Spacer(modifier = Modifier.height(30.dp))
//                        MScaffold()
//                        MSnackbar()
//                        MDrawer()
//                        MSlider()
                        MSwitch()
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
        Text(text = createMessage(5), fontSize = 24.sp)
        Text(text = createMessage(15), fontSize = 24.sp)
        Text(text = createMessage(20), fontSize = 24.sp)
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

@Composable
fun StateComponent() {
    val (value, setValue) = remember { mutableStateOf("Hello Jetpack") }
    Text(
        text = value,
        fontSize = 28.sp,
        modifier = Modifier.clickable(onClick = { setValue("Hello com") })
    )
}

@Composable
fun MText() {
    Text(
        text = "Hello Jetpack Compose!", fontSize = 25.sp,
        color = Color.Red,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Monospace,
        letterSpacing = 1.3.sp,
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.Center,
        overflow = TextOverflow.Ellipsis,
        style = TextStyle(shadow = Shadow(Color.LightGray, Offset(10.0f, 16.5f), 1.0f))
    )
}

@Composable
fun MButton() {
    Column() {
        Button(
            onClick = {},
            Modifier.padding(4.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red,
                contentColor = Color.White
            ),
            border = BorderStroke(3.dp, Color.Green)
        ) {
            Text("Click", fontSize = 25.sp)
        }

        val label = remember { mutableStateOf("Click") }
        OutlinedButton(
            onClick = { label.value = "OutlinedButton" },
            Modifier.padding(4.dp),
        ) {
            Text(label.value, fontSize = 25.sp)
        }

        val labelTextBtn = remember { mutableStateOf("Click") }
        TextButton(
            onClick = { labelTextBtn.value = "TextButton" },
            Modifier.padding(4.dp),
        ) {
            Text(labelTextBtn.value, fontSize = 25.sp)
        }
    }
}

@Composable
fun MTextField() {
    Column {
        val phone = remember { mutableStateOf("") }
        TextField(
            phone.value,
            { phone.value = it },
            Modifier.padding(4.dp),
            textStyle = TextStyle(fontSize = 28.sp),
            leadingIcon = { Icon(Icons.Filled.Check, contentDescription = "Проверено") },
            trailingIcon = {
                Icon(
                    Icons.Filled.Info,
                    contentDescription = "Дополнительная информация"
                )
            },
            placeholder = { Text("Hello", fontSize = 28.sp) },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Red,
                backgroundColor = Color.Cyan
            )
            //keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        val message = remember { mutableStateOf("") }
        OutlinedTextField(
            message.value,
            { message.value = it },
            Modifier.padding(4.dp),
            textStyle = TextStyle(fontSize = 30.sp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Green, // цвет при получении фокуса
                unfocusedBorderColor = Color.LightGray  // цвет при отсутствии фокуса
            )
        )
    }
}

@Composable
fun MModifierToggleable() {
    val checked = remember { mutableStateOf(false) }
    Text(
        modifier = Modifier.toggleable(
            value = checked.value,
            onValueChange = { checked.value = it }),
        text = checked.value.toString(),
        fontSize = 30.sp
    )
}

@Composable
fun MCheckbox() {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(4.dp)) {
            val checkedState = remember { mutableStateOf(true) }
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },
                modifier = Modifier.padding(5.dp),
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Cyan,
                    checkmarkColor = Color.Red
                )
            )
            Text("Выбрано", fontSize = 22.sp)
        }

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(4.dp)) {
            val checkedState =
                remember { mutableStateOf(androidx.compose.ui.state.ToggleableState.Indeterminate) }
            TriStateCheckbox(
                state = checkedState.value,
                onClick = {
                    if (checkedState.value == androidx.compose.ui.state.ToggleableState.Indeterminate
                        || checkedState.value == androidx.compose.ui.state.ToggleableState.Off
                    )
                        checkedState.value = androidx.compose.ui.state.ToggleableState.On
                    else checkedState.value = androidx.compose.ui.state.ToggleableState.Off
                },
                modifier = Modifier.padding(5.dp),
            )
            Text("Выбрано", fontSize = 22.sp)
        }
    }
}

@Composable
fun MSelectable() {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(4.dp)) {
            val selected = remember { mutableStateOf(true) }

            Text(
                text = selected.value.toString(),
                fontSize = 30.sp,
                modifier = Modifier.selectable(
                    selected = selected.value,
                    onClick = { selected.value = !selected.value }
                )
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(4.dp)) {
            val colors = listOf(Color.Red, Color.Green, Color.Blue)
            val selectedOption = remember { mutableStateOf(colors[0]) }
            Column(modifier = Modifier.padding(20.dp)) {
                Box(
                    Modifier
                        .padding(10.dp)
                        .size(100.dp)
                        .background(color = selectedOption.value)
                )

                colors.forEach { color ->
                    val selected = selectedOption.value == color
                    Box(
                        Modifier
                            .padding(8.dp)
                            .size(60.dp)
                            .background(color = color)
                            .selectable(
                                selected = selected,
                                onClick = { selectedOption.value = color }
                            )
                            .border(
                                width = if (selected) {
                                    2.dp
                                } else {
                                    0.dp
                                },
                                color = Color.Black
                            )
                    )
                }
            }
        }
    }
}

@Composable
fun MRadioButton() {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(4.dp)) {
            val state = remember { mutableStateOf(true) }
            Column(Modifier.selectableGroup())
            {
                RadioButton(
                    selected = state.value,
                    onClick = { state.value = true }
                )
                RadioButton(
                    selected = !state.value,
                    onClick = { state.value = false }
                )
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(4.dp)) {
            val languages = listOf("Kotlin", "Java", "Javascript", "Rust")
            val (selectedOption, onOptionSelected) = remember { mutableStateOf(languages[0]) }

            Column(Modifier.selectableGroup()) {
                languages.forEach { text ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .selectable(
                                selected = (text == selectedOption),
                                onClick = { onOptionSelected(text) }
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (text == selectedOption),
                            onClick = null
                        )
                        Text(text = text, fontSize = 22.sp)
                    }
                }
            }
        }
    }
}


@Composable
fun MIconButton() {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(4.dp)) {
            IconButton(onClick = { }) {
                Icon(
                    Icons.Filled.Info,
                    contentDescription = "Информация о приложении", modifier = Modifier.size(80.dp),
                    tint = Color.Red
                )
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(4.dp)) {
            val checked = remember { mutableStateOf(false) }
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconToggleButton(
                    checked = checked.value,
                    onCheckedChange = { checked.value = it }) {
                    Icon(
                        Icons.Filled.Info,
                        contentDescription = "Информация о приложении",
                        tint = if (checked.value) Color(0xFFEC407A) else Color(0xFFB0BEC5)
                    )
                }
                Text(
                    text = if (checked.value) "Выбрано" else "Не выбрано",
                    fontSize = 28.sp
                )
            }
        }
    }
}

@Composable
fun MFloatingActionButton() {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(4.dp)) {
            Column {
                val label = remember { mutableStateOf("") }
                Text(text = label.value, fontSize = 28.sp)
                FloatingActionButton(onClick = { label.value = "Добавлено!" }) {
                    Icon(Icons.Filled.Add, contentDescription = "Добавить")
                }
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(4.dp)) {
            val added = remember { mutableStateOf(false) }
            ExtendedFloatingActionButton(
                icon = {
                    Icon(
                        if (added.value) Icons.Filled.Delete else Icons.Filled.Add,
                        contentDescription = "Добавить"
                    )
                },
                text = { Text(if (added.value) "Удалить" else "Добавить") },
                onClick = { added.value = !added.value }
            )
        }
    }
}

@Composable
fun MTopBottomBar() {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(0.dp)) {
            TopAppBar {
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Menu, contentDescription = "Меню")
                }
                Text("TopAppBar", fontSize = 22.sp)
                Spacer(Modifier.weight(1f, true))

                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Info, contentDescription = "Информация о приложении")
                }
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Search, contentDescription = "Поиск")
                }
            }
        }

        Row(verticalAlignment = Alignment.Bottom, modifier = Modifier.fillMaxHeight()) {
            BottomAppBar() {
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Menu, contentDescription = "Меню")
                }
                Text("BottomAppBar", fontSize = 22.sp)
                Spacer(Modifier.weight(1f, true))

                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Info, contentDescription = "Информация о приложении")
                }
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Search, contentDescription = "Поиск")
                }
            }
        }
    }
}

@Composable
fun MScaffold() {
    val isAdded = remember { mutableStateOf(false) }
    Scaffold(
        topBar = { TopAppBar { Text("TopAppBar", fontSize = 22.sp) } },
        bottomBar = {
            BottomAppBar {
                IconButton(onClick = { }) { Icon(Icons.Filled.Menu, contentDescription = "Меню") }
                Spacer(Modifier.weight(1f, true))
                IconButton(onClick = { }) {
                    Icon(
                        Icons.Filled.Search,
                        contentDescription = "Поиск"
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                content = {
                    if (isAdded.value) Icon(Icons.Filled.Clear, contentDescription = "Удалить")
                    else Icon(Icons.Filled.Add, contentDescription = "Добавить")
                },
                onClick = { isAdded.value = !isAdded.value }
            )
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true
    ) {
        Text(if (isAdded.value) "Товар добавлен" else "Корзина пуста", fontSize = 28.sp)
    }
}

@Composable
fun MSnackbar() {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    val count = remember { mutableStateOf(0) }
    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(
                content = { Icon(Icons.Filled.Add, contentDescription = "Добавить") },
                onClick = {
                    scope.launch {
                        val result = scaffoldState.snackbarHostState.showSnackbar(
                            "Count: ${count.value}",
                            "Click"
                        )
                        when (result) {
                            SnackbarResult.ActionPerformed -> {
                                count.value++; }
                            SnackbarResult.Dismissed -> {
                                count.value--; }
                        }
                    }
                }
            )
        }
    ) {
        Text("Count", fontSize = 28.sp)
    }
}

@Composable
fun MDrawer() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val selectedItem = remember { mutableStateOf("") }
    val items = listOf("Главная", "Контакты", "О приложении")
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            for (item in items) {
                Text(
                    item,
                    fontSize = 28.sp,
                    modifier = Modifier.clickable {
                        selectedItem.value = item
                        scope.launch { scaffoldState.drawerState.close() }
                    }
                )
            }
        }
    ) {
        Column {
            Button(onClick = {
                scope.launch { scaffoldState.drawerState.open() }
            }) {
                Text("Меню", fontSize = 28.sp)
            }
            Text("Выбран пункт: ${selectedItem.value}", fontSize = 28.sp)
        }
    }
}

@Composable
fun MSlider() {
    var sliderPosition by remember { mutableStateOf(0f) }
    Column {
        Text(text = "Текущее значение: $sliderPosition", fontSize = 22.sp)
        Slider(
            value = sliderPosition,
            valueRange = 0f..10f,
            steps = 9,
            onValueChange = { sliderPosition = it },
            colors = SliderDefaults.colors(
                thumbColor = Color(0xFFB71C1C),
                activeTrackColor = Color(0xFFEF9A9A),
                inactiveTrackColor = Color(0xFFFFEBEE),
                inactiveTickColor = Color(0xFFEF9A9A),
                activeTickColor = Color(0xFFB71C1C)
            )
        )
    }
}

@Composable
@Preview(showBackground = true)
fun MSwitch() {
    val checkedState = remember { mutableStateOf(false) }
    val textColor = remember { mutableStateOf(Color.Unspecified) }
    Column(modifier = Modifier.fillMaxSize().padding(10.dp)){
        Row (verticalAlignment = Alignment.CenterVertically ){
            Text("Красный цвет", fontSize = 22.sp, color = textColor.value)
            Switch(
                checked = checkedState.value,
                onCheckedChange = {
                    checkedState.value = it
                    if(checkedState.value) textColor.value = Color(0xFFC62828)
                    else textColor.value = Color.Unspecified
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color(0xFFC62828),
                    checkedTrackColor = Color(0xFFE57373),
                    uncheckedThumbColor = Color(0xFFEF9A9A),
                    uncheckedTrackColor = Color(0xFFFFEBEE)
                )
            )
        }
    }
}

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