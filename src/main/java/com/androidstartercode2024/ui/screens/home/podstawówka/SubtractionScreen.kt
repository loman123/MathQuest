package com.androidstartercode2024.ui.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubtractionScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()), // Dodanie przewijania
        horizontalAlignment = Alignment.Start // Ustawienie wyrównania do lewej
    ) {
        // Tytuł
        Text(
            text = "Odejmowanie",
            fontSize = 24.sp,
            color = Color.White, // Biały kolor tekstu
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Wprowadzenie
        Text(
            text = "Odejmowanie to takie działanie, w którym zabierasz coś z większej liczby rzeczy, żeby zobaczyć, ile zostanie. To jak gdybyś miał cukierki i oddał kilka koledze, a potem liczysz, ile Ci zostało.\n\nPrzykład:\nMasz 5 ciastek, a kolega zjadł 2. Teraz liczysz, ile ciastek Ci zostało:\n\n5 ciastek - 2 ciastka = 3 ciastka.\nOdejmowanie to po prostu sprawdzanie, ile zostaje, gdy coś zabierasz. \n\nPrzykłady pokazują się randomowo",
            fontSize = 16.sp,
            color = Color.White, // Biały kolor tekstu
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(32.dp))

        // Zadania odejmowania
        repeat(15) {
            val number1 = (10..50).random()
            val number2 = (1..number1).random() // Upewnij się, że odejmowanie nie daje ujemnych wyników
            Spacer(modifier = Modifier.height(8.dp))
            SubtractionExercise(number1, number2)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubtractionExercise(number1: Int, number2: Int) {
    val userInput = remember { mutableStateOf("") }
    val resultMessage = remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start // Wyrównanie do lewej
    ) {
        // Wyświetlanie równania
        Text(
            text = "$number1 - $number2 =",
            fontSize = 16.sp,
            color = Color.White, // Biały kolor tekstu
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(end = 8.dp) // Odstęp między równaniem a polem tekstowym
        )

        // Pole tekstowe do wprowadzenia odpowiedzi
        TextField(
            value = userInput.value,
            onValueChange = { newValue -> userInput.value = newValue },
            singleLine = true,
            modifier = Modifier
                .width(60.dp)
                .padding(0.dp),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 16.sp,
                color = Color.White
            ),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Gray,
                cursorColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.width(8.dp)) // Dodanie odstępu między polem tekstowym a przyciskiem

        // Przycisk "Sprawdź"
        Button(
            onClick = {
                val correctAnswer = number1 - number2
                resultMessage.value = if (userInput.value == correctAnswer.toString()) {
                    "Dobrze!"
                } else {
                    "Źle!"
                }
            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray) // Kolor przycisku
        ) {
            Text("Sprawdź", color = Color.White) // Biały kolor tekstu na przycisku
        }

        Spacer(modifier = Modifier.width(8.dp)) // Dodanie odstępu między przyciskiem a wiadomością

        // Wyświetlanie wyniku
        Text(
            text = resultMessage.value,
            fontSize = 14.sp,
            color = if (resultMessage.value == "Dobrze!") Color.Green else Color.Red, // Kolor wyniku
            style = MaterialTheme.typography.bodySmall
        )
    }
}
