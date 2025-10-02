package edu.ucne.joserivera_ap2_p1.presentation.huacales

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.ucne.huacales.data.local.entities.EntradaHuacalEntity

@Composable
fun HuacalListScreen(
    huacales: List<EntradaHuacalEntity>,
    onCreate: () -> Unit,
    onDelete: (EntradaHuacalEntity) -> Unit,
    onEditar: (EntradaHuacalEntity) -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = onCreate,
                containerColor = Color(0xFF6650a4),
                contentColor = Color.White
            ) {
                Icon(Icons.Default.Add, contentDescription = "Agregar")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Text(
                text = "Lista de Huacales",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (huacales.isEmpty()) {
                Text(
                    text = "No hay huacales registrados",
                    modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center),
                    textAlign = TextAlign.Center
                )
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(huacales) { huacal ->
                        HuacalRow(
                            huacal,
                            onDelete = { onDelete(it) },
                            onEditar = onEditar
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HuacalRow(
    huacal: EntradaHuacalEntity,
    onDelete: (EntradaHuacalEntity) -> Unit,
    onEditar: (EntradaHuacalEntity) -> Unit
) {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Cliente: ${huacal.nombreCliente}", fontWeight = FontWeight.Bold)
                Text("Fecha: ${huacal.fecha}")
                Text("Cantidad: ${huacal.cantidad}")
                Text("Precio: $${huacal.precio}")
            }

            Row {
                IconButton(onClick = { onEditar(huacal) }) {
                    Icon(Icons.Default.Edit, contentDescription = "Editar", tint = Color(0xFF6650a4))
                }
                IconButton(onClick = { onDelete(huacal) }) {
                    Icon(Icons.Default.Delete, contentDescription = "Eliminar", tint = Color.Red)
                }
            }
        }
    }
}