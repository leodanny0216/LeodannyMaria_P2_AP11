package edu.ucne.joserivera_ap2_p1.presentation.huacales

import kotlinx.serialization.Serializable

sealed class HuacalScreenRoute {
    @Serializable
    object Home : HuacalScreenRoute()

    @Serializable
    object HuacalList : HuacalScreenRoute()

    @Serializable
    data class HuacalNuevo(val huacalId: Int) : HuacalScreenRoute()

    @Serializable
    data class HuacalEditar(val huacalId: Int) : HuacalScreenRoute()

    @Serializable
    data class HuacalDelete(val huacalId: Int) : HuacalScreenRoute()
}
