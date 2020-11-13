package com.example.bigbraintrivia.data

fun main(args: Array<String>) {
    val database = DatabaseImpl()
    database.insertLeaderboardEntry("pagode", 100.toDouble())
}
