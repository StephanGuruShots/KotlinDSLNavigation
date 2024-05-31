package com.example.firstscreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firstscreen.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    val TAG = "FirstFragment"

    @Inject
    lateinit var navigationManager: FirstScreenNavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        Log.d("rawr","$TAG: onCreateView")

        binding = FragmentFirstBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("rawr","$TAG: onViewCreated")

        parentFragmentManager.setFragmentResultListener("requestKey", this) { requestKey, bundle ->
            // We use a String here, but any type that can be put in a Bundle is supported.
            val result = bundle.getString("bundleKey")

            Log.d("rawr","result = $result")
            // Do something with the result.
        }

        binding.btnSecondScreen.setOnClickListener {
            with(navigationManager) {
                navigateToSecondScreen()
            }
        }

        binding.btnTask.setOnClickListener {
            with(navigationManager) {
                navigateToTaskScreen()
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