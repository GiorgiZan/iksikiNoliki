package com.example.iksikinoliki

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.ArrayList

open class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var resetButton: Button
    private lateinit var editScore1: EditText
    private lateinit var editScore2: EditText
    private lateinit var restartButton: Button
    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()
    private var activePlayer = 1
    var count = 0
    var count2 = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        resetButton = findViewById(R.id.resetButton)
        restartButton = findViewById(R.id.restartButton)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

        editScore1 = findViewById(R.id.score1)
        editScore2 = findViewById(R.id.score2)



        resetButton.setOnClickListener() {
            button1.setText(null)

            button1.isEnabled = true
            button2.setText(null)

            button2.isEnabled = true
            button3.setText(null)

            button3.isEnabled = true
            button4.setText(null)

            button4.isEnabled = true
            button5.setText(null)

            button5.isEnabled = true
            button6.setText(null)

            button6.isEnabled = true
            button7.setText(null)

            button7.isEnabled = true
            button8.setText(null)

            button8.isEnabled = true
            button9.setText(null)

            button9.isEnabled = true

            firstPlayer.clear()
            secondPlayer.clear()

            activePlayer = 1

        }
        restartButton.setOnClickListener( ){
            count = 0
            count2 = 0
            editScore1.setText("$count")
            editScore2.setText("$count2")


        }

    }


    override fun onClick(clickedview: View?) {
        if (clickedview is Button) {
            var buttonNumber = 0
            when (clickedview.id) {

                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9

            }

            if (buttonNumber != 0) {
                playGame(clickedview, buttonNumber)
            }
        }

    }

    private fun Finish() {
        button1.setEnabled(false)
        button2.setEnabled(false)
        button3.setEnabled(false)
        button4.setEnabled(false)
        button5.setEnabled(false)
        button6.setEnabled(false)
        button7.setEnabled(false)
        button8.setEnabled(false)
        button9.setEnabled(false)

    }


    private fun playGame(clickedview: Button, buttonNumber: Int) {
        if (activePlayer == 1) {
            clickedview.text = "X"
            clickedview.setTextColor(Color.GREEN)
            firstPlayer.add(buttonNumber)
            activePlayer = 2

        } else {
            clickedview.text = "O"
            clickedview.setTextColor(Color.YELLOW)
            secondPlayer.add(buttonNumber)
            activePlayer = 1
        }
        clickedview.isEnabled = false
        check()

    }


    private fun check() {
        var winnerPlayer = 0
        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }

        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }






        if (winnerPlayer == 1) {
            Toast.makeText(this, "First player won", Toast.LENGTH_SHORT).show()

            count += 1
            editScore1.setText("$count")
            Finish()


        } else if (winnerPlayer == 2) {
            Toast.makeText(this, "Second player won", Toast.LENGTH_SHORT).show()

            count2 += 1
            editScore2.setText("$count2")
            Finish()

        } else if (button1.text.isNotEmpty() && button2.text.isNotEmpty() && button3.text.isNotEmpty() && button4.text.isNotEmpty() && button5.text.isNotEmpty() && button6.text.isNotEmpty() && button7.text.isNotEmpty() && button8.text.isNotEmpty() && button9.text.isNotEmpty()) {
            Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show()

        }

    }


}






