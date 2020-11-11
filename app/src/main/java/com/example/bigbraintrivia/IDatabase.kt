package com.example.bigbraintrivia

import com.example.bigbraintrivia.model.LeaderBoard
import com.example.bigbraintrivia.model.Player
import com.example.bigbraintrivia.model.Question
import com.example.bigbraintrivia.model.QuestionOption

interface IDatabase {
    fun userExists(userName: String): Boolean
    fun isLoginValid(userName: String, userPassword: String): Boolean

    fun getPlayer(userName: String): Player
    fun registerPlayer(userName: String, userPassword: String)

    fun getQuestions(): List<Question>
    fun getAnswers(): List<QuestionOption>

    fun getLeaderboard(): LeaderBoard
    fun insertLeaderboardEntry(userName: String, score: Double)
}
