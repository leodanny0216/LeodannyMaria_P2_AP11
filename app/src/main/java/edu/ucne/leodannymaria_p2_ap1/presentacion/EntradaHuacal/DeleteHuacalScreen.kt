package edu.ucne.joserivera_ap2_p1.presentation.huacales

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import edu.ucne.huacales.data.local.entities.EntradaHuacalEntity

@Composable
fun DeleteHuacalScreen(
    huacalId: Int,
    viewModel: HuacalViewModel,
    goBack: () -> Unit
) {
    val huacal = viewModel.obtenerHuacal(huacalId)

    Dialog(onDismissRequest = goBack) {
        Card(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Confirmar Eliminación", style = MaterialTheme.typography.titleLarge)

                Spacer(Modifier.height(16.dp))

                Text("¿Está seguro de que desea eliminar el huacal de ${huacal.nombreCliente}?")

                Spacer(Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = goBack) {
                        Text("Cancelar")
                    }
                    Spacer(Modifier.width(8.dp))
                    Button(
                        onClick = {
                            viewModel.eliminarHuacal(huacal)
                            goBack()
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                    ) {
                        Text("Eliminar")
                    }
                }
            }
        }
    }
}