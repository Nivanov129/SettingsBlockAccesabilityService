package dev.udev.settingsblockaccesabilityservice

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import android.accessibilityservice.AccessibilityServiceInfo
import android.content.ComponentName
import android.util.Log
import android.view.accessibility.AccessibilityNodeInfo
import androidx.core.view.MotionEventCompat.getSource
import android.content.Intent


class AccessibilityServiceBlocker : AccessibilityService() {


    override fun onInterrupt() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        val preferencesHelper = PreferencesHelper(this)

        if (preferencesHelper.isBlockEnabled) {
            if (event?.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
                if (event.packageName != null && event.className != null) {
                    val componentName = ComponentName(
                        event.packageName.toString(),
                        event.className.toString()
                    )

                    val dialogIntent = Intent(this, BlockedAppInfoActivity::class.java)
                    dialogIntent.putExtra(BlockedAppInfoActivity.PACKAGENAME_INTENT, componentName.packageName)
                    dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(dialogIntent)
                }
            }
        }
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        Log.d("AccessibilityService: ", "Connected")
        val config = AccessibilityServiceInfo()
        config.eventTypes = AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED
        config.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC
        config.flags = AccessibilityServiceInfo.FLAG_INCLUDE_NOT_IMPORTANT_VIEWS

        serviceInfo = config
    }
}