package com.example.bigbraintrivia.data

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.apache.commons.text.StringEscapeUtils
import java.io.IOException

object DatabaseExecutor {
    private const val path = "http://10.0.2.2/bigbraintrivia/database.php"
    private val client = OkHttpClient()

    fun executeQuery(query: String): String {
        val request: Request = Request.Builder()
            .url(path)
            .post(query.toRequestBody())
            .build()

        client.newCall(request).execute().use { response ->

            if (!response.isSuccessful) throw IOException("Unexpected code $response")
            return StringEscapeUtils.unescapeJava(response.body!!.string())
        }
    }
}