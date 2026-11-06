# Модуль 2 – Основы Jetpack Compose

Исходный код заданий 1–10 (РТУ МИРЭА, ИКБО-66-24).

| Файл | Задание |
|---|---|
| `Task1.kt` | 1 – функция `Hello(name: String?)` |
| `Task2.kt` | 2 – три макета предпросмотра (portrait, landscape, round) |
| `Task3.kt` + `res/values/strings_task3.xml` | 3 – варианты оформления текста |
| `Task4.kt` | 4 – кнопка |
| `Task5.kt` | 5 – контейнер с кругом и инициалами |
| `Task6.kt` + `res/drawable/circle.xml` | 6 – векторный круг |
| `Task7.kt` | 7 – Column и Row |
| `Task8.kt` | 8 – «Трекер воды» |
| `androidTest/.../WaterTrackerTest.kt` | 9 – UI-тесты |
| `Task10.kt` | 10 – корзина магазина |
| `MainActivity.kt` | пример вызова функций в активити |

## Как использовать
Файлы лежат в тех же папках, что и в проекте Android Studio (`app/src/main/...`).
Скопируйте их в свой проект `FirstComposeProject` (пакет `com.example.firstcomposeproject`).
Если пакет другой, замените первую строку `package ...` в каждом файле.

В `app/build.gradle.kts` для тестов нужны зависимости:

```kotlin
androidTestImplementation(platform(libs.androidx.compose.bom))
androidTestImplementation("androidx.compose.ui:ui-test-junit4")
debugImplementation("androidx.compose.ui:ui-test-manifest")
```

Если `Icons.Filled.Star` в задании 7 не находится, добавьте
`implementation("androidx.compose.material:material-icons-core")`.
