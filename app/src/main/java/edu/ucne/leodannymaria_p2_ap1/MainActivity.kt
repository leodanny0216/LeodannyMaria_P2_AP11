package edu.ucne.leodannymaria_p2_ap1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import edu.ucne.huacales.data.repository.EntradaHuacalRepository
import edu.ucne.joserivera_ap2_p1.presentation.huacales.HuacalNavigation
import edu.ucne.joserivera_ap2_p1.presentation.huacales.HuacalViewModel
import edu.ucne.leodannymaria_p2_ap1.ui.theme.LeodannyMaria_P2_AP1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Crear repositorio manualmente
        val repository = EntradaHuacalRepository()

        // Crear ViewModel manualmente
        val viewModel = HuacalViewModel(repository)

        setContent {
            LeodannyMaria_P2_AP1Theme {
                Surface(
                    modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    HuacalNavigation(
                        navController = navController,
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}
