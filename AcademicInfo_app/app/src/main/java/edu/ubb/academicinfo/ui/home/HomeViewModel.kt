package edu.ubb.academicinfo.ui.home

import android.databinding.ObservableBoolean
import edu.ubb.academicinfo.AcademicInfoApp
import edu.ubb.academicinfo.api.SemestersService
import edu.ubb.academicinfo.model.Semester
import edu.ubb.academicinfo.util.SharedPreferenceManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class HomeViewModel(val handler: EventHandler) {

    interface EventHandler {
        fun showError(error: String)
        fun dataLoaded(semesters: List<Semester>?)
    }

    @Inject
    lateinit var semesterService: SemestersService
    @Inject
    lateinit var sharedPref: SharedPreferenceManager

    var loading: ObservableBoolean = ObservableBoolean(false)

    init {
        AcademicInfoApp.appComponent.inject(this)

        semesterService.getSemesters(sharedPref.getId()).enqueue(object : Callback<List<Semester>> {
            override fun onResponse(call: Call<List<Semester>>?, response: Response<List<Semester>>?) {
                loading.set(false)
                handler.dataLoaded(response?.body())
            }

            override fun onFailure(call: Call<List<Semester>>?, t: Throwable?) {
                loading.set(false)
                handler.showError("Failed to load semesters " + t?.message)
            }
        })
    }
}