package ru.omysin.gbdictionary.ui

import android.os.Bundle
import android.view.animation.AnticipateInterpolator
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.omysin.gbdictionary.databinding.DictionaryMainBinding

class DictionaryActivity : AppCompatActivity() {

    private var isSplashScreenDuration = true
    private lateinit var binding: DictionaryMainBinding

    @RequiresApi(31)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        installSplashScreen().apply {
            setKeepOnScreenCondition { isSplashScreenDuration }

            animatedSplashScreen()
        }
        CoroutineScope(Dispatchers.Main).launch {
            delay(1500)
            isSplashScreenDuration = false
        }

        binding = DictionaryMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    @RequiresApi(31)
    private fun SplashScreen.animatedSplashScreen() {
        setOnExitAnimationListener { splashScreenProvider ->
            splashScreenProvider.iconView.animate()
                .scaleX(0f)
                .scaleY(0f)
                .setInterpolator(AnticipateInterpolator(5f))
                .duration = 500

            splashScreenProvider.view.animate()
                .alpha(0f)
                .withEndAction { splashScreenProvider.remove() }
                .duration = 500
        }
    }
}

