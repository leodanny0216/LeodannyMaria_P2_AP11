package edu.ucne.leodannymaria_p2_ap1.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.ucne.huacales.data.local.dao.EntradaHuacalDao
import edu.ucne.huacales.data.local.database.AppDatabase
import edu.ucne.huacales.data.repository.EntradaHuacalRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "HuacalDb"
        ).build()
    }

    @Provides
    fun provideEntradaHuacalDao(db: AppDatabase): EntradaHuacalDao {
        return db.entradaHuacalDao()
    }

    @Provides
    @Singleton
    fun provideEntradaHuacalRepository(dao: EntradaHuacalDao): EntradaHuacalRepository {
        return EntradaHuacalRepository(dao)
    }
}