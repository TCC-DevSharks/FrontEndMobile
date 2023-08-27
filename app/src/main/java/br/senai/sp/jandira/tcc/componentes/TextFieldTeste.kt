import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateField(
    initValue: String,
    onValueChange: (String) -> Unit
) {
    var tfv by remember {
        val selection = TextRange(initValue.length)
        val textFieldValue = TextFieldValue(text = initValue, selection = selection)
        mutableStateOf(textFieldValue)
    }

    TextField(
        value = tfv,
        onValueChange = {

                val rawInput = it.text.replace(Regex("[^\\d]"), "")
                val formattedDate = formatDate(rawInput)
                tfv = it.copy(text = formattedDate, selection = TextRange(formattedDate.length))
                onValueChange(formattedDate)


        }
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
