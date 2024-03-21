package com.avility.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import com.avility.domain.model.CoinModel
import com.avility.shared.ui.components.containers.BaseRowItem
import com.avility.shared.ui.components.containers.BasicContainer
import com.avility.shared.ui.components.images.RemoteImage
import com.avility.shared.ui.constants.MeasureLargeDimen
import com.avility.shared.ui.constants.MeasureSmallDimen
import com.avility.shared.ui.constants.roundedShapes
import com.avility.shared.ui.styles.DimensionParams

@Composable
fun HeaderDetailCoin(
    coin: CoinModel
) {
    BaseRowItem(
        leading = {
            BasicContainer(
                Modifier
                    .size(MeasureLargeDimen.DIMEN_X12.value)
                    .background(Color.Transparent)
                    .clip(roundedShapes.large),
                containerColor = Color.Transparent
            ) {
                RemoteImage(
                    url = coin.logo.orEmpty()
                )
            }
        },
        dimensionParams = DimensionParams(
            height = MeasureLargeDimen.DIMEN_X18.value
        ),
        trailing = {
            BasicContainer(modifier = Modifier.padding(vertical = MeasureSmallDimen.DIMEN_X08.value),
                containerColor = Color.Transparent) {
                Text(
                    text = coin.description.orEmpty(),
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = MaterialTheme.colorScheme.onBackground
                    ),
                    overflow = TextOverflow.Ellipsis
                )
            }
        },
        containerColor = Color.Transparent
    )
}