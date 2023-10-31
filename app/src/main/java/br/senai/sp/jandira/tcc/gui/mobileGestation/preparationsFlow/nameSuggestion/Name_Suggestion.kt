package br.senai.sp.jandira.tcc.gui.mobileGestation.preparationsFlow.nameSuggestion

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.CardNameSuggestion
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.Navigation
import br.senai.sp.jandira.tcc.componentes.SubHeader
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.nameSuggestion.NamePost.NamePost
import br.senai.sp.jandira.tcc.model.nameSuggestion.NameSuggestionFavorite.NameFavoriteList
import br.senai.sp.jandira.tcc.model.nameSuggestion.NameSuggestionResponse
import br.senai.sp.jandira.tcc.model.nameSuggestion.NameSuggestionList
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun Name_Suggestion(navController: NavController, pregnant: ModelPregnant) {

    var selectedColumnInOtherScreen by remember { mutableStateOf(1) }
    var selectedSex by remember { mutableStateOf("Masculino") }
    var counterEffect by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        GetName(pregnant, selectedSex)
    }
    GetFavoriteName(pregnant, selectedSex)


    var lista by remember { mutableStateOf(listOf<NameSuggestionResponse>()) }
    var listaFavoritos by remember { mutableStateOf(listOf<NameSuggestionResponse>()) }
    var favoritoIds = pregnant.FavoritoSugestao.map { it.nome }

    LaunchedEffect(lista) {
        listaFavoritos = emptyList()
        val callFavorrite = RetrofitFactory().getNamesService()
            .getNameFavorite(id = pregnant.id, sexo = selectedSex)

        callFavorrite.enqueue(object : retrofit2.Callback<NameFavoriteList> {
            override fun onResponse(
                call: retrofit2.Call<NameFavoriteList>,
                response: Response<NameFavoriteList>
            ) {
                pregnant.FavoritoSugestao = response.body()!!.favoritos

                if (response.isSuccessful) {
                    var ids = pregnant.FavoritoSugestao.map { it.nome }
                    pregnant.sugestao.forEach { sugestao ->
                        if (ids.contains(sugestao.nome) && !listaFavoritos.any { it.nome == sugestao.nome }) {
                            listaFavoritos = listaFavoritos + sugestao
                        }
                    }
                }
            }

            override fun onFailure(call: retrofit2.Call<NameFavoriteList>, t: Throwable) {
                Log.i("ds3m", "onFailure: ${t.message}")
            }
        })


    }

    LaunchedEffect(pregnant.sugestao) {
        pregnant.sugestao.forEach { sugestao ->
            if (!favoritoIds.contains(sugestao.nome) && !lista.any { it.nome == sugestao.nome }) {
                lista = lista + sugestao
            }
        }
    }

    LaunchedEffect(counterEffect) {
        lista = emptyList()
        val callFavorrite = RetrofitFactory().getNamesService()
            .getNameFavorite(id = pregnant.id, sexo = selectedSex)

        callFavorrite.enqueue(object : retrofit2.Callback<NameFavoriteList> {
            override fun onResponse(
                call: retrofit2.Call<NameFavoriteList>,
                response: Response<NameFavoriteList>
            ) {
                pregnant.FavoritoSugestao = response.body()!!.favoritos

                if (response.isSuccessful) {
                    var ids = pregnant.FavoritoSugestao.map { it.nome }
                    pregnant.sugestao.forEach { sugestao ->
                        if (!ids.contains(sugestao.nome) && !lista.any { it.nome == sugestao.nome }) {
                            lista = lista + sugestao
                        }
                    }
                }
            }

            override fun onFailure(call: retrofit2.Call<NameFavoriteList>, t: Throwable) {
                Log.i("ds3m", "onFailure: ${t.message}")
            }
        })

    }

    LaunchedEffect(selectedSex){
        lista = emptyList()
        listaFavoritos = emptyList()
        GetName(pregnant, selectedSex)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(250, 250, 254))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(250, 250, 254))
                .padding(bottom = 90.dp)
        ) {

            Column(modifier = Modifier.fillMaxWidth()) {


                Header(titulo = stringResource(id = R.string.name_suggestion),
                    navController = navController,
                    rota = "homeUser")

                SubHeader(
                    leftText = stringResource(id = R.string.suggested),
                    rightText = stringResource(id = R.string.favorites),
                    onColumnSelected = { selectedColumn ->
                        selectedColumnInOtherScreen = selectedColumn
                    }
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Button(
                    modifier = Modifier
                        .size(width = 120.dp, height = 60.dp)
                        .padding(vertical = 9.dp, horizontal = 4.dp)
                        .align(alignment = Alignment.CenterVertically),
                    colors = if (selectedSex == "Masculino") ButtonDefaults.buttonColors(
                        Color(
                            182,
                            182,
                            246
                        )
                    ) else ButtonDefaults.buttonColors(Color.White),
                    shape = RoundedCornerShape(50.dp),
                    border = if (selectedSex == "Masculino") BorderStroke(
                        width = 2.dp,
                        Color(182, 182, 246)
                    ) else BorderStroke(width = 2.dp, Color(182, 182, 246)),
                    onClick = {
                        selectedSex = "Masculino"
                    },
                ) {

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Icon(
                            modifier = Modifier
                                .size(38.dp),
                            painter = painterResource(id = R.drawable.baseline_male_24),
                            contentDescription = null,
                            tint = if (selectedSex == "Masculino") Color.White else Color(
                                182,
                                182,
                                246
                            )

                        )

                    }

                }


                Button(
                    modifier = Modifier
                        .size(width = 120.dp, height = 60.dp)
                        .padding(vertical = 9.dp, horizontal = 4.dp)
                        .align(alignment = Alignment.CenterVertically),
                    border = if (selectedSex == "Feminino") BorderStroke(
                        width = 2.dp,
                        Color(182, 182, 246)
                    ) else BorderStroke(width = 2.dp, Color(182, 182, 246)),
                    colors = if (selectedSex == "Feminino") ButtonDefaults.buttonColors(
                        Color(
                            182,
                            182,
                            246
                        )
                    ) else ButtonDefaults.buttonColors(Color.White),
                    shape = RoundedCornerShape(50.dp),
                    onClick = {

                        selectedSex = "Feminino"


                    },
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_female_24),
                        contentDescription = null,
                        modifier = Modifier.size(38.dp),
                        tint = if (selectedSex == "Feminino") Color.White else Color(182, 182, 246)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            if (selectedColumnInOtherScreen == 1) {

                LazyColumn(
                    modifier = Modifier
                        .padding(vertical = 9.dp, horizontal = 4.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(lista) { nome ->

                        val matchingItem = pregnant.FavoritoSugestao.find { it.nome == nome.nome }
                        val check = matchingItem != null

                        CardNameSuggestion(
                            pregnant,
                            nome = nome.nome,
                            idNome = nome.id,
                            idGestante = pregnant.id,
                            sexo = selectedSex,
                            initialCheck = check,
                            onclick = {
                                if (!check) {

                                    var favoriteName = NamePost(
                                        id_nome = nome.id,
                                        id_gestante = pregnant.id,
                                    )

                                    Log.e("Favorito", "${favoriteName}")

                                    val callAddFavorite =
                                        RetrofitFactory().getNamesService().insertName(favoriteName)

                                    callAddFavorite.enqueue(object : Callback<NameFavoriteList> {

                                        override fun onResponse(
                                            call: Call<NameFavoriteList>,
                                            response: Response<NameFavoriteList>
                                        ) {

                                            if (response.isSuccessful) {
                                                Log.i("Post", "onResponse: ${response}")
                                                Log.i("Post", "onResponse: ${response.body()}")
                                                lista = lista - nome

                                            } else {

                                            }
                                        }

                                        override fun onFailure(
                                            call: Call<NameFavoriteList>,
                                            t: Throwable
                                        ) {
                                            Log.i("ErroPost", "onFailure: ${t.message}")

                                        }

                                    })
                                }
                            })
                    }
                }

            } else {

                LazyColumn(
                    modifier = Modifier
                        .padding(vertical = 9.dp, horizontal = 4.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(listaFavoritos) { nome ->
                        val matchingItem = pregnant.FavoritoSugestao.find { it.nome == nome.nome }
                        val check = matchingItem != null

                        CardNameSuggestion(
                            pregnant,
                            nome = nome.nome,
                            idNome = nome.id,
                            idGestante = pregnant.id,
                            sexo = selectedSex,
                            initialCheck = check,
                            onclick = {
                                DeleteName(idNome = nome.id, idGestante = pregnant.id)
                                listaFavoritos = listaFavoritos - nome
                                counterEffect = !counterEffect
                            })

                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .border(
                    .9.dp,
                    Color(182, 182, 246),
                    shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
                )
        ) {

            Navigation(navController = navController,pregnant)
        }


    }
}

fun GetFavoriteName(viewModel: ModelPregnant, sexo: String) {
    val callFavorrite =
        RetrofitFactory().getNamesService().getNameFavorite(id = viewModel.id, sexo = sexo)

    callFavorrite.enqueue(object : retrofit2.Callback<NameFavoriteList> {
        override fun onResponse(
            call: retrofit2.Call<NameFavoriteList>,
            response: Response<NameFavoriteList>
        ) {
            viewModel.FavoritoSugestao = response.body()!!.favoritos
        }

        override fun onFailure(call: retrofit2.Call<NameFavoriteList>, t: Throwable) {
            Log.i("ds3m", "onFailure: ${t.message}")
        }
    })
}

fun GetName(viewModel: ModelPregnant, sexo: String) {
    val call = RetrofitFactory().getNamesService().getNameSex(sexo)

    call.enqueue(object : retrofit2.Callback<NameSuggestionList> {
        override fun onResponse(
            call: retrofit2.Call<NameSuggestionList>,
            response: Response<NameSuggestionList>

        ) {
            viewModel.sugestao = response.body()!!.nomes
        }

        override fun onFailure(call: retrofit2.Call<NameSuggestionList>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure: ${t.message}"
            )
        }
    })
}

fun DeleteName(idNome: Int, idGestante: Int) {

    val callDeleteFavorite = RetrofitFactory().getNamesService().deleteName(idNome, idGestante)

    callDeleteFavorite.enqueue(object : Callback<NameFavoriteList> {

        override fun onResponse(
            call: Call<NameFavoriteList>,
            response: Response<NameFavoriteList>
        ) {
            Log.i("Delete", "onResponse: ${response}")
        }

        override fun onFailure(call: Call<NameFavoriteList>, t: Throwable) {

            Log.i("DeleteErro", "onResponse: ${t.message}")


        }

    })

}

fun PostName(idNome: Int, idGestante: Int) {

    var favoriteName = NamePost(
        id_nome = idNome,
        id_gestante = idGestante,
    )

    Log.e("Favorito", "${favoriteName}")

    val callAddFavorite =
        RetrofitFactory().getNamesService().insertName(favoriteName)

    callAddFavorite.enqueue(object : Callback<NameFavoriteList> {

        override fun onResponse(
            call: Call<NameFavoriteList>,
            response: Response<NameFavoriteList>
        ) {

            if (response.isSuccessful) {
                Log.i("Post", "onResponse: ${response}")
                Log.i("Post", "onResponse: ${response.body()}")

            } else {

            }
        }

        override fun onFailure(call: Call<NameFavoriteList>, t: Throwable) {
            Log.i("ErroPost", "onFailure: ${t.message}")

        }

    })
}