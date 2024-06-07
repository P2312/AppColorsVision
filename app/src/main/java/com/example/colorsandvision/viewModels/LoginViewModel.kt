package com.example.colorsandvision.viewModels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.colorsandvision.model.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class LoginViewModel : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val _loading = MutableLiveData(false)
    private val firebaseAuth = FirebaseAuth.getInstance()

    var showAlert by mutableStateOf(false)
    var alertMessage by mutableStateOf("")
    var alertEmail by mutableStateOf("")

    fun closeAlert() {
        showAlert = false
    }

    fun login(email: String, password: String, function: () -> Unit) {
        try {
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("btn Entrar", "Usuario Logeado!!")
                    function()
                } else {
                    Log.w("btn Entrar", "Inicio de sesión fallido", task.exception)
                    showAlert = true
                }
            }
        } catch (e: Exception) {
            Log.e("btn Entrar", "Error durante el inicio de sesión", e)
            showAlert = true
        }
    }

    fun createUser(email: String, password: String, username: String, userapellido: String, function: () -> Unit) {
        if (_loading.value == false) {
            _loading.value = true

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    _loading.value = false

                    if (task.isSuccessful) {
                        val currentUser = auth.currentUser
                        if (currentUser != null) {
                            val userDocument =
                                FirebaseFirestore.getInstance().collection("usuarios")
                                    .document(currentUser.uid)

                            val userData = UserModel(currentUser.uid, email, username, userapellido).toMap()

                            userDocument.set(userData)
                                .addOnSuccessListener {
                                    function()
                                }
                                .addOnFailureListener { e ->
                                    handleFirestoreError(e)
                                }
                        }
                    } else {
                        handleAuthError(task.exception)
                    }
                }
        }
    }

    private fun handleFirestoreError(exception: Exception?) {
        Log.e("btn Registrarse", "Error al agregar datos a Firestore", exception)
        showAlert = true
    }

    private fun handleAuthError(exception: Exception?) {
        Log.e("btn Registrarse", "Error al crear usuario", exception)
        showAlert = true
    }

    fun recuperarContrasena(email: String) {
        alertMessage = "¿Estás seguro de que quieres restablecer la contraseña para $email?"
        alertEmail = email
        showAlert = true
    }

    fun sendPasswordResetEmail(email: String) {
        firebaseAuth.sendPasswordResetEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("Recuperar Contraseña", "Correo de restablecimiento de contraseña enviado")
                } else {
                    Log.e("Recuperar Contraseña", "Error al enviar el correo de restablecimiento de contraseña", task.exception)
                }
            }
    }
}
