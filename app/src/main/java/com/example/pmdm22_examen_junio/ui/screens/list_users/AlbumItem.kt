package com.example.pmdm22_examen_junio.ui.screens.list_users


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pmdm22_examen_junio.R
import com.example.pmdm22_examen_junio.data.Album
import com.example.pmdm22_examen_junio.data.IMAGE_NO_AVALIABLE_RESOURCE

@Composable
fun AlbumItem(
    album: Album,
    onInfo: () -> Unit,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .padding(10.dp)
            .background(MaterialTheme.colorScheme.primaryContainer),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = album.imageRes ?: IMAGE_NO_AVALIABLE_RESOURCE),
            contentDescription = null,
            modifier = Modifier.weight(1f).padding(horizontal = 5.dp)
        )
        Column(
            modifier = Modifier
                .weight(3f)
                .padding(horizontal = 25.dp, vertical = 5.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = album.titulo, fontSize = 18.sp)
            Text(
                text = album.autor,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 10.sp,
                textAlign = TextAlign.Center
            )
        }
        Column() {
            IconButton(onClick = onInfo) {
                Icon(Icons.Filled.Info, contentDescription = stringResource(R.string.info))
            }
            IconButton(onClick = onDelete) {
                Icon(Icons.Filled.Close, contentDescription = stringResource(R.string.delete))
            }
        }
    }
}
