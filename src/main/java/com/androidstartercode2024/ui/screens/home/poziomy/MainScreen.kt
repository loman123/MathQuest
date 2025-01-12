package com.androidstartercode2024.ui.screens.home.poziomy

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LearningPage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        // Premium Subscription Section
        PremiumSubscriptionSection(navController)

        Spacer(modifier = Modifier.height(16.dp))

        // Expand Your Knowledge Section
        ExpandKnowledgeSection(navController)

        Spacer(modifier = Modifier.height(16.dp))

        // Lesson of the Day Section
        LessonOfTheDay(navController)

        Spacer(modifier = Modifier.height(16.dp))

        // Weekly Challenges Section
        WeeklyChallenges(navController)
    }
}

@Composable
fun PremiumSubscriptionSection(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray, shape = RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = "Odkryj wyjątkowe lekcje i zadania Premium",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    navController.navigate("subscriptionScreen") // Przekierowanie do ekranu subskrypcji
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Subskrybuj")
            }
        }
    }
}

@Composable
fun ExpandKnowledgeSection(navController: NavController) {
    Column {
        Text(
            text = "Poszerz swoją wiedzę",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            ExpandKnowledgeButton(navController, "Operacje na macierzach", "matrixOperationsScreen")
            ExpandKnowledgeButton(navController, "Obszar okręgu", "circleAreaScreen")

        }
    }
}

@Composable
fun ExpandKnowledgeButton(navController: NavController, title: String, destination: String) {
    Button(
        onClick = {
            navController.navigate(destination)
        },
        modifier = Modifier
            .size(120.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 8.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = title,
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun LessonOfTheDay(navController: NavController) {
    Column {
        Text(
            text = "Lekcja Dnia",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                navController.navigate("lessonOfTheDayScreen")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
            shape = RoundedCornerShape(12.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = "Ćwiczenie równań liniowych",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun WeeklyChallenges(navController: NavController) {
    Column {
        Text(
            text = "Cotygodniowe wyzwania",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            WeeklyChallengeButton(navController, "Całki nieoznaczone\nRachunek całkowy i różniczkowy", "integralsScreen")
            WeeklyChallengeButton(navController, "Twierdzenie Pitagorasa\nGeometria", "pythagorasScreen")
        }
    }
}

@Composable
fun WeeklyChallengeButton(navController: NavController, title: String, destination: String) {
    Button(
        onClick = {
            navController.navigate(destination)
        },
        modifier = Modifier
            .size(120.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 8.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = title,
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
