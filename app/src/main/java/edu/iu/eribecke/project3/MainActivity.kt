package edu.iu.eribecke.project3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    //creating private variables
    private lateinit var selDif: RadioButton
    private lateinit var selOp: RadioButton
    private var questionNum = ""
    private var count = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_menu)
        //creating variables
        val startButton = findViewById<Button>(R.id.start)
        val plusButton = findViewById<Button>(R.id.plus)
        val minusButton = findViewById<Button>(R.id.minus)
        var numOfQ = findViewById<TextView>(R.id.num)
        val easy = findViewById<RadioButton>(R.id.easy)
        val med = findViewById<RadioButton>(R.id.medium)
        val hard = findViewById<RadioButton>(R.id.hard)
        val add = findViewById<RadioButton>(R.id.addition)
        val sub = findViewById<RadioButton>(R.id.subtraction)
        val mult = findViewById<RadioButton>(R.id.multiply)
        val div = findViewById<RadioButton>(R.id.division)
        var operand = 0
        var operator = ""


        //handles what happens after start button is clicked
        startButton.setOnClickListener {
            //creating a new intent activity to switch to the question screen
            val i = Intent(this, questions::class.java)
            i.putExtra("Operand", operand)
            i.putExtra("Operator", operator)
            i.putExtra("qNum", count)
            startActivity(i)
        }
        //updates variables based on selected radio buttons
        easy.setOnClickListener() {
            operand = 10
        }
        med.setOnClickListener() {
            operand = 25
        }
        hard.setOnClickListener() {
            operand = 50
        }
        add.setOnClickListener() {
            operator = "+"
        }
        sub.setOnClickListener() {
            operator = "-"
        }
        mult.setOnClickListener() {
            operator = "X"
        }
        div.setOnClickListener() {
            operator = "/"
        }
        plusButton.setOnClickListener {
            count++
            numOfQ.text = count.toString()

        }
        minusButton.setOnClickListener {
            if (count > 1) {
                count--
                numOfQ.text = count.toString()
            }
        }

    }
}