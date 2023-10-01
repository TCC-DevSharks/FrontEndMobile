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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.nameSuggestion.NameSuggestionFavorite.NameFavoriteList
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import retrofit2.Response

@Composable
fun CardNameSuggestion(
    viewModel: ModelPregnant,
    nome: String,
    idNome: Int,
    idGestante: Int,
    onclick: () -> Unit,
    sexo: String,
    initialCheck: Boolean
) {

    val check = remember { mutableStateOf(initialCheck) }

    var imageResource = if (check.value)
                            R.drawable.heart
                        else
                            R.drawable.coracao_cinza
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
                    Image(
                        painter = painterResource(id = imageResource),
                        contentDescription = null,
                        modifier = Modifier
                            .size(27.dp)
                            .clickable(onClick = onclick)
                    )
                }
            }
        }
    }
}


