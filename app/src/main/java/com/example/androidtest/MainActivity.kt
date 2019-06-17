package com.example.androidtest

import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup ActionBar
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        setSupportActionBar(findViewById(R.id.toolbar))
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.nav_host_fragment).navigateUp()
    }
}
