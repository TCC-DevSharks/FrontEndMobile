package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R

@Composable
fun CardBirthPlan(
        enxoval: String

) {


    Column(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(vertical = 13.dp, horizontal = 29.dp)

    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Image(painter = painterResource(id = R.drawable.baseline_add_circle_65),
                contentDescription = null,
                modifier = Modifier
                    .clickable {

                    }
                    .size(30.dp)
            )

            Spacer(modifier = Modifier.width(15.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = enxoval,
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
            )
        }

    }

}
