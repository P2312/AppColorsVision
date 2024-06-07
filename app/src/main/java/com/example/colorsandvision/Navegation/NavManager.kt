package com.example.colorsandvision.Navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.colorsandvision.Catalogo
import com.example.colorsandvision.Empleado
import com.example.colorsandvision.ExamenVista
import com.example.colorsandvision.Login
import com.example.colorsandvision.Menu
import com.example.colorsandvision.Recuperar
import com.example.colorsandvision.RegistroPaciente
import com.example.colorsandvision.Venta


@Composable
fun NavManager(){
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = "Login"){
        composable("Login"){
            Login(navigationController)
        }
        composable("Empleado"){
            Empleado(navigationController)
        }
        composable("Menu"){
            Menu(navigationController)
        }
        composable("Paciente"){
            RegistroPaciente(navigationController)
        }
        composable("Examen"){
            ExamenVista(navigationController)
        }
        composable("Venta"){
            Venta(navigationController)
        }
        composable("Catalogo"){
            Catalogo(navigationController)
        }
        composable("Recuperar"){
            Recuperar(navigationController)
        }
    }
}
