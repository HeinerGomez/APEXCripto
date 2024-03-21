package com.avility.presentation.screens.coin_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.avility.presentation.R
import com.avility.presentation.components.HeaderDetailCoin
import com.avility.presentation.screens.coin_list.CoinListScreen
import com.avility.shared.ui.components.containers.MainContainer
import com.avility.shared.ui.components.others.LottieInfoScreen
import com.avility.shared.ui.components.others.PillBadge
import com.avility.shared.ui.constants.MeasureSmallDimen
import com.avility.shared.ui.constants.green500
import com.avility.shared.ui.constants.orange500
import com.avility.shared.ui.constants.white50

/**
 * [CoinListScreen] to show the concrete coin screen
 *
 * @author Heiner Gómez
 * @param [navController] to move across the screens
 * @param [viewModel] to handle the flow of data and his state
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoinDetailScreen(
    navController: NavController,
    viewModel: CoinDetailViewModel = hiltViewModel()
) {
    val state = viewModel.uiState.value
    val data = state.data
    MainContainer(
        isLoading = state.isLoading,
        header = {
            TopAppBar(
                title = {
                    val rank = data?.rank?.toString().orEmpty()
                    Text(
                        text = "$rank. ${data?.name.orEmpty()}",
                        style = MaterialTheme.typography.titleLarge.copy(
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null,
                            tint = white50
                        )
                    }
                }
            )
        },
        headerPadding = false,
        headerColor = Color.Transparent
    ) {
        if (!state.isLoading && state.errorMessage == null && data != null) {
            Column(
                Modifier.fillMaxSize()
            ) {
                  HeaderDetailCoin(data)
                  Divider()
                  Spacer(Modifier.height(MeasureSmallDimen.DIMEN_X03.value))
                  Column {
                     Row {
                          if (data.isOpenSource == true) {
                              PillBadge(
                                  text = stringResource(R.string.open_source_label),
                                  containerColor = Color.Transparent,
                                  borderColor = MaterialTheme.colorScheme.secondary,
                                  contentColor = MaterialTheme.colorScheme.secondary
                              )
                              Spacer(Modifier.width(MeasureSmallDimen.DIMEN_X03.value))
                          }

                         val statusColor = if (data.isActive) {
                             green500
                         } else {
                             orange500
                         }
                         PillBadge(
                             text = stringResource(R.string.active_status),
                             containerColor = Color.Transparent,
                             borderColor = statusColor,
                             contentColor = statusColor
                         )
                         Spacer(Modifier.width(MeasureSmallDimen.DIMEN_X03.value))

                         if (data.isNew) {
                             PillBadge(
                                 text = stringResource(R.string.is_new_label),
                                 containerColor = Color.Transparent,
                                 borderColor = green500,
                                 contentColor = green500
                             )
                         }
                     }
                  }
            }
        }

        if (!state.isLoading && state.errorMessage != null) {
            LottieInfoScreen(
                resource = com.avility.shared.R.raw.error_alert,
                message = stringResource(state.errorMessage),
                contentColor = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}