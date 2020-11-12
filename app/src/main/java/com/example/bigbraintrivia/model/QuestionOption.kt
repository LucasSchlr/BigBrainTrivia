package com.example.bigbraintrivia.model

import com.google.gson.annotations.SerializedName

class QuestionOption(
    @SerializedName("answer_id")
    val id:Int,

    @SerializedName("question_id")
    val questionId:Int,

    @SerializedName("answer_text")
    val title:String,

    @SerializedName("answer_is_correct")
    val isCorrect:Boolean
) {
    override fun toString(): String {
        return "QuestionOption(id=$id, questionId=$questionId, title='$title', isCorrect=$isCorrect)"
    }
}