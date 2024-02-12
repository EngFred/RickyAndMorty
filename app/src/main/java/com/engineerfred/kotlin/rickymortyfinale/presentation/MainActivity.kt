package com.engineerfred.kotlin.rickymortyfinale.presentation

import android.graphics.Color.TRANSPARENT
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.engineerfred.kotlin.core.theme.theme.RIckyMortyFinaleTheme
import com.engineerfred.kotlin.rickymortyfinale.presentation.App
import com.engineerfred.kotlin.rickymortyfinale.utils.NavigationProvider
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationProvider: NavigationProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                TRANSPARENT, TRANSPARENT
            ),
            navigationBarStyle = SystemBarStyle.dark(
                TRANSPARENT
            ),
        )
        super.onCreate(savedInstanceState)
        setContent {
            RIckyMortyFinaleTheme {
                val navController = rememberNavController()
                App(
                    navController = navController,
                    navigationProvider = navigationProvider
                )
            }
        }
    }
}
