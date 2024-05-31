package com.example.seconscreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.presentation.models.User
import com.example.seconscreen.databinding.FragmentSecondBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    @Inject lateinit var navigationManager: SecondScreenNavigationManager

    val TAG = "SecondFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        Log.d("rawr","$TAG: onCreateView")

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("rawr","$TAG: onViewCreated")

        binding.btnThirdScreen.setOnClickListener {
            with(navigationManager) {
                navigateToThirdScreen(
                    amount = 4,
                    value = "sadsds",
                    user = User(
                        name = "John",
                        age = 30
                    )
                )
            }
        }

        binding.btnBack.setOnClickListener {
            with(navigationManager) {
                navigateBack()
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()

        Log.d("rawr","$TAG: onDestroy")

    }

    override fun onPause() {
        super.onPause()

        Log.d("rawr","$TAG: onPause")

    }

    override fun onStart() {
        super.onStart()

        Log.d("rawr","$TAG: onStart")

    }

    override fun onStop() {
        super.onStop()

        Log.d("rawr","$TAG: onStop")

    }

    override fun onResume() {
        super.onResume()

        Log.d("rawr","$TAG: onResume")

    }
}