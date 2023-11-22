package br.senai.sp.jandira.tcc.gui.mobileGestation.maps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

@Composable
fun rememberMapViewWithLifecycle(): MapView {

    val context = LocalContext.current

    var mapView: MapView? by remember { mutableStateOf(null) }

    DisposableEffect(Unit) {
        mapView?.onCreate(Bundle())

        onDispose {
            mapView?.onDestroy()
        }
    }

    return remember {
        mapView ?: MapView(context).also {
            mapView = it
        }
    }
}

@Composable
fun MapFragment() {
    // Get the context
    val context = LocalContext.current

    // Create a MapView
    val mapView = rememberMapViewWithLifecycle()

    // Set up the MapView
    mapView.getMapAsync { googleMap ->
        // Add a marker to the map
        googleMap.addMarker(
            MarkerOptions()
                .position(LatLng(1.35, 103.87))
                .title("Marker")
        )

        // Move the camera to the marker position
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(1.35, 103.87)))
    }

    // Compose UI
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        AndroidView(
            factory = { context ->
                mapView
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
fun teste() {
    MapFragment()
}