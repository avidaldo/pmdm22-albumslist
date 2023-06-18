package com.example.pmdm22_examen_junio.ui.screens.list_users

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.pmdm22_examen_junio.R
import com.example.pmdm22_examen_junio.ui.state.AlbumsViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlbumListScreen(viewModel: AlbumsViewModel) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.my_albums)) },
            )
        }
    ) { paddingValues ->

        Column(modifier = Modifier.padding(paddingValues).fillMaxWidth()) {
            GenresRow(
                genresToShow = viewModel.genresToShow,
                onShownGenresChange = { viewModel.changeGenre(it) }
            )
            AlbumLazyList(
                list = viewModel.albumList,
                onInfoAlbum = { viewModel.showInfo(it) },
                onRemoveAlbum = { viewModel.removeAlbum(it) },
            )
        }

        viewModel.albumInfo?.let {
            AlbumInfoDialog(album = it, onDismiss = { viewModel.closeInfoDialog() })
        }
    }
}

