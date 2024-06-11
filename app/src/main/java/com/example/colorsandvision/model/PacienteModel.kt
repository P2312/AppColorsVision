package com.example.colorsandvision.model

data class PacienteModel (
    val pacienteId: String?,
    val nombre: String = "",
    val apellidop: String = "",
    val apellidom: String ="",
    val celular : Int = 0,
    val edad : Int = 0,
    val enfermedades: String = "",
    val ocupacion: String = "",
    val observaciones: String = ""
)