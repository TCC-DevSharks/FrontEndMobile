package br.senai.sp.jandira.tcc.gui.mobileGestation.preparationsFlow.trousseau

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
import br.senai.sp.jandira.tcc.model.troussea.TrousseauList2
import br.senai.sp.jandira.tcc.model.troussea.TrousseauListFavorite2
import br.senai.sp.jandira.tcc.model.troussea.TrousseauResponse2
import br.senai.sp.jandira.tcc.model.troussea.TrousseauResponseFavorite2
import br.senai.sp.jandira.tcc.model.troussea.trousseauPos.TrousseauBody
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun TrousseauScreen(navController: NavController, category: String?, viewModelPregnant: ModelPregnant) {

    var viewModel = viewModelPregnant

    var enxoval by rememberSaveable {
        mutableStateOf(listOf<TrousseauResponse2>())
    }

    var enxovalFavorite by rememberSaveable {
        mutableStateOf(listOf<TrousseauResponseFavorite2>())
    }

    fun String.capitalizeFirstLetter(): String {
        return if (isNotEmpty()) {
            val lowercase = substring(1).toLowerCase()
            this[0].toUpperCase() + lowercase
        } else {
            this
        }
    }

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val category = navBackStackEntry?.arguments?.getString("category")

    var selectedColumnInOtherScreen by remember { mutableStateOf(1) }

    Box(modifier = Modifier.fillMaxSize()) {


        Column(modifier = Modifier.fillMaxSize()) {

            if (category != null) {
                Header(titulo = "${category.capitalizeFirstLetter()}")
            }

            SubHeader(
                leftText = stringResource(id = R.string.suggested),
                rightText = stringResource(id = R.string.my_list),
                onColumnSelected = { selectedColumn ->
                    selectedColumnInOtherScreen = selectedColumn
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            val callFavorrite = RetrofitFactory().getTrousseauService()
                .getTrousseauFavorite(viewModel.id)

            callFavorrite.enqueue(object : retrofit2.Callback<TrousseauListFavorite2> {
                override fun onResponse(
                    call: retrofit2.Call<TrousseauListFavorite2>,
                    response: Response<TrousseauListFavorite2>
                ) {
                    enxovalFavorite = response.body()!!.favoritos
                }

                override fun onFailure(call: retrofit2.Call<TrousseauListFavorite2>, t: Throwable) {
                    Log.i("ds3m", "onFailure: ${t.message}")
                }
            })

            val call = category?.let {
                RetrofitFactory().getTrousseauService().getTrousseauCategory(
                    it
                )
            }

            if (call != null) {
                call.enqueue(object : retrofit2.Callback<TrousseauList2> {

                    override fun onResponse(
                        call: Call<TrousseauList2>,
                        response: Response<TrousseauList2>
                    ) {

                        enxoval = response.body()!!.enxoval

                        Log.e("Gui", "onResponse: ${enxoval}", )
                    }

                    override fun onFailure(call: Call<TrousseauList2>, t: Throwable) {
                        Log.i("Erro", "onFailure: ${t.message}")
                    }

                })
            }


            if (selectedColumnInOtherScreen == 1) {

                LazyColumn(  modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 85.dp, top = 9.dp)
                ) {




                    items(enxoval) {

                        CardBirthPlan( enxoval = it.item, onclick = { TrousseauPost(idGestante = viewModel.id, idEnxoval = it.id) })
                    }


                }

            } else {

                LazyColumn(  modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 85.dp, top = 9.dp)
                ) {



                    items(enxovalFavorite.filter { it.categoria == category }) {
                        FavoriteBirthPlan(enxoval = it.item, onclick = { TrousseauDelte(idEnxoval = it.id, idGestante = viewModel.id) })
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
fun TrousseauPost (idEnxoval: Int, idGestante: Int) {

    var favoriteTrousseau = TrousseauBody(
        id_enxoval = idEnxoval,
        id_gestante = idGestante,
    )

    val callAddTrousseau = RetrofitFactory().getTrousseauService().insertTrousseau(favoriteTrousseau)

    callAddTrousseau.enqueue(object : Callback<TrousseauListFavorite2> {
        override fun onResponse(
            call: Call<TrousseauListFavorite2>,
            response: Response<TrousseauListFavorite2>
        ) {

            Log.i("TrousseauPost", "onResponse: ${response.body()}")

        }

        override fun onFailure(call: Call<TrousseauListFavorite2>, t: Throwable) {
            Log.i("TrousseauFavoriteErro", "onFailure: ${t.message}")
        }
    })
}

fun TrousseauDelte (idEnxoval: Int, idGestante: Int) {

    var callDeleteTrousseau = RetrofitFactory().getTrousseauService().deleteTrousseau(idEnxoval, idGestante)

    callDeleteTrousseau.enqueue(object : Callback<TrousseauListFavorite2> {
        override fun onResponse(
            call: Call<TrousseauListFavorite2>,
            response: Response<TrousseauListFavorite2>
        ) {
            Log.i("DeleteSucesso", "onResponse: ${response.body()}")
        }

        override fun onFailure(call: Call<TrousseauListFavorite2>, t: Throwable) {
            Log.i("ErroDelete", "onFailure: ${t.message}")
        }
    })


}






//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun TrousseauPreview() {
//    TrousseauScreen()
//}