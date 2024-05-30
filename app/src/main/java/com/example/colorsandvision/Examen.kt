@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.colorsandvision

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.CutCornerShape
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.widget.ConstraintLayout

@Composable
fun LoginExamen(){
    FondoExamen()

}

@Composable
fun FondoExamen(){
    val backgroundImage = painterResource(id = R.drawable.fondo4)
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = backgroundImage,
            contentDescription = "Imagen de fondo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
    }
}

// Examen dando click al menu
@Composable
fun ExamenMenu(){
    FondoExamen()
    var celular by remember { mutableStateOf("") }
    var lineaOD by remember { mutableStateOf("") }
    var lineaOI by remember { mutableStateOf("") }
    var lineaAOOI by remember { mutableStateOf("") }
    var lineaAOOD by remember { mutableStateOf("") }
    var esferaOD by remember { mutableStateOf("") }
    var esferaOI by remember { mutableStateOf("") }
    var cilindroOD by remember { mutableStateOf("") }
    var cilindroOI by remember { mutableStateOf("") }
    var presbiciaOD by remember { mutableStateOf("") }
    var presbiciaOI by remember { mutableStateOf("") }
    var obser by remember { mutableStateOf("") }

    val scroll = rememberScrollState(0) //Estado scroll

    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scroll)   //Habilitar el scroll verticalmente
            .navigationBarsPadding(), // Habilitar padding para la barra de navegación
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        // Texto Examen
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Examen de la Vista",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            color = colorResource(id = R.color.AzulMarino)
        )

        // Buscador
        Spacer(modifier = Modifier.height(16.dp))
        var buscador by remember { mutableStateOf(false) }
        OutlinedTextField(value = celular, onValueChange = {
            celular = it
        }, label={
            Text(text = "Celular",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        }, trailingIcon ={
            Icon(imageVector = Icons.Default.Search, contentDescription = "Buscador")
        })

        //Card para los datos
        Spacer(modifier = Modifier.height(16.dp))
        Card (modifier = Modifier
            .width(320.dp)
            .height(120.dp),
            elevation = CardDefaults.cardElevation(1.dp),//Elevacion de la card
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            shape = CutCornerShape(8.dp)){
            // Nombre, Edad y Enfermedad
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "  Nombre: \n  Edad: \n  Enfermedad: ",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif,
                lineHeight = 2.em)
            Spacer(modifier = Modifier.height(16.dp))
        }


        // Linea OD
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = lineaOD, onValueChange = {
            lineaOD = it
        }, label={
            Text(text = "Linea OD",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        })

        // Linea OI
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = lineaOI, onValueChange = {
            lineaOI = it
        }, label={
            Text(text = "Linea OI",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        })

        // Linea AOOD
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = lineaAOOD, onValueChange = {
            lineaAOOD = it
        }, label={
            Text(text = "Linea AOOD",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        })

        // Linea AOOI
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = lineaAOOI, onValueChange = {
            lineaAOOI = it
        }, label={
            Text(text = "Linea AOOI",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        })

        // Esfera OD
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = esferaOD, onValueChange = {
            esferaOD = it
        }, label={
            Text(text = "Esfera OD",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        })

        // Esfera OI
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = esferaOI, onValueChange = {
            esferaOI = it
        }, label={
            Text(text = "Esfera OI",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        })

        // Cilindro OD
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = cilindroOD, onValueChange = {
            cilindroOD = it
        }, label={
            Text(text = "Cilindro OD",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        })

        // Cilindro OI
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = cilindroOI, onValueChange = {
            cilindroOI = it
        }, label={
            Text(text = "Cilindro OI",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        })

        // Presbicia OD
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = presbiciaOD, onValueChange = {
            presbiciaOD = it
        }, label={
            Text(text = "Presbicia OD",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        })

        // Presbicia OI
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = presbiciaOI, onValueChange = {
            presbiciaOI = it
        }, label={
            Text(text = "Presbicio OI",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        })

        // Observaciones
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = obser, onValueChange = {
            obser = it
        }, label={
            Text(text = "Observaciones",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        },
            maxLines = 50)

        // Boton Añadir
        Spacer(modifier = Modifier.height(16.dp))
        Button(modifier = Modifier
            .width(200.dp)
            .height(50.dp),
            onClick = {  },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff1C2D66)
            ),
            shape = CutCornerShape(8.dp)
        ) {
            Text(text = "Añadir",
                color = colorResource(id = R.color.white),
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif)
        }

        // Boton regresar
        Spacer(modifier = Modifier.height(16.dp))
        Button(modifier = Modifier
            .width(200.dp)
            .height(50.dp),
            onClick = {  },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff64BDCD)
            ),
            shape = CutCornerShape(8.dp)
        ) {
            Text(text = "Regresar",
                color = colorResource(id = R.color.AzulMarino),
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif)
        }
    }
}
