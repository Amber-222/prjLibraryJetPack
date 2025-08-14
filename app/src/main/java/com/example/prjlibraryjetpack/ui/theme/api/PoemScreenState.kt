package com.example.prjlibraryjetpack.ui.theme.api

import com.example.prjlibraryjetpack.PoemResponse

data class PoemScreenState(
    val poem: PoemResponse, //store the poem object
    val isLoading: Boolean = false, //tracks whether a response has been provided yet
    val error: String? = null //stores any errors that occur
)
