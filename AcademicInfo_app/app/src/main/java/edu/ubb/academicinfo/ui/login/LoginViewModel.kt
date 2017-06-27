package edu.ubb.academicinfo.ui.login

import android.databinding.ObservableBoolean

class LoginViewModel {

    var email = ""
    var password = ""
    var loading: ObservableBoolean = ObservableBoolean(false)

    fun login() {
        loading.set(true)
        print(email)
        // TODO Implement Log In request
    }
}