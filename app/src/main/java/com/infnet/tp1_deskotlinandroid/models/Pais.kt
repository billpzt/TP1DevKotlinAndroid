package com.infnet.tp1_deskotlinandroid.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class
Pais(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L,

    val nome : String =""
)


