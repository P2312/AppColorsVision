@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.colorsandvision

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavHostController

@Composable
fun Catalogo(navigationController: NavHostController){
    FondoExamen()
    val navegation = navigationController
    val scroll = rememberScrollState(0) //Estado scroll
    TopAppBar(
        title = {
            Text(text = "Catalogo",
                color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Normal
            )
        },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Regresar",
                    tint = colorResource(id = R.color.AzulMarino)
                )
            }
        }
    )
    Column (
        modifier = Modifier.fillMaxSize()
            .verticalScroll(scroll)   //Habilitar el scroll verticalmente
            .navigationBarsPadding(), // Habilitar padding para la barra de navegación,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(30.dp))
        Card (modifier = Modifier
            .padding(8.dp),
            elevation = CardDefaults.cardElevation(3.dp),//Elevacion de la card
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = CutCornerShape(8.dp)
        ){
            Column (){
                Image(painter = painterResource(id = R.drawable.lentes), contentDescription = null )
                Column (modifier = Modifier.padding(16.dp)){
                    Text(text = " Modelo: 140 \n Marca: Botox \n Color: Negro \n Precio: 250",
                        color = colorResource(id = R.color.AzulMarino),
                        fontFamily = FontFamily.Serif)

                }
            }
        }
    }
}

@Composable
fun prueba(){
    FondoExamen()
    Card (modifier = Modifier
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(1.dp),//Elevacion de la card
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = CutCornerShape(8.dp)
    ){
        Column (){
            Image(painter = painterResource(id = R.drawable.lentes), contentDescription = null )
            Column (modifier = Modifier.padding(16.dp)){
                Text(text = " Modelo: 140 \n Marca: Botox \n Color: Negro \n Precio: 250",
                    color = colorResource(id = R.color.AzulMarino),
                fontFamily = FontFamily.Serif)
                
            }
        }
    }
}