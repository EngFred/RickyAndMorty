package com.engineerfred.kotlin.rickymortyfinale

import android.graphics.Color.TRANSPARENT
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.engineerfred.kotlin.core.theme.theme.RIckyMortyFinaleTheme
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
            navigationBarStyle = SystemBarStyle.light(
                TRANSPARENT, TRANSPARENT
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

@Composable
fun App(
    navController: NavHostController,
    navigationProvider: NavigationProvider
) {
    Surface(
        modifier = Modifier.fillMaxSize().statusBarsPadding().navigationBarsPadding(),
        color = MaterialTheme.colorScheme.background
    ) {
        MainAppNavigationGraph(
            navController = navController,
            navigationProvider = navigationProvider
        )
    }
}