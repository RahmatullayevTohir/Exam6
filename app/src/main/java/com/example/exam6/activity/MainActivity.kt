package com.example.exam6.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exam6.R
import com.example.exam6.adapter.CardsAdapter
import com.example.exam6.database.AppDatabase
import com.example.exam6.model.Card
import com.example.exam6.networking.ApiClint
import com.example.exam6.networking.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val cards: ArrayList<Card> = ArrayList()
    lateinit var adapter:CardsAdapter
    lateinit var imageView: ImageView
    lateinit var recyclerView: RecyclerView
    private lateinit var retrofitService: RetrofitService
    private lateinit var appDatabase: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appDatabase = AppDatabase.getInstance(this)
        retrofitService = ApiClint.createService(RetrofitService::class.java)

        initViews()
        setObservers()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        refreshAdapter()
        imageView = findViewById(R.id.iv_add_cards)
        imageView.setOnClickListener {
            openSecondActivity()
        }
    }

    fun openSecondActivity(){
        val intent = Intent(this,SecondActivity::class.java)
        startActivity(intent)
    }

    private fun setObservers() {
        retrofitService.getCards().enqueue(object : Callback<List<Card>> {

            override fun onResponse(call: Call<List<Card>>, response: Response<List<Card>>) {
                cards.addAll(response.body()!!)
                Log.d("RESPONSE",response.body()!!.size.toString())
                adapter.addAll(cards)
                adapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<Card>>, t: Throwable) {
                Log.d("ERRROORR",t.message.toString())
            }
        })

    }
    private fun refreshAdapter() {
        adapter = CardsAdapter(MainActivity(),cards)
        recyclerView.adapter = adapter
    }
    
}