package ca.tetervak.dicecube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ca.tetervak.dicecube.ui.AppRootScreen
import ca.tetervak.dicecube.ui.theme.DiceCubeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceCubeTheme {
                AppRootScreen()
            }
        }
    }
}

