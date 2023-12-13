package com.example.projet_android

import android.app.Dialog
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import org.w3c.dom.Text

class MainActivity2 : AppCompatActivity() {
    lateinit var nav: BottomNavigationView
    private lateinit var popupBTN: TextView
    private lateinit var mDialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val buttonModifPassword = findViewById<TextView>(R.id.textView14)
        buttonModifPassword.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        popupBTN = findViewById(R.id.textView13)
        mDialog = Dialog(this)
        popupBTN.setOnClickListener {
            Log.d("MainActivity2", "Clic détecté")
            mDialog.setContentView(R.layout.popup_profil)
            mDialog.window?.setBackgroundDrawable(ColorDrawable())
        }
        }
        nav = findViewById(R.id.barre_de_navigation)


        nav.setOnItemSelectedListener(object : NavigationBarView.OnItemSelectedListener {

            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.home -> {
                        val intent = Intent(this@MainActivity2, MainActivity::class.java)
                        startActivity(intent)
                    }

                    R.id.recherche -> {
                        val intent = Intent(this@MainActivity2, MainActivity::class.java)
                        startActivity(intent)
                    }

                    R.id.calendrier -> {
                        val intent = Intent(this@MainActivity2, MainActivity4::class.java)
                        startActivity(intent)
                    }

                    R.id.profil -> {
                        val intent = Intent(this@MainActivity2, MainActivity2::class.java)
                        startActivity(intent)
                    }
                }
                return true
            }
        })
    }
}