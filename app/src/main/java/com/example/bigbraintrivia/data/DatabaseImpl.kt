package com.example.bigbraintrivia.data

import com.example.bigbraintrivia.IDatabase
import com.example.bigbraintrivia.model.LeaderBoard
import com.example.bigbraintrivia.model.Player
import com.example.bigbraintrivia.model.Question
import com.example.bigbraintrivia.model.QuestionOption

class DatabaseImpl : IDatabase {
    override fun userExists(userName: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun isLoginValid(userName: String, userPassword: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun getPlayer(userName: String): Player {
        TODO("Not yet implemented")
    }

    override fun registerPlayer(userName: String, userPassword: String) {
        TODO("Not yet implemented")
    }

    override fun getQuestions(): List<Question> {
        TODO("Not yet implemented")
    }

    override fun getAnswers(): List<QuestionOption> {
        TODO("Not yet implemented")
    }

    override fun getLeaderboard(): LeaderBoard {
        TODO("Not yet implemented")
    }

    override fun insertLeaderboardEntry(userName: String, score: Double) {
        TODO("Not yet implemented")
    }

}