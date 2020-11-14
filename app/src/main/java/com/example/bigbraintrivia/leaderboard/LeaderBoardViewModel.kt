package com.example.bigbraintrivia.leaderboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bigbraintrivia.IDatabase
import com.example.bigbraintrivia.data.DatabaseImpl
import com.example.bigbraintrivia.model.LeaderBoard
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LeaderBoardViewModel : ViewModel() {
    private val database: IDatabase = DatabaseImpl()
    private val uiScope = CoroutineScope(Dispatchers.Default)

    val listLeaderBoard = MutableLiveData<List<LeaderBoard>>()

    fun loadLeaderBoard(){


        uiScope.launch {
            val leaderboard = database.getLeaderboard()
            CoroutineScope(Dispatchers.Main).launch{listLeaderBoard.value = leaderboard}
        }

//        listLeaderBoard.value = listOf(
//            LeaderBoard(1, "lucas", 10.0),
//            LeaderBoard(2, "schuler", 10.0),
//            LeaderBoard(3, "costa", 10.0),
//            LeaderBoard(4, "eduardo viado", 10.0)
//        )
    }
}