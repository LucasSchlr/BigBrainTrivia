package com.example.bigbraintrivia.leaderboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bigbraintrivia.model.LeaderBoard

class LeaderBoardViewModel : ViewModel() {

    val listLeaderBoard = MutableLiveData<List<LeaderBoard>>()

    fun loadLeaderBoard(){
        listLeaderBoard.value = listOf(
            LeaderBoard(1, "lucas", 10.0),
            LeaderBoard(2, "schuler", 10.0),
            LeaderBoard(3, "costa", 10.0),
            LeaderBoard(4, "eduardo viado", 10.0)
        )
    }
}