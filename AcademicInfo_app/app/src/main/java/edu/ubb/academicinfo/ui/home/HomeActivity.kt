package edu.ubb.academicinfo.ui.home

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import edu.ubb.academicinfo.R

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ViewDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ViewDataBinding>(this, R.layout.activity_home)

    }
}
