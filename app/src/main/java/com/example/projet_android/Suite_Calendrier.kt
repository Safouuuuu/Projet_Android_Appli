package com.example.projet_android

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class Suite_Calendrier : AppCompatActivity() {
    lateinit var nav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suite_calendrier)
        nav = findViewById(R.id.barre_de_navigation)


        nav.setOnItemSelectedListener(object : NavigationBarView.OnItemSelectedListener {

            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.home -> {
                        val intent = Intent(this@Suite_Calendrier, MainActivity::class.java)
                        startActivity(intent)
                    }

                    R.id.recherche -> {
                        val intent = Intent(this@Suite_Calendrier, MainActivity::class.java)
                        startActivity(intent)
                    }

                    R.id.calendrier -> {
                        val intent = Intent(this@Suite_Calendrier, MainActivity4::class.java)
                        startActivity(intent)
                    }

                    R.id.profil -> {
                        val intent = Intent(this@Suite_Calendrier, MainActivity2::class.java)
                        startActivity(intent)
                    }
                }
                return true
            }
        })
        }
    }