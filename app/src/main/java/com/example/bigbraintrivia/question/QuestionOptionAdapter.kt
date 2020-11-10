package com.example.bigbraintrivia.question

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.bigbraintrivia.R
import com.example.bigbraintrivia.model.QuestionOption
import kotlinx.android.synthetic.main.question_option_item.view.*

class QuestionOptionAdapter(
        val mContext: Context,
        listEventos:List<QuestionOption>): ArrayAdapter<QuestionOption>(mContext, 0, listEventos) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val option = getItem(position) ?: QuestionOption(0,0, "", false)

            val viewHolder =
                if (convertView != null){
                    convertView.tag as ViewHolder
                } else {
                    val view = LayoutInflater.from(mContext)
                        .inflate(R.layout.question_option_item, parent, false)
                    val holder = ViewHolder(view)
                    view.tag = holder
                    holder
                }

            viewHolder.txtOptionTitle.text = option.title

            return viewHolder.view
        }

        class ViewHolder(val view: View){
            val txtOptionTitle: TextView = view.txtOptionTitle
        }


}