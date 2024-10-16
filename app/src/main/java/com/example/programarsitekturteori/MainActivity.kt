package com.example.c_program_arsitektur_apk

import ScoreViewModel
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.programarsitekturteori.R
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private val viewModel: ScoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Menghubungkan UI dengan elemen-elemen tampilan
        val scoreViewA = findViewById<TextView>(R.id.scoreViewA)
        val scoreViewB = findViewById<TextView>(R.id.scoreViewB)
        val plusOneButtonA = findViewById<Button>(R.id.plusOneButtonA)
        val plusOneButtonB = findViewById<Button>(R.id.plusOneButtonB)

        // Mengamati LiveData untuk memperbarui UI
        viewModel.scoreA.observe(this, Observer { newScore ->
            scoreViewA.text = newScore.toString()
        })

        viewModel.scoreB.observe(this, Observer { newScore ->
            scoreViewB.text = newScore.toString()
        })

        // Menambah skor tim A
        plusOneButtonA.setOnClickListener {
            viewModel.incrementScore(true)
        }

        // Menambah skor tim B
        plusOneButtonB.setOnClickListener {
            viewModel.incrementScore(false)
        }
    }
}