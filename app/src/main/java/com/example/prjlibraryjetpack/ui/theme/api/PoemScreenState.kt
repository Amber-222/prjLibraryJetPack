package com.example.prjlibraryjetpack.ui.theme.api

import com.example.prjlibraryjetpack.PoemResponse

data class PoemScreenState(
    val poem: List<PoemResponse> = emptyList(), //store the poem object (Should be empty in case no poems have been created yet, so this is then where "Create new poem" in somewhere is used so that if a poem doesn't exist (like my will to live) it will be like it is okay, we showing that there is nada and you can add later. <3
    val isLoading: Boolean = false, //tracks whether a response has been provided yet
    val error: String? = null //stores any errors that occur
)
