package com.example.artspace.viewmodel

import androidx.lifecycle.ViewModel
import com.example.artspace.data.Resource
import com.example.artspace.repository.ArtSpaceRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ArtViewModel : ViewModel() {
    private val repository = ArtSpaceRepo()
    private val listItems = repository.getResources()
    private var currentPosition = 0

    // Expose current artwork as StateFlow
    private val _currentArt = MutableStateFlow(listItems[currentPosition])
    val currentArt: StateFlow<Resource> = _currentArt.asStateFlow()

    // Next Button Logic
    fun onNextClicked() {
        currentPosition = (currentPosition + 1) % listItems.size
        _currentArt.value = listItems[currentPosition]
    }

    // Previous Button Logic
    fun onPreviousClicked() {
        currentPosition = if (currentPosition == 0) {
            listItems.size - 1
        } else {
            currentPosition - 1
        }
        _currentArt.value = listItems[currentPosition]
    }
}