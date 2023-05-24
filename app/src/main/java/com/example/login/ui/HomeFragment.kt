package com.example.login.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.login.databinding.FragmentInicioBinding
import com.example.login.ui.home.HomeViewModel

class HomeFragment : Fragment() {

private var _binding: FragmentInicioBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

    _binding = FragmentInicioBinding.inflate(inflater, container, false)
    val root: View = binding.root
    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}