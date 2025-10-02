package edu.ucne.joserivera_ap2_p1.presentation.huacales

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.ucne.huacales.data.local.entities.EntradaHuacalEntity
import edu.ucne.huacales.data.repository.EntradaHuacalRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HuacalViewModel(
    private val repository: EntradaHuacalRepository
) : ViewModel() {

    private val _huacalList = MutableStateFlow<List<EntradaHuacalEntity>>(emptyList())
    val huacalList: StateFlow<List<EntradaHuacalEntity>> = _huacalList.asStateFlow()

    init {
        loadHuacales()
    }

    fun loadHuacales(cliente: String? = null, fecha: String? = null) {
        viewModelScope.launch {
            repository.getAll(cliente, fecha).collect { huacales ->
                _huacalList.value = huacales
            }
        }
    }

    fun agregarHuacal(entrada: EntradaHuacalEntity) {
        viewModelScope.launch {
            repository.save(entrada)
            loadHuacales()
        }
    }

    fun actualizarHuacal(entrada: EntradaHuacalEntity) {
        viewModelScope.launch {
            repository.save(entrada)
            loadHuacales()
        }
    }

    fun eliminarHuacal(entrada: EntradaHuacalEntity) {
        viewModelScope.launch {
            repository.delete(entrada)
            loadHuacales()
        }
    }

    fun obtenerHuacal(id: Int): EntradaHuacalEntity {
        return _huacalList.value.find { it.idEntrada == id } ?: EntradaHuacalEntity()
    }
}
