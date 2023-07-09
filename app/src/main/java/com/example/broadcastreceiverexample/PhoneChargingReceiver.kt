package com.example.broadcastreceiverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.util.Log

// Dynamic Broadcast Receiver class
class PhoneChargingReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action == Intent.ACTION_POWER_CONNECTED) {
            val isConnected = Intent.ACTION_POWER_CONNECTED
            Log.d("PhoneChargingReceiver", "Phone charging? : $isConnected")
        }
    }
}