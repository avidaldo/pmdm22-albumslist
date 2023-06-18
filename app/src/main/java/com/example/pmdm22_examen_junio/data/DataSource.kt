package com.example.pmdm22_examen_junio.data

import com.example.pmdm22_examen_junio.R
import java.util.concurrent.atomic.AtomicInteger



enum class Genre { Rock, Blues, Jazz }

data class Album(
    val titulo: String,
    val autor: String,
    val genre: Genre,
    val imageRes: Int?, // Recurso que contiene la imagen dentro de res/drawable
    val descRes: Int, // Identificador del recurso que contiene la descripción dentro de res/values/desc_albums.xml
) {
    val id: Int = identifier.incrementAndGet()

    companion object {
        val identifier: AtomicInteger = AtomicInteger(0)
    }
}

val IMAGE_NO_AVALIABLE_RESOURCE = R.drawable.disco

fun getListAlbums() = listOf(
    //Album("Abbey Road", "The Beatles", Genre.Rock, R.drawable.abbeyroad, R.string.abbeyroad),
    Album("Abbey Road", "The Beatles", Genre.Rock, null, R.string.abbeyroad),
    Album("Exile on Main Street", "The Rolling Stones", Genre.Rock, R.drawable.exileonmainst, R.string.exilesonmainstreet),
    Album("The Velvet Underground", "The Velvet Underground and Nico", Genre.Rock, R.drawable.velvetunderground, R.string.velvetunderground),
    Album("Are You Experienced", "Jimi Hendrix",Genre.Rock, R.drawable.areyouexperienced, R.string.areyouexperienced),
    Album("Back in Black", "AC/DC", Genre.Rock, R.drawable.backinblack, R.string.backinblack),
    Album("Appetite for Destruction", "Guns N’ Roses", Genre.Rock, R.drawable.appetitefordestruction, R.string.appetitefordestruction),
    Album("Led Zeppelin IV", "Led Zeppelin", Genre.Rock, R.drawable.ledzeppeliniv, R.string.ledzeppeliniv),
    Album("Lady Soul", "Aretha Franklin", Genre.Blues, R.drawable.ladysoul, R.string.ladysoul),
    Album("I Never Loved a Man the Way I Love You", "Aretha Franklin", Genre.Blues, R.drawable.neverloved, R.string.ineverloveda),
    Album("What's Going On", "Marvin Gaye", Genre.Blues, R.drawable.whatsgoingon, R.string.whatsgoingon),
    Album("Kind of Blue", "Miles Davis", Genre.Jazz, R.drawable.kindofblue, R.string.kindofblue),
    Album("Bitches Brew", "Miles Davis", Genre.Jazz, R.drawable.bitchesbrew, R.string.bitchesbrew),
    Album("A Love Supreme", "John Coltrane", Genre.Jazz, R.drawable.alovesupreme, R.string.alovesupreme)
).shuffled()