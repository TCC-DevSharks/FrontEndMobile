package br.senai.sp.jandira.tcc.componentes

import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun SwitchComp(
    switchCheckedState: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    CorFundo : Color = Color(182, 182, 246, 51),
    corPrimary : Color = Color(182, 182, 246,),
    corBorder : Color = Color(182, 182, 246,)
) {

    Switch(
        checked = switchCheckedState,
        onCheckedChange = {
            onCheckedChange(it)

            if (it) {
                // Código para quando o Switch estiver ligado
            } else {
                // Código para quando o Switch estiver desligado
            }
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = if (switchCheckedState) corPrimary else Color(
                217,
                217,
                217
            ),
            checkedTrackColor = CorFundo,
            checkedBorderColor = corBorder,
            uncheckedThumbColor = Color(217, 217, 217),
            uncheckedTrackColor = Color.White,
            disabledCheckedBorderColor = Color(182, 182, 246)
        )
    )

}