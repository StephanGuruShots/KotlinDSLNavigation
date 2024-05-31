package com.example.bottomnavigation.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.bottomnavigation.BottomNavigationFragment
import com.example.bottomnavigation.BottomNavigationScreenNavigationManager
import com.example.bottomnavigation.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val TAG = "HomeFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("rawr","$TAG: onCreateView")

        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("rawr","$TAG: onViewCreated")

        binding.btnBack.setOnClickListener {
            (parentFragment?.parentFragment as BottomNavigationFragment).navigateBack()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
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