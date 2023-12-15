package com.example.projet_android

import android.app.Dialog
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity2 : AppCompatActivity() {
    lateinit var nav: BottomNavigationView
    lateinit var textViewAdresseMail: TextView
    lateinit var textViewPseudo: TextView
    lateinit var textViewNumeroTel: TextView
    private lateinit var popupBTN: Button
    private lateinit var mDialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val buttonModifPassword = findViewById<Button>(R.id.modifier_profil)

        //Relier les variables aux TextView ou je veux mettre mes données
        textViewAdresseMail= findViewById(R.id.adresse_mail)
        textViewPseudo= findViewById(R.id.pseudo)
        textViewNumeroTel= findViewById(R.id.tel)
        //Récupérer nos données de l'Intent
        val adresseMail = intent.getStringExtra("Adresse Mail")
        val pseudo = intent.getStringExtra("Pseudo")
        val tel = intent.getStringExtra("Numero_Tel")
        //Mettre les données dans les TextView
        textViewAdresseMail.text = adresseMail
        textViewPseudo.text = pseudo
        textViewNumeroTel.text = tel

        buttonModifPassword.setOnClickListener {
            val intent = Intent(this, Modfications::class.java)
            startActivity(intent)
        popupBTN = findViewById(R.id.modifier_profil)
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