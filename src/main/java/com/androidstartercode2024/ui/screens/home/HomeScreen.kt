package com.androidstartercode2024.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.androidstartercode2024.R
import com.androidstartercode2024.ui.components.ImageTopAppBar
import com.androidstartercode2024.ui.navigation.Route
import com.androidstartercode2024.ui.theme.MyBlackTheme

@Preview(apiLevel = 31, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    MyBlackTheme {
        HomeScreen( navController = NavController(LocalContext.current))
    }
}
@Composable
fun HomeScreen(
    navController: NavController
) {
    val imagePainter = painterResource(id = R.drawable.mathquest_logo)

    Scaffold(
        topBar = {
            ImageTopAppBar(imagePainter = imagePainter)
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp, vertical = 24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Witamy w MathQuestApp",
                    color = Color.White,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Udoskonal swoje umiejetnosci matematyczne dzięki interaktywnym lekcjom i quizom",
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(25.dp))
                Row {
                    Button(
                        onClick = { navController.navigate(Route.loginScreen) },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                    ) {
                        Text("Zaloguj się", color = Color.Black)
                    }
                    Spacer(modifier = Modifier.width(18.dp))
                    Button(
                        onClick = { navController.navigate(Route.registrationScreen) },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                    ) {
                        Text("Dołącz się", color = Color.Black)
                    }
                }
                // Dodanie przycisku "Gość" poniżej istniejących przycisków
                Spacer(modifier = Modifier.height(18.dp)) // Odstęp między przyciskami
                Button(
                    onClick = { navController.navigate("skillLevelSelectionScreen") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text("Gość", color = Color.Black)
                }
            }
        }
    )
}

@Composable
fun MyScreen() {
    val imagePainter = painterResource(id = R.drawable.mathquest_logo) // Replace with your actual image resource

    Scaffold(
        topBar = {
            ImageTopAppBar(imagePainter = imagePainter)
        }
    ) { innerPadding ->
        // Apply padding to the content
        Box(modifier = Modifier.padding(innerPadding)) {
            // Your screen content here, with padding applied
            // Example:
            Text(
                text = "Your content",
                modifier = Modifier.padding(16.dp) // Add desired padding values
            )
        }
    }
}

