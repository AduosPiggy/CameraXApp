package com.android.example.cameraxapp.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.android.example.cameraxapp.MainActivity


object PermissionUtils {

    public val REQUEST_CODE_STORAGE_PERMISSION = 1

    /**
     * 检测权限
     * @return true：已授权； false：未授权；
     */
    fun checkPermission(context: Context, permission: String): Boolean {
        return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
    }

    /**
     * 检测多个权限
     * @return 未授权的权限
     */
    fun checkMorePermissions(context: Context, permissions: Array<String>): List<String> {
        return permissions.filter { !checkPermission(context, it) }
    }

    /**
     * 请求权限
     */
    fun requestPermission(activity: Activity, permission: String, requestCode: Int) {
        ActivityCompat.requestPermissions(activity, arrayOf(permission), requestCode)
    }

    /**
     * 请求多个权限
     */
    fun requestMorePermissions(activity: Activity, permissions: List<String>, requestCode: Int) {
        ActivityCompat.requestPermissions(activity, permissions.toTypedArray(), requestCode)
    }

    /**
     * 检测权限并请求权限：如果没有权限，则请求权限
     */
    fun checkAndRequestPermission(activity: Activity, permission: String, requestCode: Int) {
        if (!checkPermission(activity, permission)) {
            requestPermission(activity, permission, requestCode)
        }
    }

    /**
     * 检测并请求多个权限
     */
    fun checkAndRequestMorePermissions(activity: Activity, permissions: Array<String>, requestCode: Int) {
        val permissionList = checkMorePermissions(activity, permissions)
        if (permissionList.isNotEmpty()) {
            requestMorePermissions(activity, permissionList, requestCode)
        }
    }

    /**
     * 跳转到权限设置界面
     */
    fun toAppPermissionSetting(context: Context) {
        val intent = Intent().apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            action = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                "android.settings.APPLICATION_DETAILS_SETTINGS"
            } else {
                Intent.ACTION_VIEW
            }
            data = Uri.fromParts("package", context.packageName, null)
        }
        context.startActivity(intent)
    }

    fun getPermissionFromAM(packageName: String): List<String> {
        val pm = MainActivity.application.packageManager
        return try {
            val requestedPermissions = pm.getPackageInfo(packageName, PackageManager.GET_PERMISSIONS).requestedPermissions
            requestedPermissions?.toList() ?: emptyList()
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            emptyList()
        }
    }
}
