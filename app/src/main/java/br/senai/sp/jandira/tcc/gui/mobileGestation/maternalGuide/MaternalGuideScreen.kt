package br.senai.sp.jandira.tcc.gui.mobileGestation.maternalGuide

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.Navigation
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.article.articleList
import br.senai.sp.jandira.tcc.model.article.articleResponse
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun MaternalGuideScreen(navController: NavController, pregnant: ModelPregnant) {

    Log.i("fdfgdfgdfgdfgdfgdf", "${pregnant.artigo}")

     var artigos by rememberSaveable {
        mutableStateOf(listOf<articleResponse>())
    }

    val painter = painterResource(id = R.drawable.gravida_card)


    fun String.capitalizeFirstLetter(): String {
        return if (isNotEmpty()) {
            val lowercase = substring(1).toLowerCase()
            this[0].toUpperCase() + lowercase
        } else {
            this
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 20.dp)
        ) {

            Header(
                titulo = stringResource(id = R.string.news),
                rota = "homeUser",
                navController = navController
            )

            Spacer(modifier = Modifier.height(25.dp))


            var call = RetrofitFactory().getTrousseauService().getArticleId(pregnant.artigo)


            call.enqueue(object : Callback<articleList> {
                override fun onResponse(
                    call: Call<articleList>,
                    response: Response<articleList>
                ) {

                    artigos = response.body()!!.artigos
                    Log.i("dsdsds", "${response.body()}")

                }

                override fun onFailure(call: Call<articleList>, t: Throwable) {
                    Log.i("fdfdfdf", "${t.message}")
                }
            })

            LazyColumn() {

                items(artigos) { artigo ->
                    Column(modifier = Modifier.padding(horizontal = 26.dp)) {

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(220.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = CardDefaults.cardColors(Color(182, 182, 246))
                        ) {
                            AsyncImage(
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop,
                                model = artigo.imagem,
                                contentDescription = null,
                                transform = { state ->
                                    when (state) {
                                        is AsyncImagePainter.State.Loading -> {
                                            state.copy(painter = painter)
                                        }
                                        is AsyncImagePainter.State.Error -> {
                                            state.copy(painter = painter)
                                        }

                                        else -> state
                                    }
                                }
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))


                    Column(modifier = Modifier.padding(horizontal = 26.dp)) {
                        Row(modifier = Modifier.fillMaxWidth()) {

                            Text(
                                text = artigo.titulo.capitalizeFirstLetter(),
                                modifier = Modifier.fillMaxWidth(),
                                fontSize = 22.sp,
                                fontWeight = FontWeight(900),
                                color = Color(182, 182, 246),
                                textAlign = TextAlign.Center
                            )
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Row(modifier = Modifier.fillMaxWidth()) {

                            Text(
                                text = artigo.descricao,
                                fontSize = 15.sp,
                                fontWeight = FontWeight(400),
//                        lineHeight = 16.sp
                            )

                        }
                    }
                }
            }

        }

    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun guiaMaternoPreview() {
//    guiaMaternoScreen()
//}