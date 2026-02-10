package com.example.artspace

import androidx.annotation.DrawableRes

data class Resource(
    @DrawableRes val img: Int,
    val title: Int,
    val author: Int,
    val date: Int
)
