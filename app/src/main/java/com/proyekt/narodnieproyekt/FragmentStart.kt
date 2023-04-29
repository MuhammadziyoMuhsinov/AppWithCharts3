package com.proyekt.narodnieproyekt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.proyekt.narodnieproyekt.databinding.FragmentStartBinding


class FragmentStart : Fragment() {


    private var _binding:FragmentStartBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentStartBinding.inflate(layoutInflater)
        binding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.fragmentMain)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}