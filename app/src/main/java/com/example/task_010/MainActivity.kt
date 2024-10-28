package com.example.task_010

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var data1ET: EditText
    private lateinit var data2ET: EditText
    private lateinit var calculateBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        data1ET      = findViewById(R.id.data1ET)
        data2ET      = findViewById(R.id.data2ET)
        calculateBTN = findViewById(R.id.calculateBTN)

        calculateBTN.setOnClickListener{
            val humanGrowth = data1ET.text.toString()
            val humanWeight = data2ET.text.toString()

            if (humanGrowth != "" && humanWeight != "")
            {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("humanGrowth", humanGrowth)
                intent.putExtra("humanWeight", humanWeight)
                startActivity(intent)
            }
        }
    }
}