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
fun DivisionScreen() {
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
            text = "Dzielenie",
            fontSize = 24.sp,
            color = Color.White, // Biały kolor tekstu
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Wprowadzenie
        Text(
            text = "Dzielenie to takie działanie, w którym rozdzielasz rzeczy na równe części, żeby zobaczyć, ile jest w każdej części, albo ile takich części możesz zrobić. To jak dzielenie cukierków między kolegów, żeby każdy dostał po równo.\n\nPrzykład:\nMasz 12 cukierków i chcesz podzielić je między 4 kolegów. Liczysz, ile cukierków dostanie każdy:\n\n12 cukierków ÷ 4 osoby = 3 cukierki dla każdej osoby.\nDzielenie to sprawdzanie, jak podzielić coś po równo! \n\nPrzykłady pokazują się randomowo.",
            fontSize = 16.sp,
            color = Color.White, // Biały kolor tekstu
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(32.dp))

        // Zadania dzielenia
        repeat(15) {
            val divisor = (1..10).random()
            val quotient = (1..10).random()
            val dividend = divisor * quotient // Tworzymy poprawny wynik dzielenia
            Spacer(modifier = Modifier.height(8.dp))
            DivisionExercise(dividend, divisor)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DivisionExercise(dividend: Int, divisor: Int) {
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
            text = "$dividend ÷ $divisor =",
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
                val correctAnswer = dividend / divisor
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
