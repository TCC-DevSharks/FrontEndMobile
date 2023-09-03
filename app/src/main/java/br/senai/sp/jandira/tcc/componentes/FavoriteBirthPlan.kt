package br.senai.sp.jandira.tcc.componentes

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
fun FavoriteBirthPlan() {


    Column(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(vertical = 13.dp, horizontal = 29.dp)

    ) {

        Row(
            modifier = Modifier.fillMaxWidth(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_add_circle_65),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            // navController.navigate(rota)
                        }
                        .size(30.dp)
                )

                Spacer(modifier = Modifier.width(15.dp))

                Text(
                    text = "Gostaria de ter um acompanhante durante o trabalho de parto, parto e puerpério.",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.trash),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            Log.i("DS3m", "fdhgdfhgfhsdgfjhsdgfjhsdgfdhf")
                        }
                )
            }
        }


    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FavoriteBirthPlanPreview() {
    FavoriteBirthPlan()
}