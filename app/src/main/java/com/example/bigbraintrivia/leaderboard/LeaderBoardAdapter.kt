package com.example.bigbraintrivia.leaderboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.bigbraintrivia.R
import com.example.bigbraintrivia.model.LeaderBoard
import com.example.bigbraintrivia.model.QuestionOption
import kotlinx.android.synthetic.main.leaderboard_item.view.*
import kotlinx.android.synthetic.main.question_option_item.view.*

class LeaderBoardAdapter(
    val mContext: Context,
    listEventos:List<LeaderBoard>): ArrayAdapter<LeaderBoard>(mContext, 0, listEventos) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val leaderBoard = getItem(position) ?: LeaderBoard(0, "", 0.0)

        val viewHolder =
            if (convertView != null){
                convertView.tag as ViewHolder
            } else {
                val view = LayoutInflater.from(mContext)
                    .inflate(R.layout.leaderboard_item, parent, false)
                val holder = ViewHolder(view)
                view.tag = holder
                holder
            }

        viewHolder.txtScore.text = leaderBoard.score.toString()
        viewHolder.txtName.text = leaderBoard.playerName
        viewHolder.txtPosition.text = leaderBoard.position.toString()

        return viewHolder.view
    }

    class ViewHolder(val view: View){
        val txtScore: TextView = view.txtScore
        val txtName: TextView = view.txtName
        val txtPosition: TextView = view.txtPosition
    }
}