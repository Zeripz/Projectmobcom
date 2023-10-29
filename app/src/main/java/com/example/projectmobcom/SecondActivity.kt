package com.example.projectmobcom

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import com.example.projectmobcom.ui.theme.ProjectmobcomTheme

class SecondActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            ProjectmobcomTheme{
                Text(text = "ini halaman ke2")
                Button(onClick ={
                    Intent(applicationContext, MainActivity::class.java).also{
                        startActivity(it)
                    }
                }){
                    Text(text = "Back")
                }
            }
        }
    }

}