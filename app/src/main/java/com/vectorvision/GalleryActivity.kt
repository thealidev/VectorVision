package com.vectorvision

import android.os.Bundle
import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.vectorvision.databinding.ActivityGalleryBinding
import java.io.File

class GalleryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGalleryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val directory = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "VectorVision")
        val files = directory.listFiles()?.filter { 
            it.name.endsWith(".svgc") || it.name.endsWith(".svgv") 
        } ?: emptyList()

        binding.galleryRecycler.layoutManager = GridLayoutManager(this, 3)
        binding.galleryRecycler.adapter = GalleryAdapter(files.map { MediaFile(it.absolutePath) })
    }
}

data class MediaFile(val path: String)
