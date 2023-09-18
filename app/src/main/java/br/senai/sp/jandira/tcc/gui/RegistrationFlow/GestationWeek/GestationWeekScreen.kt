<<<<<<<< HEAD:app/src/main/java/br/senai/sp/jandira/tcc/gui/mobileGestation/registrationFlow/gestationWeek/GestationWeekScreen.kt
package br.senai.sp.jandira.tcc.gui.mobileGestation.registrationFlow.gestationWeek
========
package br.senai.sp.jandira.tcc.gui.RegistrationFlow.GestationWeek
>>>>>>>> main:app/src/main/java/br/senai/sp/jandira/tcc/gui/RegistrationFlow/GestationWeek/GestationWeekScreen.kt

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.ArrowLeft
import br.senai.sp.jandira.tcc.componentes.ButtonPurple
import br.senai.sp.jandira.tcc.componentes.TextDescription
import br.senai.sp.jandira.tcc.componentes.TextComp
import br.senai.sp.jandira.tcc.model.ModelRegister


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
        fontSize =  if (selected) 28.sp  else 22.sp,
    )
}

@Composable
fun LazyColumnWithSelection(viewModel: ModelRegister){
    var selectedIndex by remember { mutableStateOf(0) }

    val onItemClick = { index: Int -> selectedIndex = index}

    viewModel.semana_gestacao = selectedIndex

    LazyColumn(
        modifier = Modifier.height(308.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        items(40){ index ->
            ItemView(
                index = index + 1,
                selected = selectedIndex == index + 1,
                onClick = onItemClick,
            )
        }

    }
}

@Composable
fun GestationWeekScreen(navController: NavController, viewModel: ModelRegister) {



    Column (modifier = Modifier.fillMaxSize()) {



        Column {

            Row (modifier = Modifier.padding(start = 26.dp, top = 35.dp)) {
                ArrowLeft(navController = navController, rota = "register")

            }

            TextComp(texto = R.string.title_week)
            
            TextDescription(texto = R.string.description_week)

            Spacer(modifier = Modifier.height(55.dp))

        }

        LazyColumnWithSelection(viewModel)

        Spacer(modifier = Modifier.height(60.dp))



        ButtonPurple(navController = navController, texto = stringResource(id = R.string.button_next), rota = "calendar", onclick = {

            if (viewModel.semana_gestacao != 0){
                navController.navigate("calendar")
            }else{
                Log.i("erro","Selecione uma semana")
            }
        })

    }



}




//@Preview (showSystemUi = true, showBackground = true)
//@Composable
//fun GestationWeekPreview() {
//    GestationWeekScreen()
//}