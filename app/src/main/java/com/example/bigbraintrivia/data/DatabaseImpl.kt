package com.example.bigbraintrivia.data

import com.example.bigbraintrivia.IDatabase
import com.example.bigbraintrivia.model.*
import com.google.gson.Gson


class DatabaseImpl : IDatabase {
    private val databaseExecutor = DatabaseExecutor
    private val gson = Gson()

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
        val query = String.format("SELECT * FROM questions")
        val questionJson = databaseExecutor.executeQuery(query)

        val questions = gson.fromJson(
            questionJson,
            Array<Question>::class.java
        ).asList()

        val answers = getAnswers()

        questions.forEach { question ->
            var answerGroup = mutableListOf<QuestionOption>()

            answers.forEach { answer ->
                if (question.id == answer.questionId) {
                    answerGroup.add(answer)
                }
            }

            question.options = answerGroup.toList()
        }

        return questions
    }

    override fun getAnswers(): List<QuestionOption> {
        val query = String.format("SELECT * FROM answers")
        val answersJson = databaseExecutor.executeQuery(query)
            .replace("\"answer_is_correct\":\"1\"", "\"answer_is_correct\":true")

        return gson.fromJson(
            answersJson,
            Array<QuestionOption>::class.java
        ).asList()
    }

    override fun getLeaderboard(): LeaderBoard {
        TODO("Not yet implemented")
    }

    override fun insertLeaderboardEntry(userName: String, score: Double) {
        TODO("Not yet implemented")
    }

}