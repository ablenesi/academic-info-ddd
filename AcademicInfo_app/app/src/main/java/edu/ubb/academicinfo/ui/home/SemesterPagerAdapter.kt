package edu.ubb.academicinfo.ui.home

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import edu.ubb.academicinfo.model.Semester
import edu.ubb.academicinfo.ui.home.semseter.SemesterFragment

class SemesterPagerAdapter(val semesters: MutableList<Semester>, fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment = SemesterFragment.newInstance(semesters[position])

    override fun getCount(): Int = semesters.size

    override fun getPageTitle(position: Int): CharSequence = semesters[position].name

}