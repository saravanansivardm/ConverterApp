package com.unitconverter.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val IconButtonSizedMethodModifier = Modifier.size(40.dp)

@Composable
fun RoundedButtons(
    modifier: Modifier,
    onClick: () -> Unit = {},
    buttonText: String,
    isLandsScape: Boolean,
) {
    if (isLandsScape) {
        Card(
            modifier = modifier
                .width(250.dp)
                .height(50.dp)
                .padding(start = 20.dp, end = 20.dp, top = 11.dp)
                .clickable { onClick.invoke() }
                .then(IconButtonSizedMethodModifier),
            colors = CardDefaults.cardColors(
                containerColor = Color.Blue, //Card background color
                contentColor = Color.Red  //Card content color,e.g.text
            ),
            shape = RoundedCornerShape(10.dp),
        ) {
            Text(
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 8.dp),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp,
                color = Color.White,
                text = buttonText,
            )
        }
    } else {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 20.dp, end = 20.dp, top = 11.dp)
                .clickable { onClick.invoke() }
                .then(IconButtonSizedMethodModifier),
            colors = CardDefaults.cardColors(
                containerColor = Color.Blue, //Card background color
                contentColor = Color.Red  //Card content color,e.g.text
            ),
            shape = RoundedCornerShape(10.dp),
        ) {
            Text(
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 8.dp),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp,
                color = Color.White,
                text = buttonText,
            )
        }
    }

}