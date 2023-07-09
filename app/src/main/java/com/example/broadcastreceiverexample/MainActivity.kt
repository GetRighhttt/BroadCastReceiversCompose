package com.example.broadcastreceiverexample

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.broadcastreceiverexample.ui.theme.BroadCastReceiverExampleTheme

class MainActivity : ComponentActivity() {

    // declaring our dynamic broadcast receiver variables
    private val airplaneModeReceiver by lazy { AirplaneModeReceiver() }
    private val phoneChargingReceiver by lazy { PhoneChargingReceiver() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // here is how we register receivers without manifest
        registerReceiver(airplaneModeReceiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
        registerReceiver(phoneChargingReceiver, IntentFilter(Intent.ACTION_POWER_CONNECTED))

        setContent {
            BroadCastReceiverExampleTheme {
            }
        }
    }

    // must unregister dynamic receivers when application is destroyed
    // meaning this will only work when app is active
    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(airplaneModeReceiver)
        unregisterReceiver(phoneChargingReceiver)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BroadCastReceiverExampleTheme {
        Greeting("Android")
    }
}