package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar   // ✅ pour l'UI popup en bas

class SecondActivity : AppCompatActivity() {

    private var squeezeCount = 0   // ✅ compteur de clics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lemon)
        supportActionBar?.title = "Lemonade"

        // ✅ vues
        val root: View = findViewById(R.id.second_root)     // racine pour ancrer le Snackbar
        val ivLemon: ImageView = findViewById(R.id.ivLemon) // image à cliquer

        // ✅ ajustement des insets (comme chez toi)
        ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        // ✅ logique de clic
        ivLemon.setOnClickListener {
            squeezeCount++

            if (squeezeCount < 4) {
                // message type: "Squeeze count: 2, keep squeezing!"
                val msg = "Squeeze count: $squeezeCount, keep squeezing!"
                Snackbar.make(root, msg, Snackbar.LENGTH_SHORT).show()
            } else {
                // 4e clic → message + page suivante
                Snackbar.make(root, "All juice extracted! 🍋", Snackbar.LENGTH_SHORT).show()
                startActivity(Intent(this, ThirdActivity::class.java))
                finish() // optionnel: ferme cette page pour ne pas revenir dessus
            }
        }
    }
}
