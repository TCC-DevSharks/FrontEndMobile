package br.senai.sp.jandira.tcc.gui.mobileGestation.scheduleAdd

import android.util.Log
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.SwitchComp
import br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.doctor.DataHora
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.schedule.ModelSchedule
import br.senai.sp.jandira.tcc.model.schedule.ScheduleResponse
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleAdd(
    navController: NavController,
    modelSchedule: ModelSchedule,
    viewModel: ModelPregnant
) {

    var tarefas by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }
    var data by remember { mutableStateOf("") }
    var id by remember { mutableStateOf(0) }
    val context = LocalContext.current

    var tfv by remember {
        val selection = TextRange(data.length)
        val textFieldValue = TextFieldValue(text = data, selection = selection)
        mutableStateOf(textFieldValue)
    }

    LaunchedEffect(Unit) {
        tarefas = modelSchedule.titulo
        descricao = modelSchedule.descricao
        data = modelSchedule.dia
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Header(titulo = stringResource(id = R.string.schedule),
                navController = navController,
                rota = "homeUser")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.tasks),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(5.dp))



            OutlinedTextField(
                value = tarefas,
                onValueChange = { tarefas = it },
                modifier = Modifier
                    .width(355.dp)
                    .border(
                        width = 1.dp,
                        color = Color(182, 182, 246),
                        shape = RoundedCornerShape(20.dp)
                    ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color(243, 243, 243),
                    unfocusedIndicatorColor = Color(243, 243, 243)
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.description),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = descricao,
                onValueChange = { descricao = it },
                singleLine = false, // Permitir várias linhas
                modifier = Modifier
                    .width(355.dp)
                    .height(250.dp)
                    .border(
                        width = 1.dp,
                        color = Color(182, 182, 246),
                        shape = RoundedCornerShape(20.dp)
                    ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color(243, 243, 243),
                    unfocusedIndicatorColor = Color(243, 243, 243)
                )
            )


            Spacer(modifier = Modifier.height(10.dp))


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.date),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(5.dp))


            OutlinedTextField(
                value = tfv,
                onValueChange = {
                    val rawInput = it.text.replace(Regex("[^\\d]"), "")
                    val formattedDate = formatDate(rawInput)
                    tfv = it.copy(text = formattedDate, selection = TextRange(formattedDate.length))
                                },
                modifier = Modifier
                    .width(355.dp)
                    .border(
                        width = 1.dp,
                        color = Color(182, 182, 246),
                        shape = RoundedCornerShape(20.dp)
                    ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color(243, 243, 243),
                    unfocusedIndicatorColor = Color(243, 243, 243)
                ),
                singleLine = true
            )


        }
        Spacer(modifier = Modifier.height(15.dp))

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .background(Color(182, 182, 246), CircleShape)
                    .size(60.dp),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.lixeirinha),
                    contentDescription = null,
                    modifier = Modifier.size(27.dp).clickable {
                        var call = RetrofitFactory().schedule().deleteSchedule(modelSchedule.id)

                        call.enqueue(object : retrofit2.Callback<ResponseBody> {
                            override fun onResponse(
                                call: Call<ResponseBody>,
                                response: Response<ResponseBody>

                            ) {
                                if (response.isSuccessful){
                                    val backgroundColor = Color.Gray
                                    val contentColor = Color.White

                                    val toast = Toast(context)
                                    toast.setGravity(Gravity.CENTER, 0, 20)
                                    toast.duration = Toast.LENGTH_SHORT

                                    val textView = TextView(context).apply {
                                        text = "Evento removido com sucesso"
                                        textSize = 18f // Tamanho da fonte aumentado
                                        setBackgroundColor(backgroundColor.toArgb()) // Converter a cor para ARGB
                                        setTextColor(contentColor.toArgb()) // Converter a cor para ARGB
                                        setPadding(
                                            36,
                                            36,
                                            36,
                                            36
                                        ) // Valores inteiros em pixels para padding
                                    }

                                    toast.view = textView
                                    toast.show()
                                }

                            }

                            override fun onFailure(
                                call: Call<ResponseBody>,
                                t: Throwable
                            ) {
                                Log.i(
                                    "ds2m",
                                    "onFailure: ${t.message}"
                                )
                                println(t.message + t.cause)
                            }
                        })

                        navController.navigate("homeUser")

                    },
                )
            }
            Box(
                modifier = Modifier
                    .background(Color(182, 182, 246), CircleShape)
                    .size(60.dp),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.save),
                    contentDescription = null,
                    modifier = Modifier
                        .size(27.dp)
                        .clickable {

                            if (modelSchedule.id == 0) {

                                val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")


                                var schedule = ScheduleResponse(

                                    dia = "${LocalDate.parse(tfv.text, formatter)}",
                                    titulo = tarefas,
                                    lembrete = 0,
                                    descricao = descricao,
                                    id_gestante = viewModel.id
                                )

                                var call = RetrofitFactory()
                                    .schedule()
                                    .postSchedule(schedule)

                                call.enqueue(object : retrofit2.Callback<ResponseBody> {
                                    override fun onResponse(
                                        call: Call<ResponseBody>,
                                        response: Response<ResponseBody>

                                    ) {
                                        if (response.isSuccessful) {
                                            val backgroundColor = Color.Gray
                                            val contentColor = Color.White

                                            val toast = Toast(context)
                                            toast.setGravity(Gravity.CENTER, 0, 20)
                                            toast.duration = Toast.LENGTH_SHORT

                                            val textView = TextView(context).apply {
                                                text = "Evento adicionado com sucesso"
                                                textSize = 18f // Tamanho da fonte aumentado
                                                setBackgroundColor(backgroundColor.toArgb()) // Converter a cor para ARGB
                                                setTextColor(contentColor.toArgb()) // Converter a cor para ARGB
                                                setPadding(
                                                    36,
                                                    36,
                                                    36,
                                                    36
                                                ) // Valores inteiros em pixels para padding
                                            }

                                            toast.view = textView
                                            toast.show()

                                            navController.navigate("homeUser")
                                        }

                                    }

                                    override fun onFailure(
                                        call: Call<ResponseBody>,
                                        t: Throwable
                                    ) {
                                        Log.i(
                                            "ds2m",
                                            "onFailure: ${t.message}"
                                        )
                                        println(t.message + t.cause)
                                    }
                                })
                            } else {

                                val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                                var schedule = ScheduleResponse(

                                    dia = "${LocalDate.parse(tfv.text, formatter)}",
                                    titulo = tarefas,
                                    lembrete = 0,
                                    descricao = descricao,
                                    id_gestante = viewModel.id
                                )

                                var call = RetrofitFactory()
                                    .schedule()
                                    .putSchedule(modelSchedule.id, schedule)

                                call.enqueue(object : retrofit2.Callback<ScheduleResponse> {
                                    override fun onResponse(
                                        call: Call<ScheduleResponse>,
                                        response: Response<ScheduleResponse>

                                    ) {
                                        if (response.isSuccessful) {
                                            val backgroundColor = Color.Gray
                                            val contentColor = Color.White

                                            val toast = Toast(context)
                                            toast.setGravity(Gravity.CENTER, 0, 20)
                                            toast.duration = Toast.LENGTH_SHORT

                                            val textView = TextView(context).apply {
                                                text = "Evento atualizado com sucesso"
                                                textSize = 18f // Tamanho da fonte aumentado
                                                setBackgroundColor(backgroundColor.toArgb()) // Converter a cor para ARGB
                                                setTextColor(contentColor.toArgb()) // Converter a cor para ARGB
                                                setPadding(
                                                    36,
                                                    36,
                                                    36,
                                                    36
                                                ) // Valores inteiros em pixels para padding
                                            }

                                            toast.view = textView
                                            toast.show()

                                            navController.navigate("homeUser")
                                        }

                                    }

                                    override fun onFailure(
                                        call: Call<ScheduleResponse>,
                                        t: Throwable
                                    ) {
                                        Log.i(
                                            "ds2m",
                                            "onFailure: ${t.message}"
                                        )
                                        println(t.message + t.cause)
                                    }
                                })
                            }
                        },
                )
            }
        }


    }
}

fun formatDate(rawInput: String): String {
    val parts = listOf(
        rawInput.substring(0, minOf(2, rawInput.length)),
        rawInput.substring(minOf(2, rawInput.length), minOf(4, rawInput.length)),
        rawInput.substring(minOf(4, rawInput.length), minOf(8, rawInput.length))
    )
    return parts.filter { it.isNotEmpty() }.joinToString("/")
}
