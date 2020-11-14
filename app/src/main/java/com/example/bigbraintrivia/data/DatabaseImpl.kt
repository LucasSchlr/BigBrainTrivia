package com.example.bigbraintrivia.data

import android.util.Log
import com.example.bigbraintrivia.IDatabase
import com.example.bigbraintrivia.model.*
import com.google.gson.Gson


class DatabaseImpl : IDatabase {
    private val databaseExecutor = DatabaseExecutor
    private val gson = Gson()

    override fun userExists(userName: String): Boolean {
        val query = String.format("select users.name from users where name = '%s'", userName)
        val playerJson = databaseExecutor.executeQuery(query)

        val player = gson.fromJson(
            playerJson,
            Array<Player>::class.java
        )[0]

        return player.nome.isNotEmpty()
    }

    override fun isLoginValid(userName: String, userPassword: String): Boolean {
        val query = String.format("select name from users where name = '%s' and password = '%s'", userName, userPassword)
        val playerJson = databaseExecutor.executeQuery(query)

        val player = gson.fromJson(
            playerJson,
            Array<Player>::class.java
        )

        if (player.isNotEmpty()) {
            return player[0].nome.isNotEmpty()
        }

        return false
    }

    override fun getPlayer(userName: String): Player {
        val query = String.format("select * from users where name = '%s'", userName)
        val playerJson = databaseExecutor.executeQuery(query)

        return gson.fromJson(
            playerJson,
            Array<Player>::class.java
        )[0]
    }

    override fun registerPlayer(userName: String, userPassword: String) {
        val query = String.format("insert into users (NAME, PASSWORD) VALUES ('%s', '%s')", userName, userPassword)
        databaseExecutor.executeQuery(query)

    }

    override fun getQuestions(): List<Question> {
        Log.i("teste", "entrando aqui")
        val query = String.format("SELECT * FROM questions")
        Log.i("teste", "entrando aqui.2")
        val questionJson = databaseExecutor.executeQuery(query)
        Log.i("teste", "0")

        val questions = gson.fromJson(
            questionJson,
            Array<Question>::class.java
        ).asList()
        Log.i("teste", "1")

        val answers = getAnswers()
        Log.i("teste", "2")

        questions.forEach { question ->
            Log.i("teste", "3")
            var answerGroup = mutableListOf<QuestionOption>()
            Log.i("teste", "4")

            answers.forEach { answer ->
                if (question.id == answer.questionId) {
                    answerGroup.add(answer)
                }
            }
            Log.i("teste", "5")
            question.options = answerGroup.toList()
            Log.i("teste", "6")
        }
        Log.i("teste", "7")

        return questions
    }

    private fun getAnswers(): List<QuestionOption> {
        val query = String.format("SELECT * FROM answers")
        val answersJson = databaseExecutor.executeQuery(query)
            .replace("\"answer_is_correct\":\"1\"", "\"answer_is_correct\":true")

        return gson.fromJson(
            answersJson,
            Array<QuestionOption>::class.java
        ).asList()
    }

    override fun getLeaderboard(): List<LeaderBoard> {
        val query = String.format("select * from leaderboard order by score desc limit 10")
        val leaderBoardJson = databaseExecutor.executeQuery(query)

        var leaderBoard = gson.fromJson(
            leaderBoardJson,
            Array<LeaderBoard>::class.java
        ).asList()

        var counter = 1
        leaderBoard.forEach{ leaderBoard ->
            leaderBoard.position = counter++
        }

        return leaderBoard
    }

    override fun insertLeaderboardEntry(userName: String, score: Double) {
        val query = String.format("insert into leaderboard (NAME, SCORE) VALUES ('%s', '%s')", userName, score.toString())
        databaseExecutor.executeQuery(query)
    }

}