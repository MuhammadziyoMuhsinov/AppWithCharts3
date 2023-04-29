package com.proyekt.narodnieproyekt.fragmentService

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.proyekt.narodnieproyekt.R


object TransactionService {
    private lateinit var transaction: FragmentTransaction
    fun replaceFragment(fragment: Fragment, manager: FragmentManager, backStack: Boolean) {
        transaction = manager.beginTransaction()
        transaction.replace(R.id.container, fragment).commit()
        if (backStack) {
            transaction.addToBackStack(manager.toString())
        }

    }

    fun addFragment(fragment: Fragment, manager: FragmentManager) {
        transaction = manager.beginTransaction()
        transaction.add(R.id.container, fragment).commit()

    }

    fun removeFragment(fragment: Fragment, manager: FragmentManager) {
        transaction = manager.beginTransaction()
        transaction.remove(fragment)

    }


}