package com.example.bigbraintrivia.question

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bigbraintrivia.model.Question
import com.example.bigbraintrivia.model.QuestionOption

class QuestionViewModel(): ViewModel() {
    val questionsList = MutableLiveData<List<Question>>()
    val currentQuestion = MutableLiveData<Question>()
    var currentQuestionIndex = -1;
    var score = MutableLiveData<Int>()

    fun startGame(){
        currentQuestionIndex = 0
        score.value = 0
        currentQuestion.value = questionsList.value?.get(currentQuestionIndex)
    }

    fun nextQuestion(){
        currentQuestionIndex++
        if (currentQuestionIndex + 1 <= questionsList.value?.size?:0){
            currentQuestion.value = questionsList.value?.get(currentQuestionIndex)
        }
    }

    fun loadQuestions(){
        val list = listOf(
            Question(
                0,
                "Questão 1",
                listOf(
                    QuestionOption(0,0,"Opção 1", false),
                    QuestionOption(1,0,"Opção 2", false),
                    QuestionOption(2,0,"Opção 3", true),
                    QuestionOption(3,0,"Opção 4", false),
                    QuestionOption(4,0,"Opção 5", false)
                )
            ),
            Question(
                1,
                "Questão 2",
                listOf(
                    QuestionOption(0,1,"Opção 1", false),
                    QuestionOption(1,1,"Opção 2", false),
                    QuestionOption(2,1,"Opção 3", true),
                    QuestionOption(3,1,"Opção 4", false),
                    QuestionOption(4,1,"Opção 5", false)
                )
            ),
            Question(
                2,
                "Questão 3",
                listOf(
                    QuestionOption(0,2,"Opção 1", false),
                    QuestionOption(1,2,"Opção 2", false),
                    QuestionOption(2,2,"Opção 3", true),
                    QuestionOption(3,2,"Opção 4", false),
                    QuestionOption(4,2,"Opção 5", false)
                )
            )
        )
        questionsList.value = list
    }

    fun checkAnswer(selectedOption:Int){
        val option = currentQuestion.value?.options?.get(selectedOption)
        if (option?.isCorrect == true){
            score.value = score.value?.plus(1)
        }
        nextQuestion()
    }
}