package edu.ubb.academicinfo.ui.login

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import edu.ubb.academicinfo.R
import edu.ubb.academicinfo.databinding.ActivityLoginBinding
import edu.ubb.academicinfo.model.User
import edu.ubb.academicinfo.ui.home.HomeActivity

class LoginActivity : AppCompatActivity(), LoginViewModel.EventHandler {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.viewModel = LoginViewModel(this)
    }

    override fun showError(error: String) {
        Snackbar.make(binding.root, error, Snackbar.LENGTH_LONG).show()
    }

    override fun loginSuccess(user: User?) {
        startActivity(Intent(this, HomeActivity::class.java))
    }

}
