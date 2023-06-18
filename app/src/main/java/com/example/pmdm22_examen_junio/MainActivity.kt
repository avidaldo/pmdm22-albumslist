package com.example.pmdm22_examen_junio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pmdm22_examen_junio.ui.screens.list_users.AlbumListScreen
import com.example.pmdm22_examen_junio.ui.state.AlbumsViewModel
import com.example.pmdm22_examen_junio.ui.theme.Pmdm22examenjunioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pmdm22examenjunioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel : AlbumsViewModel = viewModel()
                    AlbumListScreen(viewModel)
                }
            }
        }
    }
}
