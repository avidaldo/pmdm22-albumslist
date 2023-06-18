package com.example.pmdm22_examen_junio.ui.screens.list_users

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.pmdm22_examen_junio.R
import com.example.pmdm22_examen_junio.data.Album

@Composable
fun AlbumInfoDialog(
    album: Album,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    confirmString: String = stringResource(R.string.ok),
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = { onDismiss() }) {
                Text(text = confirmString)
            }
        },
        modifier = modifier,
        title = { Text(text = album.titulo) },
        text = {
            Text(text = stringResource(id = album.descRes))
        },
    )
}