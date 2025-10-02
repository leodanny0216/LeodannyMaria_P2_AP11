package edu.ucne.leodannymaria_p2_ap1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.leodannymaria_p2_ap1.ui.theme.LeodannyMaria_P2_AP1Theme
import edu.ucne.joserivera_ap2_p1.presentation.huacales.HuacalNavigation
import edu.ucne.leodannymaria_p2_ap1.presentation.huacales.HuacalViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            LeodannyMaria_P2_AP1Theme {
                val navController = rememberNavController()
                val viewModel: HuacalViewModel = hiltViewModel()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HuacalNavigation(
                        navController = navController,
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}