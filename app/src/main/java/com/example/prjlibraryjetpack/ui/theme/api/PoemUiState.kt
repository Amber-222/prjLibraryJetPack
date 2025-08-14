package com.example.prjlibraryjetpack.ui.theme.api

import com.example.prjlibraryjetpack.PoemResponse

sealed interface PoemUiState {
    data object Loading: PoemUiState //stores whether the api request is fulfilled
    data class Success(val poem: PoemResponse): PoemUiState //stores whether the data is pulled from the api
    data class Error(val message: String): PoemUiState //or returns a message if something went wrong
}