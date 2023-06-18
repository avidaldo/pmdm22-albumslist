package com.example.pmdm22_examen_junio.ui.screens.list_users

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pmdm22_examen_junio.data.Album

@Composable
fun AlbumLazyList(
    list: List<Album>,
    onInfoAlbum: (Int) -> Unit,
    onRemoveAlbum: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier.padding(5.dp)) {
        items(items = list, key = { it.id }) {
            AlbumItem(album = it,
                onInfo = { onInfoAlbum(it.id) },
                onDelete = { onRemoveAlbum(it.id) })
        }
    }
}