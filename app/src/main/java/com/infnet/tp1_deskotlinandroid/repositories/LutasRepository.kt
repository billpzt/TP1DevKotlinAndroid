package com.infnet.tp1_deskotlinandroid.repositories

import android.content.Context
import androidx.room.Room
import com.infnet.tp1_deskotlinandroid.database.LutasDatabase
import com.infnet.tp1_deskotlinandroid.models.Estilo
import com.infnet.tp1_deskotlinandroid.models.Pais


private const val DATABASE_NAME = "lutas-db"

class LutasRepository private constructor(context: Context){
    private val database: LutasDatabase = Room
        .databaseBuilder(
            context.applicationContext,
            LutasDatabase::class.java,
            DATABASE_NAME
        )
        .build()

    companion object {
        private var INSTANCE: LutasRepository? = null
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = LutasRepository(context)
            }
        }

        fun get(): LutasRepository {
            return INSTANCE
                ?: throw IllegalStateException("LutasRepository deve ser inicializado.")
        }

    }

    // Chamar o DAO Categoria:
    fun insertPais(pais: Pais){
        database.paisDao().insert(pais)
    }

    fun getPaisByid(id: Long) : Pais{
        return database.paisDao().getById(id)
    }

    fun deletePais(pais: Pais){
        database.paisDao().delete(pais)
    }

    fun updatePais(pais: Pais){
        database.paisDao().update(pais)
    }

    fun getAllPaises(): List<Pais> {
        return database.paisDao().getAll()
    }



    // Chamar o DAO produto:
    fun insertEstilo(estilo: Estilo){
        database.estiloDao().insert(estilo)
    }

    fun getEstiloByid(id: Long) : Estilo{
        return database.estiloDao().getById(id)
    }

    fun deleteEstilo(estilo: Estilo){
        database.estiloDao().delete(estilo)
    }

    fun updateEstilo(estilo: Estilo){
        database.estiloDao().update(estilo)
    }

    fun getAllEstilos(): List<Estilo> {
        return database.estiloDao().getAll()
    }

    fun getAllEstilosByPaisId(id: Long): List<Estilo> {
        return database.estiloDao().getEstilosByPaisId(id)
    }

}