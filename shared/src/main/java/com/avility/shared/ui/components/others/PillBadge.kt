package com.avility.shared.ui.components.others

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.avility.shared.ui.components.containers.BasicContainer
import com.avility.shared.ui.constants.MeasureSmallDimen
import com.avility.shared.ui.constants.roundedShapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PillBadge(
    text: String,
    containerColor: Color = MaterialTheme.colorScheme.secondary,
    borderColor: Color = Color.Transparent,
    contentColor: Color = MaterialTheme.colorScheme.onSecondary
) {

    Badge(
        modifier = Modifier.border(
            width = 1.dp,
            color = borderColor,
            shape = roundedShapes.medium
        ).padding(MeasureSmallDimen.DIMEN_X03.value),
        containerColor = containerColor,
        contentColor = contentColor
    ){
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge.copy(
                color = contentColor
            ),
            color = contentColor
        )
    }
}

@Preview
@Composable
fun PillBadgePreview() {
    return PillBadge(text = "Hello World")
}