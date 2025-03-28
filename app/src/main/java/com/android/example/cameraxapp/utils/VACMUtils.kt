package com.android.example.cameraxapp.utils

import android.content.Context
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

object VACMUtils {
    private val path_ori_dir = "/storage/emulated/0/Movies/CameraX-Video/"
    private var path_ori = "/storage/emulated/0/Movies/CameraX-Video/2025-03-28-14-26-23-268.mp4"
    private val path_mdf = "/storage/emulated/0/Movies/CameraX-Video/virtual.mp4"

    fun renameMp4File(context: Context): Boolean {
//        val list = listFilenames(path_ori_dir)
//        if(list.isEmpty()) return false
//        val name = list[0]
//        if(name.isEmpty()) return false
//        path_ori = "$path_ori_dir/$name"
        return try {
            val command = arrayOf("su", "-c", "mv $path_ori $path_mdf")
            val process = Runtime.getRuntime().exec(command)
            process.waitFor()
            val reader = BufferedReader(InputStreamReader(process.inputStream))
            val output = StringBuilder()
            var line: String? = reader.readLine()
            while (line != null) {
                output.append(line)
                line = reader.readLine()
            }

            process.exitValue() == 0
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    private fun listFilenames(dir: String): List<String> {
        val list: MutableList<String> = mutableListOf()
        val file = File(dir)
        if (file.exists() && file.isDirectory) {
            val filenames = file.list()
            if (filenames != null) {
                list.addAll(filenames)
            }
        }
        return list
    }

}