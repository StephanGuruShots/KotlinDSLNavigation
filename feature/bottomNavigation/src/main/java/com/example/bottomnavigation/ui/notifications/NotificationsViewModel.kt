package com.example.bottomnavigation.ui.notifications

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotificationsViewModel @Inject constructor() : ViewModel() {
    val text: MutableStateFlow<String> = MutableStateFlow("")

    init {
        text.value = "loading..."
        viewModelScope.launch {
            delay(5000)
            text.value = "NotificationsViewModel loaded"
        }
        Log.d("rawr","NotificationsViewModel init")
    }
}