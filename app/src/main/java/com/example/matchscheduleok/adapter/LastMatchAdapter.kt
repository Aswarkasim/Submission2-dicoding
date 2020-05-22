package com.example.matchscheduleok.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.matchscheduleok.R
import com.example.matchscheduleok.model.MatchModel


class LastMatchAdapter(private val events: List<MatchModel>, private val listener: (MatchModel)->Unit):RecyclerView.Adapter<LastMatchHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LastMatchHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellRow = layoutInflater.inflate(R.layout.list_last_match, parent, false)
        return LastMatchHolder(cellRow)
    }

    override fun getItemCount(): Int {
       return events.size
    }

    override fun onBindViewHolder(holder: LastMatchHolder, position: Int) {
        holder.bindItem(events[position], listener)
        Glide.with(holder.itemView.context).load(events)
    }

}

class LastMatchHolder(view: View): RecyclerView.ViewHolder(view){

    private val date = view.findViewById<TextView>(R.id.textView_HomeTeam_LastMatch)
    private val homeTeam = view.findViewById<TextView>(R.id.textView_HomeTeam_LastMatch)
    private val homeTeamScore = view.findViewById<TextView>(R.id.textView_home_score_match)

    private val awayTeam = view.findViewById<TextView>(R.id.textView_away_team_last_match)
    private val awayTeamScore = view.findViewById<TextView>(R.id.textView_away_score_match)

    fun bindItem(event: MatchModel, listener: (MatchModel) -> Unit){
        date.text = event.dateEvent

        homeTeam.text = event.strHomeTeam
        homeTeamScore.text = event.intHomeScore

        awayTeam.text = event.strAwayTeam
        awayTeamScore.text = event.intAwayScore

        itemView.setOnClickListener {
            listener(event)
        }
    }
}