package com.example.matchscheduleok.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.matchscheduleok.R
import com.example.matchscheduleok.adapter.LastMatchAdapter
import com.example.matchscheduleok.api.ApiRepository
import com.example.matchscheduleok.main.DetailMatchActivity
import com.example.matchscheduleok.model.MatchModel
import com.example.matchscheduleok.presenter.LastMatchPresenter
import com.example.matchscheduleok.view.MatchView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_last_match.*
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast

/**
 * A simple [Fragment] subclass.
 */
class LastMatchFragment(private val idLeague: String?) : Fragment(), MatchView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_last_match, container, false)

       // recycler_last_match.layoutManager = LinearLayoutManager(ctx)
    }

    private lateinit var adapter: LastMatchAdapter
    private val events: MutableList<MatchModel> = mutableListOf()
    private lateinit var presenter: LastMatchPresenter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


            recycler_last_match.layoutManager = LinearLayoutManager(context)
            adapter = LastMatchAdapter(events) {
                startActivity<DetailMatchActivity>(DetailMatchActivity.EXTRA_DATA_DETAIL to it)
            }
            recycler_last_match.adapter = adapter

            presenter = LastMatchPresenter(this, ApiRepository(), Gson())
            presenter.getLastMatchList(idLeague)
        }


    override fun showMatchList(data: List<MatchModel>) {
        events.clear()
        events.addAll(data)
        adapter.notifyDataSetChanged()
    }


}
