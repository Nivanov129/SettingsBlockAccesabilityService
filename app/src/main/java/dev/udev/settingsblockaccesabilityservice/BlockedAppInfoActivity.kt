package dev.udev.settingsblockaccesabilityservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_blocked_app_info.*

class BlockedAppInfoActivity : AppCompatActivity() {

    val packageNameApp by lazy {
        intent.getStringExtra(PACKAGENAME_INTENT) as String
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blocked_app_info)
        package_name.text = packageNameApp
    }

    companion object {
        val PACKAGENAME_INTENT = "package_name_intent"
    }

    override fun onBackPressed() {

    }
}
