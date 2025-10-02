package edu.ucne.huacales.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "EntradasHuacales")
data class EntradaHuacalEntity(
    @PrimaryKey(autoGenerate = true)
    val idEntrada: Int = 0,
    val fecha: String = "",
    val nombreCliente: String = "",
    val cantidad: Int = 0,
    val precio: Double = 0.0
)