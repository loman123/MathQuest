package com.androidstartercode2024.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.androidstartercode2024.ui.navigation.Route
import com.androidstartercode2024.ui.screens.details.*
import com.androidstartercode2024.ui.screens.home.HomeScreen
import com.androidstartercode2024.ui.screens.home.poziomy.LearningPage
import com.androidstartercode2024.ui.screens.home.LoginScreen
import com.androidstartercode2024.ui.screens.home.RegistrationScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val context = LocalContext.current // Pobierz context w Compose

            NavHost(navController = navController, startDestination = Route.homeScreen) {
                // Ekrany główne
                composable(Route.homeScreen) {
                    HomeScreen(navController)
                }
                composable(Route.registrationScreen) {
                    RegistrationScreen(navController = navController, context = context)
                }
                composable(Route.loginScreen) {
                    LoginScreen(navController = navController, context = context)
                }
                composable(Route.mainScreen) {
                    LearningPage(navController)
                }
                composable("skillLevelSelectionScreen") {
                    SkillLevelSelectionScreen(navController = navController)
                }

                // Ekrany poziomów
                composable("highSchoolScreen") {
                    HighSchoolScreen(navController = navController)
                }
                composable("primarySchoolScreen") {
                    PrimarySchoolScreen(navController = navController)
                }




                // Ekrany szczegółowe
                composable("matrixOperationsScreen") {
                    MatrixOperationsScreen()
                }
                composable("circleAreaScreen") {
                    CircleAreaScreen()
                }
                composable("linearEquationsScreen") {
                    LinearEquationsScreen()
                }
                composable("lessonOfTheDayScreen") {
                    LessonOfTheDayScreen()
                }
                composable("integralsScreen") {
                    IntegralsScreen()
                }
                composable("pythagorasScreen") {
                    PythagorasScreen()
                }
                composable("subscriptionScreen") {
                    SubscriptionScreen()
                }
                composable("exponentsScreen") {
                    ExponentsScreen()
                }
                composable("linearFunctionScreen") {
                    LinearFunctionScreen()
                }
                composable("percentagesScreen") {
                    PercentagesScreen()
                }
                composable("fractionsScreen") {
                    FractionsScreen()
                }
                composable("realNumbersScreen") {
                    RealNumbersScreen()
                }

                composable("functionsScreen") {
                    FunctionsScreen()
                }
                composable("sequencesScreen") {
                    SequencesScreen()
                }
                composable("additionScreen") {
                    AdditionScreen()
                }
                composable("subtractionScreen") {
                    SubtractionScreen()
                }
                composable("multiplicationScreen") {
                    MultiplicationScreen()
                }
                composable("divisionScreen") {
                    DivisionScreen() }
                composable("basicGeometryScreen") {
                    BasicGeometryScreen() }


            }
        }
    }
}
