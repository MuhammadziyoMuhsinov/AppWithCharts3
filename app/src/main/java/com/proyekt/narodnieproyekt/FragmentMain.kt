package com.proyekt.narodnieproyekt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.proyekt.narodnieproyekt.fragmentService.TransactionService
import com.proyekt.narodnieproyekt.databinding.FragmentMainBinding


class FragmentMain : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater)
        TransactionService.addFragment(FragmentDiagram1(), childFragmentManager)
        binding.bottomNavbar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.diagram1 -> {
                    TransactionService.replaceFragment(FragmentDiagram1(), childFragmentManager,false)
                }
                R.id.diagram2 -> {
                    TransactionService.replaceFragment(FragmentDiagram2(), childFragmentManager,false)
                }
                R.id.test ->{
                    TransactionService.replaceFragment(FragmentTest(), childFragmentManager,false)
                }
                R.id.setting -> {
                    TransactionService.replaceFragment(FragmentSetting(),childFragmentManager,false)
                }
                R.id.info ->{
                    TransactionService.replaceFragment(FragmentAboutUs(),childFragmentManager,false)
                }
            }
            true
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}