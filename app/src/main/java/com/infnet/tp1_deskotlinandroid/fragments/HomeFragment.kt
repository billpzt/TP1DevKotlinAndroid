package com.infnet.tp1_deskotlinandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.infnet.tp1_deskotlinandroid.R
import com.infnet.tp1_deskotlinandroid.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        setup()
        return view
    }

    private fun setup() {
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.apply{
            btnPaises.setOnClickListener{
                nav(R.id.action_homeFragment_to_paisesFragment)
            }

            btnEstilos.setOnClickListener {
                nav(R.id.action_homeFragment_to_estilosFragment)
            }
        }
    }

    fun nav(id: Int){
        findNavController().navigate(id)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}