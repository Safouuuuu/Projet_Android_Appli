package com.example.projet_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.projet_android.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.squareup.picasso.Picasso
import javax.annotation.Nonnull
import com.example.projet_android.databinding.ActivityMainBinding as ActivityMainBinding1

class MainActivity : AppCompatActivity() {
    lateinit var nav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav = findViewById(R.id.barre_de_navigation)


        nav.setOnItemSelectedListener(object : NavigationBarView.OnItemSelectedListener {

            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.home -> {
                        val intent = Intent(this@MainActivity, MainActivity::class.java)
                        startActivity(intent)
                    }

                    R.id.recherche -> {
                        val intent = Intent(this@MainActivity, MainActivity::class.java)
                        startActivity(intent)
                    }

                    R.id.calendrier -> {
                        val intent = Intent(this@MainActivity, MainActivity4::class.java)
                        startActivity(intent)
                    }

                    R.id.profil -> {
                        val intent = Intent(this@MainActivity, MainActivity2::class.java)
                        startActivity(intent)
                    }
                }
                return true
            }
        })
    }
}