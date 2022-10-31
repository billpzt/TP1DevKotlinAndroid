package com.infnet.tp1_deskotlinandroid.daos

import androidx.room.*
import com.infnet.tp1_deskotlinandroid.models.Pais

@Dao
interface PaisDao {
        // CRUD:

        // Create
        @Insert
        fun insert(pais: Pais)

        // Read
        @Query("SELECT * FROM Pais WHERE Pais.id = :id")
        fun getById(id: Long): Pais

        // Update
        @Update
        fun update(pais: Pais)

        // Delete
        @Delete
        fun delete(pais: Pais)

        @Query("SELECT * FROM Pais")
        fun getAll(): List<Pais>
}