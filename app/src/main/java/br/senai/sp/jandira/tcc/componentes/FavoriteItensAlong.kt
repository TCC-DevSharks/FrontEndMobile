package br.senai.sp.jandira.tcc.componentes

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R

@Composable
fun FavoriteItensAlong(
    //textTitle: String
    //textDescription: String
) {

    var isChecked by remember { mutableStateOf(false) }


    val expanded = remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(vertical = 7.dp, horizontal = 19.dp)
//                    .background(Color.Yellow)
                .clickable {

                    expanded.value = !expanded.value
                }

        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                    Checkbox(
                        modifier = Modifier.height(30.dp),
                        checked = isChecked,
                        onCheckedChange = { isChecked = it },
                        colors = CheckboxDefaults.colors(
                            checkmarkColor = Color(182, 182, 246),
                            checkedColor = Color(182, 182, 246), // Cor quando marcado
                            uncheckedColor = Color(182, 182, 246) // Cor quando não marcado
                        )
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Mamadeiras e Bicos",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(700),
                    )

                }



                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.trash),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                            .clickable {

                                Log.i("DS3m", "fdhgdfhgfhsdgfjhsdgfjhsdgfdhf")

                            }
                    )

                }


            }

            Column(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(
                        vertical = 5.dp,
                        horizontal = 14.dp
                    )
            ) {

                if (expanded.value) {
                    Text(
                        text = "Ter várias garrafas permitirá que você lave e esterilize todas de uma só vez, economizando um pouco de tempo e esforço.",
                        fontSize = 14.sp, // Reduced font size
                        fontWeight = FontWeight.Normal, // Use FontWeight.Normal enum
                        color = Color.Gray
                    )
                }

            }
        }


}

@Preview (showBackground = true, showSystemUi = true)
@Composable
fun FavoriteItensPreview() {
    FavoriteItensAlong()
}