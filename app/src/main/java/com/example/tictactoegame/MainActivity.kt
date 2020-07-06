package com.example.tictactoegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //var btns = Array<Button>(3,(3)->Button)

    var player1: Int = 0
    var player2: Int = 0
    var count: Int = 0
    var player1Turn = true
    //var textview_player1 : TextView = TODO()
    //var textview_player2 : TextView = TODO()
    var resetButton : Button = TODO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textview_player1 = findViewById<TextView>(R.id.text_view_player1) as TextView
        var textview_player2 = findViewById<TextView>(R.id.text_view_player2) as TextView

        resetButton= findViewById(R.id.button_reset) as Button

        //btns[0][0] = findViewById(R.id.button_00) as Button
    }
}