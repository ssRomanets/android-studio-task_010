package com.example.task_010

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class ResultActivity : AppCompatActivity() {
    private lateinit var toolbarMain: Toolbar
    private lateinit var resultTV: TextView

    private lateinit var imageViewTV: ImageView
    private lateinit var humanInfoTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        toolbarMain = findViewById(R.id.toolbarMain)
        resultTV    = findViewById(R.id.resultTV)
        imageViewTV = findViewById(R.id.imageViewTV)
        humanInfoTV = findViewById(R.id.humanInfoTV)

        //Фиксируем туллбар
        setSupportActionBar(toolbarMain)
        title = "Вывод результата"

        //Получаем данные и рассчитываем анализируемый коэффициент
        var humanKoeff: Double = 0.0

        var intentIn: Intent
        intentIn = getIntent()

        humanKoeff = intentIn.getStringExtra("humanGrowth")!!.toDouble()/intentIn.getStringExtra("humanWeight")!!.toDouble()
        resultTV.text = humanKoeff.toString()

        outputGeneralInfo(humanKoeff)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return  true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.toBeginMenuMain -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.exitMenuMain->{
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun outputGeneralInfo(humanKoeff: Double)
    {
        if (humanKoeff > 2.9) {
            imageViewTV.setImageResource(R.drawable.human1)
            humanInfoTV.text = "Нужно вести правильный образ жизни."
        }
        else if (humanKoeff <= 2.9 && humanKoeff >= 2.3)
        {
            imageViewTV.setImageResource(R.drawable.human2)
            humanInfoTV.text = "Образ жизни хороший."
        }
        else
        {
            imageViewTV.setImageResource(R.drawable.human3)
            humanInfoTV.text = "Не нужно есть ничего жирного."
        }
    }
}