package com.example.plantshandbook

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plantshandbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val adapter = PlantAdapter()
    private var editLauncher: ActivityResultLauncher<Intent>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Your minions"
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                adapter.addPlant(it.data?.getSerializableExtra("plant") as Plant)
            }
        }
        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.add -> openAddActivity()
                R.id.menu -> binding.drawer.openDrawer(GravityCompat.START)
            }
            return@setOnItemSelectedListener true
        }

        binding.apply {
            navView.setNavigationItemSelectedListener {
                when(it.itemId) {
                    R.id.item1 -> Toast.makeText(this@MainActivity, R.string.sideMenuText, Toast.LENGTH_LONG).show()
                }
                true
            }
        }
    }

    private fun openAddActivity() = with(binding) {
        recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 3)
        recyclerView.adapter = adapter
        editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.add) {
            openAddActivity()
            //openAddActivity()
        }
        return true
    }
}