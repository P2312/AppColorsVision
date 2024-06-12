@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.colorsandvision

import android.icu.util.Calendar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import java.text.DateFormat


@Composable
fun Venta(navigationController: NavHostController){

    FondoRegistro()
    val scroll = rememberScrollState(0) //Estado scroll
    val navegation = navigationController
    val calendar = Calendar.getInstance().time
    val dateFormat = DateFormat.getDateInstance().format(calendar)

    var IDPaciente by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var modelo by remember { mutableStateOf("") }
    var serie by remember { mutableStateOf("") }
    var material by remember { mutableStateOf("") }
    var accerorio by remember { mutableStateOf("") }
    var tratamiento by remember { mutableStateOf("") }
    var precioLente by remember { mutableStateOf("") }
    var precioAdic by remember { mutableStateOf("") }
    var fechaentrega by remember { mutableStateOf("") }
    val total = precioAdic.toDouble()+precioLente.toDouble()+200

    Column (
        modifier = Modifier.fillMaxSize()
            .verticalScroll(scroll)   //Habilitar el scroll verticalmente
            .navigationBarsPadding(), // Habilitar padding para la barra de navegación,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        // Venta
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Venta",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            color = colorResource(id = R.color.AzulMarino))

        // Buscador
        Spacer(modifier = Modifier.height(16.dp))
        var buscador by remember { mutableStateOf(false) }
        OutlinedTextField(value = IDPaciente, onValueChange = {
            IDPaciente = it
        }, label={
            Text(text = "ID Paciente",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        }, trailingIcon ={
            Icon(imageVector = Icons.Default.Search, contentDescription = "Buscador")
        })

        //Fecha y Nombre
        Spacer(modifier = Modifier.height(16.dp))
        Card (modifier = Modifier
            .width(290.dp)
            .height(120.dp),
            elevation = CardDefaults.cardElevation(1.dp),//Elevacion de la card
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = CutCornerShape(8.dp)
        ){
            // Nombre y fecha
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "  Fecha:$dateFormat \n  Nombre: \n  Edad: \n  Celular:",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif,
                lineHeight = 2.em)
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Modelo
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = modelo, onValueChange = {
            modelo = it
        }, label={
            Text(text = "Modelo",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        })

        // Serie
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = serie, onValueChange = {
            serie = it
        }, label={
            Text(text = "Serie",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        })

        // Material
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = material, onValueChange = {
            material = it
        }, label={
            Text(text = "Material",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        })

        // Accesorio
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = accerorio, onValueChange = {
            accerorio = it
        }, label={
            Text(text = "Accesorio",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        })
        // Tratamiento
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = tratamiento, onValueChange = {
            tratamiento = it
        }, label={
            Text(text = "Tratamiento",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        })
        // Precio del modelo
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = precioLente, onValueChange = {
            precioLente = it
        }, label={
            Text(text = "Precio del lente",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        })

        // Precio adicional
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = precioAdic, onValueChange = {
            precioAdic = it
        }, label={
            Text(text = "Precio adicional",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        })

        // Fecha de Entrega
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = fechaentrega, onValueChange = {
            fechaentrega = it
        }, label={
            Text(text = "Fecha de Entrega",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        })

        // Total
        Text(text = "$total",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        //total= preciodelente+precioadd+200*(serie)

        //Boton Guardar
        Spacer(modifier = Modifier.height(16.dp))
        Button(modifier = Modifier
            .width(200.dp)
            .height(50.dp),
            onClick = {
                navegation.navigate("Menu")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff64BDCD)),
            shape = CutCornerShape(8.dp)

        ) {
            Text(text = "Guardar",
                color = colorResource(id = R.color.AzulMarino),
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif)
        }
        //Boton Regresar
        Spacer(modifier = Modifier.height(16.dp))
        Button(modifier = Modifier
            .width(200.dp)
            .height(50.dp),
            onClick = {
                navegation.navigate("Menu")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff1C2D66)),
            shape = CutCornerShape(8.dp)

        ) {
            Text(text = "Regresar",
                color = colorResource(id = R.color.white),
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif)
        }
    }
}