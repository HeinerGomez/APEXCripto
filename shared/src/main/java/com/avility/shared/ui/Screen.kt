package com.avility.shared.ui

sealed class Screen(val route: String) {
    object CoinListScreen : Screen("coin_list_screen")
    object DetailCoinScreen : Screen("detail_coin_screen")
}
