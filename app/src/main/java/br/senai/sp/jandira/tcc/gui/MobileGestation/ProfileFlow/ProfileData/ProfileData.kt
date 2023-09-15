package br.senai.sp.jandira.tcc.gui.MobileGestation.ProfileFlow.ProfileData

import androidx.compose.foundation.background
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
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileData() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Header(titulo = stringResource(id = R.string.header_date))

        Spacer(modifier = Modifier.height(5.dp))
        Row() {

            Text(
                text = stringResource(id = R.string.people_date),
                fontSize = 15.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.padding(start = 20.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Row {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier
                            .width(180.dp)
                            .height(60.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(id = R.string.example_name),
                                fontSize = 15.sp,
                                color = Color.Black, // Defina a cor do texto como preta
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(148, 112, 214),
                                unfocusedBorderColor = Color(182, 182, 246)
                            ),
                        singleLine = true,

                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.editor_outlined),
                                contentDescription = "",
                                tint = Color(182, 182, 246)
                            )

                        }
                    )
                }

                var cpf by remember {
                    mutableStateOf("")
                }
                Row {
                    OutlinedTextField(
                        value = cpf,
                        onValueChange = { newCpf ->
                            cpf = newCpf.filter { it.isDigit() }.take(11)
                        },
                        modifier = Modifier
                            .width(180.dp)
                            .height(60.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(id = R.string.example_cpf),
                                fontSize = 15.sp,
                                color = Color.Black,
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(148, 112, 214),
                                unfocusedBorderColor = Color(182, 182, 246)
                            ),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Done,
                            keyboardType = KeyboardType.Number,
                        ),
                        singleLine = true,
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.editor_outlined),
                                contentDescription = "",
                                tint = Color(182, 182, 246)
                            )

                        },
                        visualTransformation = VisualTransformation.None
                    )

                }

            }
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Row {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier
                            .width(370.dp)
                            .height(60.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(id = R.string.date_of_birth),
                                fontSize = 15.sp,
                                color = Color.Black, // Defina a cor do texto como preta
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(148, 112, 214),
                                unfocusedBorderColor = Color(182, 182, 246)
                            ),
                        singleLine = true,

                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.editor_outlined),
                                contentDescription = "",
                                tint = Color(182, 182, 246)
                            )

                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            var email by remember {
                mutableStateOf("")
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Row {
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        modifier = Modifier
                            .width(370.dp)
                            .height(60.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(id = R.string.email),
                                fontSize = 15.sp,
                                color = Color.Black, // Defina a cor do texto como preta
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(148, 112, 214),
                                unfocusedBorderColor = Color(182, 182, 246)
                            ),
                        singleLine = true,

                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.editor_outlined),
                                contentDescription = "",
                                tint = Color(182, 182, 246)
                            )

                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Row {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier
                            .width(180.dp)
                            .height(60.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(id = R.string.date_childbirth),
                                fontSize = 15.sp,
                                color = Color.Black, // Defina a cor do texto como preta
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(148, 112, 214),
                                unfocusedBorderColor = Color(182, 182, 246)
                            ),
                        singleLine = true,

                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.editor_outlined),
                                contentDescription = "",
                                tint = Color(182, 182, 246)
                            )

                        }
                    )
                }


                Row {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier
                            .width(180.dp)
                            .height(60.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(id = R.string.gestation_week),
                                fontSize = 15.sp,
                                color = Color.Black,
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(148, 112, 214),
                                unfocusedBorderColor = Color(182, 182, 246)
                            ),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Done,
                            keyboardType = KeyboardType.Number,
                        ),
                        singleLine = true,
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.editor_outlined),
                                contentDescription = "",
                                tint = Color(182, 182, 246)
                            )

                        },
                        visualTransformation = VisualTransformation.None
                    )

                }

            }

            Spacer(modifier = Modifier.height(10.dp))
            Row() {
                Text(
                    text = stringResource(id = R.string.address),
                    fontSize = 15.sp,
                    fontFamily = FontFamily.SansSerif,
                    modifier = Modifier.padding(start = 20.dp)
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Row {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier
                            .width(180.dp)
                            .height(60.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(id = R.string.example_street),
                                fontSize = 15.sp,
                                color = Color.Black, // Defina a cor do texto como preta
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(148, 112, 214),
                                unfocusedBorderColor = Color(182, 182, 246)
                            ),
                        singleLine = true,

                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.editor_outlined),
                                contentDescription = "",
                                tint = Color(182, 182, 246)
                            )

                        }
                    )
                }


                Row {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier
                            .width(180.dp)
                            .height(60.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(id = R.string.numberrr),
                                fontSize = 15.sp,
                                color = Color.Black,
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(148, 112, 214),
                                unfocusedBorderColor = Color(182, 182, 246)
                            ),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Done,
                            keyboardType = KeyboardType.Number,
                        ),
                        singleLine = true,
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.editor_outlined),
                                contentDescription = "",
                                tint = Color(182, 182, 246)
                            )

                        },
                        visualTransformation = VisualTransformation.None
                    )

                }
            }

            Spacer(modifier = Modifier.height(10.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Row {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier
                            .width(370.dp)
                            .height(60.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(id = R.string.date_of_birth),
                                fontSize = 15.sp,
                                color = Color.Black, // Defina a cor do texto como preta
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(148, 112, 214),
                                unfocusedBorderColor = Color(182, 182, 246)
                            ),
                        singleLine = true,

                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.editor_outlined),
                                contentDescription = "",
                                tint = Color(182, 182, 246)
                            )

                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Row {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier
                            .width(370.dp)
                            .height(60.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(id = R.string.date_of_birth),
                                fontSize = 15.sp,
                                color = Color.Black, // Defina a cor do texto como preta
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(148, 112, 214),
                                unfocusedBorderColor = Color(182, 182, 246)
                            ),
                        singleLine = true,

                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.editor_outlined),
                                contentDescription = "",
                                tint = Color(182, 182, 246)
                            )

                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Row {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier
                            .width(370.dp)
                            .height(60.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(id = R.string.date_of_birth),
                                fontSize = 15.sp,
                                color = Color.Black, // Defina a cor do texto como preta
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(148, 112, 214),
                                unfocusedBorderColor = Color(182, 182, 246)
                            ),
                        singleLine = true,

                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.editor_outlined),
                                contentDescription = "",
                                tint = Color(182, 182, 246)
                            )

                        }
                    )
                }
            }

        }


    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ProfileDatePreview() {
    ProfileData()
}