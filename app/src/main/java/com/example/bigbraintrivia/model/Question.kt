package com.example.bigbraintrivia.model

import com.google.gson.annotations.SerializedName

class Question(
    @SerializedName("question_id")
    val id:Int,

    @SerializedName("question_text")
    val title:String,

    val options:List<QuestionOption>
) {
    override fun toString(): String {
        return "Question(id=$id, title='$title', options=$options)"
    }
}