package com.androidstartercode2024.ui.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.pow
import kotlin.math.sqrt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExponentsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start
    ) {
        // Title
        Text(
            text = "Potęgowanie i Pierwiastkowanie - Podstawy",
            fontSize = 24.sp,
            color = Color.White,
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Theory Section: Exponentiation
        Text(
            text = "1. Potęgowanie",
            fontSize = 20.sp,
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Potęgowanie to operacja matematyczna, która polega na mnożeniu liczby przez siebie określoną liczbę razy. Na przykład:\n\n" +
                    "3² = 3 × 3 = 9",
            fontSize = 16.sp,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Task: Exponentiation
        repeat(3) {
            val base = (2..5).random()
            val exponent = (2..4).random()
            ExponentiationTask(base, exponent)
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Theory Section: Roots
        Text(
            text = "2. Pierwiastkowanie",
            fontSize = 20.sp,
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Pierwiastkowanie to operacja odwrotna do potęgowania. Pierwiastek kwadratowy z liczby to liczba, która pomnożona przez siebie daje tę liczbę. Na przykład:\n\n" +
                    "√16 = 4, ponieważ 4 × 4 = 16.",
            fontSize = 16.sp,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Task: Roots
        repeat(3) {
            val number = listOf(4, 9, 16, 25, 36).random()
            SquareRootTask(number)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExponentiationTask(base: Int, exponent: Int) {
    val userInput = remember { mutableStateOf("") }
    val resultMessage = remember { mutableStateOf("") }

    val correctAnswer = base.toDouble().pow(exponent).toInt()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Oblicz wynik: $base^$exponent",
            fontSize = 16.sp,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        TaskInputField(userInput, correctAnswer, resultMessage)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SquareRootTask(number: Int) {
    val userInput = remember { mutableStateOf("") }
    val resultMessage = remember { mutableStateOf("") }

    val correctAnswer = sqrt(number.toDouble()).toInt()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Oblicz pierwiastek kwadratowy z $number:",
            fontSize = 16.sp,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        TaskInputField(userInput, correctAnswer, resultMessage)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskInputField(userInput: MutableState<String>, correctAnswer: Int, resultMessage: MutableState<String>) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        TextField(
            value = userInput.value,
            onValueChange = { newValue -> userInput.value = newValue },
            placeholder = { Text("Odpowiedź", color = Color.Gray) },
            modifier = Modifier
                .width(100.dp)
                .padding(end = 8.dp),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 16.sp,
                color = Color.White
            ),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Gray,
                cursorColor = Color.White
            )
        )
        Button(
            onClick = {
                val answer = userInput.value.toIntOrNull()
                resultMessage.value = if (answer == correctAnswer) {
                    "Dobrze!"
                } else {
                    "Źle! Poprawna odpowiedź to $correctAnswer."
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
        ) {
            Text("Sprawdź", color = Color.White)
        }
    }
    Text(
        text = resultMessage.value,
        fontSize = 14.sp,
        color = if (resultMessage.value.startsWith("Dobrze")) Color.Green else Color.Red,
        style = MaterialTheme.typography.bodySmall,
        modifier = Modifier.padding(top = 8.dp)
    )
}
