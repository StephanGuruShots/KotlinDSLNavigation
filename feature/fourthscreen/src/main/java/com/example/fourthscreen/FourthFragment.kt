package com.example.fourthscreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fourthscreen.databinding.FragmentFourthBinding
import javax.inject.Inject

class FourthFragment : Fragment() {

    private lateinit var binding: FragmentFourthBinding

    val TAG = "FourthFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFourthBinding.inflate(layoutInflater)
        Log.d("rawr","$TAG: onCreateView")

        return binding.root
    }
}