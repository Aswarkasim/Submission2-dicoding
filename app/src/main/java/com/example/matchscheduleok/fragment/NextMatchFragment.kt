package com.example.matchscheduleok.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.matchscheduleok.R
import com.example.matchscheduleok.adapter.LastMatchAdapter
import com.example.matchscheduleok.adapter.NextMatchAdapter
import com.example.matchscheduleok.api.ApiRepository
import com.example.matchscheduleok.main.DetailMatchActivity
import com.example.matchscheduleok.model.MatchModel
import com.example.matchscheduleok.presenter.NextMAtchPresenter
import com.example.matchscheduleok.view.MatchView
import com.example.matchscheduleok.view.NextView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_next_match.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * A simple [Fragment] subclass.
 */
class NextMatchFragment(private val idLeague: String?) : Fragment(), NextView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next_match, container, false)
    }



    private lateinit var adapter: NextMatchAdapter
    private lateinit var presenter: NextMAtchPresenter
    private val events: MutableList<MatchModel> = mutableListOf()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recycler_next_match.layoutManager = LinearLayoutManager(activity)
        adapter = NextMatchAdapter(events){
            startActivity<DetailMatchActivity>(DetailMatchActivity.EXTRA_DATA_DETAIL to it)
        }
        recycler_next_match.adapter = adapter

        presenter = NextMAtchPresenter(this, ApiRepository(), Gson())
        presenter.getNextMatch(idLeague)
    }


    override fun showNextList(data: List<MatchModel>) {
        events.clear()
        events.addAll(data)
        adapter.notifyDataSetChanged()
    }


}

