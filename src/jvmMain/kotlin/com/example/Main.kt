package com.example

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.service.IpService
import de.jensklingenberg.ktorfit.Ktorfit

private fun createIpService(): IpService {
    val ktorFit = Ktorfit.Builder().build()
    return ktorFit.create()
}

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    val service = remember { createIpService() }

    val ip: String by produceState("", service) {
        value = service.getIp()
    }

    MaterialTheme {
        Column {
            Button(onClick = {
                text = "Hello, Desktop!"
            }) {
                Text(text)
            }

            AnimatedVisibility(ip.isNotEmpty()) {
                Text(ip)
            }

        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
