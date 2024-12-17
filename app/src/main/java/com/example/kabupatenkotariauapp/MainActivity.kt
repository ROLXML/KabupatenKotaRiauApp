package com.example.kabupatenkotariauapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.polbeng.SyahrulRidwan.kabupatenkotariauapp.R
import id.ac.polbeng.SyahrulRidwan.kabupatenkotariauapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var title: String = "Mode List View"
    private var listData: ArrayList<KabKota> = arrayListOf()
    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding . inflate (layoutInflater)
        setContentView (binding.root)
        setActionBarTitle (title)
        listData . addAll (KabKotaData.listDataKabKota)
        showRecyclerList ()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                title = "Mode List View"

                showRecyclerList ()
            }

            R.id.action_grid -> {
                title = "Mode Grid View"
            }

            R.id.action_cardview -> {
                title = "Mode Card View"
            }
        }
        setActionBarTitle (title)
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    private fun showRecyclerList() {
        binding.rvKabKota.layoutManager = LinearLayoutManager(this)
        val kabKotaAdapter =
            ListKabKotaAdapter(listData)
        binding . rvKabKota . adapter = kabKotaAdapter
    }
}