package com.avility.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.avility.domain.model.CoinModel
import com.avility.presentation.R
import com.avility.shared.ui.components.containers.BaseRowItem
import com.avility.shared.ui.constants.MeasureSmallDimen
import com.avility.shared.ui.constants.green500
import com.avility.shared.ui.constants.orange500
import com.avility.shared.ui.styles.DimensionParams

@Composable
fun CoinItem(
    coin: CoinModel,
    onTap: () -> Unit
) {
    BaseRowItem(
        leading = {
            Column {
                Text(
                    text = "${coin.rank}. ${coin.name}",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.onSecondary
                    )
                )
            }
        },
        trailing = {
            Column {
                var status = stringResource(id = R.string.active_status)
                var colorStatus = green500
                if (!coin.isActive) {
                    status = stringResource(id = R.string.in_active_status)
                    colorStatus = orange500
                }
                Text(
                    text = status,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = colorStatus
                    )
                )
            }
        },
        leadingWeight = 0.7f,
        trailingWeight = 0.3f,
        containerColor = Color.Transparent,
        dimensionParams = DimensionParams(
            width = null,
            height = MeasureSmallDimen.DIMEN_X28.value
        ),
        onTap = onTap
    )
}