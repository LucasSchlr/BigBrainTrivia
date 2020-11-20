package com.example.bigbraintrivia.leaderboard

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.bigbraintrivia.R
import com.example.bigbraintrivia.model.Question
import com.example.bigbraintrivia.question.QuestionActivity
import kotlinx.android.synthetic.main.activity_leader_board.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LeaderBoardActivity : AppCompatActivity() {
    private val viewModel: LeaderBoardViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leader_board)

        viewModel.listLeaderBoard.observe(this, Observer { list ->
            listLeaderBoard.adapter = LeaderBoardAdapter(this, list)
        })

        viewModel.loadLeaderBoard()

        btNewGame.setOnClickListener { QuestionActivity.open(this) }
    }

    override fun onResume() {
        viewModel.loadLeaderBoard()
        super.onResume()
    }

    companion object {
        fun open (activity: Activity){
            activity.startActivity(
                Intent(activity, LeaderBoardActivity::class.java)
            )
        }
    }
}
