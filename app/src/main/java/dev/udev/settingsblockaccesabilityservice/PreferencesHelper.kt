package dev.udev.settingsblockaccesabilityservice

import android.content.Context
import android.preference.PreferenceManager

class PreferencesHelper(context: Context){
    companion object {
        const val BLOCK_ENABLED = "block_enabled"
    }

    private val preferences = PreferenceManager.getDefaultSharedPreferences(context)

    var isBlockEnabled = preferences.getBoolean(BLOCK_ENABLED, false)
        set(value) = preferences.edit().putBoolean(BLOCK_ENABLED, value).apply()
}