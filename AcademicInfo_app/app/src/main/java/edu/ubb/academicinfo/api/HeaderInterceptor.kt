package edu.ubb.academicinfo.api

import edu.ubb.academicinfo.util.SharedPreferenceManager
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor(val sharedPref: SharedPreferenceManager) : Interceptor{

    companion object {
        const val AUTHORIZATION = "Authorization"
    }

    override fun intercept(chain: Interceptor.Chain?): Response? {
        val request = chain?.request()
        val builder = request?.newBuilder()
        if (sharedPref.getToken()!=null) {
            builder?.addHeader(AUTHORIZATION, sharedPref.getToken())
        }

        val response = chain?.proceed(builder?.build())

        if(response != null && response.header(AUTHORIZATION) != null) {
            sharedPref.setToken(response.header(AUTHORIZATION)!!)
        }

        return response
    }

}
