package com.androidstartercode2024.ui.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidstartercode2024.R // Zaktualizuj nazwę pakietu, jeśli jest inna

@Composable
fun RealNumbersScreen() {
    var userInput1 by remember { mutableStateOf("") }
    var userInput2 by remember { mutableStateOf("") }
    var resultMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Obraz
        Image(
            painter = painterResource(id = R.drawable.realnumbers), // Dodaj obraz do res/drawable
            contentDescription = "Obraz przedstawiający liczby rzeczywiste",
            modifier = Modifier
                .size(150.dp)
                .padding(bottom = 16.dp)
        )

        // Tytuł
        Text(
            text = "Liczby rzeczywiste",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Zadanie 1
        TaskInputFieldRealNumbers(
            taskText = "1. Oblicz pierwiastek kwadratowy z 144.",
            userInput = userInput1,
            onValueChange = { userInput1 = it },
            correctAnswer = "12",
            resultMessage = { resultMessage = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Zadanie 2
        TaskInputFieldRealNumbers(
            taskText = "2. Ile wynosi suma liczby π i liczby 2 (zaokrąglij wynik do dwóch miejsc po przecinku)?",
            userInput = userInput2,
            onValueChange = { userInput2 = it },
            correctAnswer = "5.14",
            resultMessage = { resultMessage = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Wiadomość o wyniku
        Text(
            text = resultMessage,
            color = Color.White,
            fontSize = 16.sp
        )
    }
}

@Composable
fun TaskInputFieldRealNumbers(
    taskText: String,
    userInput: String,
    onValueChange: (String) -> Unit,
    correctAnswer: String,
    resultMessage: (String) -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = taskText,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        BasicTextField(
            value = userInput,
            onValueChange = onValueChange,
            modifier = Modifier
                .background(Color.Gray)
                .padding(8.dp)
                .width(200.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Sprawdzanie wyniku
        Text(
            text = "Sprawdź",
            color = Color.Green,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 8.dp)
                .clickable {
                    if (userInput.trim() == correctAnswer) {
                        resultMessage("Poprawna odpowiedź!")
                    } else {
                        resultMessage("Niepoprawna odpowiedź. Spróbuj ponownie.")
                    }
                }
        )
    }
}