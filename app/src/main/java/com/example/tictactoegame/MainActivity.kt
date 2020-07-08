package com.example.tictactoegame

import android.R.attr.delay
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener  {

    //var btns = Array<Button>(3,(3)->Button)

    lateinit var buttons: Array<Button>

//    var buttons= arrayOf(Button)
    var player1: Int = 0
    var player2: Int = 0
    var roundCount: Int = 0
    var count: Int = 0
    var player1Turn = true
    //var textview_player1 : TextView = TODO()
    //var textview_player2 : TextView = TODO()
//    var resetButton : Button = TODO()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textview_player1 = findViewById<TextView>(R.id.text_view_player1) as TextView
        var textview_player2 = findViewById<TextView>(R.id.text_view_player2) as TextView
        val resetButton= findViewById(R.id.button_reset) as Button

        resetButton.setOnClickListener {
            resetGame()
        }

       buttons = arrayOf(findViewById(R.id.button_00),
           findViewById(R.id.button_01),
           findViewById<Button>(R.id.button_02),
           findViewById(R.id.button_10),
           findViewById(R.id.button_11),
           findViewById<Button>(R.id.button_12),
           findViewById(R.id.button_20),
           findViewById(R.id.button_21),
           findViewById<Button>(R.id.button_22)
       )

        for (i in 0..8) {
                buttons[i].setOnClickListener(this)
        }

        println("before check")


    }

    fun player1Win(){
        player1++
        Toast.makeText(this,"Player 1 wins",Toast.LENGTH_SHORT).show()
    }

    fun player2Win(){
        player2++
        Toast.makeText(this,"Player 2 wins",Toast.LENGTH_SHORT).show()
    }

    fun draw(){
        Toast.makeText(this,"Draw",Toast.LENGTH_SHORT).show()
        resetBoard()
    }

    fun updatePoints(){
        text_view_player1.setText("Player 1 : "+player1)
        text_view_player2.setText("Player 1 : "+player2)

    }

    fun resetGame(){
        player1=0;
        player2=0;
        updatePoints();
        resetBoard();
    }

    fun resetBoard(){
        for(i in 0..8)
           buttons[i].text=""
        roundCount=0;
        player1Turn=true
    }

    override fun onClick(v: View?) {
        println("hello")
        val b = v as Button

        if(!b.text.toString().equals(""))
        {
            return
        }
        if(player1Turn){
            b.text = "X"
        }
        else{
            b.text = "0"
        }
        roundCount++

        if(checkWin()){
            if(player1Turn){
                player1Win()
                updatePoints()
                resetBoard()
            }
            else{
                player2Win()
                updatePoints()
                resetBoard()
            }
        }
        else if(roundCount==9){
            draw()
        }
        else{
            player1Turn = !player1Turn
        }

    }

    fun checkWin(): Boolean{
        println("checkWin")
        var field = arrayOf("","","","","","","","","")
        for (i in 0..8) {
                field[i] = buttons[i].text.toString()
            }

        for(i in 0..2){
            if((field[i*3].equals(field[i*3 + 1]))  && (field[i*3].equals(field[i*3 + 2])) && !(field[i*3].equals(""))){
                return true
            }
        }

        for(i in 0..2){
            if((field[i].equals(field[i+ 3]))  && (field[i].equals(field[i+6])) && !(field[i].equals(""))){
                return true
            }
        }

        if((field[0].equals(field[4]))  && (field[0].equals(field[8])) && !(field[0].equals(""))){
            return true
        }

        if((field[2].equals(field[4]))  && (field[2].equals(field[6])) && !(field[2].equals(""))){
            return true
        }

    return false
    }

}

