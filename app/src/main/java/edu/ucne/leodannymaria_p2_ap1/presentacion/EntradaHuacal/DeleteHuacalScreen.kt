package edu.ucne.joserivera_ap2_p1.presentation.huacales

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import edu.ucne.leodannymaria_p2_ap1.presentation.huacales.HuacalViewModel

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