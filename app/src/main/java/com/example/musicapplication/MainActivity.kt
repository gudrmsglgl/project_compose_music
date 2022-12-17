package com.example.musicapplication

import android.animation.ObjectAnimator
import android.graphics.Color.alpha
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator
import android.view.animation.DecelerateInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.musicapplication.ui.theme.MusicApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        splashScreen.setOnExitAnimationListener { splashScreenView ->

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

        super.onCreate(savedInstanceState)


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