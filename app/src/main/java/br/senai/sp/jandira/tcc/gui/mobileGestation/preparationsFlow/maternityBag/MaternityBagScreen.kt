package br.senai.sp.jandira.tcc.gui.mobileGestation.preparationsFlow.maternityBag

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.CardAlong
import br.senai.sp.jandira.tcc.componentes.FavoriteItensAlong
import br.senai.sp.jandira.tcc.componentes.Navigation
import br.senai.sp.jandira.tcc.componentes.SubHeader
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.maternityBag.MaternityBagBody
import br.senai.sp.jandira.tcc.model.maternityBag.MaternityBagFavoriteList
import br.senai.sp.jandira.tcc.model.maternityBag.MaternityBagList
import br.senai.sp.jandira.tcc.model.maternityBag.MaternityBagResponse
import br.senai.sp.jandira.tcc.model.maternityBag.MaternityBagResponseFavorite
import br.senai.sp.jandira.tcc.model.troussea.TrousseauList2
import br.senai.sp.jandira.tcc.model.troussea.TrousseauListFavorite2
import br.senai.sp.jandira.tcc.model.troussea.TrousseauResponseFavorite2
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaternityBagScreen(navController: NavController, viewModelPregnant: ModelPregnant) {

    var selectedColumnInOtherScreen by remember { mutableStateOf(1) }

    var counterEffect by remember { mutableStateOf(false) }

    var mala by rememberSaveable {
        mutableStateOf(listOf<MaternityBagResponse>())
    }

    var malaFavorito by rememberSaveable {
        mutableStateOf(listOf<MaternityBagResponse>())
    }

    var favorite by rememberSaveable {
        mutableStateOf(listOf<MaternityBagResponseFavorite>())
    }

    var favoritoIds = favorite.map { it.item }

    LaunchedEffect(favorite, counterEffect) {
        malaFavorito = emptyList()

        val callFavorite =
            RetrofitFactory().getMaternityBangService()
                .getMaternityBagFavorite(viewModelPregnant.id)

        callFavorite.enqueue(object : retrofit2.Callback<MaternityBagFavoriteList> {
            override fun onResponse(
                call: Call<MaternityBagFavoriteList>,
                response: Response<MaternityBagFavoriteList>
            ) {
                favorite = response.body()!!.favoritos

                if (response.isSuccessful) {

                    malaFavorito = emptyList()


                    mala.map {
                        if (favoritoIds.contains(it.item)) {
                            malaFavorito = malaFavorito + it
                            println(it.item)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<MaternityBagFavoriteList>, t: Throwable) {
                Log.i("Favorito", "onFailure: ${t.message}")
            }
        })
    }

    LaunchedEffect(Unit) {
        val call = RetrofitFactory().getMaternityBangService().getMaternityBag()

        call.enqueue(object : retrofit2.Callback<MaternityBagList> {
            override fun onResponse(
                call: Call<MaternityBagList>,
                response: Response<MaternityBagList>
            ) {
                mala = response.body()!!.mala
            }

            override fun onFailure(call: Call<MaternityBagList>, t: Throwable) {
                Log.i("GetErro", "onFailure: ${t.message}")
            }
        })

    }




    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Column(modifier = Modifier.fillMaxSize()) {

            Header(
                titulo = stringResource(id = R.string.header_maternity_bag),
//            rota = "homeUser",
//            navController = navController
            )

            SubHeader(
                leftText = stringResource(id = R.string.suggested),
                rightText = stringResource(id = R.string.my_list),
                onColumnSelected = { selectedColumn ->
                    selectedColumnInOtherScreen = selectedColumn


                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            if (selectedColumnInOtherScreen == 1) {

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 85.dp)
                ) {
                    items(mala) {


                        CardAlong(textTitle = it.item, textDescription = it.descricao, onclick = {

                            var favoriteMaternity = MaternityBagBody(
                                id_mala = it.id,
                                id_gestante = viewModelPregnant.id,
                            )
                            if (favoritoIds.contains(it.item)) {

                            } else {
                                val callAddMaternity = RetrofitFactory().getMaternityBangService()
                                    .insertMaternityBag(favoriteMaternity)

                                callAddMaternity.enqueue(object :
                                    retrofit2.Callback<MaternityBagFavoriteList> {
                                    override fun onResponse(
                                        call: Call<MaternityBagFavoriteList>,
                                        response: Response<MaternityBagFavoriteList>
                                    ) {
                                        Log.i("Post", "onResponse: ${response.body()}")

                                        if (response.isSuccessful) {
                                            counterEffect = !counterEffect
                                        }

                                    }

                                    override fun onFailure(
                                        call: Call<MaternityBagFavoriteList>,
                                        t: Throwable
                                    ) {
                                        Log.i("TrousseauFavoriteErro", "onFailure: ${t.message}")
                                    }
                                })
                            }


                        })

                    }
                }

            } else {

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 85.dp)
                ) {
                    items(malaFavorito) {
                        FavoriteItensAlong(textTitle = it.item, textDescription = it.descricao,
                            onclick = {
                                MaternityDelte(idMala = it.id, idGestante = viewModelPregnant.id)
                                malaFavorito = malaFavorito - it

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

            Navigation(navController = navController)


        }

    }
}

fun MaternityDelte(idMala: Int, idGestante: Int) {

    var callDeleteMaternity =
        RetrofitFactory().getMaternityBangService().deleteMaternity(idMala, idGestante)

    callDeleteMaternity.enqueue(object : Callback<MaternityBagFavoriteList> {
        override fun onResponse(
            call: Call<MaternityBagFavoriteList>,
            response: Response<MaternityBagFavoriteList>
        ) {
            Log.i("teste", "onResponse: ${idMala}, ${idGestante}")
            Log.i("DeleteSucesso", "onResponse: ${response.body()}")
        }

        override fun onFailure(call: Call<MaternityBagFavoriteList>, t: Throwable) {
            Log.i("ErroDelete", "onFailure: ${t.message}")
        }
    })
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun MaternityBagPreview() {
//    MaternityBagScreen()
//}