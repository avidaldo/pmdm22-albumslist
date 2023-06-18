package com.example.pmdm22_examen_junio.ui.screens.list_users

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pmdm22_examen_junio.data.Genre

@Composable
fun GenresRow(genresToShow: List<Genre>, onShownGenresChange: (Genre) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.primary).padding(top = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Genre.values().forEach { genre ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = genre.toString())
                Checkbox(
                    checked = genresToShow.contains(genre),
                    onCheckedChange = { onShownGenresChange(genre) })
            }
        }
    }
}