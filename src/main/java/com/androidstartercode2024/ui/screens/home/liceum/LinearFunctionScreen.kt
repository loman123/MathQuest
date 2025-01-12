package com.androidstartercode2024.ui.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidstartercode2024.R // Add images to the res/drawable folder if needed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LinearFunctionScreen() {
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
            text = "Równania liniowe - Podstawy",
            fontSize = 24.sp,
            color = Color.White,
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Theory Section
        Text(
            text = "1. Co to jest równanie liniowe?",
            fontSize = 20.sp,
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Równanie liniowe to równanie postaci ax + b = 0, gdzie a i b są liczbami rzeczywistymi, a x to niewiadoma. Rozwiązaniem równania jest wartość x, która sprawia, że równanie jest prawdziwe.",
            fontSize = 16.sp,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Common Example
        Text(
            text = "Przykład: Jeśli równanie to 2x + 4 = 0, rozwiązujemy je, przenosząc 4 na prawą stronę, a następnie dzieląc przez 2:\n2x = -4\nx = -2.",
            fontSize = 16.sp,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Exercises for Linear Equations
        repeat(3) {
            val a = (1..10).random()
            val b = (-20..20).random()
            LinearEquationExercise(a, b)
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LinearEquationExercise(a: Int, b: Int) {
    val userInput = remember { mutableStateOf("") }
    val resultMessage = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Rozwiąż równanie: ${a}x + $b = 0",
            fontSize = 16.sp,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = userInput.value,
                onValueChange = { newValue -> userInput.value = newValue },
                singleLine = true,
                placeholder = { Text("x =", color = Color.Gray) },
                modifier = Modifier
                    .width(100.dp)
                    .padding(end = 8.dp),
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

            Button(
                onClick = {
                    val correctAnswer = -b.toDouble() / a
                    resultMessage.value = if (userInput.value.toDoubleOrNull() == correctAnswer) {
                        "Dobrze!"
                    } else {
                        "Źle! Poprawna odpowiedź to x = %.2f".format(correctAnswer)
                    }
                },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
            ) {
                Text("Sprawdź", color = Color.White)
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = resultMessage.value,
                fontSize = 14.sp,
                color = if (resultMessage.value.startsWith("Dobrze")) Color.Green else Color.Red,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
