package edu.ubb.academicinfo.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import javax.inject.Singleton
import javax.inject.Inject

@Singleton
class SharedPreferenceManager @Inject constructor(context: Context) {

    companion object {
        val SERVER_IP_KEY: String = "server_ip"
        val SERVER_PORT_KEY: String = "server_port"
    }

    private var preferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun getPort(): String {
        return if (getString(SERVER_PORT_KEY) != "") {
            getString(SERVER_PORT_KEY)
        } else {
            "8080"
        }
    }

    fun getIP(): String {
        return if (getString(SERVER_IP_KEY) != "") {
            getString(SERVER_IP_KEY)
        } else {
            "192.168.100.4"
        }
    }

    private fun getString(key: String): String {
        return preferences.getString(key, "")
    }

    fun putString(key: String, value: String) {
        preferences.edit().putString(key, value).apply()
    }

}