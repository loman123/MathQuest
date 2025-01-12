package com.androidstartercode2024.ui.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext

@Composable
fun HighSchoolScreen(navController: NavController) {
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
            HighSchoolTopicButton(navController, "Ułamki", "fractionsScreen", isPremium = false)
            HighSchoolTopicButton(navController, "Procenty", "percentagesScreen", isPremium = false)
            HighSchoolTopicButton(navController, "Potęgowanie", "exponentsScreen", isPremium = false)
            HighSchoolTopicButton(navController, "Funkcja liniowa", "linearFunctionScreen", isPremium = false)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Matura",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HighSchoolTopicButton(navController, "Liczby rzeczywiste", "realNumbersScreen", isPremium = true)
            HighSchoolTopicButton(navController, "Wyrażenia algebraiczne", "algebraicExpressionsScreen", isPremium = true)
            HighSchoolTopicButton(navController, "Funkcje", "functionsScreen", isPremium = true)
            HighSchoolTopicButton(navController, "Ciągi", "sequencesScreen", isPremium = true)
        }
    }
}

@Composable
fun HighSchoolTopicButton(
    navController: NavController,
    title: String,
    destination: String,
    isPremium: Boolean
) {
    val context = LocalContext.current
    Button(
        onClick = {
            if (isPremium) {
                Toast.makeText(context, "Tylko dla użytkowników którzy posiadają Premium", Toast.LENGTH_SHORT).show()
            } else {
                navController.navigate(destination)
            }
        },
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
