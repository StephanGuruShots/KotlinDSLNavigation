package com.example.bottomnavigation.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    val text: MutableStateFlow<String> = MutableStateFlow("")

    init {
        text.value = "loading..."
        viewModelScope.launch {
            delay(5000)
            text.value = "HomeViewModel loaded"
        }
        Log.d("rawr","HomeViewModel init")
    }

}