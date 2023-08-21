package br.senai.sp.jandira.tcc.GestationWeek

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.ArrowLeftPurple
import br.senai.sp.jandira.tcc.componentes.ButtonPurple
import br.senai.sp.jandira.tcc.componentes.TextDescription
import br.senai.sp.jandira.tcc.componentes.TextTitulo
import br.senai.sp.jandira.tcc.model.week


@Composable
fun ItemView(index: Int, selected: Boolean, onClick: (Int) -> Unit){
    Text(
        text = "$index semana",
        modifier = Modifier
            .clickable {
                onClick.invoke(index)
            }
            .fillMaxWidth()
            .padding(12.dp),
        textAlign = TextAlign.Center,
        color = if (selected) Color(182,182,246) else Color.Black,
        fontSize =  if (selected) 25.sp  else 20.sp,
    )
}

@Composable
fun LazyColumnWithSelection(){
    var selectedIndex by remember { mutableStateOf(0) }
    val onItemClick = { index: Int -> selectedIndex = index}
    LazyColumn(
        modifier = Modifier.height(308.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center


    ){
        items(40){ index ->
            ItemView(
                index = index,
                selected = selectedIndex == index,
                onClick = onItemClick,
            )
        }
    }
}
@Composable
fun GestationWeekScreen(weeks : List<week>, navController: NavController) {

    Column (modifier = Modifier.fillMaxSize()) {



        Column {

            ArrowLeftPurple(navController = navController, rota = "register")

            TextTitulo(texto = R.string.title_week)
            
            TextDescription(texto = R.string.description_week)

            Spacer(modifier = Modifier.height(55.dp))

        }

        LazyColumnWithSelection()

        Spacer(modifier = Modifier.height(60.dp))


        ButtonPurple(navController = navController, texto = R.string.button_next, rota = "home")

    }



}




//@Preview (showSystemUi = true, showBackground = true)
//@Composable
//fun GestationWeekPreview() {
//    GestationWeekScreen()
//}