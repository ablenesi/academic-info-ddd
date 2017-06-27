package edu.ubb.academicinfo.ui.home

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.ubb.academicinfo.R

class SemesterFragment : Fragment() {

    lateinit var binding : ViewDataBinding

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_semester, container, false)
        return binding.root
    }
}