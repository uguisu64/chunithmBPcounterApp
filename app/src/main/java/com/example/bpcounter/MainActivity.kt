package com.example.bpcounter

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        var bp = sharedPref.getInt("bp", 0)
        setBP(bp)

        findViewById<Button>(R.id.button1).setOnClickListener {
            bp += 10
            setBP(bp)
        }
        findViewById<Button>(R.id.button2).setOnClickListener {
            bp += 8
            setBP(bp)
        }
        findViewById<Button>(R.id.button3).setOnClickListener {
            bp += 6
            setBP(bp)
        }
        findViewById<Button>(R.id.button4).setOnClickListener {
            bp += 4
            setBP(bp)
        }
        findViewById<Button>(R.id.setBpButton).setOnClickListener {
            with(findViewById<EditText>(R.id.editTextNumber).text) {
                bp = toString().toIntOrNull() ?: bp
                clear()
            }
            setBP(bp)
        }
    }

    private fun setBP(bp: Int) {
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putInt("bp",bp)
            apply()
        }
        findViewById<TextView>(R.id.bpView).text = "${bp}BP"
    }
}