package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }


       

        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val edtPeso : EditText = findViewById(R.id.edtPeso)
        val edtAltura : EditText = findViewById(R.id.edtAltura)



        btnCalcular.setOnClickListener {

            val altura: Float = edtAltura.text.toString().toFloat()
            val alturaFinal: Float = altura * altura
            val peso: Float = edtPeso.text.toString().toFloat()
            val result: Float = peso / alturaFinal



            val intent = Intent(this, ResultActivity2::class.java)
                .apply {
                    putExtra("EXTRA_RESULT", result)
                }

            startActivity(intent)
        }
    }
}