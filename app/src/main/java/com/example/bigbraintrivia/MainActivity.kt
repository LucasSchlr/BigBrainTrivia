package com.example.bigbraintrivia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bigbraintrivia.data.DatabaseImpl
import com.example.bigbraintrivia.leaderboard.LeaderBoardActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val uiScope = CoroutineScope(Dispatchers.Default)
    private val database: IDatabase = DatabaseImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        regularButton.setOnClickListener {
            val activity = this

            uiScope.launch {
                if (database.isLoginValid(txtUsuario.text.toString(), txtSenha.text.toString())) {
                    CoroutineScope(Dispatchers.Main).launch{ LeaderBoardActivity.open(activity) }
                } else {
                    println("Invalid login!")
                    println("Insert alert dialog here")
                }
            }
        }
    }
}
