package com.androidstartercode2024.ui.screens.details

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidstartercode2024.R // Upewnij się, że obraz znajduje się w res/drawable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicGeometryScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()), // Dodanie przewijania
        horizontalAlignment = Alignment.Start // Wyrównanie do lewej
    ) {
        // Tytuł
        Text(
            text = "Podstawy Geometrii",
            fontSize = 24.sp,
            color = Color.White,
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Sekcja obwodu
        Text(
            text = "1. Obwód",
            fontSize = 20.sp,
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Obwód to długość linii, która otacza figurę. Można go wyobrazić jako 'płot' dookoła ogródka.\n\nJak liczyć obwód?\nDodaj długości wszystkich boków figury.",
            fontSize = 16.sp,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Obliczenia dla obwodu
        Text(
            text = "Obwód = 4 × długość boku.",
            fontSize = 16.sp,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Dodanie obrazu
        Image(
            painter = painterResource(id = R.drawable.obwod),
            contentDescription = "Obraz obwodu figury",
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 200.dp)
                .padding(bottom = 16.dp)
        )

        // Przykłady dla obwodu
        val usedLengths = mutableSetOf<Int>()
        repeat(2) {
            var length: Int
            do {
                length = (1..10).random()
            } while (!usedLengths.add(length)) // Dodajemy tylko, jeśli długość jest unikalna
            Spacer(modifier = Modifier.height(8.dp))
            GeometryExercise(length, "Obwód kwadratu", length * 4)
        }

        repeat(2) {
            var length: Int
            var width: Int
            do {
                length = (1..10).random()
                width = (1..10).random()
            } while (!usedLengths.add(length * 100 + width)) // Unikalne kombinacje długości i szerokości
            Spacer(modifier = Modifier.height(8.dp))
            GeometryExerciseRectangle(length, width, "Obwód prostokąta", 2 * (length + width))
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Sekcja pola powierzchni
        Text(
            text = "2. Pole powierzchni",
            fontSize = 20.sp,
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Pole powierzchni to ilość miejsca wewnątrz figury. Wyobraź sobie, że chcesz pomalować środek pokoju albo pokryć go płytkami.\n\nJak liczyć pole?\nZwykle mnożysz długości boków figury.",
            fontSize = 16.sp,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Dodanie obrazu
        Image(
            painter = painterResource(id = R.drawable.pole),
            contentDescription = "Obraz obwodu figury",
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 200.dp)
                .padding(bottom = 16.dp)
        )

        repeat(2) {
            var side: Int
            do {
                side = (1..10).random()
            } while (!usedLengths.add(side)) // Dodajemy tylko, jeśli bok jest unikalny
            Spacer(modifier = Modifier.height(8.dp))
            GeometryExercise(side, "Pole kwadratu", side * side)
        }

        repeat(2) {
            var length: Int
            var width: Int
            do {
                length = (1..10).random()
                width = (1..10).random()
            } while (!usedLengths.add(length * 100 + width)) // Unikalne kombinacje długości i szerokości
            Spacer(modifier = Modifier.height(8.dp))
            GeometryExerciseRectangle(length, width, "Pole prostokąta", length * width)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeometryExercise(inputValue: Int, label: String, correctAnswer: Int) {
    val userInput = remember { mutableStateOf("") }
    val resultMessage = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "$label o boku $inputValue =",
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
                modifier = Modifier
                    .width(80.dp)
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
                    resultMessage.value = if (userInput.value == correctAnswer.toString()) {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeometryExerciseRectangle(length: Int, width: Int, label: String, correctAnswer: Int) {
    val userInput = remember { mutableStateOf("") }
    val resultMessage = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "$label o długości $length i szerokości $width =",
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
                modifier = Modifier
                    .width(80.dp)
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
                    resultMessage.value = if (userInput.value == correctAnswer.toString()) {
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
