package com.bareksa.test.ui.intro

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.bareksa.test.R
import com.bareksa.test.databinding.ActivitySplashBinding
import com.bareksa.test.ui.comparison.ComparisonActivity
import com.bumptech.glide.Glide

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this).load(R.drawable.logo_bareksa).into(binding.imageLogo)

        Glide.with(this).load(R.drawable.logo_ojk).into(binding.imageOjk)

        Handler(mainLooper).postDelayed({
            startActivity(Intent(this, ComparisonActivity::class.java))
            finish()
        }, 3000)
    }
}