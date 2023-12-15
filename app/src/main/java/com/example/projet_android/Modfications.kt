package com.example.projet_android

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Modfications : AppCompatActivity() {
    lateinit var input1: EditText
    lateinit var input2: EditText
    lateinit var input3: EditText
    lateinit var btn: Button
    lateinit var root: DatabaseReference



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modfications)
        input1= findViewById(R.id.nouv_adresse)
        input2= findViewById(R.id.nouv_pseudo)
        input3= findViewById(R.id.nouv_tel)
        btn= findViewById(R.id.confirmer_changement)



        root = FirebaseDatabase.getInstance().getReference().child("MyData")
        btn.setOnClickListener{
            val data1= input1.text.toString()
            val data2= input2.text.toString()
            val data3= input3.text.toString()
            val hashmap = HashMap<String, Any>()
            hashmap["Adresse_Mail"] = data1
            hashmap["Pseudo"] = data2
            hashmap["Numéro_Tel"] = data3
            root.child("user1").setValue(hashmap).addOnSuccessListener {
                val intent = Intent(this@Modfications, MainActivity2::class.java)
                startActivity(intent)
                Toast.makeText(this@Modfications, "Modifications enregistrées", Toast.LENGTH_LONG).show()
            }
            root.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        // Récupérer les données de la base de données
                        val adresseMail = snapshot.child("Adresse_Mail").getValue(String::class.java)
                        val pseudo = snapshot.child("Pseudo").getValue(String::class.java)
                        val numeroTel = snapshot.child("Numéro_Tel").getValue(String::class.java)

                        // Mettre les données dans les EditText
                        val intent = Intent(this@Modfications, MainActivity2::class.java)
                        intent.putExtra("Adresse Mail", adresseMail)
                        intent.putExtra("Pseudo", pseudo)
                        intent.putExtra("Numéro_Tel", numeroTel)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Gérer les erreurs de lecture
                    Toast.makeText(this@Modfications, "Erreur de lecture depuis la base de données", Toast.LENGTH_LONG).show()
                }
            })

            }


    }
}