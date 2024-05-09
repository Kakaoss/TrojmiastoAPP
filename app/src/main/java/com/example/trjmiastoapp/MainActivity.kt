package com.example.trjmiastoapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import android.os.Bundle
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private val GDANSK_ID = R.id.gdansk_text_view
    private val GDYNIA_ID = R.id.gdynia_text_view
    private val SOPOT_ID = R.id.sopot_text_view
    private val GDANSK_DRAWABLE = R.drawable.gdansk
    private val GDYNIA_DRAWABLE = R.drawable.gdynia
    private val SOPOT_DRAWABLE = R.drawable.sopot

    private val items = mutableListOf(
        Item(GDANSK_DRAWABLE, "Gdańsk"),
        Item(GDYNIA_DRAWABLE, "Gdynia"),
        Item(SOPOT_DRAWABLE, "Sopot")

    )

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

        val textViews = listOf(
            GDANSK_ID to "Gdańsk",
            GDYNIA_ID to "Gdynia",
            SOPOT_ID to "Sopot"
        )

        textViews.forEach { (id, title) ->
            findViewById<TextView>(id).setOnClickListener { showItems(title) }
        }
    }

    private fun showItems(cityTitle: String) {
        items.clear()
        val cityItems = items.filter { item -> item.title == cityTitle }
        if (cityTitle == "Gdynia") {
            items.addAll(
                listOf(
                    Item(GDYNIA_DRAWABLE, "Gdynia"),
                    Item(R.drawable.gdynia_blyskawica, "blyskawica"),
                    Item(R.drawable.gdynia_centumnaukiexperyment, "centrum nauki experyment"),
                    Item(R.drawable.gdynia_skwerkociuszki, "skwer kociuszki")

                )
            )
        }
        if (cityTitle == "Sopot") {
            items.addAll(
                listOf(
                    Item(SOPOT_DRAWABLE, "Sopot"),
                    Item(R.drawable.sopot_krzywydomek, "krzywy domek"),
                    Item(R.drawable.sopot_molo, "molo"),
                    Item(R.drawable.sopot_latarniamorska, "latarnia morska")
                )
            )
        }
        if (cityTitle == "Gdańsk") {
            items.addAll(
                listOf(
                    Item(GDANSK_DRAWABLE, "Gdańsk"),
                    Item(R.drawable.gdansk_dugitarg, "dlugi targ"),
                    Item(R.drawable.gdansk_katedraoliwska, "katedra oliwska"),
                    Item(R.drawable.gdansk_parkoliwski, "park oliwski")
                )
            )
        }
        findViewById<RecyclerView>(R.id.recycler_view).adapter = ItemsAdapter(items)
    }
}