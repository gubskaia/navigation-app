package kg.iuca.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

// Composable-функция для отображения Первого экрана.
// Параметр navigationToSecondScreen позволяет передать данные (имя и возраст) и выполнить навигацию на Второй экран
@Composable
fun FirstScreen(navigationToSecondScreen: (String, Int) -> Unit = { _, _ -> }) {
    // Переменная состояния для имени пользователя
    val name = remember { mutableStateOf("") }
    // Переменная состояния для возраста пользователя
    val age = remember { mutableStateOf("") }

    // Макет экрана: все элементы располагаются вертикально
    Column(
        modifier = Modifier
            .fillMaxSize() // Занимает весь экран
            .padding(16.dp), // Отступы со всех сторон
        verticalArrangement = Arrangement.Center, // Элементы центрируются по вертикали
        horizontalAlignment = Alignment.CenterHorizontally // Элементы центрируются по горизонтали
    ) {
        // Заголовок экрана
        Text("This is the First Screen", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp)) // Отступ между элементами

        // Текстовое поле для ввода имени
        OutlinedTextField(
            value = name.value, // Текущее значение
            onValueChange = { name.value = it }, // Изменение значения
            label = { Text("Enter your name") } // Метка поля
        )
        Spacer(modifier = Modifier.height(16.dp)) // Отступ между элементами

        // Текстовое поле для ввода возраста
        OutlinedTextField(
            value = age.value, // Текущее значение
            onValueChange = { age.value = it }, // Изменение значения
            label = { Text("Enter your age") } // Метка поля
        )
        Spacer(modifier = Modifier.height(16.dp)) // Отступ между элементами

        // Кнопка для перехода на Второй экран
        Button(onClick = {
            // Преобразуем введенный возраст в число (или задаем 0, если конвертация не удалась)
            val ageValue = age.value.toIntOrNull() ?: 0
            // Передаем имя и возраст в navigationToSecondScreen и выполняем навигацию
            navigationToSecondScreen(name.value, ageValue)
        }) {
            Text("Go to Second Screen") // Текст на кнопке
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstPreview() {
    FirstScreen()
}