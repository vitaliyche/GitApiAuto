package com.codeliner.vitalchernavsky

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.codeliner.vitalchernavsky.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private var moviesBinding: ActivityMainBinding? = null
    private val binding get() = moviesBinding!!

    private var currentMenuItemId = R.id.menu_find_repository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        moviesBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = Navigation.findNavController(this, R.id.nav_host)
        setBottomNavListener()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun setBottomNavListener() {
        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_find_repository -> { currentMenuItemId = R.id.menu_find_repository }
                R.id.menu_favourite -> { currentMenuItemId = R.id.menu_favourite }
            }
            true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        moviesBinding = null

    }

    companion object {
        var REQUEST = "retrofit+kotlin"
    }
}