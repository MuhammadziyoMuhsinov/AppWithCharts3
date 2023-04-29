package com.proyekt.narodnieproyekt.kesh

import android.content.Context
import android.content.SharedPreferences
import com.proyekt.narodnieproyekt.models.Settings
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object MySharedPreferences {
    private const val NAME = "my_catch_file"
        private const val MODE = Context.MODE_PRIVATE

        private lateinit var sharedPreferences: SharedPreferences

        fun init(context: Context) {
            sharedPreferences = context.getSharedPreferences(NAME, MODE)
        }

        private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
            val editor = edit()
            operation(editor)
            editor.apply()
        }

        var obektString: Settings
            get() = gsonStringToArray(sharedPreferences.getString("obyekt", "[]")!!)
            set(value) = sharedPreferences.edit {
                if (value != null) {
                    it.putString("obyekt", arrayToGsonString(value))
                }

            }


        fun arrayToGsonString(arrayList: Settings): String {

            return Gson().toJson(arrayList)
        }

        fun gsonStringToArray(gsonString: String): Settings {
            val typeToken = object : TypeToken<Settings>() {}.type
            return Gson().fromJson(gsonString, typeToken)
        }
}
