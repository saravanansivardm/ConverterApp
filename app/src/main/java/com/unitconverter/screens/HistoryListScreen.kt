package com.unitconverter.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.unitconverter.db.ConversionResultEntity
import com.unitconverter.viewmodel.ConvertorViewModel

@Composable
fun HistoryListScreen(
    modifier: Modifier = Modifier,
    isLandsScape: Boolean,
    historyList: State<List<ConversionResultEntity>>,
    viewModel: ConvertorViewModel = hiltViewModel(),
    onCloseTask: (ConversionResultEntity) -> Unit,
    onClearAllData: () -> Unit,
) {
    if (isLandsScape) {
        Column {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 18.sp,
                    color = Color.Black,
                    text = "History",
                )
                Card(
                    modifier = modifier
                        .width(100.dp)
                        .height(45.dp)
                        .clickable {
                            onClearAllData()
                        },
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White, //Card background color
                        contentColor = Color.White  //Card content color,e.g.text
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    )
                ) {
                    Text(
                        modifier = modifier
                            .padding(top = 10.dp)
                            .align(Alignment.CenterHorizontally),
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 17.sp,
                        color = Color.Black,
                        text = "Clear All",
                    )
                }
            }
            LazyColumn(modifier = modifier.padding(top = 16.dp)) {
                itemsIndexed(historyList.value) { index, item ->
                    HistoryItem(
                        item.convertTo,
                        item.convertFrom,
                        item.inputText,
                        item.roundedResult,
                        onClose = {
                            onCloseTask(item)
                        }
                    )
                }
            }
        }
    } else {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 18.sp,
                color = Color.Black,
                text = "History",
            )
            Card(
                modifier = modifier
                    .width(100.dp)
                    .height(45.dp)
                    .clickable {
                        onClearAllData()
                    },
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White, //Card background color
                    contentColor = Color.White  //Card content color,e.g.text
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ) {
                Text(
                    modifier = modifier
                        .padding(top = 10.dp)
                        .align(Alignment.CenterHorizontally),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 17.sp,
                    color = Color.Black,
                    text = "Clear All",
                )
            }
        }
        LazyColumn(modifier = modifier.padding(top = 16.dp)) {
            itemsIndexed(historyList.value) { index, item ->
                HistoryItem(
                    item.convertTo,
                    item.convertFrom,
                    item.inputText,
                    item.roundedResult,
                    onClose = {
                        onCloseTask(item)
                    }
                )
            }
        }
    }
}