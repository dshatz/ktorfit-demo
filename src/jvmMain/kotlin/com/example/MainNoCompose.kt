package com.example

import com.example.service.IpService
import de.jensklingenberg.ktorfit.Ktorfit
import kotlinx.coroutines.runBlocking


private fun createIpService(): IpService {
    val ktorFit = Ktorfit.Builder().build()
    return ktorFit.create()
}

fun main() {
    val ipService = createIpService()
    runBlocking {
        println(ipService.getIp())
    }
}