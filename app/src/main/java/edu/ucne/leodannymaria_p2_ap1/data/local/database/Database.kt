package edu.ucne.huacales.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.ucne.huacales.data.local.dao.EntradaHuacalDao
import edu.ucne.huacales.data.local.entities.EntradaHuacalEntity

@Database(
    entities = [EntradaHuacalEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun entradaHuacalDao(): EntradaHuacalDao
}
