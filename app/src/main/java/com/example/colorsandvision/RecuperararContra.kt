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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Recuperar (navigationController: NavHostController){
    BackgroundImage()

    val navegation = navigationController

    var email by remember { mutableStateOf("") }
    var respuesta by remember { mutableStateOf("") }

    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Recuperar Contraseña", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        // Email
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = email, onValueChange = {
            email = it
        }, label={
            Text(text = "Email",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        }, trailingIcon ={
            Icon(imageVector = Icons.Default.Check, contentDescription = "Verificar")
        })

        //Card pregunta
        Spacer(modifier = Modifier.height(16.dp))
        Card (modifier = Modifier
            .width(300.dp)
            .height(70.dp),
            //elevation = CardDefaults.cardElevation(1.dp),//Elevacion de la card
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            shape = CutCornerShape(8.dp)){
            // Nombre, Edad y Enfermedad
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "  Pregunta \n  ¿Qué comiste ayer?   ",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif,
                lineHeight = 2.em)
            Spacer(modifier = Modifier.height(16.dp))
        }
        // Respuesta
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = respuesta, onValueChange = {
            respuesta = it
        }, label={
            Text(text = "Respuesta",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        })

        // Boton Aceptar
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
            Text(text = "Aceptar",
                color = colorResource(id = R.color.white),
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif)
        }

    }


}

@Composable
fun Restablecer(navigationController: NavHostController){
    BackgroundImage()

    var password by remember { mutableStateOf("") }
    var confirmarPassword by remember { mutableStateOf("") }
    val scroll = rememberScrollState(0) //Estado scroll

    Column (modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scroll)   //Habilitar el scroll verticalmente
        .navigationBarsPadding(), // Habilitar padding para la barra de navegación,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Restablecer Contraseña", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        //Contraseña
        Spacer(modifier = Modifier.height(16.dp))
        var isPasswordVisible by remember { mutableStateOf(false) }
        OutlinedTextField(value = password, onValueChange = {
            password = it
        }, label={
            Text(text = "Contraseña",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        },visualTransformation = if (isPasswordVisible) VisualTransformation.None else
            PasswordVisualTransformation(),
            trailingIcon = {
                Icon(painter =
                if (isPasswordVisible) painterResource(id = R.drawable.ic_visibility)
                else painterResource(id = R.drawable.ic_visibility_off),
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        isPasswordVisible = !isPasswordVisible
                    }
                )
            })

        //Contraseña validar
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = confirmarPassword, onValueChange = {
            confirmarPassword = it
        }, label={
            Text(text = "Validar Contraseña",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        },visualTransformation = if (isPasswordVisible) VisualTransformation.None else
            PasswordVisualTransformation(),
            trailingIcon = {
                Icon(painter =
                if (isPasswordVisible) painterResource(id = R.drawable.ic_visibility)
                else painterResource(id = R.drawable.ic_visibility_off),
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        isPasswordVisible = !isPasswordVisible
                    }
                )
            })
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
            Text(text = "Restablecer",
                color = colorResource(id = R.color.white),
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif)
        }
    }

}