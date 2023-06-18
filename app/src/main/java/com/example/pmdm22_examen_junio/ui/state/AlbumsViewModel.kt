package com.example.pmdm22_examen_junio.ui.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.pmdm22_examen_junio.data.Album
import com.example.pmdm22_examen_junio.data.Genre
import com.example.pmdm22_examen_junio.data.getListAlbums


class AlbumsViewModel : ViewModel() {
    private var _genresToShow = mutableStateListOf(Genre.Rock, Genre.Blues, Genre.Jazz)
    val genresToShow get() = _genresToShow.toList()

    private var _albumList = mutableStateListOf<Album>()
    val albumList get() = _albumList.toList()

    init {
        filterByGenre()
    }

    private fun filterByGenre() {
        _albumList = getListAlbums().toMutableList()
            .filter { album -> genresToShow.any { it == album.genre } }
            .toMutableStateList()
    }

    private var _albumInfo: Album? by mutableStateOf(null)
    val albumInfo get() = _albumInfo

    fun showInfo(id: Int) {
        _albumInfo = _albumList.find { it.id == id }
    }

    fun removeAlbum(id: Int) {
        _albumList.removeIf { it.id == id }
    }

    fun closeInfoDialog() {
        _albumInfo = null
    }

    fun changeGenre(genre: Genre) {
        _genresToShow.find { it == genre }
            ?.let { _genresToShow.removeIf { it == genre } }
            ?: _genresToShow.add(genre)
        filterByGenre()
    }

}