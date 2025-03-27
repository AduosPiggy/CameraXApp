package com.android.example.cameraxapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.example.cameraxapp.activity.CameraXActivity
import com.android.example.cameraxapp.databinding.ActivityMainBinding
import com.android.example.cameraxapp.activity.FfmpegActivity

typealias LumaListener = (luma: Double) -> Unit

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.startFfmpegButton.setOnClickListener{
            val intent = Intent(this, FfmpegActivity::class.java)
            startActivity(intent)
        }
        viewBinding.startCameraXButton.setOnClickListener {
            val intent = Intent(this, CameraXActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
    }


}