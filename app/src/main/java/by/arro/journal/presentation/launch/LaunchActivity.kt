package by.arro.journal.presentation.launch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import by.arro.journal.presentation.main.MainActivity

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(MainActivity.getIntent(this))
        finish()
    }
}