package edu.ubb.academicinfo.ui.home

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import edu.ubb.academicinfo.R
import edu.ubb.academicinfo.databinding.ActivityHomeBinding
import edu.ubb.academicinfo.model.Course
import edu.ubb.academicinfo.model.Semester

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.pager.adapter = SemesterPagerAdapter(listOf(Semester("2016/2017 I", 8.92f, 30, emptyList<Course>().toMutableList())).toMutableList(), supportFragmentManager)
        binding.tabLayout.setupWithViewPager(binding.pager
        )
    }
}
