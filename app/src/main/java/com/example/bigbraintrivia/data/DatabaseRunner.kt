package com.example.bigbraintrivia.data

fun main(args: Array<String>) {
    val databaseExecutor = DatabaseExecutor()

    databaseExecutor.executeQuery("SELECT * FROM USERS")
}