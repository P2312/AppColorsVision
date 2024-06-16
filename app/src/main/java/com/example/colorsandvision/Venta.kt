@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.colorsandvision

import android.icu.util.Calendar
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.firestore.FirebaseFirestore
import java.text.DateFormat
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

@Composable
fun Venta(navigationController: NavHostController) {
    FondoRegistro()
    val scroll = rememberScrollState(0)
    val navegation = navigationController
    val calendar = Calendar.getInstance().time
    val dateFormat = DateFormat.getDateInstance().format(calendar)

    var IDPaciente by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var idpaciente by remember { mutableStateOf("") }
    var idventa by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var celular by remember { mutableStateOf("") }
    var idlente by remember { mutableStateOf("") }
    var serie by remember { mutableStateOf("") }
    var material by remember { mutableStateOf("") }
    var articulo by remember { mutableStateOf("") }
    var tratamiento by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var precioaadd by remember { mutableStateOf("") }
    var fechav by remember { mutableStateOf("") }
    var fechaentrega by remember { mutableStateOf("") }

    val total = try {
        precioaadd.toDouble() + precio.toDouble() + 200
    } catch (e: NumberFormatException) {
        0.0
    }

    // función fetch para tomar los datos de firbase de la tabla paciente
    fun fetchPatientData(id: String) {
        val db = FirebaseFirestore.getInstance()
        db.collection("paciente").document(id)
            .get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    nombre = document.getString("nombre") ?: ""
                    edad = document.getString("edad") ?: ""
                    celular = document.getString("celular") ?: ""
                }
            }
            .addOnFailureListener { exception ->
                // Handle the error
            }
    }
    // función para guardar los datos en la tabla de venta de Firebase
    fun guardarVenta() {
        val db = FirebaseFirestore.getInstance()
        val venta = hashMapOf(
            "IDPaciente" to IDPaciente,
            "nombre" to nombre,
            "idpaciente" to idpaciente,
            "idventa" to idventa,
            "edad" to edad,
            "celular" to celular,
            "idlente" to idlente,
            "serie" to serie,
            "material" to material,
            "articulo" to articulo,
            "tratamiento" to tratamiento,
            "precio" to precio.toDouble(),
            "precioaadd" to precioaadd.toDouble(),
            "fechav" to fechav,
            "fechaentrega" to fechaentrega
            // Agrega más campos según sea necesario
        )

        // Aquí se guarda en la colección 'ventas' de Firebase
        db.collection("venta")
            .add(venta)
            .addOnSuccessListener {
                // Éxito
            }
            .addOnFailureListener { e ->
                // Manejar el error
            }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scroll)
            .navigationBarsPadding(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Venta",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            color = colorResource(id = R.color.AzulMarino)
        )

        Spacer(modifier = Modifier.height(16.dp))
        var buscador by remember { mutableStateOf(false) }
        OutlinedTextField(
            value = IDPaciente,
            onValueChange = {
                IDPaciente = it
                fetchPatientData(IDPaciente)
            },
            label = {
                Text(
                    text = "ID Paciente",
                    color = colorResource(id = R.color.AzulMarino),
                    fontFamily = FontFamily.Serif
                )
            },
            trailingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Buscador")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier
                .width(350.dp)
                .height(150.dp),
            elevation = CardDefaults.cardElevation(1.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = CutCornerShape(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Fecha: $dateFormat",
                    color = colorResource(id = R.color.AzulMarino),
                    fontFamily = FontFamily.Serif
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Nombre: $nombre",
                    color = colorResource(id = R.color.AzulMarino),
                    fontFamily = FontFamily.Serif
                )
                Text(
                    text = "Edad: $edad",
                    color = colorResource(id = R.color.AzulMarino),
                    fontFamily = FontFamily.Serif
                )
                Text(
                    text = "Celular: $celular",
                    color = colorResource(id = R.color.AzulMarino),
                    fontFamily = FontFamily.Serif
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = idlente, onValueChange = {
                idlente = it
            },
            label = {
                Text(
                    text = "Modelo",
                    color = colorResource(id = R.color.AzulMarino),
                    fontFamily = FontFamily.Serif
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = serie, onValueChange = {
                serie = it
            },
            label = {
                Text(
                    text = "Serie",
                    color = colorResource(id = R.color.AzulMarino),
                    fontFamily = FontFamily.Serif
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = material, onValueChange = {
                material = it
            },
            label = {
                Text(
                    text = "Material",
                    color = colorResource(id = R.color.AzulMarino),
                    fontFamily = FontFamily.Serif
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = articulo, onValueChange = {
                articulo = it
            },
            label = {
                Text(
                    text = "Accesorio",
                    color = colorResource(id = R.color.AzulMarino),
                    fontFamily = FontFamily.Serif
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = tratamiento, onValueChange = {
                tratamiento = it
            },
            label = {
                Text(
                    text = "Tratamiento",
                    color = colorResource(id = R.color.AzulMarino),
                    fontFamily = FontFamily.Serif
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = precio, onValueChange = {
                precio = it
            },
            label = {
                Text(
                    text = "Precio del lente",
                    color = colorResource(id = R.color.AzulMarino),
                    fontFamily = FontFamily.Serif
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = precioaadd, onValueChange = {
                precioaadd = it
            },
            label = {
                Text(
                    text = "Precio adicional",
                    color = colorResource(id = R.color.AzulMarino),
                    fontFamily = FontFamily.Serif
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = fechaentrega, onValueChange = {
                fechaentrega = it
            },
            label = {
                Text(
                    text = "Fecha de Entrega",
                    color = colorResource(id = R.color.AzulMarino),
                    fontFamily = FontFamily.Serif
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "$total",
            color = colorResource(id = R.color.AzulMarino),
            fontFamily = FontFamily.Serif
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier
                .width(200.dp)
                .height(50.dp),
            onClick = {
                navegation.navigate("Menu")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff64BDCD)
            ),
            shape = CutCornerShape(8.dp)
        ) {
            Text(
                text = "Guardar",
                color = colorResource(id = R.color.AzulMarino),
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier
                .width(200.dp)
                .height(50.dp),
            onClick = {
                navegation.navigate("Menu")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff1C2D66)
            ),
            shape = CutCornerShape(8.dp)
        ) {
            Text(
                text = "Regresar",
                color = colorResource(id = R.color.white),
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewVenta() {

}

