package com.ramm.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.ramm.wastify.databinding.ActivityEdukasiBinding


class EdukasiActivity : AppCompatActivity() {

    private lateinit var userBinding: ActivityEdukasiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userBinding = ActivityEdukasiBinding.inflate(layoutInflater)
        setContentView(userBinding.root)

    }
}