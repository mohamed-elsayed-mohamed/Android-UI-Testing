package com.alpha.android_ui_testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alpha.android_ui_testing.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private val binding: ActivitySecondBinding by lazy { ActivitySecondBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}