package com.infnet.tp1_deskotlinandroid.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.infnet.tp1_deskotlinandroid.daos.EstiloDao
import com.infnet.tp1_deskotlinandroid.daos.PaisDao
import com.infnet.tp1_deskotlinandroid.models.Estilo
import com.infnet.tp1_deskotlinandroid.models.Pais

@Database(entities = [Pais::class, Estilo::class], version = 1, exportSchema = false)
abstract class LutasDatabase: RoomDatabase() {

    // Interfaces que alteram o banco de dados
    abstract fun paisDao(): PaisDao
    abstract fun estiloDao(): EstiloDao
}