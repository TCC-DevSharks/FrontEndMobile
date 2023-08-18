package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.tcc.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextFieldSenha(
    texto: Int,
) {

    var password by rememberSaveable { mutableStateOf("") }

    var passwordVisibility by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility) {
        painterResource(id = R.drawable.baseline_remove_red_eye_24)
    } else {
        painterResource(id = R.drawable.baseline_visibility_off_24)
    }

    OutlinedTextField(
        value = password,
        onValueChange = {
            password = it
        },
        modifier = Modifier
            .width(355.dp),
        shape = RoundedCornerShape(20.dp),

        label = {
            Text(text = stringResource(id = texto))
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(243, 243, 243),
            unfocusedIndicatorColor = Color(243, 243, 243),
            focusedIndicatorColor = Color(243, 243, 243),
//
        ),
        trailingIcon = {
            IconButton(onClick = {
                passwordVisibility = !passwordVisibility
            }) {
                Icon(
                    painter = icon,
                    contentDescription = "visibility Icon"
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        }
        else {
            PasswordVisualTransformation()
        }

    )
}