package com.infnet.tp1_deskotlinandroid.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.infnet.tp1_deskotlinandroid.models.Estilo
import com.infnet.tp1_deskotlinandroid.models.Pais
import com.infnet.tp1_deskotlinandroid.repositories.LutasRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val repositorio = LutasRepository.get()

    fun insertPais(pais: Pais) {
        viewModelScope.launch(Dispatchers.IO) {
            repositorio.insertPais(pais)
        }
    }

    suspend fun getPaisById(id: Long): Pais {

        val pais = viewModelScope.async(Dispatchers.IO) {
            return@async repositorio.getPaisByid(id)
        }
        return pais.await()
    }

    fun deletePaisById(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            repositorio.deletePais(Pais(id = id))
        }
    }

    fun updatePais(pais: Pais){
        viewModelScope.launch(Dispatchers.IO) {
            repositorio.updatePais(pais)
        }
    }

    suspend fun getAllPaises(): List<Pais> {
        val lista = viewModelScope.async(Dispatchers.IO) {
            return@async repositorio.getAllPaises()
        }
        return lista.await()
    }

    suspend fun getAllPaisesString(): String{
        val lista  = getAllPaises()
        var texto = ""
        lista.forEach { item ->
            texto += "${item.id} - ${item.nome}\n"
        }
        return texto
    }

// Estilos:

    fun insertEstilo(estilo: Estilo) {
        viewModelScope.launch(Dispatchers.IO) {
            repositorio.insertEstilo(estilo)
        }
    }

    suspend fun getEstiloById(id: Long): Estilo {

        val estilo = viewModelScope.async(Dispatchers.IO) {
            return@async repositorio.getEstiloByid(id)
        }
        return estilo.await()
    }

    fun deleteEstiloById(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            repositorio.deleteEstilo(Estilo(id = id))
        }
    }

    fun updateEstilo(estilo: Estilo){
        viewModelScope.launch(Dispatchers.IO) {
            repositorio.updateEstilo(estilo)
        }
    }

    suspend fun getAllEstilos(): List<Estilo> {
        val lista = viewModelScope.async(Dispatchers.IO) {
            return@async repositorio.getAllEstilos()
        }
        return lista.await()
    }

    suspend fun getAllEstilosByPaisId(id: Long): List<Estilo> {
        val lista = viewModelScope.async(Dispatchers.IO) {
            return@async repositorio.getAllEstilosByPaisId(id)
        }
        return lista.await()
    }

    suspend fun getAllEstilosString(): String{
        val lista  = getAllEstilos()
        var texto = ""
        lista.forEach { item ->
            texto += "${item.id} - ${item.nome} - PaisId: ${item.paisId}\n"
        }
        return texto
    }

}