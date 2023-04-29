package com.proyekt.narodnieproyekt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.proyekt.narodnieproyekt.fragmentService.TransactionService
import com.proyekt.narodnieproyekt.kesh.MySharedPreferences
import com.proyekt.narodnieproyekt.models.Settings
import com.proyekt.narodnieproyekt.databinding.FragmentSettingBinding


class FragmentSetting : Fragment() {


    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentSettingBinding.inflate(layoutInflater)
        MySharedPreferences.init(binding.root.context)
        var settings: Settings? = null
        try {
            settings = MySharedPreferences.obektString
            binding.mode.isChecked = settings.dark!!
            binding.notification.isChecked = settings.notification!!
            binding.voice.isChecked = settings.voice!!
            binding.language.setSelection(settings.language!!)

            setLanguage(settings)

        } catch (e: Exception) {
        }



        binding.btnSave.setOnClickListener {
            settings = Settings(
                binding.mode.isChecked,
                binding.voice.isChecked,
                binding.notification.isChecked,
                binding.language.selectedItemPosition
            )
            setLanguage(settings!!)
            TransactionService.removeFragment(FragmentSetting(), requireFragmentManager())
            MySharedPreferences.obektString = settings!!
            Toast.makeText(binding.root.context, "Настройки сохранены!", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    fun setLanguage(settings: Settings) {
        if (settings.language == 0) {
            binding.txtmode.text = "темный режим"
            binding.txtnotification.text = "уведомление"
            binding.txtvoice.text = "звук"
            binding.txtlanguage.text = "язык"
        } else {
            binding.txtmode.text = "dark mode"
            binding.txtnotification.text = "notification"
            binding.txtvoice.text = "voice"
            binding.txtlanguage.text = "language"
        }
    }


}