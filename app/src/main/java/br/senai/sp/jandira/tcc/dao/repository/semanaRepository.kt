package br.senai.sp.jandira.tcc.dao.repository

import androidx.compose.runtime.Composable
import br.senai.sp.jandira.tcc.model.week

class semanaRepository {

    companion object {
        @Composable
        fun getSemanasList(): List<week> {
            return listOf<week> (
                week(numero =1),
                week(numero =2),
                week(numero =3),
                week(numero =4),
                week(numero =5),
                week(numero =6),
                week(numero =7),
                week(numero =8),
                week(numero =9),
                week(numero =10),
            )
        }
    }

}