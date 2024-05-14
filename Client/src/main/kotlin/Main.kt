import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    var message by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }
    var is_login by remember { mutableStateOf(false) }
    var login by remember { mutableStateOf("") }
    var messages by remember { mutableStateOf(mutableStateListOf<String>()) }

    Column {
        Row(modifier = Modifier.weight(9f)) {
            Box(modifier = Modifier.fillMaxSize()) {
                val lazyListState = rememberLazyListState()
                LazyColumn(modifier = Modifier.fillMaxWidth(), state = lazyListState) {
                    items(messages) { it ->
                        Text(it, fontSize = 23.sp)
                    }
                }

            }
        }

        Row {
            OutlinedTextField(modifier = Modifier.weight(9f), value = message, onValueChange = {
                message = it

            })
            Button(onClick = {
                if (!is_login) {
                    text = "Добро пожаловать в чат " + message
                    login = message
                    message = ""
                    is_login = true
                } else {
                    text += login + ":" + message
                    message = ""
                }
                messages.add(text)
                text = ""
            }) {
                if (is_login) {
                    Text("Отправить сообщение")
                } else {
                    Text("Ввести логин")

                }
            }
        }
    }

}


fun pass() {}


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
