package com.example.service

import com.example.API
import com.example.ExternalModel
import de.jensklingenberg.ktorfit.http.GET

interface IpService {
    @GET(API.IP)
    suspend fun getIp(): String
}