package com.unitconverter.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.unitconverter.components.IconButtonSizedMethodModifier

@Composable
fun ResultBlock(
    modifier: Modifier = Modifier,
    isLandsScape: Boolean,
    inputText: String,
    convertFrom: String,
    roundResult: String,
    convertTo: String
) {
    if (isLandsScape) {
        Row(
            modifier = modifier.padding(16.dp, 12.dp, 0.dp, 0.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Card(
                modifier = modifier
                    .width(250.dp)
                    .height(100.dp)
                    .padding(start = 20.dp, end = 20.dp, top = 12.dp)
                    .then(IconButtonSizedMethodModifier),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                    contentColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ) {
                Row {
                    Text(
                        modifier = modifier
                            .padding(start = 12.dp, top = 12.dp),
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        color = Color.Black,
                        text = inputText,
                    )
                    Text(
                        modifier = modifier
                            .padding(start = 12.dp, top = 12.dp),
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        color = Color.Black,
                        text = "$convertFrom is equal to",
                    )
                }
                Row(
                    modifier = modifier
                        .padding(start = 12.dp, top = 4.dp)
                ) {
                    Text(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 24.sp,
                        color = Color.Blue,
                        text = roundResult,
                    )
                    Spacer(modifier = modifier.width(8.dp))
                    Text(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 24.sp,
                        color = Color.Blue,
                        text = convertTo,
                    )
                }
            }
        }
    } else {
        Column(
            modifier = modifier.padding(16.dp, 12.dp, 0.dp, 0.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Card(
                modifier = modifier
                    .width(250.dp)
                    .height(100.dp)
                    .padding(start = 20.dp, end = 20.dp, top = 12.dp)
                    .then(IconButtonSizedMethodModifier),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                    contentColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ) {
                Row {
                    Text(
                        modifier = modifier
                            .padding(start = 12.dp, top = 12.dp),
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        color = Color.Black,
                        text = inputText,
                    )
                    Text(
                        modifier = modifier
                            .padding(start = 12.dp, top = 12.dp),
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        color = Color.Black,
                        text = "$convertFrom is equal to",
                    )
                }
                Row(
                    modifier = modifier
                        .padding(start = 12.dp, top = 4.dp)
                ) {
                    Text(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 24.sp,
                        color = Color.Blue,
                        text = roundResult,
                    )
                    Spacer(modifier = modifier.width(8.dp))
                    Text(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 24.sp,
                        color = Color.Blue,
                        text = convertTo,
                    )
                }
            }
        }
    }
}