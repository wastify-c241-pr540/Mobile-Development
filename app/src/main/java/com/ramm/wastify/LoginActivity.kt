package com.ramm.wastify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.runtime.Composable
import com.google.firebase.inappmessaging.model.Button
import com.ramm.ui.HomeActivity
import com.ramm.wastify.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var userBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(userBinding.root)

        userBinding.skipTextView.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }


}