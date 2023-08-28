package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextFieldPhone (
    texto: String,
    meuType: KeyboardType,
    data: String,
    onValueChange: (String) -> Unit,

)
{
    var tfv by remember {
        val selection = TextRange(data.length)
        val textFieldValue = TextFieldValue(text = data, selection = selection)
        mutableStateOf(textFieldValue)
    }

    var maxLength: Int = 15
   OutlinedTextField(
        value = tfv,
        onValueChange = {
            val digits = it.text.filter { it.isDigit() }
            val formatted = when (digits.length) {
                in 0..2 -> "(${digits})"
                in 3..7 -> "(${digits.substring(0, 2)}) ${digits.substring(2)}"
                else -> "(${digits.substring(0, 2)}) ${digits.substring(2, 7)}-${digits.substring(7)}"
            }
            if (formatted.length <= maxLength) {
                tfv = it.copy(text = formatted, selection = TextRange(formatted.length))
                onValueChange(formatted)
            }

            onValueChange(formatted)
        },
        modifier = Modifier
            .width(355.dp),
        shape = RoundedCornerShape(20.dp),
        label = {
            Text(text = texto)
        },
        keyboardOptions = KeyboardOptions(keyboardType = meuType, imeAction = ImeAction.Done),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(243, 243, 243),
            focusedIndicatorColor = Color(243, 243, 243),
            unfocusedIndicatorColor = Color(243, 243, 243)
        ),
    )


}

