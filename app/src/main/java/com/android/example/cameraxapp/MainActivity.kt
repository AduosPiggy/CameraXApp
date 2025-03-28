package com.android.example.cameraxapp

import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.VersionedPackage
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.example.cameraxapp.activity.CameraXActivity
import com.android.example.cameraxapp.databinding.ActivityMainBinding
import com.android.example.cameraxapp.activity.FfmpegActivity
import com.android.example.cameraxapp.utils.PermissionUtils
import com.android.example.cameraxapp.utils.VACMUtils

typealias LumaListener = (luma: Double) -> Unit

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    companion object {
        lateinit var appContext: Context
        lateinit var application: Application
    }

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
        viewBinding.startMdfMp4NameButton.setOnClickListener{
//            val permissions = arrayOf(
//                android.Manifest.permission.READ_EXTERNAL_STORAGE,
//                android.Manifest.permission.WRITE_EXTERNAL_STORAGE
//            )
//
//            PermissionUtils.checkAndRequestMorePermissions(this, permissions, PermissionUtils.REQUEST_CODE_STORAGE_PERMISSION)
//            val success = VACMUtils.renameMp4File(this)
//            Log.i("kfflsol","success: $success")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        finish()
    }

//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == PermissionUtils.REQUEST_CODE_STORAGE_PERMISSION) {
//            if (grantResults.isNotEmpty() && grantResults.all { it == PackageManager.PERMISSION_GRANTED }) {
//                // 权限已授予，执行重命名操作
//                val success = VACMUtils.renameMp4File(this)
//                Log.i("kfflsol", "success: $success")
//            } else {
//                // 权限被拒绝，提示用户
//                Log.i("kfflsol", "Permission denied")
//            }
//        }
//    }

}