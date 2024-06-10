package com.example.service

import com.example.API
import de.jensklingenberg.ktorfit.http.GET

interface IpService {
    @GET(API.IP)
    suspend fun getIp(): String
}