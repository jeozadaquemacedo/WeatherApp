package com.weatherapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.weatherapp.ui.RegisterPage
import com.weatherapp.ui.theme.WeatherAppTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RegisterPage(this)
                }
            }
        }
    }
}

fun showToastAndFinish(activity: ComponentActivity) {
    Toast.makeText(activity, "Registro OK!", Toast.LENGTH_LONG).show()
    activity.finish()
}

@Preview(showBackground = true)
@Composable
fun PreviewRegisterPage() {
    WeatherAppTheme {
        RegisterPage(ComponentActivity())
    }
}