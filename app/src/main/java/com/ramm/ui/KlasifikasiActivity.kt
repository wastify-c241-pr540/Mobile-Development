package com.ramm.ui

import ClasificationHelper
import android.content.Intent
import android.icu.text.NumberFormat
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.sampahclassifier.view.ResultActivity
import com.ramm.wastify.MainActivity
import com.ramm.wastify.databinding.ActivityKlasifikasiBinding
import org.tensorflow.lite.task.vision.classifier.Classifications

class KlasifikasiActivity : AppCompatActivity() {
    private lateinit var userBinding: ActivityKlasifikasiBinding
    private lateinit var clasificationHelper: ClasificationHelper
    private var currentImageUri: Uri? = null
    private var result: String? = null
    private var prediction: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userBinding = ActivityKlasifikasiBinding.inflate(layoutInflater)
        setContentView(userBinding.root)

        userBinding.btnTakePhoto.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        userBinding.btnChooseImage.setOnClickListener { startGallery() }
        userBinding.btnAnalyze.setOnClickListener {
            if (currentImageUri != null) {
            } else {
                Toast.makeText(this, "Silakan pilih gambar terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private val intentGallery = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            currentImageUri = result.data?.data
            showImage()
        }
    }

    private fun showImage() {
        currentImageUri?.let {
            userBinding.ivPreview.setImageURI(it)
        }
    }

    private fun startGallery() {
        launcherGallery.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }

    private val launcherGallery = registerForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        if (uri != null) {
            currentImageUri = uri
            showImage()
        } else {
            Log.d("Photo Picker", "Tidak ada media yang dipilih")
        }
    }



    private fun moveToResult() {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra(ResultActivity.EXTRA_LABEL, result)
        intent.putExtra(ResultActivity.EXTRA_PHOTO_URI, currentImageUri.toString())
        intent.putExtra(ResultActivity.EXTRA_PREDICTION, prediction)
        startActivity(intent)
    }
}
