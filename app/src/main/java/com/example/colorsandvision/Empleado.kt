package com.example.colorsandvision

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Empleado(){
    //Fondo
    BackgroundImage()
    var preguntaSelected by remember { mutableStateOf("") }
    var expandedPregunta by remember { mutableStateOf(false) }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var nombre by remember {
        mutableStateOf("")
    }
    var apellido by remember {
        mutableStateOf("")
    }
    var respuesta by remember {
        mutableStateOf("")
    }
    var puesto by remember {
        mutableStateOf("")
    }
    var pregunta = listOf("¿Cuál es el nombre de tu primera mascota?",
        "¿Cuál es tu canción favorita?",
        "¿Cuál es tu película favorita?",
        "¿Cuál es tu color favorito?",
        "¿En qué ciudad naciste?")

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Crear Usuario", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        //Nombre
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = nombre, onValueChange = {
            nombre = it
        }, label={
            Text(text = "Nombre",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        })

        //Apellido
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = apellido, onValueChange = {
            apellido = it
        }, label={
            Text(text = "Apellido",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        })

        //Puesto
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = puesto, onValueChange = {
            puesto = it
        }, label={
            Text(text = "Puesto",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        })

        //Email
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = email, onValueChange = {
            email = it
        }, label={
            Text(text = "Email",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        })

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
        OutlinedTextField(value = password, onValueChange = {
            password = it
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

        //Pregunta
        Text(text = "Periodo",
            color = colorResource(id = R.color.AzulMarino),
            fontFamily = FontFamily.Serif)
        OutlinedTextField(
            value = preguntaSelected,
            onValueChange = { preguntaSelected = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable {
                    expandedPregunta = true
                }
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp),
            colors = TextFieldDefaults.colors(Color.White),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        DropdownMenu(
            expanded = expandedPregunta,
            onDismissRequest = { expandedPregunta = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            pregunta.forEach { preguntaItem ->
                DropdownMenuItem(
                    text = { Text(text = preguntaItem) },
                    onClick = {
                        expandedPregunta = false
                        preguntaSelected = preguntaItem
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {}
        ) {
            Text(text = "Registrarse",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        }


        Spacer(modifier = Modifier.height(20.dp))
        TextButton(onClick = {
            //navegation.navigate("")
        }) {
            Text(text = "¿Ya tienes una cuenta? Acceso",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
        }

    }
}