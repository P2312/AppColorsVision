package com.example.colorsandvision

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.StrictMode
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.colorsandvision.Navegation.NavManager
import com.example.colorsandvision.ui.theme.ColorsAndVisionTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.sql.Connection
import java.sql.DriverManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Habilitar políticas de red en el hilo principal (no recomendado para producción)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        enableEdgeToEdge()
        setContent {
            ColorsAndVisionTheme {
                NavManager()
            }
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    var data by remember { mutableStateOf<List<String>>(emptyList()) }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            val connector = MySQLConnector(
                url = "jdbc:mysql://your-database-url:3306/your-database-name",
                user = "your-database-user",
                password = "your-database-password"
            )
            data = connector.getData("SELECT your_column_name FROM your_table_name")
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("MySQL Data") }
            )
        }
    ) {
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            items(data) { item ->
                Text(text = item, modifier = Modifier.padding(8.dp))
            }
        }
    }
}
class MySQLConnector(
    private val url: String,
    private val user: String,
    private val password: String
) {

    init {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver")
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }

    fun getData(query: String): List<String> {
        val dataList = mutableListOf<String>()

        try {
            val connection: Connection = DriverManager.getConnection(url, user, password)
            val statement = connection.createStatement()
            val resultSet = statement.executeQuery(query)

            while (resultSet.next()) {
                val columnValue = resultSet.getString("your_column_name")
                dataList.add(columnValue)
            }

            resultSet.close()
            statement.close()
            connection.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return dataList
    }
}
@Composable
fun Login(navigationController: NavHostController){
    val navegation = navigationController
    BackgroundImage()
    LoginInicio(navegation)
}

@Composable
fun BackgroundImage(){
    val backgroundImage = painterResource(id = R.drawable.fondo)
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

@Composable
fun LoginInicio(navegation:NavHostController){
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(50.dp))
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Login imagen",
            modifier = Modifier.size(220.dp))

        Spacer(modifier = Modifier.height(1.dp))
        Text(
            text = "Bienvenido",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            color = colorResource(id = R.color.AzulMarino)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Iniciar Seción",
            fontFamily = FontFamily.Serif,
            color = colorResource(id = R.color.AzulMarino))

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = email, onValueChange = {
            email = it
        }, label={
            Text(text = "Email",
                fontFamily = FontFamily.Serif,
                color = colorResource(id = R.color.AzulMarino))
        })

        Spacer(modifier = Modifier.height(10.dp))
        var isPasswordVisible by remember { mutableStateOf(false) }
        OutlinedTextField(value = password, onValueChange = {
            password = it
        }, label={
            Text(text = "Contraseña",
                fontFamily = FontFamily.Serif,
                color = colorResource(id = R.color.AzulMarino))
        },visualTransformation = if (isPasswordVisible) VisualTransformation.None else
            PasswordVisualTransformation(),
            trailingIcon = {
                Icon(painter =
                if (isPasswordVisible) painterResource(id = R.drawable.ic_visibility)
                else painterResource(id = R.drawable.ic_visibility),
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        isPasswordVisible = !isPasswordVisible
                    }
                )
            })

        //Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Olvide mi contraseña",
                fontFamily = FontFamily.Serif,
                modifier = Modifier
                    .clickable {
                        navegation.navigate("Recuperar")
                    },
                color = Color.Gray
            )

            Spacer(modifier = Modifier.width(58.dp))
        }

        Spacer(modifier = Modifier.height(19.dp))
        Button(modifier = Modifier
            .width(150.dp)
            .height(50.dp),
            onClick = {
                navegation.navigate("Menu")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff1C2D66)),
            shape = CutCornerShape(8.dp)
        ) {
            Text(text = "Ingresar",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(10.dp))
        TextButton(onClick = {
            navegation.navigate("Empleado")
        }

            ) {
            Text(text = "¿No tienes cuenta?" ,
                fontFamily = FontFamily.Serif,
                color = colorResource(id = R.color.AzulMarino))
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ColorsAndVisionTheme {

    }
}