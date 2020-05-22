package com.example.matchscheduleok.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.matchscheduleok.BuildConfig.BASE_URL
import com.example.matchscheduleok.R
import com.example.matchscheduleok.fragment.LastMatchFragment
import com.example.matchscheduleok.fragment.NextMatchFragment
import kotlinx.android.synthetic.main.activity_match.*
import org.jetbrains.anko.*

class MatchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)

        val idLeague = intent.getStringExtra("idLeague")
        val nameLeague = intent.getStringExtra("nameLeague")

        val adapter = MatchViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(LastMatchFragment(idLeague), "Last Fragment")
        adapter.addFragment(NextMatchFragment(idLeague), "Next Match")
        ViewPagerMatch.adapter = adapter
        tabMatch.setupWithViewPager(ViewPagerMatch)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.btn_searchMenu -> {
                startActivity<SearchActivity>()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu, menu)
        return super.onCreateOptionsMenu(menu)


    }

    class MatchViewPagerAdapter(manager: FragmentManager): FragmentPagerAdapter(manager){

        private val fragmentList: MutableList<Fragment> = ArrayList()
        private val titleList: MutableList<String> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String){
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }

    }
}
