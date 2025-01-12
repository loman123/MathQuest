package com.androidstartercode2024.ui.screens.details

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidstartercode2024.R // Replace with your actual R file path
import kotlin.math.PI
import kotlin.math.roundToInt
@Preview
@Composable
fun CircleAreaScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Drawable Image
        Image(
            painter = painterResource(id = R.drawable.obszar_okregu),
            contentDescription = "Circle Illustration",
            modifier = Modifier
                .size(150.dp)
                .padding(bottom = 16.dp)
        )

        // Title
        Text(
            text = "Obszar Okręgu - Podstawy",
            fontSize = 24.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Theory Section
        Text(
            text = "Teoria",
            fontSize = 20.sp,
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Obszar okręgu można obliczyć za pomocą wzoru:\n" +
                    "A = π × r²\n" +
                    "gdzie:\n" +
                    "• A to obszar okręgu,\n" +
                    "• r to promień okręgu,\n" +
                    "• π to stała matematyczna (około 3.14159).",
            fontSize = 16.sp,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Interactive Tasks
        Text(
            text = "Ćwiczenia",
            fontSize = 20.sp,
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(8.dp))

        repeat(3) {
            val radius = (5..15).random()
            CircleAreaTask(radius)
        }
    }
}

@Composable
fun CircleAreaTask(radius: Int) {
    val userInput = remember { mutableStateOf("") }
    val resultMessage = remember { mutableStateOf("") }

    val correctAnswer = (PI * radius * radius).roundToInt()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Oblicz obszar okręgu o promieniu: $radius",
            fontSize = 16.sp,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        TaskInputFieldCircle(userInput, correctAnswer, resultMessage)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskInputFieldCircle(userInput: MutableState<String>, correctAnswer: Int, resultMessage: MutableState<String>) {
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
