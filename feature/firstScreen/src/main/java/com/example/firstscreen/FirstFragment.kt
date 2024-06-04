package com.example.firstscreen

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.navigation.fragment.findNavController
import com.example.firstscreen.databinding.FragmentFirstBinding
import com.example.presentation.models.ProductDetails
import com.example.presentation.models.User
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
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

        binding.btnDeeplinkArgs.setOnClickListener {
            val productDetails = Uri.encode(Json.encodeToString(User("test",1)))
            val deepLinkUri = Uri.parse("https://www.example.com/product/${productDetails}")

// In your Activity or Fragment
            findNavController().navigate(deepLinkUri)
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