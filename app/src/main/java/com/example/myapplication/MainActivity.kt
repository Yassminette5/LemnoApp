package com.example.myapplication            // ✅ Le package de ton app (à garder identique)

import android.content.Intent                // ✅ Pour lancer une autre Activity
import android.os.Bundle                     // ✅ État/arguments d'une Activity Android
import android.widget.Button                // ✅ Accès au widget Button
import android.widget.ImageView             // ✅ Accès au widget ImageView
import androidx.activity.enableEdgeToEdge    // ✅ API Material pour gérer les bords (status/nav bars)
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {   // ✅ Activity d'entrée (écran 1)
    override fun onCreate(savedInstanceState: Bundle?) { // ✅ Point d’entrée quand l’écran est créé
        super.onCreate(savedInstanceState)              // ✅ Appelle la version parent
        enableEdgeToEdge()                              // ✅ Étend le contenu derrière status/nav bars (look moderne)
        setContentView(R.layout.activity_main)          // ✅ Lie l’UI au layout res/layout/activity_main.xml

        // ✅ Ajuste les marges pour que le contenu ne passe pas sous les barres système
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ✅ 1) Récupère la référence de l'image cliquable dans activity_main.xml
        val ivLemonTree: ImageView = findViewById(R.id.ivLemonTree)

        // ✅ 2) Quand on clique l’image → on ouvre la 2ᵉ page (SecondActivity)
        ivLemonTree.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java) // ✅ Prépare la "navigation" vers SecondActivity
            startActivity(intent)                                 // ✅ Lance la 2ᵉ Activity
        }

        // ✅ 3) Nouveau bouton pour tester le pipeline (simple log/placeholder)
        val btnTestPipeline: Button = findViewById(R.id.btnTestPipeline)
        btnTestPipeline.setOnClickListener {
            // Ici tu peux plus tard ajouter une action spécifique si tu veux
            // Pour l’instant, c’est juste une modification fonctionnelle pour ton commit
        }
    }
}
