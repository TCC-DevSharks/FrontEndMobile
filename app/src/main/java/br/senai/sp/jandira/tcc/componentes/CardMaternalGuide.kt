package br.senai.sp.jandira.tcc.componentes

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.article.articleList
import br.senai.sp.jandira.tcc.model.article.articleResponse
import br.senai.sp.jandira.tcc.model.timeLine.timeLineResonse
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun MarternalGuide(
    //textTitle: String
    //textDescription: String
    navController: NavController,
    imagem: String,
    descricao: String,
    titulo: String,
    idArtigo: Int,
    pregnant: ModelPregnant,
    onclick : () -> Unit
) {


    Column(modifier = Modifier.padding(start = 16.dp))
    {

//        pregnant.artigo = idArtigo

        Card(
                modifier = Modifier
                    .size(250.dp, 215.dp)
                    .clickable(onClick = onclick),
                colors = CardDefaults.cardColors(Color(182, 182, 246, 23)),
                border = BorderStroke(.3.dp, Color(182, 182, 246))

            ) {

                Column(modifier = Modifier.size(250.dp, 115.dp)) {

                    AsyncImage(
                        model = imagem,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )


                }
                Spacer(modifier = Modifier.height(5.dp))

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 7.dp)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 15.5.dp)
                    ) {

                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = titulo,
                            color = Color(182, 182, 246),
                            fontSize = 13.9.sp,
                            fontWeight = FontWeight(900),
                            lineHeight = 15.5.sp, // Ajuste a altura das linhas conforme necessário

                        )

                    }

                    Spacer(modifier = Modifier.height(7.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 15.5.dp)
                    ) {

                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = descricao,
                            fontSize = 10.sp,
                            color = Color(102, 97, 97),
                            fontWeight = FontWeight(300),
                            lineHeight = 12.sp, // Ajuste a altura das linhas conforme necessário
                        )

                    }

                }

            }
        }
    }

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun MarternalGuidePreview() {
//
//    MarternalGuide()
//}