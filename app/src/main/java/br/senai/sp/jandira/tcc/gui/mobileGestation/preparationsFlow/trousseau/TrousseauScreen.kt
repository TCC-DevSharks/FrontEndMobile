package br.senai.sp.jandira.tcc.gui.mobileGestation.preparationsFlow.trousseau

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
import androidx.compose.material3.Text
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.CardBirthPlan
import br.senai.sp.jandira.tcc.componentes.FavoriteBirthPlan
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.Navigation
import br.senai.sp.jandira.tcc.componentes.SubHeader
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.Trousseau.TrousseauList
import br.senai.sp.jandira.tcc.model.Trousseau.TrousseauListFavorite
import br.senai.sp.jandira.tcc.model.Trousseau.TrousseauResponse
import br.senai.sp.jandira.tcc.model.Trousseau.TrousseauResponseFavorite
import br.senai.sp.jandira.tcc.model.nameSuggestion.NameSuggestionFavorite.NameFavoriteList
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Response

@Composable
fun TrousseauScreen(navController: NavController, category: String?, viewModelPregnant: ModelPregnant) {

    var viewModel = viewModelPregnant

    var enxoval by rememberSaveable {
        mutableStateOf(listOf<TrousseauResponse>())
    }

    var enxovalFavorite by rememberSaveable {
        mutableStateOf(listOf<TrousseauResponseFavorite>())
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


            val call = category?.let {
                RetrofitFactory().getTrousseauService().getTrousseauCategory(
                    it
                )
            }

            if (call != null) {
                call.enqueue(object : retrofit2.Callback<TrousseauList> {

                    override fun onResponse(
                        call: Call<TrousseauList>,
                        response: Response<TrousseauList>
                    ) {

                        enxoval = response.body()!!.enxoval

                        Log.e("Gui", "onResponse: ${enxoval}", )
                    }

                    override fun onFailure(call: Call<TrousseauList>, t: Throwable) {
                        Log.i("Erro", "onFailure: ${t.message}")
                    }

                })
            }

            val callFavorrite = RetrofitFactory().getTrousseauService()
                .getTrousseauFavorite(viewModel.id)

            callFavorrite.enqueue(object : retrofit2.Callback<TrousseauListFavorite> {
                override fun onResponse(
                    call: retrofit2.Call<TrousseauListFavorite>,
                    response: Response<TrousseauListFavorite>
                ) {
                    enxovalFavorite = response.body()!!.favoritos
                }

                override fun onFailure(call: retrofit2.Call<TrousseauListFavorite>, t: Throwable) {
                    Log.i("ds3m", "onFailure: ${t.message}")
                }
            })



            if (selectedColumnInOtherScreen == 1) {

                LazyColumn(  modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 85.dp, top = 9.dp)
                ) {

                    items(enxoval) {
                        CardBirthPlan( enxoval = it.item)
                    }


                }

            } else {

                LazyColumn(  modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 85.dp, top = 9.dp)
                ) {

                    items(enxovalFavorite.filter { it.categoria == category }) {
                        FavoriteBirthPlan(enxoval = it.item)
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

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun TrousseauPreview() {
//    TrousseauScreen()
//}