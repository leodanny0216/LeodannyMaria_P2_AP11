package edu.ucne.huacales.data.local.dao

import androidx.room.*
import edu.ucne.huacales.data.local.entities.EntradaHuacalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EntradaHuacalDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(entrada: EntradaHuacalEntity)

    @Delete
    suspend fun delete(entrada: EntradaHuacalEntity)

    @Query("SELECT * FROM EntradasHuacales WHERE idEntrada = :id LIMIT 1")
    suspend fun find(id: Int): EntradaHuacalEntity?

    // Consulta con filtros opcionales
    @Query("""
        SELECT * FROM EntradasHuacales
        WHERE (:cliente IS NULL OR nombreCliente LIKE '%' || :cliente || '%')
        AND (:fecha IS NULL OR fecha LIKE '%' || :fecha || '%')
    """)
    fun getAll(cliente: String? = null, fecha: String? = null): Flow<List<EntradaHuacalEntity>>
}
