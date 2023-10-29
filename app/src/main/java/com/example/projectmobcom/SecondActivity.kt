package com.example.projectmobcom

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import com.example.projectmobcom.ui.theme.ProjectmobcomTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

class SecondActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectmobcomTheme {
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = {
                        Intent(applicationContext, MainActivity::class.java).also {
                            startActivity(it)
                        }
                    }) {
                        Text(text = "Back")
                    }
                    Text(text = "ini halaman ke-2")
                }
            }
        }
    }
}
