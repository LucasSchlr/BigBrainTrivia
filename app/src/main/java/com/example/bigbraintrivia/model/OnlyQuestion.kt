package com.example.bigbraintrivia.model

import com.google.gson.annotations.SerializedName

class OnlyQuestion(
    @SerializedName("question_id")
    val id: Int,

    @SerializedName("question_text")
    val title: String
) {
    override fun toString(): String {
        return "OnlyQuestion(id=$id, title='$title')"
    }
}