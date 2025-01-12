package com.androidstartercode2024.ui.screens.details

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
fun PrimarySchoolScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Sekcja subskrypcji na samej górze
        PremiumSubscriptionSection(navController = navController)

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Wybierz temat",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PrimarySchoolTopicButton(navController, "Dodawanie", "additionScreen")
            PrimarySchoolTopicButton(navController, "Odejmowanie", "subtractionScreen")
            PrimarySchoolTopicButton(navController, "Mnożenie", "multiplicationScreen")
            PrimarySchoolTopicButton(navController, "Dzielenie", "divisionScreen")
            PrimarySchoolTopicButton(navController, "Podstawy geometrii", "basicGeometryScreen")
        }
    }
}

@Composable
fun PrimarySchoolTopicButton(navController: NavController, title: String, destination: String) {
    Button(
        onClick = { navController.navigate(destination) },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = title,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun SubscriptionSection(navController: NavController) {
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
