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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
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
import br.senai.sp.jandira.tcc.model.nameSuggestion.NameSuggestionFavorite.NomeFavoriteResponse
import br.senai.sp.jandira.tcc.model.nameSuggestion.NameSuggestionResponse
import br.senai.sp.jandira.tcc.model.nameSuggestion.NameSuggestionList
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun Name_Suggestion(navController: NavController, viewModel: ModelPregnant) {

    var nomes by rememberSaveable {
        mutableStateOf(listOf<NameSuggestionResponse>())
    }

    var nomesFavoritos by rememberSaveable {
        mutableStateOf(listOf<NomeFavoriteResponse>())
    }

    var selectedColumnInOtherScreen by remember { mutableStateOf(1) }


    var selectedSex by remember { mutableStateOf("Masculino") }



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


                Header(titulo = stringResource(id = R.string.name_suggestion))

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



            val call = RetrofitFactory().getNamesService().getNameSex(selectedSex)

            call.enqueue(object : retrofit2.Callback<NameSuggestionList> {
                override fun onResponse(
                    call: retrofit2.Call<NameSuggestionList>,
                    response: Response<NameSuggestionList>

                ) {
                    nomes = response.body()!!.nomes

                    Log.e("Gui", "onResponse: ${nomes}")

                }

                override fun onFailure(call: retrofit2.Call<NameSuggestionList>, t: Throwable) {
                    Log.i(
                        "ds2m",
                        "onFailure: ${t.message}"
                    )
                }
            })

            val callFavorrite = RetrofitFactory().getNamesService().getNameFavorite(id = viewModel.id, sexo = selectedSex)

            callFavorrite.enqueue(object : retrofit2.Callback<NameFavoriteList> {
                override fun onResponse(
                    call: retrofit2.Call<NameFavoriteList>,
                    response: Response<NameFavoriteList>
                ) {

                    nomesFavoritos = response.body()!!.favoritos

                }

                override fun onFailure(call: retrofit2.Call<NameFavoriteList>, t: Throwable) {
                    Log.i("ds3m", "onFailure: ${t.message}")
                }
            })

            if (selectedColumnInOtherScreen == 1) {

                LazyColumn(
                    modifier = Modifier
                        .padding(vertical = 9.dp, horizontal = 4.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(nomes) {

                        CardNameSuggestion(nome = it.nome, idNome = it.id, idGestante = viewModel.id){

                        }

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
                    items(nomesFavoritos) {

                        CardNameSuggestion( nome = it.nome, idNome = it.id, idGestante = viewModel.id){



                        }

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