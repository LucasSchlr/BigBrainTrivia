package com.example.bigbraintrivia.model

import com.google.gson.annotations.SerializedName

class LeaderBoard(
    @SerializedName(value = "position")
    var position:Int,

    @SerializedName(value = "name")
    val playerName:String,

    @SerializedName(value = "score")
    val score:Double
) {
    override fun toString(): String {
        return "LeaderBoard(position=$position, playerName='$playerName', score=$score)"
    }
}