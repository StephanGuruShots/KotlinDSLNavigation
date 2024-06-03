package com.example.bottomnavigation.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.bottomnavigation.BottomNavigationFragment
import com.example.bottomnavigation.BottomNavigationScreenNavigationManager
import com.example.bottomnavigation.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    val viewModel: HomeViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val TAG = "HomeFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("rawr", "$TAG: onCreateView")

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("rawr", "$TAG: onViewCreated")

        binding.btnBack.setOnClickListener {
            (parentFragment?.parentFragment as BottomNavigationFragment).navigateBack()
        }

        val textView: TextView = binding.textHome

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.text.collect() {
                    textView.text = it
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        Log.d("rawr", "$TAG: onDestroy")

    }

    override fun onPause() {
        super.onPause()

        Log.d("rawr", "$TAG: onPause")

    }

    override fun onStart() {
        super.onStart()

        Log.d("rawr", "$TAG: onStart")

    }

    override fun onStop() {
        super.onStop()

        Log.d("rawr", "$TAG: onStop")

    }

    override fun onResume() {
        super.onResume()

        Log.d("rawr", "$TAG: onResume")

    }
}