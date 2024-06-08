import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.colorsandvision.Components.Alert
import com.example.colorsandvision.viewModels.PasswordViewModel

@Composable
fun Recuperar(navigationController: NavHostController, viewModel: PasswordViewModel) {
    val emailState = remember { mutableStateOf("") }

    if (viewModel.showAlert) {
        Alert(
            title = "Restablecer contraseña",
            message = viewModel.alertMessage,
            confirmText = "Sí",
            onConfirmClick = {
                Log.d("Recuperar", "Botón 'Sí' en cuadro de diálogo de alerta presionado")
                viewModel.confirmRecuperarContrasena(true,navigationController)
            },
            onDismissClick = {
                Log.d("Recuperar", "Cuadro de diálogo de alerta cerrado sin confirmar")
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
        OutlinedTextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            label = { Text(text = "Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            trailingIcon = {
                if (emailState.value.isNotEmpty()) {
                    Button(
                        onClick = {
                            Log.d("Recuperar", "Botón 'Enviar' presionado")
                            viewModel.recuperarContrasena(emailState.value)
                        },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Enviar")
                    }
                }
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
            keyboardActions = KeyboardActions(
                onSend = {
                    Log.d("Recuperar", "Tecla 'Enviar' presionada en el teclado")
                    viewModel.recuperarContrasena(emailState.value)
                }
            )
        )
    }

    // Observar cambios en resetPasswordEmailSent y manejar la navegación
    if (viewModel.resetPasswordEmailSent) {
        LaunchedEffect(Unit) {
            Log.d("Recuperar", "Navegando a 'inicio' después de enviar correo electrónico de recuperación")
            navigationController.navigate("inicio")
        }
    }
}