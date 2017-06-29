package edu.ubb.academicinfo.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import javax.inject.Singleton
import javax.inject.Inject

@Singleton
class SharedPreferenceManager @Inject constructor(context: Context) {

    companion object {
        val AUTH_TOKEN: String = "auth_token"
        val AUTH_ID: String = "user_ip"
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
            "192.168.1.95"
        }
    }

    fun getToken(): String? = getString(AUTH_TOKEN)

    fun setToken(token: String) {
        putString(AUTH_TOKEN, token)
    }

    fun getId(): Int = getInt(AUTH_ID)

    fun setID(token: Int) {
        putInt(AUTH_ID, token)
    }

    private fun getString(key: String): String {
        return preferences.getString(key, "")
    }

    private fun putString(key: String, value: String) {
        preferences.edit().putString(key, value).apply()
    }

    private fun getInt(key: String): Int {
        return preferences.getInt(key, 0)
    }

    private fun putInt(key: String, value: Int) {
        preferences.edit().putInt(key, value).apply()
    }

}