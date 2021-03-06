package edu.ubb.academicinfo.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import edu.ubb.academicinfo.api.AuthenticationService
import edu.ubb.academicinfo.api.HeaderInterceptor
import edu.ubb.academicinfo.api.SemestersService
import edu.ubb.academicinfo.util.SharedPreferenceManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {

    @Singleton
    @Provides
    fun provideContext(): Context = app.applicationContext

    @Provides
    @Singleton
    fun provideOkHttpClient(headerInterceptor: HeaderInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(headerInterceptor)
                .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, sharePref: SharedPreferenceManager): Retrofit {
        return Retrofit.Builder()
                .baseUrl("http://${sharePref.getIP()}:${sharePref.getPort()}/uma-api/users/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Singleton
    @Provides
    fun provideAuthService(retrofit: Retrofit): AuthenticationService {
        return retrofit.create(AuthenticationService::class.java)
    }

    @Singleton
    @Provides
    fun provideSemesterService(retrofit: Retrofit): SemestersService{
        return  retrofit.create(SemestersService::class.java)
    }

}