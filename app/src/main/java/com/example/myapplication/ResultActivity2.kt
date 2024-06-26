package com.example.myapplication

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result2)


        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


            val tvResult = findViewById<TextView>(R.id.textview_result)
            val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)
            val result = intent.getFloatExtra("EXTRA_RESULT",0.1f)

            tvResult.text = result.toString()

        var classificacao =""

        if(result < 18.5f){
            classificacao = "Under Weight"
        }  else if (result >=18.5f && result <= 24.9f ){
            classificacao = "Normal"
        }  else if (result >= 25f && result <= 29.9f ){
            classificacao = "Overweight"
        }  else if (result >= 30f && result <= 39.9){
            classificacao = "Obese"
        } else {
            classificacao += "Super Obese"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)


        }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

    }
