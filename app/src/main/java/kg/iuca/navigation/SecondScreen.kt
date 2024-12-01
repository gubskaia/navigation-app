package kg.iuca.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

// Composable-функция для отображения Второго экрана
// Принимает параметры: name (имя пользователя), age (возраст пользователя), navigateToThirdScreen (функция навигации на Третий экран)
@Composable
fun SecondScreen(name: String, age: Int, navigateToThirdScreen: () -> Unit = {}) {
    // Макет экрана, все элементы располагаются вертикально
    Column(
        modifier = Modifier
            .fillMaxSize() // Занимает весь экран
            .padding(16.dp), // Добавляет отступы со всех сторон
        verticalArrangement = Arrangement.Center, // Центрирует элементы по вертикали
        horizontalAlignment = Alignment.CenterHorizontally // Центрирует элементы по горизонтали
    ) {
        // Текст с приветствием, включающим имя и возраст
        Text("Hello $name, age $age", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp)) // Отступ между текстом и кнопкой

        // Кнопка для перехода на Третий экран
        Button(onClick = navigateToThirdScreen) {
            Text("Go to Third Screen") // Текст на кнопке
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SecondPreview() {
    SecondScreen(name = "Alex", age = 25)
}