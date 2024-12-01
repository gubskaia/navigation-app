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

// Composable-функция для отображения Третьего экрана
// Принимает параметры: name (имя пользователя), age (возраст пользователя), navigateBack (функция возврата на Первый экран)
@Composable
fun ThirdScreen(name: String, age: Int, navigateBack: () -> Unit = {}) {
    // Макет экрана, все элементы располагаются вертикально
    Column(
        modifier = Modifier
            .fillMaxSize() // Занимает весь экран
            .padding(16.dp), // Добавляет отступы со всех сторон
        verticalArrangement = Arrangement.Center, // Центрирует элементы по вертикали
        horizontalAlignment = Alignment.CenterHorizontally // Центрирует элементы по горизонтали
    ) {
        // Текст с приветствием, включающим возраст и имя
        Text("Hello $age year old $name!", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp)) // Отступ между текстом и кнопкой

        // Кнопка для возврата на Первый экран
        Button(onClick = navigateBack) {
            Text("Go Back to First Screen") // Текст на кнопке
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ThirdPreview() {
    ThirdScreen(name = "Alex", age = 25)
}