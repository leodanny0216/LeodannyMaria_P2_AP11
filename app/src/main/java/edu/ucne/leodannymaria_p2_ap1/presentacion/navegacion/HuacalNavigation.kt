package edu.ucne.joserivera_ap2_p1.presentation.huacales

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.ucne.huacales.data.local.entities.EntradaHuacalEntity
import edu.ucne.joserivera_ap2_p1.presentation.HomeScreen
import edu.ucne.leodannymaria_p2_ap1.presentation.huacales.HuacalViewModel

@Composable
fun HuacalNavigation(
    navController: NavHostController,
    viewModel: HuacalViewModel
) {
    val huacalList by viewModel.huacalList.collectAsState()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navController = navController)
        }

        composable("huacal_list") {
            HuacalListScreen(
                huacales = huacalList,
                onCreate = { navController.navigate("huacal_nuevo") },
                onDelete = { huacal -> navController.navigate("eliminar_huacal/${huacal.idEntrada}") },
                onEditar = { huacal -> navController.navigate("editar_huacal/${huacal.idEntrada}") }
            )
        }

        composable("huacal_nuevo") {
            HuacalScreen(
                entrada = EntradaHuacalEntity(),
                onGuardar = { entity ->
                    viewModel.agregarHuacal(entity)
                    navController.popBackStack()
                },
                onCancelar = { navController.popBackStack() }
            )
        }

        composable("editar_huacal/{huacalId}") { backStackEntry ->
            val huacalId = backStackEntry.arguments?.getString("huacalId")?.toIntOrNull() ?: 0
            HuacalScreen(
                entrada = viewModel.obtenerHuacal(huacalId),
                onGuardar = { entity ->
                    viewModel.actualizarHuacal(entity)
                    navController.popBackStack()
                },
                onCancelar = { navController.popBackStack() }
            )
        }

        composable("eliminar_huacal/{huacalId}") { backStackEntry ->
            val huacalId = backStackEntry.arguments?.getString("huacalId")?.toIntOrNull() ?: 0
            DeleteHuacalScreen(
                huacalId = huacalId,
                viewModel = viewModel,
                goBack = { navController.popBackStack() }
            )
        }
    }
}