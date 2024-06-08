package com.example.bottomnavigation.ui.notifications

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
import com.example.bottomnavigation.databinding.FragmentNotificationsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    val TAG = "NotificationsFragment"

    val viewModel: NotificationsViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("rawr","$TAG: onCreateView")

        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        Log.d("rawr","$TAG: onDestroy")

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView: TextView = binding.textNotifications
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
//                viewModel.text.collect() {
//                    textView.text = it
//                }
                delay(5000)
                textView.text = "Done!"
            }
        }
        Log.d("rawr","$TAG: onViewCreated")

//        val menu = (parentFragment?.parentFragment as BottomNavigationFragment).menu
//
//        binding.btnHome.setOnClickListener {
//            navigateToBottomTab(NavigationRoute.HOME_SCREEN.toMenuItem(menu), findNavController())
//        }
//
//        findNavController()
//
//        binding.btnDashboard.setOnClickListener {
//            navigateToBottomTab(NavigationRoute.DASHBOARD_SCREEN.toMenuItem(menu), findNavController())
//        }

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