package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.limpeanapp.home.components.BottomNavigation
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.professional.Professional

data class BottomNavigationDoctor(
    val title: String,
    val selectedIcon: Int,
    val modifier: Modifier,
    val route: String,
)

@Composable
fun NavigationNutritionist(
    navController: NavController,
    professional: Professional,
    pregnant: ModelPregnant
) {

//    val itemsDoctor = listOf(
//        BottomNavigationDoctor(
//            title = "Chat",
//            selectedIcon = R.drawable.chat_cinza,
//
//            route = "medicalRecordSelectDate",
//            modifier = Modifier.size(24.dp)
//        ),
//        BottomNavigationDoctor(
//            title = "Home",
//            selectedIcon = R.drawable.home_cinza,
//
//            route = "DoctorHome",
//            modifier = Modifier.size(24.dp)
//        ),
//        BottomNavigationDoctor(
//            title = "Prontuario",
//            selectedIcon = R.drawable.clipboard_doctor,
//
//            route = "medicalRecordSelect",
//            modifier = Modifier.size(24.dp)
//        ),
//        BottomNavigationDoctor(
//            title = "Agenda",
//            selectedIcon = R.drawable.calendar_doctor,
//
//            route = "doctorSchedule",
//            modifier = Modifier.size(24.dp)
//        ),
//
//        )
//
//    var selectedItemIndex by rememberSaveable {
//        mutableStateOf(1)
//    }
//
//    NavigationBar(
//        containerColor =Color(245,245,245),
//        contentColor = MaterialTheme.colorScheme.onBackground
//    ) {
//        itemsDoctor.forEachIndexed { index, item ->
//            NavigationBarItem(
//                colors = NavigationBarItemDefaults.colors(
//                    selectedIconColor = MaterialTheme.colorScheme.onPrimary,
//                    indicatorColor = Color(245,245,245),
//                    selectedTextColor = MaterialTheme.colorScheme.primary,
//                    unselectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer
//                ),
//                selected = selectedItemIndex == index,
//                onClick = {
//                    selectedItemIndex = index
//                    navController.navigate(item.route)
//                },
//                label = {
//                    Text(
//                        text = item.title,
//                        style = MaterialTheme.typography.labelSmall,
//                        color = if (selectedItemIndex == index) Color(182,182,246) else Color(209, 209, 214)
//                    )
//                },
//                icon = {
//
//                    Image(
//                        painter =
//                        painterResource(id = item.selectedIcon),
//                        contentDescription = item.title,
//                        modifier = Modifier.size(24.dp),
//                        colorFilter = if (selectedItemIndex == index) ColorFilter.tint(Color(182,182,246))
//                        else ColorFilter.tint(Color(209, 209, 214))
//                    )
//
//                }
//            )
//        }
//    }

    var isNutricionistaSelected by remember { mutableStateOf(false) }
    var isChatSelected by remember { mutableStateOf(false) }
    var isHomeSelected by remember { mutableStateOf(true) }
    var isMedicalRecordSelected by remember { mutableStateOf(false) }
    var isDoctorScheduleSelected by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .height(70.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 7.7.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            if (professional.especialidade == "Nutricionista") {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.clickable {
                    navController.navigate("dietSelect")
//                    isNutricionistaSelected = true
//                    isChatSelected = false
//                    isHomeSelected = false
//                    isMedicalRecordSelected = false
//                    isDoctorScheduleSelected = false
                }) {
                    Image(
                        painter = painterResource(id = R.drawable.utensils_cinza),
                        contentDescription = null,
                        modifier = Modifier.size(27.dp),
//                        colorFilter = if (isNutricionistaSelected) ColorFilter.tint(Color(182,182,246))
//                        else ColorFilter.tint(Color(209, 209, 214))
                    )
                }
            }

            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.clickable {
                        navController.navigate("DoctorContact")
//                    isNutricionistaSelected = false
//                    isChatSelected = true
//                    isHomeSelected = false
//                    isMedicalRecordSelected = false
//                    isDoctorScheduleSelected = false
                }) {
                Image(
                    painter = painterResource(id = R.drawable.chat_cinza),
                    contentDescription = null,
                    modifier = Modifier.size(27.dp),
//                    colorFilter = if (isChatSelected) ColorFilter.tint(Color(182,182,246))
//                    else ColorFilter.tint(Color(209, 209, 214))
                )
            }

            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.clickable {
                    navController.navigate("DoctorHome")
//                    isNutricionistaSelected = false
//                    isChatSelected = false
//                    isHomeSelected = true
//                    isMedicalRecordSelected = false
//                    isDoctorScheduleSelected = false


                }) {
                Image(
                    painter = painterResource(id = R.drawable.home_cinza),
                    contentDescription = null,
                    modifier = Modifier.size(27.dp),
//                    colorFilter = if (isHomeSelected) ColorFilter.tint(Color(182,182,246))
//                    else ColorFilter.tint(Color(209, 209, 214))
                )
            }

            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.clickable {
                    navController.navigate("medicalRecordSelect")
//                    isNutricionistaSelected = false
//                    isChatSelected = false
//                    isHomeSelected = false
//                    isMedicalRecordSelected = true
//                    isDoctorScheduleSelected = false
                }) {
                Image(
                    painter = painterResource(id = R.drawable.clipboard_doctor),
                    contentDescription = null,
                    modifier = Modifier.size(27.dp),
//                    colorFilter = if (isMedicalRecordSelected) ColorFilter.tint(Color(182,182,246))
//                    else ColorFilter.tint(Color(209, 209, 214))
                )
            }


            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.clickable {
                    navController.navigate("doctorSchedule")
//                    isNutricionistaSelected = false
//                    isChatSelected = false
//                    isHomeSelected = false
//                    isMedicalRecordSelected = false
//                    isDoctorScheduleSelected = true
                }) {

                Image(
                    painter = painterResource(id = R.drawable.calendar_doctor),
                    contentDescription = null,
                    modifier = Modifier.size(27.dp),
//                    colorFilter = if (isDoctorScheduleSelected) ColorFilter.tint(Color(182,182,246))
//                    else ColorFilter.tint(Color(209, 209, 214))
                )

            }


        }


    }

}