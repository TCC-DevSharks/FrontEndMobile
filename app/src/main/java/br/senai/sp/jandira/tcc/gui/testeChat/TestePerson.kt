package br.senai.sp.jandira.tcc.gui.testeChat

import android.os.Parcelable
import androidx.annotation.DrawableRes
import br.senai.sp.jandira.tcc.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val id: Int = 0,
    val name: String = "",
    @DrawableRes val icon: Int = R.drawable.avia
) : Parcelable

val personList = listOf(
    Person(
        1,
        "Pranav",
        R.drawable.avia
    ),
    Person(
        2,
        "Ayesha",
        R.drawable.avia    ),
    Person(
        3,
        "Roshini",
        R.drawable.avia    ),
    Person(
        4,
        "Kaushik",
        R.drawable.avia    ),
    Person(
        5,
        "Dad",
        R.drawable.avia    ),
    Person(
        6,
        "Pranav",
        R.drawable.avia    ),
    Person(
        7,
        "Ayesha",
        R.drawable.avia    ),
    Person(
        8,
        "Roshini",
        R.drawable.avia    ),
    Person(
        9,
        "Kaushik",
        R.drawable.avia    ),
    Person(
        10,
        "Dad",
        R.drawable.avia    ),
)