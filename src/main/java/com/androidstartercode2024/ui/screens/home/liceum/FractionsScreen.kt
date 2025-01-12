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
import com.androidstartercode2024.R // Upewnij się, że obrazy znajdują się w res/drawable
@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FractionsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()), // Scrollable content
        horizontalAlignment = Alignment.Start
    ) {
        // Title
        Text(
            text = "Ułamki - Podstawy",
            fontSize = 24.sp,
            color = Color.White,
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Theory Section
        Text(
            text = "1. Co to jest ułamek?",
            fontSize = 20.sp,
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Ułamek przedstawia część całości. Na przykład, jeśli pokroisz pizzę na 8 kawałków i zjesz 3, zjadłeś 3/8 pizzy.",
            fontSize = 16.sp,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Example Fraction Image
        Image(
            painter = painterResource(id = R.drawable.ulamek), // Add your drawable resource
            contentDescription = "Ilustracja ułamków",
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 200.dp)
                .padding(bottom = 16.dp)
        )

        // Explanation for Numerator and Denominator
        Text(
            text = "Każdy ułamek ma dwie części:\n- Licznik (numerator): Liczba na górze, która pokazuje ile części mamy.\n- Mianownik (denominator): Liczba na dole, która pokazuje na ile części została podzielona całość.",
            fontSize = 16.sp,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Exercises for Fractions
        val usedFractions = mutableSetOf<Pair<Int, Int>>()
        repeat(3) {
            var numerator: Int
            var denominator: Int
            do {
                numerator = (1..9).random()
                denominator = (2..10).random()
            } while (!usedFractions.add(Pair(numerator, denominator)))
            Spacer(modifier = Modifier.height(8.dp))
            FractionExercise(numerator, denominator)
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FractionExercise(numerator: Int, denominator: Int) {
    val userInput = remember { mutableStateOf("") }
    val resultMessage = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Czy ułamek $numerator/$denominator jest poprawny?",
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
                placeholder = { Text("Tak/Nie", color = Color.Gray) },
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
                    val isCorrect = numerator < denominator
                    resultMessage.value = if ((userInput.value.lowercase() == "tak" && isCorrect) ||
                        (userInput.value.lowercase() == "nie" && !isCorrect)
                    ) {
                        "Dobrze!"
                    } else {
                        "Źle!"
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
                color = if (resultMessage.value == "Dobrze!") Color.Green else Color.Red,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
