package com.example.bigbraintrivia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bigbraintrivia.data.DatabaseExecutor
import com.example.bigbraintrivia.leaderboard.LeaderBoardActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val uiScope = CoroutineScope(Dispatchers.Default)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        regularButton.setOnClickListener{

            uiScope.launch {
                val db = DatabaseExecutor()

                db.executeQuery("SELECT * FROM USERS")
            }
            //LeaderBoardActivity.open(this)
        }
    }
}
