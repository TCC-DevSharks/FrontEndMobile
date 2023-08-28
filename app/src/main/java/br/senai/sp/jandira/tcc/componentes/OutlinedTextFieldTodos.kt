package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextFieldTodos(
    texto: Int,
    meuType: KeyboardType,
    email: String,
    onValueChange: (String) -> Unit,

)
{

    OutlinedTextField(
        value = email,
        onValueChange = {
            onValueChange(it)
        },
        modifier = Modifier
            .width(355.dp),
        shape = RoundedCornerShape(20.dp),
        label = {
            Text(text = stringResource(id = texto))
        },
        keyboardOptions = KeyboardOptions(keyboardType = meuType, imeAction = ImeAction.Next),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(243, 243, 243),
            focusedIndicatorColor = Color(243, 243, 243),
            unfocusedIndicatorColor = Color(243, 243, 243)
        ),
        maxLines = 1,


    )
}