package com.example.travels

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageSwitcher
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var imageSwitcher: ImageSwitcher
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageSwitcher = findViewById(R.id.imageSwitcher)
        recyclerView = findViewById(R.id.recyclerView)

        val images = listOf(
            R.drawable.image1, R.drawable.image2, R.drawable.image3,
            R.drawable.image4, R.drawable.image5, R.drawable.image6,
            R.drawable.image7, R.drawable.image8, R.drawable.image9, R.drawable.image10
        )

        imageSwitcher.setFactory {
            android.widget.ImageView(applicationContext).apply {
                scaleType = android.widget.ImageView.ScaleType.CENTER_CROP
                layoutParams = android.widget.FrameLayout.LayoutParams(
                    android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                    android.view.ViewGroup.LayoutParams.MATCH_PARENT
                )
            }
        }

        // Animaciones de transición
        imageSwitcher.inAnimation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        imageSwitcher.outAnimation = AnimationUtils.loadAnimation(this, android.R.anim.fade_out)

        // Configurar RecyclerView horizontal
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = ImageAdapter(images) { image ->
            imageSwitcher.setImageResource(image)
        }
    }
}
