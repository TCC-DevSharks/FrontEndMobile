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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.tcc.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateField(
    texto: Int,
    meuType: KeyboardType,
    data: String,
    onValueChange: (String) -> Unit
) {
    var tfv by remember {
        val selection = TextRange(data.length)
        val textFieldValue = TextFieldValue(text = data, selection = selection)
        mutableStateOf(textFieldValue)
    }

    OutlinedTextField(
        value = tfv,
        onValueChange = {

                val rawInput = it.text.replace(Regex("[^\\d]"), "")
                val formattedDate = formatDate(rawInput)
                tfv = it.copy(text = formattedDate, selection = TextRange(formattedDate.length))
                onValueChange(formattedDate)
        },
        modifier = Modifier
                .width(355.dp),
        shape = RoundedCornerShape(20.dp),
        label = {
            Text(text = stringResource(id = texto),
                fontFamily = FontFamily(Font(R.font.outfit_medium))
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = meuType, imeAction = ImeAction.Done),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color(182, 182, 246),
            unfocusedIndicatorColor = Color(182, 182, 246)
        ),
    )
}

fun formatDate(rawInput: String): String {
    val parts = listOf(
        rawInput.substring(0, minOf(2, rawInput.length)),
        rawInput.substring(minOf(2, rawInput.length), minOf(4, rawInput.length)),
        rawInput.substring(minOf(4, rawInput.length), minOf(8, rawInput.length))
    )
    return parts.filter { it.isNotEmpty() }.joinToString("/")
}
