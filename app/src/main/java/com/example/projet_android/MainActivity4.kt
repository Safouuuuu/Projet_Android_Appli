package com.example.projet_android

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity4 : AppCompatActivity() {
    lateinit var nav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        nav = findViewById(R.id.barre_de_navigation)
        val jour = findViewById<TextView>(R.id.textView36)

        jour.setOnClickListener {
            val intent = Intent(this, Suite_Calendrier::class.java)
            startActivity(intent)
        }

        nav.setOnItemSelectedListener(object : NavigationBarView.OnItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.home -> {
                        val intent = Intent(this@MainActivity4, MainActivity::class.java)
                        startActivity(intent)
                    }

                    R.id.recherche -> {
                        val intent = Intent(this@MainActivity4, MainActivity::class.java)
                        startActivity(intent)
                    }

                    R.id.calendrier -> {

                    }

                    R.id.profil -> {
                        val intent = Intent(this@MainActivity4, MainActivity2::class.java)
                        startActivity(intent)
                    }
                }
                return true
            }
        })
    }
}
