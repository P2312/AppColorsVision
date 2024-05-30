@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.colorsandvision

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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

@Composable
fun Venta(){
    FondoRegistro()
    var fechav by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var modelo by remember { mutableStateOf("") }
    var serie by remember { mutableStateOf("") }
    var material by remember { mutableStateOf("") }
    var accerorio by remember { mutableStateOf("") }
    var fechaentrega by remember { mutableStateOf("") }
    var total by remember { mutableStateOf("") }

    Column (
        modifier = Modifier.fillMaxSize(),
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

        //Fecha y Nombre
        Spacer(modifier = Modifier.height(16.dp))
        Card (modifier = Modifier
            .width(290.dp)
            .height(90.dp),
            elevation = CardDefaults.cardElevation(1.dp),//Elevacion de la card
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            shape = CutCornerShape(8.dp)
        ){
            // Nombre, Edad y Enfermedad
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "  Fecha: \n  Nombre: ",
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
        Spacer(modifier = Modifier.height(16.dp)) //esta linea me hace un espacio entre los componentes
        OutlinedTextField(value = total, onValueChange = {
            total = it
        }, label={
            Text(text = "Total",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        })

        //Boton Guardar
        Spacer(modifier = Modifier.height(16.dp))
        Button(modifier = Modifier
            .width(200.dp)
            .height(50.dp),
            onClick = {  },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff64BDCD)),
            shape = CutCornerShape(8.dp)

        ) {
            Text(text = "Guardar",
                color = colorResource(id = R.color.AzulMarino),
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif)
        }

    }
}