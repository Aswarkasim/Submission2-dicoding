package com.example.matchscheduleok.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.matchscheduleok.R
import com.example.matchscheduleok.adapter.SearchAdapter
import com.example.matchscheduleok.api.ApiRepository
import com.example.matchscheduleok.model.MatchModel
import com.example.matchscheduleok.presenter.SearchPresenter
import com.example.matchscheduleok.view.SearchView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_search.*
import org.jetbrains.anko.startActivity

class SearchActivity : AppCompatActivity(), SearchView {


    private val events: MutableList<MatchModel> = mutableListOf()
    private lateinit var adapter: SearchAdapter
    private lateinit var presenter: SearchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)


        button_param_search.setOnClickListener {
            recycler_search.layoutManager = LinearLayoutManager(this)
            adapter = SearchAdapter(events){
                startActivity<DetailMatchActivity>(DetailMatchActivity.EXTRA_DATA_DETAIL to it)
            }
            recycler_search.adapter = adapter


            val param = EditText_parameter_search.text.toString()
            presenter = SearchPresenter(this, ApiRepository(), Gson())
            presenter.getSearchPresenter(param)
        }
    }

    override fun showSearchEvent(data: List<MatchModel>) {
        events.clear()
        events.addAll(data)
        adapter.notifyDataSetChanged()
    }
}
