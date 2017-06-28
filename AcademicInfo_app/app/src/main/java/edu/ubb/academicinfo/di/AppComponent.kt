package edu.ubb.academicinfo.di

import dagger.Component
import edu.ubb.academicinfo.ui.login.LoginViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(loginViewModel: LoginViewModel)
}