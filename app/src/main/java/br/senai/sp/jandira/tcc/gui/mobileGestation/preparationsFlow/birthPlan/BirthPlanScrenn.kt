package br.senai.sp.jandira.tcc.gui.mobileGestation.preparationsFlow.birthPlan

import android.util.Log
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
import androidx.navigation.compose.currentBackStackEntryAsState
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.CardBirthPlan
import br.senai.sp.jandira.tcc.componentes.FavoriteBirthPlan
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.Navigation
import br.senai.sp.jandira.tcc.componentes.SubHeader
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.birthPlan.BirthPlanBody
import br.senai.sp.jandira.tcc.model.birthPlan.BirthPlanList
import br.senai.sp.jandira.tcc.model.birthPlan.BirthPlanListFavorite
import br.senai.sp.jandira.tcc.model.birthPlan.BirthPlanResponse
import br.senai.sp.jandira.tcc.model.birthPlan.BirthPlanResponseFavorite
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun birthPlanScreen(
    navController: NavController,
    category: String?,
    pregnant: ModelPregnant
) {

    var counterEffect by remember { mutableStateOf(false) }

    var planoParto by rememberSaveable {
        mutableStateOf(listOf<BirthPlanResponse>())
    }

    var planoPartoFavorito by rememberSaveable {
        mutableStateOf(listOf<BirthPlanResponse>())
    }

    var favorite by rememberSaveable {
        mutableStateOf(listOf<BirthPlanResponseFavorite>())
    }

    var favoritoIds = favorite.map { it.item }


    fun String.capitalizeFirstLetter(): String {
        return if (isNotEmpty()) {
            val lowercase = substring(1).toLowerCase()
            this[0].toUpperCase() + lowercase
        } else {
            this
        }
    }

    LaunchedEffect(favorite, counterEffect) {
        val callFavorrite = RetrofitFactory().getBirthPlanService()
            .getBirthPlanFavorite(pregnant.id)

        callFavorrite.enqueue(object : Callback<BirthPlanListFavorite> {
            override fun onResponse(
                call: Call<BirthPlanListFavorite>,
                response: Response<BirthPlanListFavorite>
            ) {
                favorite = response.body()!!.favoritos

                Log.i("BirthPlan", "onResponse: $favorite")
                if (response.isSuccessful) {
                    val favoritoIds = favorite.map { it.item }
                    planoPartoFavorito = planoParto.filter { favoritoIds.contains(it.item) }
                }
            }

            override fun onFailure(call: Call<BirthPlanListFavorite>, t: Throwable) {
                Log.i("ds3m", "onFailure: ${t.message}")
            }
        })
    }

    LaunchedEffect(Unit) {
        val call = RetrofitFactory().getBirthPlanService().getBirthPlanCategory(category!!)

        call.enqueue(object : Callback<BirthPlanList> {

            override fun onResponse(
                call: Call<BirthPlanList>,
                response: Response<BirthPlanList>
            ) {

                planoParto = response.body()!!.planos

                Log.e("Gui", "onResponse: ${planoParto}")
            }

            override fun onFailure(call: Call<BirthPlanList>, t: Throwable) {
                Log.i("Erro", "onFailure: ${t.message}")
            }

        })
    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val category = navBackStackEntry?.arguments?.getString("category")

    var selectedColumnInOtherScreen by remember { mutableStateOf(1) }


    Box(modifier = Modifier.fillMaxSize()) {


        Column(modifier = Modifier.fillMaxSize()) {

            if (category != null) {
                Header(
                    titulo = "${category.capitalizeFirstLetter()}",
                    rota = "birthPlanCategory",
                    navController = navController
                )
            }

            SubHeader(
                leftText = stringResource(id = R.string.suggested),
                rightText = stringResource(id = R.string.my_list),
                onColumnSelected = { selectedColumn ->
                    selectedColumnInOtherScreen = selectedColumn
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            if (selectedColumnInOtherScreen == 1) {

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 20.dp, top = 9.dp)
                ) {

                    items(planoParto) {
                        CardBirthPlan(preparativo = it.item, onclick = {

                            if (favoritoIds.contains(it.item)) {


                            } else {

                                var favoriteBirthPlan = BirthPlanBody(
                                    id_plano = it.id,
                                    id_gestante = pregnant.id,
                                )

                                val callAddBirthPlan = RetrofitFactory().getBirthPlanService()
                                    .insertBirthPlan(favoriteBirthPlan)

                                callAddBirthPlan.enqueue(object : Callback<BirthPlanListFavorite> {
                                    override fun onResponse(
                                        call: Call<BirthPlanListFavorite>,
                                        response: Response<BirthPlanListFavorite>

                                    ) {
                                        Log.i("PostBirth", "onResponse: $response")
                                        if (response.isSuccessful) {
                                            counterEffect = !counterEffect
                                        }

                                    }

                                    override fun onFailure(
                                        call: Call<BirthPlanListFavorite>,
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
                        .padding(bottom = 85.dp, top = 9.dp)
                ) {

                    items(planoPartoFavorito.filter { it.categoria == category }) {


                        FavoriteBirthPlan(enxoval = it.item, onclick = {
                            BirthPLanDelte(idPlano = it.id, idGestante = pregnant.id)
                            planoPartoFavorito = planoPartoFavorito - it
                        })
                    }

                }

            }
        }
    }

}

fun BirthPLanDelte(idPlano: Int, idGestante: Int) {

    var callDeleteBirthPlan =
        RetrofitFactory().getBirthPlanService().deleteBirthPlan(idPlano, idGestante)

    callDeleteBirthPlan.enqueue(object : Callback<BirthPlanListFavorite> {
        override fun onResponse(
            call: Call<BirthPlanListFavorite>,
            response: Response<BirthPlanListFavorite>
        ) {
            Log.i("teste", "onResponse: ${idPlano}, ${idGestante}")
            Log.i("DeletePlano", "onResponse: ${response.body()}")
        }

        override fun onFailure(call: Call<BirthPlanListFavorite>, t: Throwable) {
            Log.i("ErroPlano", "onFailure: ${t.message}")
        }
    })
}