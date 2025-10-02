package edu.ucne.joserivera_ap2_p1.presentation.huacales

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import edu.ucne.huacales.data.local.entities.EntradaHuacalEntity

@Composable
fun HuacalScreen(
    entrada: EntradaHuacalEntity = EntradaHuacalEntity(),
    onGuardar: (EntradaHuacalEntity) -> Unit,
    onCancelar: () -> Unit
) {
    var fecha by remember { mutableStateOf(entrada.fecha) }
    var cliente by remember { mutableStateOf(entrada.nombreCliente) }
    var cantidad by remember { mutableStateOf(entrada.cantidad.takeIf { it > 0 }?.toString() ?: "") }
    var precio by remember { mutableStateOf(entrada.precio.takeIf { it > 0.0 }?.toString() ?: "") }
    var showError by remember { mutableStateOf(false) }

    Dialog(onDismissRequest = onCancelar) {
        Card(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    if (entrada.idEntrada == 0) "Nuevo Huacal" else "Editar Huacal",
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(Modifier.height(16.dp))

                OutlinedTextField(
                    value = fecha,
                    onValueChange = { fecha = it },
                    label = { Text("Fecha") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(
                    value = cliente,
                    onValueChange = { cliente = it },
                    label = { Text("Cliente") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(
                    value = cantidad,
                    onValueChange = { cantidad = it },
                    label = { Text("Cantidad") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(
                    value = precio,
                    onValueChange = { precio = it },
                    label = { Text("Precio") },
                    modifier = Modifier.fillMaxWidth()
                )

                if (showError) {
                    Text(
                        "Complete todos los campos correctamente",
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }

                Spacer(Modifier.height(16.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    TextButton(onClick = onCancelar) {
                        Icon(Icons.Default.Close, contentDescription = null)
                        Text("Cancelar")
                    }
                    Spacer(Modifier.width(8.dp))
                    Button(onClick = {
                        val cantidadInt = cantidad.toIntOrNull()
                        val precioDouble = precio.toDoubleOrNull()

                        if (fecha.isNotBlank() && cliente.isNotBlank() &&
                            cantidadInt != null && cantidadInt > 0 &&
                            precioDouble != null && precioDouble > 0) {

                            val entity = EntradaHuacalEntity(
                                idEntrada = entrada.idEntrada,
                                fecha = fecha,
                                nombreCliente = cliente,
                                cantidad = cantidadInt,
                                precio = precioDouble
                            )
                            onGuardar(entity)
                        } else {
                            showError = true
                        }
                    }) {
                        Icon(Icons.Default.Done, contentDescription = null)
                        Text("Guardar")
                    }
                }
            }
        }
    }
}