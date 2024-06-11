package com.ramm.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.ramm.wastify.databinding.ActivityHomeBinding
import com.ramm.wastify.databinding.BottomSheetBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var userBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(userBinding.root)

        userBinding.cameraIcon.setOnClickListener {
            val intent = Intent(this, KlasifikasiActivity::class.java)
            startActivity(intent)
        }

        userBinding.iconHome.setOnClickListener {
            // Handle Home icon click
            Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show()
            // startActivity(Intent(this, HomeActivity::class.java))
        }

        userBinding.iconUser.setOnClickListener {
            // Handle Features icon click
            Toast.makeText(this, "Features clicked", Toast.LENGTH_SHORT).show()
             startActivity(Intent(this, EdukasiActivity::class.java))
        }

        userBinding.iconFitur.setOnClickListener {
            // Handle User icon click
            Toast.makeText(this, "Account clicked", Toast.LENGTH_SHORT).show()
            // startActivity(Intent(this, UserActivity::class.java))
        }


    }





}