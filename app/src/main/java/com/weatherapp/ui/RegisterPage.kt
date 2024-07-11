package com.weatherapp.ui

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.saveable.rememberSaveable
import com.weatherapp.LoginActivity

@Composable
fun RegisterPage() {
    val activity = LocalContext.current as? Activity
    var name by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var repeatPassword by rememberSaveable { mutableStateOf("") }
    val isFormValid by remember {
        derivedStateOf {
            name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && password == repeatPassword
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { newValue -> name = newValue },
            label = { Text("Nome") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { newValue -> email = newValue },
            label = { Text("E-mail") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { newValue -> password = newValue },
            label = { Text("Senha") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            visualTransformation = PasswordVisualTransformation()
        )

        OutlinedTextField(
            value = repeatPassword,
            onValueChange = { newValue -> repeatPassword = newValue },
            label = { Text("Repetir Senha") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(
                onClick = {
                    name = ""
                    email = ""
                    password = ""
                    repeatPassword = ""
                },
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
            ) {
                Text("Limpar")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = {
                    Toast.makeText(activity, "Registro bem-sucedido!", Toast.LENGTH_LONG).show()
                    val intent = Intent(activity, LoginActivity::class.java).setFlags(
                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    )
                    activity?.startActivity(intent)
                },
                enabled = isFormValid,
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
            ) {
                Text("Registrar")
            }
        }
    }
}

@Preview
@Composable
fun PreviewRegisterPage() {
    RegisterPage()
}

