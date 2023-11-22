package br.senai.sp.jandira.tcc.gui.mobileDoctor.flowNutrition.selectDiet

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.model.professional.Professional

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectDiet(professional: Professional, navController: NavController) {

    data class Itens(val nome: String, val navegacao: String)

    val opcoes = listOf(
        Itens("Pacientes","nutritionSelect"),
        Itens("Refeições Padrões","mealSelect")
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Header(titulo = "Selecione",rota ="", navController = navController)
        }
        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))

            LazyColumn(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                items(opcoes)      {
                    Card(
                        modifier = Modifier
                            .width(340.dp)
                            .height(85.dp)
                            .padding(bottom = 14.dp)
                            .clickable {
                                navController.navigate(it.navegacao)
                            },
                        colors = CardDefaults.cardColors(Color(182, 182, 246, 100)),
                        border = BorderStroke(width = 1.dp, color = Color(182, 182, 246)),

                        shape = RoundedCornerShape(16.dp),
                    ) {
                        Row(
                            Modifier
                                .fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                                Text(
                                    text = it.nome,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Black,
                                    fontSize = 20.sp,
                                )
                        }
                    }
                }
            }


        }
    }
}
