package com.example.bigbraintrivia

import com.example.bigbraintrivia.model.LeaderBoard
import com.example.bigbraintrivia.model.Player
import com.example.bigbraintrivia.model.Question
import com.example.bigbraintrivia.model.QuestionOption

interface IDatabase {
    fun userExists(): Boolean
    fun isLoginValid(): Boolean

    fun getPlayer(): Player
    fun registerPlayer()

    fun getQuestions(): List<Question>
    fun getAnswers(): List<QuestionOption>

    fun getLeaderboard(): LeaderBoard
    fun insertLeaderboardEntry()
}
