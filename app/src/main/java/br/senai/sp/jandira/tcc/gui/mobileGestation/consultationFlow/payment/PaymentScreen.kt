package br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.payment

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.ArrowLeft
import br.senai.sp.jandira.tcc.componentes.OutlinedTextFieldTodos
import br.senai.sp.jandira.tcc.componentes.TextComp
import br.senai.sp.jandira.tcc.model.ModelPregnant

@Composable
fun PaymentScreen(
//    viewModel: ModelPregnant
) {




    Column(modifier = Modifier.fillMaxSize()) {

        var nome by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var cpf by remember { mutableStateOf("") }
        var dddPais by remember { mutableStateOf("55") }
        var dd by remember { mutableStateOf("") }
        var telefone by remember { mutableStateOf("") }
        var complemento by remember { mutableStateOf("") }
        var logradouro by remember { mutableStateOf("") }
        var numero by remember { mutableStateOf("") }
        var bairro by remember { mutableStateOf("") }
        var cidade by remember { mutableStateOf("") }
        var estado by remember { mutableStateOf("") }
        var cep by remember { mutableStateOf("") }
        var tipoCartao by remember { mutableStateOf("") }
        var numeroCartao by remember { mutableStateOf("") }
        var mesVencimento by remember { mutableStateOf("") }
        var anoVencimento by remember { mutableStateOf("") }
        var cdd by remember { mutableStateOf("") }

//        nome = viewModel.nome
//        email = viewModel.email
//        cpf = viewModel.cpf
//        telefone = viewModel.telefone
//        complemento = viewModel.complemento
//        cep = viewModel.cep
//        numero = viewModel.numero
//        bairro = viewModel.bairro
//        cidade = viewModel.cidade
//        estado = viewModel.estado


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

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp, bottom = 15.dp)
                .verticalScroll(rememberScrollState())
        ) {

                OutlinedTextFieldTodos(
                    texto = R.string.example_name,
                    meuType = KeyboardType.Text,
                    value = nome,
                    onValueChange = { nome = it },
                    )

            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextFieldTodos(
                texto = R.string.email,
                meuType = KeyboardType.Text,
                value = email,
                onValueChange = { email = it },
            )

            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextFieldTodos(
                texto = R.string.text_field_cpf,
                meuType = KeyboardType.Text,
                value = cpf,
                onValueChange = { cpf = it })

            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextFieldTodos(
                texto = R.string.text_field_ddPais,
                meuType = KeyboardType.Text,
                value = dddPais,
                onValueChange = { dddPais = it })

            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextFieldTodos(
                texto = R.string.text_field_dd,
                meuType = KeyboardType.Text,
                value = dd,
                onValueChange = { dd = it })

            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextFieldTodos(
                texto = R.string.text_field_telefone,
                meuType = KeyboardType.Text,
                value = telefone,
                onValueChange = { telefone = it })

            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextFieldTodos(
                texto = R.string.text_field_rua,
                meuType = KeyboardType.Text,
                value = logradouro,
                onValueChange = { logradouro = it })

            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextFieldTodos(
                texto = R.string.text_field_numero,
                meuType = KeyboardType.Text,
                value = numero,
                onValueChange = { numero = it })

            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextFieldTodos(
                texto = R.string.example_complement,
                meuType = KeyboardType.Text,
                value = complemento,
                onValueChange = { complemento = it })

            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextFieldTodos(
                texto = R.string.text_field_bairro,
                meuType = KeyboardType.Text,
                value = bairro,
                onValueChange = { bairro = it })

            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextFieldTodos(
                texto = R.string.text_field_cidade,
                meuType = KeyboardType.Text,
                value = cidade,
                onValueChange = { cidade == it })

            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextFieldTodos(
                texto = R.string.text_field_cpf,
                meuType = KeyboardType.Text,
                value = cep,
                onValueChange = { cep == it })

            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextFieldTodos(
                texto = R.string.text_field_state,
                meuType = KeyboardType.Text,
                value = estado,
                onValueChange = { estado == it })

            Spacer(modifier = Modifier.height(5.dp))


        }


    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PaymentPreview() {
    PaymentScreen()
}