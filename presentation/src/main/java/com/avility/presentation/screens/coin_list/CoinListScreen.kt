package com.avility.presentation.screens.coin_list

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.avility.presentation.R
import com.avility.presentation.components.CoinItem
import com.avility.shared.ui.Screen
import com.avility.shared.ui.components.containers.MainContainer
import com.avility.shared.ui.components.others.LottieInfoScreen
import com.avility.shared.ui.constants.MeasureSmallDimen

/**
 * [CoinListScreen] to show the list coin screen
 *
 * @author Heiner Gómez
 * @param [navController] to move across the screens
 * @param [viewModel] to handle the flow of data and his state
 */
@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel()
) {

    val state = viewModel.uiState.value

    MainContainer(
        isLoading = state.isLoading,
        header = {
            Text(
                text = stringResource(id = R.string.title_list_coin),
                style = MaterialTheme.typography.titleMedium.copy(
                    color = MaterialTheme.colorScheme.onSecondary
                )
            )
            Spacer(modifier = Modifier.height(MeasureSmallDimen.DIMEN_X11.value))
        }
    ) {
        if (state.data.isNotEmpty()) {
            LazyColumn {
                items(state.data) { coin ->
                    CoinItem(coin) {
                        navController.navigate(Screen.DetailCoinScreen.route + "/${coin.id}")
                    }
                    Divider()
                }
            }
        }

        state.data.ifEmpty {
            if (!state.isLoading) {
                state.errorMessage?.let {
                    LottieInfoScreen(
                        resource = com.avility.shared.R.raw.error_alert,
                        message = stringResource(it),
                        contentColor = MaterialTheme.colorScheme.tertiary
                    )
                } ?: LottieInfoScreen(
                    resource = com.avility.shared.R.raw.empty_screen,
                    message = stringResource(R.string.no_data),
                    contentColor = MaterialTheme.colorScheme.tertiary
                )
            }
        }
    }
}