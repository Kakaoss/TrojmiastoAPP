package com.example.trjmiastoapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private val items = listOf(
        Item(R.drawable.gdansk, "Gdańsk"),
        Item(R.drawable.gdynia, "Gdynia"),
        Item(R.drawable.sopot, "Sopot")
    )
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recycler_view = findViewById<RecyclerView>(R.id.recycler_view)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = ItemsAdapter(items)

        findViewById<TextView>(R.id.gdansk_text_view).setOnClickListener { showItems(0) }
        findViewById<TextView>(R.id.gdynia_text_view).setOnClickListener { showItems(1) }
        findViewById<TextView>(R.id.sopot_text_view).setOnClickListener { showItems(2) }


    }

    private fun showItems(cityIndex: Int) {
        val cityItems = items.filter { item -> item.title == items[cityIndex].title }
        findViewById<RecyclerView>(R.id.recycler_view).adapter = ItemsAdapter(cityItems)
    }
}