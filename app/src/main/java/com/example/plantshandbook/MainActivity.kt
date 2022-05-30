package com.example.plantshandbook

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plantshandbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val adapter = PlantAdapter()
    private val imageIdList = getList()
    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() = with(binding) {
        recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 3)
        recyclerView.adapter = adapter
        button.setOnClickListener {
            if (index > 11) index = 0
            val plant = Plant(imageIdList[index], "Plant $index")
            adapter.addPlant(plant)
            index ++
        }
    }

    fun getList() : List<Int> {
        return listOf(
            R.drawable.minion1,
            R.drawable.minion2,
            R.drawable.minion3,
            R.drawable.minion4 ,
            R.drawable.minion5,
            R.drawable.minion6 ,
            R.drawable.minion7 ,
            R.drawable.minion8 ,
            R.drawable.minion9 ,
            R.drawable.minion10,
            R.drawable.minion11,
            R.drawable.minion12)
    }
}