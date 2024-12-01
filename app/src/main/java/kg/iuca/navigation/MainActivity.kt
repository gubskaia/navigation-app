package kg.iuca.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

// Главная composable-функция для настройки навигации в приложении
@Composable
fun MyApp() {
    // Создаем NavController для управления навигацией в приложении
    val navController = rememberNavController()

    // Определяем навигационный хост с маршрутами для каждого экрана
    NavHost(navController = navController, startDestination = "firstscreen") {
        // Маршрут для Первого экрана
        composable(route = "firstscreen") {
            // Переход на Второй экран с передачей имени и возраста
            FirstScreen { name, age ->
                navController.navigate("secondscreen/$name/$age")
            }
        }
        // Маршрут для Второго экрана
        composable(route = "secondscreen/{name}/{age}") { backStackEntry ->
            // Получаем параметры, переданные через маршрут навигации
            val name = backStackEntry.arguments?.getString("name") ?: "Нет имени"
            val age = backStackEntry.arguments?.getString("age")?.toIntOrNull() ?: 0
            // Переход на Третий экран с передачей тех же параметров
            SecondScreen(name = name, age = age) {
                navController.navigate("thirdscreen/$name/$age")
            }
        }
        // Маршрут для Третьего экрана
        composable(route = "thirdscreen/{name}/{age}") { backStackEntry ->
            // Получаем параметры, переданные через маршрут навигации
            val name = backStackEntry.arguments?.getString("name") ?: "Нет имени"
            val age = backStackEntry.arguments?.getString("age")?.toIntOrNull() ?: 0
            // Возврат к Первому экрану при завершении работы на Третьем экране
            ThirdScreen(name = name, age = age) {
                navController.popBackStack("firstscreen", false)
            }
        }
    }
}
