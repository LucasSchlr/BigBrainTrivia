package com.example.bigbraintrivia.model

import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName(value = "name")
    val nome:String,

    @SerializedName(value = "password")
    val password:String
)