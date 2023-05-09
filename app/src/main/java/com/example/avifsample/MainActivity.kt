package com.example.avifsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.avifsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        loadImage(binding.avifImage, "f_avif")
        loadImage(binding.webpImage, "f_webp")
    }

    private fun loadImage(imageView: ImageView, formatParam: String) {
        Glide.with(this).load(buildImageUrl(formatParam)).centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground).into(imageView)
    }

    private fun buildImageUrl(formatParam: String) =
        "https://res.cloudinary.com/swiggy/image/upload/c_fill,$formatParam,q_auto,h_375,w_302/v1674029842/PC_Creative%20refresh/3D_bau/banners_new/Vada.png".also {
            Log.d(TAG, "buildImageUrl: $it")
        }
}

private const val TAG = "MainActivity"