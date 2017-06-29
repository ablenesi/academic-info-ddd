package edu.ubb.academicinfo.api

import edu.ubb.academicinfo.model.Semester
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SemestersService {
    @GET("{id}/semesters")
    fun getSemesters(@Path("id") id: Int): Call<List<Semester>>
}