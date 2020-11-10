package com.example.bigbraintrivia.di

import com.example.bigbraintrivia.leaderboard.LeaderBoardViewModel
import com.example.bigbraintrivia.question.QuestionViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val androidModule = module {
    single {this}
    viewModel{
        LeaderBoardViewModel()
    }
    viewModel {
        QuestionViewModel()
    }
}
