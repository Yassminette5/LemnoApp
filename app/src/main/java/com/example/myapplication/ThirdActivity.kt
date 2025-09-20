package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.lemon_drink)          // <-- ton layout 3
        supportActionBar?.title = "Lemonade"

        val root: View = findViewById(R.id.third_root)
        ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        // 👉 quand on clique l'image du drink → on va vers la page "restart"
        val ivDrink: ImageView = findViewById(R.id.ivLemon)
        ivDrink.setOnClickListener {
            startActivity(Intent(this, RestartActivity::class.java))
            // optionnel: finish() si tu ne veux pas revenir à cette page via "Back"
        }
    }
}
