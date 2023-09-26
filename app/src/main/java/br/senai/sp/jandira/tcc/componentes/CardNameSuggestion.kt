package br.senai.sp.jandira.tcc.componentes

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.nameSuggestion.NameDelete.NameDelete
import br.senai.sp.jandira.tcc.model.nameSuggestion.NamePost.NamePost
import br.senai.sp.jandira.tcc.model.nameSuggestion.NameSuggestionFavorite.NameFavoriteList
import br.senai.sp.jandira.tcc.model.nameSuggestion.NameSuggestionFavorite.NomeFavoriteResponse
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun CardNameSuggestion(
    nome: String,
    idNome: Int,
    idGestante: Int,
    onclick: () -> Unit,
) {

    var nomesFavoritos by rememberSaveable {
        mutableStateOf(listOf<NomeFavoriteResponse>())
    }

    var imageResource = R.drawable.coracao_cinza


    Card(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(horizontal = 24.dp, vertical = 10.dp)
            .shadow(
                2.dp, shape = RoundedCornerShape(20.dp), ambientColor = Color(182, 182, 246)
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
                        text = nome, fontSize = 20.sp
                    )

                }



                Row() {

                    //imageResource = if () {
//                        R.drawable.heart
//                    } else {
//                        R.drawable.coracao_cinza
//                    }

                    fun DeleteName(viewModel: ModelPregnant) {

                        var deleteName = NameDelete(

                            id_nome = idNome,
                            id_gestante = idGestante
                        )

                    }

                    fun PostName(viewModel: ModelPregnant) {

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

                                    nomesFavoritos = response.body()!!.favoritos

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

                    Image(
                        painter = painterResource(id = imageResource),
                        contentDescription = null,
                        modifier = Modifier
                            .size(27.dp)
                            .clickable {
                                PostName(viewModel = ModelPregnant())
                            }
                    )
                }
            }
        }
    }
}


