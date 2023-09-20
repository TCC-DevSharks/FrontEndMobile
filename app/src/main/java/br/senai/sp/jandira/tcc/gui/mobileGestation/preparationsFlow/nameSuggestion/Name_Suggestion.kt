package br.senai.sp.jandira.tcc.gui.mobileGestation.preparationsFlow.nameSuggestion

import android.telecom.Call
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.SubHeader
import br.senai.sp.jandira.tcc.model.getPregnant.PregnantResponse
import br.senai.sp.jandira.tcc.model.getPregnant.PregnantResponseList
import br.senai.sp.jandira.tcc.model.nameSuggestion.NameSuggestionResponse
import br.senai.sp.jandira.tcc.model.nameSuggestion.NameSuggestionList
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import retrofit2.Response
import javax.security.auth.callback.Callback

@Composable
fun Name_Suggestion() {
    Column(modifier = Modifier.fillMaxSize().background(Color(250, 250, 254))) {

        var nomes by rememberSaveable {
            mutableStateOf(listOf<NameSuggestionResponse>())
        }

//        var selectedSex by remember { mutableStateOf(1) }



        Column(modifier = Modifier.fillMaxWidth()) {


            Header(titulo = stringResource(id = R.string.name_suggestion))

            SubHeader(
                leftText = stringResource(id = R.string.suggested),
                rightText = stringResource(id = R.string.favorites)
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
                colors = ButtonDefaults.buttonColors(Color(182, 182, 246, 23)),
                shape = RoundedCornerShape(50.dp),
                border = BorderStroke(width = 2.dp, Color(182, 182, 246)),
                onClick = { },
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {

                    Image(
                        modifier = Modifier
                            .size(29.dp),
                        painter = painterResource(id = R.drawable.gender_baixo),
                        contentDescription = null,
                    )

                }

            }


            Button(
                modifier = Modifier
                    .size(width = 120.dp, height = 60.dp)
                    .padding(vertical = 9.dp, horizontal = 4.dp)
                    .align(alignment = Alignment.CenterVertically),
                colors = ButtonDefaults.buttonColors(Color(182, 182, 246)),
                shape = RoundedCornerShape(50.dp),
                border = BorderStroke(width = 2.dp, Color(182, 182, 246)),
                onClick = { /*TODO*/ },
            ) {
                Image(
                    painter = painterResource(id = R.drawable.gender_cima),
                    contentDescription = null,
                    modifier = Modifier.size(29.dp),
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        val call = RetrofitFactory().getNamesService().getNameSex("Masculino")

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
                println(t.message + t.cause)
            }
        })

        LazyColumn(
            modifier = Modifier
                .padding(vertical = 9.dp, horizontal = 4.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(nomes) {

                Card(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(horizontal = 24.dp, vertical = 10.dp)
                        .shadow(
                            2.dp,
                            shape = RoundedCornerShape(20.dp),
                            ambientColor = Color(182, 182, 246)
                        ),
                    colors = CardDefaults.cardColors(Color.White),
                    shape = RoundedCornerShape(20.dp),
                ) {

                    Card(
                        modifier = Modifier
                            .size(width = 350.dp, height = 60.dp)
                            .padding(horizontal = 15.dp),
                        colors = CardDefaults.cardColors(Color.White),
                        shape = RoundedCornerShape(20.dp),
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row() {
                                Text(
                                    text = it.nome,
                                    fontSize = 20.sp
                                )

                            }
                            var isRed by remember { mutableStateOf(false) }
                            Row(modifier = Modifier.clickable {
                                isRed = !isRed
                            }) {
                                val imageResource = if (isRed) {
                                    R.drawable.coracao_roxo
                                } else {
                                    R.drawable.coracao_cinza
                                }
                                Image(
                                    painter = painterResource(id = imageResource),
                                    contentDescription = null,
                                    modifier = Modifier.size(27.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Name_SuggestionPreview() {
    Name_Suggestion()
}