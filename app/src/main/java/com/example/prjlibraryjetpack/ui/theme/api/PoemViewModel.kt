package com.example.prjlibraryjetpack.ui.theme.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prjlibraryjetpack.PoemResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.prjlibraryjetpack.RetrofitClient



class PoemViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(PoemScreenState()) //stores the class that contains details about the api requests
    val uiState: StateFlow<PoemScreenState> = _uiState

    //as soon as this viewmodel is called, fetch the titles
    init {
        fetchTitles() //fetches the titles when the view model is initially created
    }

    fun fetchTitles() {
        _uiState.value = _uiState.value.copy(isLoading = true, error = null) //set the loading to true and the error to nothing when it is first called
        viewModelScope.launch {
            try {
                val titles = RetrofitClient.instance.getTitles()
            }
            catch (e: Exception) {
                _uiState.value = _uiState.value.copy(isLoading = false, error = e.message)
            }
        }
    }
}