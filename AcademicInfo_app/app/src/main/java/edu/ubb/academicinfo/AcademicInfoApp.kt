package edu.ubb.academicinfo

import android.app.Application
import edu.ubb.academicinfo.di.AppComponent
import edu.ubb.academicinfo.di.AppModule
import edu.ubb.academicinfo.di.DaggerAppComponent

class AcademicInfoApp : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}