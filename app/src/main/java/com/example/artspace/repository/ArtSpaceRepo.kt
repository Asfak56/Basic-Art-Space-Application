package com.example.artspace.repository

import com.example.artspace.R
import com.example.artspace.data.Resource

class ArtSpaceRepo {
    fun getResources(): List<Resource> = listOf(
        Resource(
            img = R.drawable.images,
            title = R.string.title_1,
            author = R.string.author_1,
            date = R.string.date_1
        ),
        Resource(
            img = R.drawable.alone,
            title = R.string.title_2,
            author = R.string.author_2,
            date = R.string.date_2
        ),
        Resource(
            img = R.drawable.house,
            title = R.string.title_3,
            author = R.string.author_3,
            date = R.string.date_3
        ),
        Resource(
            img = R.drawable.paris,
            title = R.string.title_4,
            author = R.string.author_4,
            date = R.string.date_4
        ),
        Resource(
            img = R.drawable.childhood,
            title = R.string.title_5,
            author = R.string.author_5,
            date = R.string.date_5
        )
    )
}