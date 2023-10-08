package br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.payment

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.ButtonPurple
import br.senai.sp.jandira.tcc.componentes.OutlinedTextFieldTodos
import br.senai.sp.jandira.tcc.componentes.TextComp
import br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.doctor.DataHora
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.clinic.Clinic
import br.senai.sp.jandira.tcc.model.consult.ConsultResponse
import br.senai.sp.jandira.tcc.model.payment.PaymentResponse
import br.senai.sp.jandira.tcc.model.professional.Professional
import br.senai.sp.jandira.tcc.model.schedule.ScheduleResponse
import br.senai.sp.jandira.tcc.model.viaCep.ViaCep
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import br.senai.sp.jandira.tcc.service.RetrofitFactoryCep
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(
    navController: NavController,
    viewModel: ModelPregnant,
    professional: Professional,
    clinic: Clinic
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        var nome by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var cpf by remember { mutableStateOf("") }
        var telefone by remember { mutableStateOf("") }
        var complemento by remember { mutableStateOf("") }
        var logradouro by remember { mutableStateOf("") }
        var numero by remember { mutableStateOf("") }
        var bairro by remember { mutableStateOf("") }
        var cidade by remember { mutableStateOf("") }
        var estado by remember { mutableStateOf("") }
        var cep by remember { mutableStateOf("") }
        var numeroCartao by remember { mutableStateOf("") }
        var mesVencimento by remember { mutableStateOf("") }
        var anoVencimento by remember { mutableStateOf("") }
        var cvv by remember { mutableStateOf("") }

        var visible by remember { mutableStateOf(false) }
        var visibleCard by remember { mutableStateOf(true) }
        var visiblePayment by remember { mutableStateOf(true) }

        LaunchedEffect(Unit) {
            val call = RetrofitFactoryCep().getCep().getCep(viewModel.cep)

            call.enqueue(object : retrofit2.Callback<ViaCep> {
                override fun onResponse(
                    call: Call<ViaCep>,
                    response: Response<ViaCep>

                ) {

                    println(response)

                    if (response.code() == 200) {
                        viewModel.bairro = response.body()!!.bairro
                        viewModel.cidade = response.body()!!.localidade
                        viewModel.logradouro = response.body()!!.logradouro
                        estado = response.body()!!.uf
                    }


                }

                override fun onFailure(call: Call<ViaCep>, t: Throwable) {
                    Log.i(
                        "ds2m",
                        "onFailure: ${t.message}"
                    )
                    println(t.message + t.cause)
                }
            })
            nome = viewModel.nome
            email = viewModel.email
            cpf = viewModel.cpf
            telefone = viewModel.telefone
            complemento = viewModel.complemento
            cep = viewModel.cep
            logradouro = viewModel.logradouro
            numero = viewModel.numero
            bairro = viewModel.bairro
            cidade = viewModel.cidade
            estado = viewModel.estado
            numeroCartao = "4111111111111111"
            mesVencimento = "12"
            anoVencimento = "2026"
            cvv = "123"

        }

        Row(modifier = Modifier.padding(start = 26.dp, top = 35.dp)) {
            Image(painter = painterResource(id = R.drawable.arrow_circle),
                contentDescription = null,
                Modifier
                    .clickable {
                    }
                    .size(40.dp)
            )
        }

        Row(modifier = Modifier.padding(horizontal = 50.dp, vertical = 2.dp)) {
            TextComp(
                texto = R.string.pagseguro,
                fontSize = 19.sp
            )
        }

        AnimatedVisibility(
            visible = visible,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(bottom = 20.dp),
            enter = fadeIn(
                initialAlpha = 0.4f
            ),
            exit = fadeOut(
                animationSpec = tween(durationMillis = 250)
            )
        ) {

            Scaffold(modifier = Modifier.background(Color.White), bottomBar = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = {
                            visibleCard = false
                            visible = false
                            visiblePayment = true
                        },
                        modifier = Modifier
                            .width(250.dp)
                    ) {

                        Text(
                            text = "Revisar ->",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                }

            }) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 20.dp, bottom = 15.dp)
                        .verticalScroll(rememberScrollState())
                        .background(Color.White)
                ) {

                    OutlinedTextFieldTodos(
                        texto = R.string.example_name,
                        meuType = KeyboardType.Text,
                        value = nome,
                        onValueChange = { nome = it },
                        shape = RoundedCornerShape(5.dp)
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    OutlinedTextFieldTodos(
                        texto = R.string.email,
                        meuType = KeyboardType.Text,
                        value = email,
                        onValueChange = { email = it },
                        shape = RoundedCornerShape(5.dp)
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    OutlinedTextFieldTodos(
                        texto = R.string.text_field_cpf,
                        meuType = KeyboardType.Text,
                        value = cpf,
                        shape = RoundedCornerShape(5.dp),
                        onValueChange = { cpf = it })

                    Spacer(modifier = Modifier.height(5.dp))

                    OutlinedTextFieldTodos(
                        texto = R.string.text_field_telefone,
                        meuType = KeyboardType.Text,
                        value = telefone,
                        shape = RoundedCornerShape(5.dp),
                        onValueChange = { telefone = it })

                    Spacer(modifier = Modifier.height(5.dp))

                    OutlinedTextFieldTodos(
                        texto = R.string.example_cep,
                        meuType = KeyboardType.Text,
                        value = cep,
                        shape = RoundedCornerShape(5.dp),
                        onValueChange = { cep == it })

                    Spacer(modifier = Modifier.height(5.dp))

                    OutlinedTextFieldTodos(
                        texto = R.string.text_field_rua,
                        meuType = KeyboardType.Text,
                        value = logradouro,
                        shape = RoundedCornerShape(5.dp),
                        onValueChange = { logradouro = it })

                    Spacer(modifier = Modifier.height(5.dp))

                    OutlinedTextFieldTodos(
                        texto = R.string.text_field_numero,
                        meuType = KeyboardType.Text,
                        value = numero,
                        shape = RoundedCornerShape(5.dp),
                        onValueChange = { numero = it })

                    Spacer(modifier = Modifier.height(5.dp))

                    OutlinedTextFieldTodos(
                        texto = R.string.example_complement,
                        meuType = KeyboardType.Text,
                        value = complemento,
                        shape = RoundedCornerShape(5.dp),
                        onValueChange = { complemento = it })

                    Spacer(modifier = Modifier.height(5.dp))

                    OutlinedTextFieldTodos(
                        texto = R.string.text_field_bairro,
                        meuType = KeyboardType.Text,
                        value = bairro,
                        shape = RoundedCornerShape(5.dp),
                        onValueChange = { bairro = it }
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    OutlinedTextFieldTodos(
                        texto = R.string.text_field_cidade,
                        meuType = KeyboardType.Text,
                        value = cidade,
                        shape = RoundedCornerShape(5.dp),
                        onValueChange = { cidade == it }
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    OutlinedTextFieldTodos(
                        texto = R.string.text_field_state,
                        meuType = KeyboardType.Text,
                        value = estado,
                        shape = RoundedCornerShape(5.dp),
                        onValueChange = { estado == it }
                    )

                    Spacer(modifier = Modifier.height(50.dp))


                }
            }
        }

        AnimatedVisibility(
            visible = visibleCard,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(bottom = 20.dp),
            enter = fadeIn(
                initialAlpha = 0.4f
            ),
            exit = fadeOut(
                animationSpec = tween(durationMillis = 250)
            )
        ) {

            val meses = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12")
            var expanded by remember { mutableStateOf(false) }
            var selectedOption by remember { mutableStateOf(meses[0]) }

            val years = listOf(
                "${LocalDate.now().year}",
                "${LocalDate.now().year + 1}",
                "${LocalDate.now().year + 2}",
                "${LocalDate.now().year + 3}",
                "${LocalDate.now().year + 4}",
            )
            var expandedYears by remember { mutableStateOf(false) }
            var selectedOptionYears by remember { mutableStateOf(years[0]) }

            Scaffold(modifier = Modifier.background(Color.White), bottomBar = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = {
                            visibleCard = false
                            visible = true
                        },
                        modifier = Modifier
                            .width(250.dp)
                    ) {

                        Text(
                            text = "Continuar ->",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                }

            }) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp)
                ) {

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(text = "Número do cartão:")

                        OutlinedTextField(
                            value = numeroCartao,
                            onValueChange =
                            { numeroCartao = it },
                            modifier = Modifier.padding(start = 15.dp, top = 5.dp, bottom = 5.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.White,
                            )
                        )

                        Text(text = "Data de validade:")

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(modifier = Modifier.padding(start = 15.dp)) {
                                Text(
                                    text = mesVencimento,
                                    modifier = Modifier
                                        .width(100.dp)
                                        .clickable(onClick = { expanded = true })
                                        .background(Color.White)
                                        .border(BorderStroke(1.dp, Color.Black))
                                        .padding(16.dp)
                                )
                                DropdownMenu(
                                    expanded = expanded,
                                    onDismissRequest = { expanded = false },
                                ) {
                                    meses.forEach { option ->
                                        DropdownMenuItem(
                                            text = {
                                                Text(text = option)
                                            },
                                            onClick = {
                                                mesVencimento = option
                                                expanded = false
                                            })
                                    }
                                }
                            }

                            Text(
                                text = "/",
                                modifier = Modifier.padding(start = 15.dp, end = 15.dp),
                                fontSize = 20.sp
                            )

                            Box() {
                                Text(
                                    text = anoVencimento,
                                    modifier = Modifier
                                        .width(100.dp)
                                        .clickable(onClick = { expandedYears = true })
                                        .background(Color.White)
                                        .border(BorderStroke(1.dp, Color.Black))
                                        .padding(16.dp)
                                )
                                DropdownMenu(
                                    expanded = expandedYears,
                                    onDismissRequest = { expandedYears = false },
                                ) {
                                    years.forEach { option ->
                                        DropdownMenuItem(
                                            text = {
                                                Text(text = option)
                                            },
                                            onClick = {
                                                anoVencimento = option
                                                expandedYears = false
                                            })
                                    }
                                }
                            }

                        }
                    }

                    Text(text = "CVV")

                    OutlinedTextField(
                        value = cvv,
                        onValueChange =
                        { cvv = it },
                        modifier = Modifier
                            .padding(start = 15.dp, top = 5.dp, bottom = 5.dp)
                            .width(100.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White,
                        )
                    )

                }
            }

        }
        AnimatedVisibility(
            visible = visiblePayment,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(bottom = 20.dp),
            enter = fadeIn(
                initialAlpha = 0.4f
            ),
            exit = fadeOut(
                animationSpec = tween(durationMillis = 250)
            )
        ) {
            Scaffold(bottomBar = {
                ButtonPurple(
                    navController = navController,
                    texto = "Finalizar",
                    rota = "",
                    onclick = {
                        val ddd = viewModel.telefone.substring(1, 3)
                        var numerousCert = viewModel.telefone.substring(4)
                        numerousCert = numerousCert.replace("-", "")
                        numerousCert = numerousCert.replace(" ", "")

                        var valor = professional.valor
                        valor = valor.replace(",", "")

                        var payment = PaymentResponse(
                            nome = viewModel.nome,
                            email = viewModel.email,
                            cpf = viewModel.cpf,
                            telefone = numerousCert,
                            cep = viewModel.cep,
                            complemento = if (viewModel.complemento == "") "''" else viewModel.complemento,
                            numero = viewModel.numero,
                            logradouro = logradouro,
                            bairro = bairro,
                            cidade = cidade,
                            estado = estado,
                            pais = "BRA",
                            tipoCartao = "CREDIT_CARD",
                            numeroCartao = numeroCartao,
                            mesVencimento = mesVencimento,
                            anoVencimento = anoVencimento,
                            cdd = cvv,
                            id_gestante = viewModel.id,
                            id_clinica = clinic.id,
                            dddPais = "55",
                            ddd = ddd,
                            descricaoCobranca = "Cobrança de uma consulta",
                            nomeItem = "Consulta com ${professional.especialidade}",
                            quantidadeItem = 1,
                            referenciaCobranca = "${LocalDate.now()}",
                            valorUnitarioItem = valor
                        )

                        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                        var consult = ConsultResponse(
                            dia = "${LocalDate.parse(DataHora.selectedDate, formatter) }",
                            hora = DataHora.selectedTime + ":00",
                            id_gestante = viewModel.id,
                            id_profissional = professional.id
                        )

                        var schedule = ScheduleResponse(
                            dia = "${LocalDate.parse(DataHora.selectedDate, formatter) }",
                            titulo = "${professional.especialidade}",
                            lembrete = 0,
                            descricao = "Consulta na ${clinic.razao_social}",
                            id_gestante = viewModel.id
                        )

                        var call = RetrofitFactory().insertPayment().insertPayment(payment)

                        call.enqueue(object : retrofit2.Callback<ResponseBody> {
                            override fun onResponse(
                                call: Call<ResponseBody>,
                                response: Response<ResponseBody>

                            ) {
                               if (response.isSuccessful){

                                   var call = RetrofitFactory().insertConsult().insertConsult(consult)

                                   call.enqueue(object : retrofit2.Callback<ResponseBody> {
                                       override fun onResponse(
                                           call: Call<ResponseBody>,
                                           response: Response<ResponseBody>

                                       ) {
                                           if (response.isSuccessful){
                                               var call = RetrofitFactory().insertSchedule().postSchedule(schedule)

                                               call.enqueue(object : retrofit2.Callback<ResponseBody> {
                                                   override fun onResponse(
                                                       call: Call<ResponseBody>,
                                                       response: Response<ResponseBody>

                                                   ) {
                                                       if (response.isSuccessful){
                                                           navController.navigate("ConsultFinish")
                                                       }
                                                   }

                                                   override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                                                       Log.i(
                                                           "ds2m",
                                                           "onFailure: ${t.message}"
                                                       )
                                                       println(t.message + t.cause)
                                                   }
                                               })
                                           }
                                       }

                                       override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                                           Log.i(
                                               "ds2m",
                                               "onFailure: ${t.message}"
                                           )
                                           println(t.message + t.cause)
                                       }
                                   })
                               }
                            }

                            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                                Log.i(
                                    "ds2m",
                                    "onFailure: ${t.message}"
                                )
                                println(t.message + t.cause)
                            }
                        })

                    })
            }) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 15.dp)
                ) {

                    Text(
                        text = "Cliente: ",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Column(modifier = Modifier.padding(start = 15.dp, top = 10.dp)) {
                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Nome: ",
                                fontSize = 17.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Black,
                                lineHeight = 18.sp
                            )

                            Text(
                                text = viewModel.nome,
                                fontSize = 15.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                lineHeight = 18.sp
                            )

                        }

                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Email: ",
                                fontSize = 17.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Black,
                                lineHeight = 18.sp
                            )

                            Text(
                                text = viewModel.email,
                                fontSize = 15.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                lineHeight = 18.sp
                            )

                        }

                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Cpf: ",
                                fontSize = 17.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Black,
                                lineHeight = 18.sp
                            )

                            Text(
                                text = viewModel.cpf,
                                fontSize = 15.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                lineHeight = 18.sp
                            )
                        }

                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Telefone: ",
                                fontSize = 17.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Black,
                                lineHeight = 18.sp
                            )

                            Text(
                                text = viewModel.telefone,
                                fontSize = 15.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                lineHeight = 18.sp
                            )
                        }

                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = buildAnnotatedString {
                                    withStyle(
                                        style = SpanStyle(
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 17.sp
                                        )
                                    ) {
                                        append("Endereço: ")
                                    }
                                    append(viewModel.logradouro + ", " + viewModel.numero + ", " + viewModel.bairro + ", " + viewModel.cidade + ", " + viewModel.estado + ", Brasil")
                                },
                                fontSize = 15.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Start,
                                lineHeight = 20.sp
                            )
                        }
                    }

                    Text(
                        text = "Cartão: ",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Column(modifier = Modifier.padding(start = 15.dp, top = 10.dp)) {


                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Número do cartão: ",
                                fontSize = 17.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Black,
                                lineHeight = 18.sp
                            )

                            Text(
                                text = numeroCartao,
                                fontSize = 15.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                lineHeight = 18.sp
                            )
                        }

                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Vencimento: ",
                                fontSize = 17.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Black,
                                lineHeight = 18.sp
                            )

                            Text(
                                text = "${mesVencimento}/${anoVencimento}",
                                fontSize = 15.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                lineHeight = 18.sp
                            )
                        }
                    }

                    Text(
                        text = "Consulta: ",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Column(modifier = Modifier.padding(start = 15.dp, top = 10.dp)) {
                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Clínica: ",
                                fontSize = 17.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Black,
                                lineHeight = 18.sp
                            )

                            Text(
                                text = professional.clinica,
                                fontSize = 15.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                lineHeight = 18.sp
                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = buildAnnotatedString {
                                    withStyle(
                                        style = SpanStyle(
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 17.sp
                                        )
                                    ) {
                                        append("Endereço: ")
                                    }
                                    append(clinic.logradouro + ", " + clinic.numero + ", " + clinic.bairro + ", " + clinic.cidade + ", " + clinic.estado + ", Brasil")
                                },
                                fontSize = 15.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Start,
                                lineHeight = 20.sp
                            )
                        }
                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Profissional: ",
                                fontSize = 17.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Black,
                                lineHeight = 18.sp
                            )

                            Text(
                                text = professional.nome,
                                fontSize = 15.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                lineHeight = 18.sp
                            )
                        }

                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Especialidade: ",
                                fontSize = 17.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Black,
                                lineHeight = 18.sp
                            )

                            Text(
                                text = professional.especialidade,
                                fontSize = 15.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                lineHeight = 18.sp
                            )
                        }
                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Telefone: ",
                                fontSize = 17.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Black,
                                lineHeight = 18.sp
                            )

                            Text(
                                text = professional.telefone,
                                fontSize = 15.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                lineHeight = 18.sp
                            )
                        }

                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Cobrança: ",
                                fontSize = 17.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Black,
                                lineHeight = 18.sp
                            )

                            Text(
                                text = "Consulta com ${professional.especialidade}",
                                fontSize = 15.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                lineHeight = 18.sp
                            )
                        }

                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Dia: ",
                                fontSize = 17.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Black,
                                lineHeight = 18.sp
                            )

                            Text(
                                text = DataHora.selectedDate,
                                fontSize = 15.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                lineHeight = 18.sp
                            )
                        }

                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Hora: ",
                                fontSize = 17.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Black,
                                lineHeight = 18.sp
                            )

                            Text(
                                text = DataHora.selectedTime,
                                fontSize = 15.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                lineHeight = 18.sp
                            )
                        }
                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Valor: ",
                                fontSize = 17.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Black,
                                lineHeight = 18.sp
                            )

                            Text(
                                text = "R$" + professional.valor,
                                fontSize = 15.sp,
                                color = Color(57, 57, 56),
                                textAlign = TextAlign.Center,
                                lineHeight = 18.sp
                            )
                        }
                    }

                }
            }

        }

    }

}