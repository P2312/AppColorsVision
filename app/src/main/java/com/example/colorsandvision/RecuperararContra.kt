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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.colorsandvision.Components.Alert
import com.example.colorsandvision.viewModels.LoginViewModel

@Composable
fun Recuperar(navigationController: NavHostController, viewModel: LoginViewModel = viewModel()) {
    BackgroundImage()

    val navegation = navigationController

    var email by remember { mutableStateOf("") }
    var respuesta by remember { mutableStateOf("") }

    if (viewModel.showAlert) {
        Alert(
            title = "Restablecer contraseña",
            message = viewModel.alertMessage,
            confirmText = "Sí",
            onConfirmClick = {
                viewModel.sendPasswordResetEmail(viewModel.alertEmail)
                viewModel.closeAlert()
            },
            onDismissClick = {
                viewModel.closeAlert()
            }
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Recuperar Contraseña", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        // Email
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = email, onValueChange = {
            email = it
        }, label = {
            Text(
                text = "Email",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif
            )
        }, trailingIcon = {
            Icon(imageVector = Icons.Default.Check, contentDescription = "Verificar")
        })

        // Card pregunta
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier
                .width(300.dp)
                .height(70.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            shape = CutCornerShape(8.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "  Pregunta \n  ¿Qué comiste ayer?   ",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif,
                lineHeight = 2.em
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Respuesta
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = respuesta, onValueChange = {
            respuesta = it
        }, label = {
            Text(
                text = "Respuesta",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif
            )
        })

        // Boton Aceptar
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier
                .width(200.dp)
                .height(50.dp),
            onClick = {
                viewModel.recuperarContrasena(email)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff1C2D66)
            ),
            shape = CutCornerShape(8.dp)
        ) {
            Text(
                text = "Aceptar",
                color = colorResource(id = R.color.white),
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
            )
        }
    }
}
