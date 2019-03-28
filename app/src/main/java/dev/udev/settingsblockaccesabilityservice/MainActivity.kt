package dev.udev.settingsblockaccesabilityservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.provider.Settings


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_start.setOnClickListener {
            startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
        }
        val preferencesHelper = PreferencesHelper(this)

        switch1.isChecked = preferencesHelper.isBlockEnabled
        switch1.setOnCheckedChangeListener { _, isChecked ->
            preferencesHelper.isBlockEnabled = isChecked
        }
    }
}
