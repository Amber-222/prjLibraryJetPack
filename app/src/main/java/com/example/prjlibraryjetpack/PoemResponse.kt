package com.example.prjlibraryjetpack

data class PoemResponse(
    val title: String,
    val author: String,
    val lines: MutableList<String>, //poems are returned in an array of lines as elements
    val linecount: Int
)
