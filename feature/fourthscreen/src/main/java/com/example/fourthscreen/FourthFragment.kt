package com.example.fourthscreen

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fourthscreen.databinding.FragmentFourthBinding
import com.example.presentation.core.NavigationRoute
import com.example.presentation.models.User
import com.example.presentation.utils.parcelable

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.goToFF.setOnClickListener {
            findNavController().navigate(NavigationRoute.FIRST_SCREEN)
        }

        binding.goToFFdl.setOnClickListener {
            val deepLinkUri = Uri.parse("test://hand_called")
            findNavController().navigate(deepLinkUri)
        }

        val productDetails = arguments?.parcelable<User>("user")
        Log.d("rawr","$TAG: onViewCreated: $productDetails")
    }
}