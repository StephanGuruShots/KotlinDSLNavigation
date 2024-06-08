package com.example.bottomnavigation.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bottomnavigation.R

class InnerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        Log.d("rawr", "oncreateview inner fragment")

        return inflater.inflate(R.layout.fragment_inner, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        Log.d("rawr", "ondestroyview inner fragment")

    }
}