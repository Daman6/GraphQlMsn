package com.example.graphqlmsn.presentation

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.graphqlmsn.Model.GameSchedule
import com.example.graphqlmsn.common.Resource
import com.example.graphqlmsn.domain.GetScheduleGameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.lang.Error
import javax.inject.Inject

@HiltViewModel
class ScheduleGameViewModel @Inject constructor(
    private val getScheduleGameUseCase: GetScheduleGameUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(Games())
    val state = _state.asStateFlow()

//    init {
//        viewModelScope.launch {
//            _state.update {
//                it.copy(
//                    isLoading = true
//                )
//            }
//        }
//    }

    fun gameDetail(
        site: String,
        limit: Int,
        offset: Int,
        startDate: Int
    ) {
        viewModelScope.launch {
            val result =  getScheduleGameUseCase.execute(site, limit, offset, startDate)
            when(result){
                is Resource.Loading ->{
                    _state.value =  Games(isLoading = true)
                }
                is Resource.Success ->{
                    _state.value = Games(game = result.data, isLoading = false)
                }
                is Resource.Error ->{
                    _state.value = Games(error = result.message ?: "An unexpected Error")
                }
            }
//            _state.update {
//                it.copy(
//                    game = getScheduleGameUseCase.execute(site, limit, offset, startDate),
//                    isLoading = false
//                )
//            }
        }
    }


    data class Games(
        val isLoading: Boolean = false,
        val game: GameSchedule? = null,
        val error: String = ""
    )
}

