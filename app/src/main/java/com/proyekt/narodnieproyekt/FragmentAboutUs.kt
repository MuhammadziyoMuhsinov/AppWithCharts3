package com.proyekt.narodnieproyekt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.proyekt.narodnieproyekt.databinding.FragmentAboutUsBinding


class FragmentAboutUs : Fragment() {

    private var _binding: FragmentAboutUsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentAboutUsBinding.inflate(layoutInflater)



        return binding.root
    }


}