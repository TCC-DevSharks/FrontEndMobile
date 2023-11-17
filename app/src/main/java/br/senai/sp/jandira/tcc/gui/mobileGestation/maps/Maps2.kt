package br.senai.sp.jandira.tcc.gui.mobileGestation.maps

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapsScreen() {

    Column (modifier = Modifier.fillMaxSize()) {

        Column (modifier = Modifier.size(200.dp)) {

            val singapore = LatLng(1.35, 103.87)
            val cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(singapore, 100f)
            }
            GoogleMap(
                modifier = Modifier
                    .width(360.dp)
                    .height(180.dp),
                cameraPositionState = cameraPositionState
            ) {
                Marker(
                    state = MarkerState(position = singapore),
                    title = "Singapore",
                    snippet = "Marker in Singapore"
                )
            }

            var uiSettings by remember { mutableStateOf(MapUiSettings()) }
            var properties by remember {
                mutableStateOf(MapProperties(mapType = MapType.SATELLITE))
            }

            Box(Modifier.fillMaxSize()) {
                GoogleMap(
                    modifier = Modifier.matchParentSize(),
                    properties = properties,
                    uiSettings = uiSettings
                )
                Switch(
                    checked = uiSettings.zoomControlsEnabled,
                    onCheckedChange = {
                        uiSettings = uiSettings.copy(zoomControlsEnabled = it)
                    }
                )
            }

        }



    }



}