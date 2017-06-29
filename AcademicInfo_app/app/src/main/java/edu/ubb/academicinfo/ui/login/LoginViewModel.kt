package edu.ubb.academicinfo.ui.login

import android.databinding.ObservableBoolean
import edu.ubb.academicinfo.AcademicInfoApp
import edu.ubb.academicinfo.api.AuthenticationService
import edu.ubb.academicinfo.api.LoginDTO
import edu.ubb.academicinfo.model.User
import edu.ubb.academicinfo.util.SharedPreferenceManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LoginViewModel(val handler: LoginViewModel.EventHandler) {

    interface EventHandler {
        fun showError(error: String)
        fun loginSuccess(user: User?)
    }

    @Inject
    lateinit var authService: AuthenticationService
    @Inject
    lateinit var sharedPref: SharedPreferenceManager

    init {
        AcademicInfoApp.appComponent.inject(this)
    }

    var email = ""
    var password = ""

    var loading: ObservableBoolean = ObservableBoolean(false)

    fun login() {
        loading.set(true)
        authService.login(LoginDTO(email, password)).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>?, response: Response<User>?) {
                if (response?.body() != null) {
                    sharedPref.setID(response.body().id)
                } else {
                    handler.showError("Unexpected login response")
                }
                handler.loginSuccess(response?.body())
            }

            override fun onFailure(call: Call<User>?, t: Throwable?) {
                handler.showError(t?.message ?: "Something went wrong")
                loading.set(false)
            }

        })
    }

    init {
        AcademicInfoApp.appComponent.inject(this)
    }
}