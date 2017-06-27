package edu.ubb.academicinfo.ui.home.semseter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.ubb.academicinfo.R
import edu.ubb.academicinfo.model.Semester

class SemesterFragment : Fragment() {

    companion object {
        fun newInstance(semester: Semester): SemesterFragment {
            val args = Bundle()
            args.putParcelable(SEMESTER, semester)

            val fragment = SemesterFragment()
            fragment.arguments = args
            return fragment
        }

        const val SEMESTER = "semester"
    }

    lateinit var binding: ViewDataBinding

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_semester, container, false)
        return binding.root
    }
}