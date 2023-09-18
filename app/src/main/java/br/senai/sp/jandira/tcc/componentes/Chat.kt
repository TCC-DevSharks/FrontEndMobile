package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R

@Composable
fun Chat(

//    messageText: String,
//    timeText: String,

) {


    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {



    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 26.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {

        Card(
            modifier = Modifier
                .size(40.dp),
            shape = CircleShape,


            ) {
            Image(
                painter = painterResource(id = R.drawable.doctor),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

        }

        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(start = 20.dp, end = 14.dp),
        ) {

            Box(
                modifier = Modifier
                    .background(
                        Color(255, 218, 185),
                        RoundedCornerShape(10.dp)
                    ),
            ) {
                Text(
                    text = "Heytytytyygygygygyfewgfr3efg3eyfrh3euf3f3fr3fr3rr3frr3kjfklj3lkr3krj3lkjr3fklrj3kfj3kljr3lrj3klr3jfrl3jkfr3kjfrkl3jfr3fr",
                    style = TextStyle(
                        color = Color.Black,
                    ),
                    modifier = Modifier
                        .padding(13.dp)
                        .padding(bottom = 9.dp),
                    textAlign = TextAlign.Start
                )



                Row(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .align(Alignment.BottomStart),
                    horizontalArrangement = Arrangement.Start
                ) {

                    Text(
                        text = "Tue",
                        fontSize = 14.sp,
                        color = Color(102, 97, 97, 95)
                    )

                    Text(
                        text = "12.30",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 7.dp),
                        color = Color(102, 97, 97, 95)
                    )

                }
            }
        }
    }

        Spacer(modifier = Modifier.height(70.dp))

    /// Lado Esquerdo



    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 26.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(start = 58.dp, end = 10.dp),
            horizontalAlignment = Alignment.End
        ) {

            Box(
                modifier = Modifier
                    .background(
                        Color(182,182,246,98),
                        RoundedCornerShape(10.dp)
                    ),
            ) {
                Text(
                    text = "Heytytfr3 ggghg hgjhghghg gvv gvgv gvgv  gvvgvh hgv gvvv  huj hbhb hbjjn nbnj bl3jfr3fr",
                    style = TextStyle(
                        color = Color.Black,
                    ),
                    modifier = Modifier
                        .padding(13.dp)
                        .padding(bottom = 9.dp),
                    textAlign = TextAlign.Start
                )



                Row(
                    modifier = Modifier
                        .padding(horizontal = 12.dp,)
                        .align(Alignment.BottomEnd),
                    horizontalArrangement = Arrangement.End
                ) {

                    Text(
                        text = "Tue",
                        fontSize = 14.sp,
                        color = Color(102, 97, 97, 95)
                    )

                    Text(
                        text = "12.30",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 7.dp),
                        color = Color(102, 97, 97, 95)
                    )

                }
            }
        }

        Card(
            modifier = Modifier
                .size(40.dp),
            shape = CircleShape,


            ) {
            Image(
                painter = painterResource(id = R.drawable.doctor),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

        }

    }

    }


}

@Preview (showBackground = true , showSystemUi = true)
@Composable
fun ChatPreview() {
    Chat()
}