package com.avility.apexcrypto.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.avility.presentation.screens.coin_detail.CoinDetailScreen
import com.avility.presentation.screens.coin_list.CoinListScreen
import com.avility.shared.ui.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.CoinListScreen.route
    ) {
        composable(Screen.CoinListScreen.route) {
            CoinListScreen(navController)
        }
        composable(Screen.DetailCoinScreen.route + "/{coinId}") {
            CoinDetailScreen(navController = navController)
        }
    }
}