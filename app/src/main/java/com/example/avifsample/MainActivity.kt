package com.example.avifsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions
import com.example.avifsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupLoadClickListener()
    }

    private fun setupLoadClickListener() {
        binding.loadButton.setOnClickListener {
            val imageId = binding.urlEditText.text.trim().toString()
            loadImage(binding.webpImage, "f_webp", imageId)
            loadImage(binding.avifImage, "f_avif", imageId)
        }
    }

    private fun loadImage(imageView: ImageView, formatParam: String, imageId: String) {
        Glide.with(this).load(buildImageUrl(formatParam, imageId)).centerInside()
            .placeholder(R.drawable.ic_launcher_foreground).into(imageView)
    }

    private fun getRequestOptions() = RequestOptions()
        .format(DecodeFormat.PREFER_RGB_565)
        .disallowHardwareConfig()

    // food bb icon https://res.cloudinary.com/swiggy/image/upload/$formatParam/rng/md/carousel/production/z5kgwcyecjebueopxcbs
    // food nav tile https://res.cloudinary.com/swiggy/image/upload/$formatParam/rng/md/carousel/production/uycdjcbljscpflwcjeob
    private fun buildImageUrl(formatParam: String, imageId: String) =
        "https://res.cloudinary.com/swiggy/image/upload/$formatParam/$imageId".also {
            Log.d(TAG, "buildImageUrl: $it")
        }
}

private const val TAG = "MainActivity"