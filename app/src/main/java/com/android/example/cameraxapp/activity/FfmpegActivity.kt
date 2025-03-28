package com.android.example.cameraxapp.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.example.cameraxapp.databinding.ActivityFfmpegBinding

class FfmpegActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFfmpegBinding
    private val tag_ffmpeg_kfflso = "tag_ffmpeg_kfflso"

    override fun onDestroy() {
        super.onDestroy()
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFfmpegBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.executeButton.setOnClickListener {
            val command = binding.commandEditText.text.toString()
            executeFFmpegCommand(command)
        }

        binding.testButton.setOnClickListener {
            performTest()
        }
    }

    private fun executeFFmpegCommand(command: String) {
        if (command.isNotEmpty()){
            Log.i(tag_ffmpeg_kfflso,"is gong to exec ffmpeg command: { $command }")

        }
    }

    private fun performTest() {
        Log.i(tag_ffmpeg_kfflso,"is gong to exec performTest")
    }
}
