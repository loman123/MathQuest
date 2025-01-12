package com.androidstartercode2024.ui.screens.details

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidstartercode2024.R // Add appropriate images in res/drawable
@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PercentagesScreen() {
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
            text = "Procenty - Podstawy",
            fontSize = 24.sp,
            color = Color.White,
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Theory Section
        Text(
            text = "1. Co to są procenty?",
            fontSize = 20.sp,
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Procenty to sposób wyrażania części całości w formie ułamka o mianowniku 100. Na przykład, 50% oznacza 50 na 100, czyli połowę całości.",
            fontSize = 16.sp,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Example Percent Image
        Image(
            painter = painterResource(id = R.drawable.procent), // Add your drawable resource
            contentDescription = "Ilustracja procentów",
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 200.dp)
                .padding(bottom = 16.dp)
        )

        // Explanation of Common Percentages
        Text(
            text = "Najczęściej używane procenty:\n- 50% = połowa\n- 25% = jedna czwarta\n- 10% = jedna dziesiąta\n- 1% = jedna setna",
            fontSize = 16.sp,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Exercises for Percentages
        val usedNumbers = mutableSetOf<Int>()
        repeat(3) {
            var base: Int
            var percentage: Int
            do {
                base = (100..500).random()
                percentage = listOf(10, 25, 50, 75).random()
            } while (!usedNumbers.add(base * 100 + percentage))
            Spacer(modifier = Modifier.height(8.dp))
            PercentageExercise(base, percentage)
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PercentageExercise(base: Int, percentage: Int) {
    val userInput = remember { mutableStateOf("") }
    val resultMessage = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Ile to $percentage% z $base?",
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
                placeholder = { Text("Wynik", color = Color.Gray) },
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
                    val correctAnswer = (base * percentage) / 100
                    resultMessage.value = if (userInput.value == correctAnswer.toString()) {
                        "Dobrze!"
                    } else {
                        "Źle! Poprawna odpowiedź to $correctAnswer."
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
