package com.ramm.ui

import android.os.Bundle
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



    }




}