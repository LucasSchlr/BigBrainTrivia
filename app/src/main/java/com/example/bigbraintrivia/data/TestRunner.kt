package com.example.bigbraintrivia.data

fun main(args: Array<String>) {
    val database = DatabaseImpl()
    val result = database.getQuestions()

    println(result)
}
