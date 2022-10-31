package com.infnet.tp1_deskotlinandroid.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.infnet.tp1_deskotlinandroid.models.Estilo

@Dao
interface EstiloDao {
    // CRUD:

    // Create
    @Insert
    fun insert(estilo: Estilo)

    // Read
    @Query("SELECT * FROM Estilo WHERE Estilo.id = :id")
    fun getById(id: Long): Estilo

    // Update
    @Update
    fun update(estilo: Estilo)

    // Delete
    @Delete
    fun delete(estilo: Estilo)

    @Query("SELECT * FROM Estilo")
    fun getAll(): List<Estilo>

    @Query("SELECT * From Estilo WHERE paisId = :id")
    fun getEstilosByPaisId(id: Long) : List<Estilo>
}