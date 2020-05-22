package com.example.matchscheduleok.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.matchscheduleok.R
import com.example.matchscheduleok.model.MatchModel
import com.example.matchscheduleok.view.MatchView

class NextMatchAdapter(private val events: List<MatchModel>, private val listener: (MatchModel)->Unit): RecyclerView.Adapter<NextMatchHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NextMatchHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellRow = layoutInflater.inflate(R.layout.list_next_match, parent, false)
        return NextMatchHolder(cellRow)
    }

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: NextMatchHolder, position: Int) {
        holder.bindItem(events[position], listener)

    }

}

class NextMatchHolder(view: View): RecyclerView.ViewHolder(view){
    private val date = view.findViewById<TextView>(R.id.textView_date_NextMatch)
    private val homeTeam = view.findViewById<TextView>(R.id.textView_HomeTeam_NextMatch)
    private val homeTeamScore = view.findViewById<TextView>(R.id.textView_home_score_matchNextMatch)

    private val awayTeam = view.findViewById<TextView>(R.id.textView_away_team_NextMatch)
    private val awayTeamScore = view.findViewById<TextView>(R.id.textView_away_score_matchNextMatch)

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