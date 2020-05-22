package com.example.matchscheduleok.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.matchscheduleok.R
import com.example.matchscheduleok.model.MatchModel

class SearchAdapter (private val events: List<MatchModel>, private val listener:(MatchModel)->Unit): RecyclerView.Adapter<SearchViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellrow = layoutInflater.inflate(R.layout.list_last_match, parent, false)
        return SearchViewHolder(cellrow)
    }

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        return holder.bindItem(events[position], listener)
    }

}

class SearchViewHolder(view: View): RecyclerView.ViewHolder(view){

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