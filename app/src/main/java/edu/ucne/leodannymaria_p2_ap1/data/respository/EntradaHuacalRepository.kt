package edu.ucne.huacales.data.repository

import edu.ucne.huacales.data.local.dao.EntradaHuacalDao
import edu.ucne.huacales.data.local.entities.EntradaHuacalEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EntradaHuacalRepository @Inject constructor(
    private val dao: EntradaHuacalDao
) {
    suspend fun save(entrada: EntradaHuacalEntity) = dao.save(entrada)

    suspend fun delete(entrada: EntradaHuacalEntity) = dao.delete(entrada)

    suspend fun find(id: Int) = dao.find(id)

    fun getAll(cliente: String?, fecha: String?): Flow<List<EntradaHuacalEntity>> =
        dao.getAll(cliente, fecha)
}
