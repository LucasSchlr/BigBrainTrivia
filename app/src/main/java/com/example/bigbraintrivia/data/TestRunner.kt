package com.example.bigbraintrivia.data

fun main(args: Array<String>) {
    val database = DatabaseImpl()
    val result = database.isLoginValid("pagode", "pagode")

    println(result)
}
