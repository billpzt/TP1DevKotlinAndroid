package com.infnet.tp1_deskotlinandroid.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [
    ForeignKey(
        entity = Pais::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("paisId"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class Estilo(
    @PrimaryKey
    val id: Long  = 0L,

    val paisId: Long = 0L,

    val nome: String = ""
)