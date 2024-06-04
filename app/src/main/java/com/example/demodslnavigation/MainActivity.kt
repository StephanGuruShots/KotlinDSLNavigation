package com.example.demodslnavigation

import android.content.Intent
import android.os.Bundle
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import com.example.demodslnavigation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        onBackPressedDispatcher.addCallback {
            try {
                navController.popBackStack()
            } catch (e: Exception) {
                onBackPressedDispatcher.onBackPressed()
            }
        }

        setContentView(binding.root)
    }


    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        if (intent.action == Intent.ACTION_VIEW) {
            navController.handleDeepLink(intent)
        }
    }
}