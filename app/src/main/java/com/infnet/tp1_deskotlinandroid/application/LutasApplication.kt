package com.infnet.tp1_deskotlinandroid.application

import android.app.Application
import com.infnet.tp1_deskotlinandroid.repositories.LutasRepository

class LutasApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        LutasRepository.initialize(this)
    }
}