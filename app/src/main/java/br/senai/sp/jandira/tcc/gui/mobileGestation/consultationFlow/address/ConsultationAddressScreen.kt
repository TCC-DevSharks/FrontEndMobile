package br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.address

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.ArrowLeft
import br.senai.sp.jandira.tcc.componentes.Navigation
import br.senai.sp.jandira.tcc.componentes.OutlinedTextFieldTodos
import br.senai.sp.jandira.tcc.componentes.TextComp
import br.senai.sp.jandira.tcc.model.ModelPregnant

@Composable
fun AddressScreen(navController: NavController, pregnant: ModelPregnant) {

    var isCheckedAlergy by remember { mutableStateOf(false) }
    var isCheckedComorbid by remember { mutableStateOf(false) }
    var isCheckedMedic by remember { mutableStateOf(false) }

    var altura by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var cpf by remember { mutableStateOf("") }
    var alergia by remember { mutableStateOf("") }
    var comorbidade by remember { mutableStateOf("") }
    var medicacao by remember { mutableStateOf("") }

    LaunchedEffect(Unit){
        altura = pregnant.altura.toString()
        peso = pregnant.peso.toString()
        cpf = pregnant.cpf
        comorbidade = pregnant.comorbidades
        alergia = pregnant.alergia
        medicacao = pregnant.medicacao
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 26.dp, top = 35.dp),
            ) {

                ArrowLeft(navController = navController, rota = "homeUser")

            }

            Row(modifier = Modifier.padding(horizontal = 50.dp, vertical = 2.dp)) {
                TextComp(
                    texto = R.string.title_address,
                    fontSize = 19.sp
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Column (modifier = Modifier
                .verticalScroll(rememberScrollState())) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 32.dp)
                ) {

                    Text(
                        text = stringResource(id = R.string.personal_information),
                        fontSize = 16.sp,
                        color = Color(182, 182, 246),
                        fontWeight = FontWeight(900)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
//                .padding(horizontal = 20.dp)
                ) {

                    OutlinedTextFieldTodos(
                        texto = stringResource(id = R.string.text_field_altura),
                        meuType = KeyboardType.Number,
                        value = altura,
                        onValueChange = {altura = it })
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
//                .padding(horizontal = 20.dp)
                ) {

                    OutlinedTextFieldTodos(
                        texto = stringResource(id = R.string.text_field_peso),
                        meuType = KeyboardType.Number,
                        value = peso,
                        onValueChange = {peso = it })
                }

                Spacer(modifier = Modifier.height(35.dp))

                Column() {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = "Possui alguma alergia?",
                            fontSize = 15.sp,
                            fontWeight = FontWeight(600),
                            modifier = Modifier.padding(start = 13.dp)
                        )

                        Checkbox(
                            modifier = Modifier.height(30.dp),
                            checked = isCheckedAlergy,
                            onCheckedChange = { isCheckedAlergy = it },
                            colors = CheckboxDefaults.colors(
                                checkmarkColor = Color(182, 182, 246),
                                checkedColor = Color(182, 182, 246), // Cor quando marcado
                                uncheckedColor = Color(182, 182, 246) // Cor quando não marcado
                            )
                        )
                    }

                    AnimatedVisibility(
                        visible = isCheckedAlergy,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, bottom = 10.dp),
                        enter = fadeIn(
                            initialAlpha = 0.4f
                        ),
                        exit = fadeOut(
                            animationSpec = tween(durationMillis = 250)
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                        ) {

                            OutlinedTextFieldTodos(
                                texto = stringResource(id = R.string.text_field_medication),
                                meuType = KeyboardType.Text,
                                value = alergia,
                                onValueChange = { alergia = it})
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = stringResource(id = R.string.comorbidity),
                            fontSize = 15.sp,
                            fontWeight = FontWeight(600),
                            modifier = Modifier.padding(start = 13.dp)
                        )

                        Checkbox(
                            modifier = Modifier.height(30.dp),
                            checked = isCheckedComorbid,
                            onCheckedChange = { isCheckedComorbid = it },
                            colors = CheckboxDefaults.colors(
                                checkmarkColor = Color(182, 182, 246),
                                checkedColor = Color(182, 182, 246), // Cor quando marcado
                                uncheckedColor = Color(182, 182, 246) // Cor quando não marcado
                            )
                        )
                    }

                    AnimatedVisibility(
                        visible = isCheckedComorbid,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, bottom = 10.dp),
                        enter = fadeIn(
                            initialAlpha = 0.4f
                        ),
                        exit = fadeOut(
                            animationSpec = tween(durationMillis = 250)
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                        ) {

                            OutlinedTextFieldTodos(
                                texto = stringResource(id = R.string.text_field_medication),
                                meuType = KeyboardType.Text,
                                value = comorbidade,
                                onValueChange = {comorbidade = it })
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = stringResource(id = R.string.regular_medication),
                            fontSize = 15.sp,
                            fontWeight = FontWeight(600),
                            modifier = Modifier.padding(start = 13.dp)
                        )

                        Checkbox(
                            modifier = Modifier.height(30.dp),
                            checked = isCheckedMedic,
                            onCheckedChange = { isCheckedMedic = it },
                            colors = CheckboxDefaults.colors(
                                checkmarkColor = Color(182, 182, 246),
                                checkedColor = Color(182, 182, 246), // Cor quando marcado
                                uncheckedColor = Color(182, 182, 246) // Cor quando não marcado
                            )
                        )
                    }

                    AnimatedVisibility(
                        visible = isCheckedMedic,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        enter = fadeIn(
                            initialAlpha = 0.4f
                        ),
                        exit = fadeOut(
                            animationSpec = tween(durationMillis = 250)
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                        ) {

                            OutlinedTextFieldTodos(
                                texto = stringResource(id = R.string.text_field_medication),
                                meuType = KeyboardType.Text,
                                value = medicacao,
                                onValueChange = { medicacao = it})
                        }
                    }
                }



                Spacer(modifier = Modifier.height(35.dp))


                Column () {


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 32.dp)
                    ) {

                        Text(
                            text = stringResource(id = R.string.document),
                            fontSize = 16.sp,
                            color = Color(182, 182, 246),
                            fontWeight = FontWeight(900)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
//                .padding(horizontal = 20.dp)
                    ) {

                        OutlinedTextFieldTodos(
                            texto = stringResource(id = R.string.text_field_cpf),
                            meuType = KeyboardType.Number,
                            value = cpf,
                            onValueChange = {cpf = it })
                    }


                    Spacer(modifier = Modifier.height(25.dp))


                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 80.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(
                            onClick =
                            {


                                if (cpf.isNotEmpty() && peso.isNotEmpty() && altura.isNotEmpty()){
                                    pregnant.altura = altura.toDouble()
                                    pregnant.peso = peso.toDouble()
                                    pregnant.cpf = cpf
                                    pregnant.alergia = alergia
                                    pregnant.comorbidades = comorbidade
                                    pregnant.medicacao = medicacao

                                    navController.navigate("consultationEndress")
                                }
                            },
                            modifier = Modifier
                                .width(200.dp)
                                .height(48.dp),
                            colors = ButtonDefaults.buttonColors(Color(182, 182, 246)),

                            shape = RoundedCornerShape(16.dp),

                            ) {
                            Text(
                                text = stringResource(R.string.button_next),
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                        }
                    }

                }
            }
        }
    }


}

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun AddressScreenPreview() {
//    AddressScreen(navController)
//}