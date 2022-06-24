package com.biybiruza.redbook.ui

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.biybiruza.redbook.R
import com.biybiruza.redbook.ui.animal.AnimalFragment

class MainActivity : AppCompatActivity() {

    companion object{
        const val TYPE_ID = "type_id"
        const val INVERTEBRATES = 1
        const val FISHES = 2
        const val REPTILES = 3
        const val BIRDS = 4
        const val MAMMALS = 5
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val fragment = AnimalFragment()
        val bundle = Bundle()
        bundle.putInt(TYPE_ID, INVERTEBRATES)
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,fragment).commit()

        navView.setNavigationItemSelectedListener {
            val bFragment = AnimalFragment()
            val bBundle = Bundle()
            when(it.itemId){
                R.id.nav_invertebrates -> {
                    bBundle.putInt(TYPE_ID, INVERTEBRATES)
                    bFragment.arguments = bBundle }
                R.id.nav_fishes -> {
                    bBundle.putInt(TYPE_ID, FISHES)
                    bFragment.arguments = bBundle}
                R.id.nav_reptiles -> {
                    bBundle.putInt(TYPE_ID, REPTILES)
                    bFragment.arguments = bBundle}
                R.id.nav_birds -> {
                    bBundle.putInt(TYPE_ID, BIRDS)
                    bFragment.arguments = bBundle}
                R.id.nav_mammals -> {
                    bBundle.putInt(TYPE_ID, MAMMALS)
                    bFragment.arguments = bBundle}
                else -> return@setNavigationItemSelectedListener false
            }
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,bFragment).commit()
            drawerLayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

}