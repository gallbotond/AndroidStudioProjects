package com.example.androidfundamentals3

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AriplaneModeChangedReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneModeEnabled = intent?.getBooleanArrayExtra("state") ?: return
        if (isAirplaneModeEnabled[0]) {
            // Airplane mode is enabled
            Toast.makeText(context, "Airplane mode is enabled", Toast.LENGTH_SHORT).show()
        } else {
            // Airplane mode is disabled
            Toast.makeText(context, "Airplane mode is disabled", Toast.LENGTH_SHORT).show()
        }
    }
}