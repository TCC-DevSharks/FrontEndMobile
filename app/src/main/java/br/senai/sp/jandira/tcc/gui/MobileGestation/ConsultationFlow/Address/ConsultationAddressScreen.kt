package br.senai.sp.jandira.tcc.gui.MobileGestation.ConsultationFlow.Address

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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

@Composable
fun AddressScreen(navController: NavController) {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
//
        ) {

            var isChecked by remember { mutableStateOf(false) }

            //    ArrowLeftPurple(navController = navController, rota = "")

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 26.dp, top = 35.dp),
            ) {

                ArrowLeft(navController = navController, rota = "")

            }

            Row(modifier = Modifier.padding(horizontal = 50.dp, vertical = 2.dp)) {

                TextComp(
                    texto = R.string.title_address,
                    fontSize = 19.sp,
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

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
                    texto = R.string.text_field_altura,
                    meuType = KeyboardType.Number,
                    email = "",
                    onValueChange = { })
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
//                .padding(horizontal = 20.dp)
            ) {

                OutlinedTextFieldTodos(
                    texto = R.string.text_field_peso,
                    meuType = KeyboardType.Number,
                    email = "",
                    onValueChange = { })
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
                        checked = isChecked,
                        onCheckedChange = { isChecked = it },
                        colors = CheckboxDefaults.colors(
                            checkmarkColor = Color(182, 182, 246),
                            checkedColor = Color(182, 182, 246), // Cor quando marcado
                            uncheckedColor = Color(182, 182, 246) // Cor quando não marcado
                        )
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "Possui alguma comorbidade?",
                        fontSize = 15.sp,
                        fontWeight = FontWeight(600),
                        modifier = Modifier.padding(start = 13.dp)
                    )

                    Checkbox(
                        modifier = Modifier.height(30.dp),
                        checked = isChecked,
                        onCheckedChange = { isChecked = it },
                        colors = CheckboxDefaults.colors(
                            checkmarkColor = Color(182, 182, 246),
                            checkedColor = Color(182, 182, 246), // Cor quando marcado
                            uncheckedColor = Color(182, 182, 246) // Cor quando não marcado
                        )
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "Medicação em uso regular?",
                        fontSize = 15.sp,
                        fontWeight = FontWeight(600),
                        modifier = Modifier.padding(start = 13.dp)
                    )

                    Checkbox(
                        modifier = Modifier.height(30.dp),
                        checked = isChecked,
                        onCheckedChange = { isChecked = it },
                        colors = CheckboxDefaults.colors(
                            checkmarkColor = Color(182, 182, 246),
                            checkedColor = Color(182, 182, 246), // Cor quando marcado
                            uncheckedColor = Color(182, 182, 246) // Cor quando não marcado
                        )
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
//                .padding(horizontal = 20.dp)
                ) {

                    OutlinedTextFieldTodos(
                        texto = R.string.text_field_medication,
                        meuType = KeyboardType.Number,
                        email = "",
                        onValueChange = { })
                }
            }



            Spacer(modifier = Modifier.height(35.dp))


            Column() {


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
                        texto = R.string.text_field_cpf,
                        meuType = KeyboardType.Number,
                        email = "",
                        onValueChange = { })
                }


                Spacer(modifier = Modifier.height(25.dp))


                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick =
                        {

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

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun AddressScreenPreview() {
//    AddressScreen(navController)
//}