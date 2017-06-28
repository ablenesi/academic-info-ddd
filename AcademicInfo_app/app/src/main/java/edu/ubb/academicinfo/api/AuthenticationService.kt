package edu.ubb.academicinfo.api

import edu.ubb.academicinfo.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationService {

    @POST("users/login")
    fun login(@Body login: LoginDTO): Call<User>

}

data class LoginDTO(val email: String, val passWord: String)