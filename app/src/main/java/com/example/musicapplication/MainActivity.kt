package com.example.musicapplication

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.animation.DecelerateInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.musicapplication.MainState.Loading
import com.example.musicapplication.MainState.Success
import com.example.musicapplication.ui.theme.MusicApplicationTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        splashScreen.setExitSplashAnimation()

        super.onCreate(savedInstanceState)

        var mainActivityUiState: MainState by mutableStateOf(Loading)
        
        lifecycleScope.launch {
           changeMainActivityState {
               mainActivityUiState = it
           }
        }

        splashScreen
            .shouldExitStateSuccess(mainActivityUiState)

        setContent {
            MusicApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }

    private suspend fun changeMainActivityState(block: (MainState) -> Unit) = viewModel.mainState
        .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
        .onEach {
            block(it)
        }
        .collect()

}

private fun SplashScreen.setExitSplashAnimation() {
    setOnExitAnimationListener { splashScreenView ->
        val animator = splashScreenView.iconView.animate()

        animator
            .alpha(0f)
            .translationYBy(-splashScreenView.iconView.height.toFloat()+10)
            .setInterpolator(DecelerateInterpolator())
            .setDuration(1500L)
            .withEndAction {
                animator
                    .alphaBy(0.5f)
                splashScreenView.remove()
            }
            .start()
    }
}

private fun SplashScreen.shouldExitStateSuccess(mainActivityUiState: MainState) {
    setKeepOnScreenCondition {
        when (mainActivityUiState) {
            Loading -> {
                true
            }
            Success -> {
                false
            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MusicApplicationTheme {
        Greeting("Android")
    }
}