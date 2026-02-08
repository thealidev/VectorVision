package com.vectorvision

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.vectorvision.databinding.ActivityViewerBinding

class ViewerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val filePath = intent.getStringExtra("MEDIA_PATH") ?: return
        val isVideo = filePath.endsWith(".svgv")

        // Set Toolbar Title [cite: 2026-02-07]
        binding.viewerToolbar.title = if (isVideo) "SVGV Stream" else "SVGC High-Fidelity"

        if (isVideo) {
            binding.videoControls.visibility = View.VISIBLE
            startGeometricPlayback(filePath)
        } else {
            renderGeometricStatic(filePath)
        }
    }

    private fun startGeometricPlayback(path: String) {
        // Calls the .svgv decoder in C++ [cite: 2026-02-07]
    }

    private fun renderGeometricStatic(path: String) {
        // Calls the .svgc infinite-zoom renderer in C++ [cite: 2026-02-07]
    }
}
