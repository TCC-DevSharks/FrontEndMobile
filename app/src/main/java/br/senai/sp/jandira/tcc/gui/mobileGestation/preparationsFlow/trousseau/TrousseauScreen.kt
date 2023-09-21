package br.senai.sp.jandira.tcc.gui.mobileGestation.preparationsFlow.trousseau

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.CardBirthPlan
import br.senai.sp.jandira.tcc.componentes.FavoriteBirthPlan
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.Navigation
import br.senai.sp.jandira.tcc.componentes.SubHeader
import br.senai.sp.jandira.tcc.model.Trousseau.TrousseauList
import br.senai.sp.jandira.tcc.model.Trousseau.TrousseauResponse
import br.senai.sp.jandira.tcc.model.Trousseau.TrousseauService
import br.senai.sp.jandira.tcc.model.nameSuggestion.NameSuggestionResponse
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

@Composable
fun TrousseauScreen(navController: NavController) {

    var enxoval by rememberSaveable {
        mutableStateOf(listOf<TrousseauResponse>())
    }


    Box(modifier = Modifier.fillMaxSize()) {


        Column(modifier = Modifier.fillMaxSize()) {

            Header(titulo = stringResource(id = R.string.header_trousseau))

            SubHeader(
                leftText = stringResource(id = R.string.suggested),
                rightText = stringResource(id = R.string.my_list)
            )

            val call = RetrofitFactory().getTrousseauService().getTrousseau()

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


            LazyColumn(  modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 85.dp, top = 9.dp)
            ) {

                items(enxoval) {

                    CardBirthPlan( enxoval = it.item)



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