package br.senai.sp.jandira.tcc.gui.scheduleAdd

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleAdd() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Header(titulo = stringResource(id = R.string.schedule))
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)) {
                Text(
                        text = stringResource(id = R.string.tasks),
                        fontSize = 20.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                            .width(355.dp)
                            .border(
                                    width = 1.dp,
                                    color = Color(182, 182, 246),
                                    shape = RoundedCornerShape(20.dp)
                            ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
                    colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White,
                            focusedIndicatorColor = Color(243, 243, 243),
                            unfocusedIndicatorColor = Color(243, 243, 243)
                    ),
                    singleLine = true
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)) {
                Text(
                        text = stringResource(id = R.string.description),
                        fontSize = 20.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                            .width(355.dp)
                            .height(250.dp)
                            .border(
                                    width = 1.dp,
                                    color = Color(182, 182, 246),
                                    shape = RoundedCornerShape(20.dp)
                            ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
                    colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White,
                            focusedIndicatorColor = Color(243, 243, 243),
                            unfocusedIndicatorColor = Color(243, 243, 243)
                    ),
                    singleLine = true
            )
            Spacer(modifier = Modifier.height(5.dp))


            Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)) {
                Text(
                        text = stringResource(id = R.string.date),
                        fontSize = 20.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                            .width(355.dp)
                            .border(
                                    width = 1.dp,
                                    color = Color(182, 182, 246),
                                    shape = RoundedCornerShape(20.dp)
                            ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
                    colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White,
                            focusedIndicatorColor = Color(243, 243, 243),
                            unfocusedIndicatorColor = Color(243, 243, 243)
                    ),
                    singleLine = true
            )



        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScheduleAddPreview() {
    ScheduleAdd()
}