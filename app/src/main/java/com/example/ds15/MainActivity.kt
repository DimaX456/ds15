package com.example.ds15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.ds15.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recipeList = Recipe.getRecipesFromFile("recipes.json", this)
            val adapter = RecipeAdapter(this, recipeList)
        listView = binding.recipeListView
        listView.adapter = adapter

        val context = this
        listView.setOnItemClickListener {_, _, position, _ ->
            val selectedRecipe = recipeList[position]
            val detailIntent = RecipeDetailActivity.newIntent(context, selectedRecipe)
            startActivity(detailIntent)
        }
    }
}