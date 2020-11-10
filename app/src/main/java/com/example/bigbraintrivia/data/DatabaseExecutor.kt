package com.example.bigbraintrivia.data

import java.sql.Connection

class DatabaseExecutor{
    private var connection: Connection = MySQLConnector.connection

    fun executeQuery(query: String) {
        var result = connection.createStatement().executeQuery(query)

        while (result.next()) {
            var id = result.getInt(("id"))

            println(id.toString() + ") " + result.getString(("username")) + ":" + result.getString(("password")))
        }
    }
}