package br.senai.sp.jandira.tcc.StartScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import kotlinx.coroutines.delay

@Composable
fun LoadingScreen(navController: NavController) {

    LaunchedEffect(true) {
        // Simula o tempo de carregamento
        delay(1500)
        navController.navigate("home") // Navegação para a tela principal
    }

    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color(236, 238, 255)),
        verticalArrangement = Arrangement.Center
    ) {

        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier.size(400.dp))
    }
}

