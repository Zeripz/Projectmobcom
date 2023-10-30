package com.example.projectmobcom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.projectmobcom.ui.theme.ProjectmobcomTheme
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Build
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import android.net.Uri

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<ImageViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectmobcomTheme {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.Center
                    ){
                        Text(
                            text = "Main Activity",
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Pencet tombol berikut untuk membuka second activity",
                            modifier = Modifier.weight(1f)
                        )
                        Button(onClick = {
                            Intent(applicationContext, SecondActivity::class.java).also {
                                startActivity(it)
                            }
                        }) {
                            Text(text = "Second Activity")
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Pencet tombol berikut untuk membuka Youtube",
                            modifier = Modifier.weight(1f)
                        )
                        Button(onClick = {
                            Intent(Intent.ACTION_MAIN).also {
                                it.`package` = "com.google.android.youtube"
                                try {
                                    startActivity(it)
                                } catch (e: ActivityNotFoundException) {
                                    e.printStackTrace()
                                }
                            }
                        }) {
                            Text(text = "Youtube")
                        }
                    }
                    viewModel.uri?.let{
                        AsyncImage(
                            model = viewModel.uri,
                            contentDescription = null)
                    }
                }
            }
        }
    }
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val uri = intent?.getParcelableExtra(Intent.EXTRA_STREAM, Uri::class.java)
        viewModel.updateUri(uri)
    }
}