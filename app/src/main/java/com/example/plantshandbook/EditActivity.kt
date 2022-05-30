package com.example.plantshandbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.plantshandbook.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    lateinit var binding: ActivityEditBinding
    private var imageIndex = 0
    var image = R.drawable.minion1
    private val imageList = getList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Edit minion"
        initButtons()
    }

    private fun initButtons() = with(binding){
        nextButton.setOnClickListener {
            imageIndex++
            if (imageIndex > imageList.size - 1) imageIndex = 0
            image = imageList[imageIndex]
            imageView.setImageResource(image)
        }

        doneButton.setOnClickListener {
            val title = editTitle.text.toString()
            val description = editDescription.text.toString()
            val plant = Plant(image, title, description)
            val editIntent = Intent().apply {
                putExtra("plant", plant)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }

    private fun getList() : List<Int> {
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