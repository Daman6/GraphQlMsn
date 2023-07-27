package com.example.graphqlmsn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.graphqlmsn.presentation.ScheduleGameViewModel
import com.example.graphqlmsn.ui.theme.GraphQlMsnTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GraphQlMsnTheme {
                val viewModel = hiltViewModel<ScheduleGameViewModel>()
                viewModel.gameDetail( "", 100, 0, 1690355035)

                val state by viewModel.state.collectAsState()

                CountriesScreen(
                    state = state,
                )
            }
        }
    }
}


@Composable
fun CountriesScreen(
    state: ScheduleGameViewModel.Games,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (state.isLoading) {
            LinearProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
        if (state.game != null) {
            Column() {
                Text(text = state.game.limit.toString(), color = Color.Black)
                Text(text = state.game.offset.toString(), color = Color.Black)
            }
        }

        if (state.error.isNotBlank()){
            Text(
                text = state.error,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }


    }

}