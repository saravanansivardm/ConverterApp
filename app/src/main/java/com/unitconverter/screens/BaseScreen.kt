package com.unitconverter.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.unitconverter.utils.toastMessage
import com.unitconverter.viewmodel.ConvertorViewModel
import kotlinx.coroutines.launch

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    viewModel: ConvertorViewModel = hiltViewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val configurationChanges = LocalConfiguration.current
    var isLandsScape by remember {
        mutableStateOf(false)
    }
    when (configurationChanges.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            isLandsScape = true
            Row(
                modifier = modifier
                    .fillMaxSize()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                TopScreen(viewModel.getConversionList(), isLandsScape = isLandsScape)
                Spacer(modifier = modifier.width(10.dp))
                val historyList = viewModel.resultList.collectAsState(initial = emptyList())
                if (historyList.value.isNotEmpty()) {
                    HistoryListScreen(
                        modifier = modifier,
                        isLandsScape = isLandsScape,
                        historyList,
                        viewModel,
                        onCloseTask = {
                            coroutineScope.launch {
                                viewModel.deleteResult(it)
                                toastMessage("Deleted successfully", context)
                            }
                        }, onClearAllData = {
                            if (historyList.value.isNotEmpty()) {
                                coroutineScope.launch {
                                    viewModel.deleteAll()
                                    toastMessage("All values deleted successfully", context)
                                }
                            } else {
                                toastMessage("No Values available to delete", context)
                            }
                        })
                }
            }
        }

        else -> {
            isLandsScape = false
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(top = 16.dp)
            ) {
                TopScreen(viewModel.getConversionList(), isLandsScape = isLandsScape)
                Spacer(modifier = modifier.height(20.dp))
                val historyList = viewModel.resultList.collectAsState(initial = emptyList())
                if (historyList.value.isNotEmpty()) {
                    HistoryListScreen(
                        modifier = modifier,
                        isLandsScape = isLandsScape,
                        historyList,
                        viewModel,
                        onCloseTask = {
                            coroutineScope.launch {
                                viewModel.deleteResult(it)
                                toastMessage("Deleted successfully", context)
                            }
                        }, onClearAllData = {
                            if (historyList.value.isNotEmpty()) {
                                coroutineScope.launch {
                                    viewModel.deleteAll()
                                    toastMessage("All values deleted successfully", context)
                                }
                            } else {
                                toastMessage("No Values available to delete", context)
                            }
                        })
                }
            }
        }
    }

}