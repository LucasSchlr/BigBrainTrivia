package com.example.bigbraintrivia.question

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.bigbraintrivia.BigBrainTrivia
import com.example.bigbraintrivia.R
import com.example.bigbraintrivia.model.Question
import kotlinx.android.synthetic.main.activity_question_activity.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class QuestionActivity : AppCompatActivity() {
    private val viewModel: QuestionViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_activity)

        viewModel.currentQuestion.observe(this, Observer { question ->
            setupQuestion(question)
        })

        viewModel.score.observe(this, Observer { score ->
            txtScore.text = getString(R.string.score, score)
        })

        viewModel.inGame.observe(this, Observer { inGame ->
            if (!inGame) {
                finish()
            }
        })

        listOptions.setOnItemClickListener { _, _, position, _ ->
            viewModel.checkAnswer(position)
        }
        viewModel.usuario = (getApplication() as BigBrainTrivia).usuario
        viewModel.loadQuestions()
    }

    fun setupQuestion(question: Question){
        txtTitle.text = question.title
        listOptions.adapter = QuestionOptionAdapter(this,  question.options )

    }

    companion object {
        fun open (activity: Activity){
            activity.startActivity(
                Intent(activity, QuestionActivity::class.java)
            )
        }
    }
}
