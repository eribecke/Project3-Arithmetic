package edu.iu.eribecke.project3

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text


class questions : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_questions)
        //creating variables
        //first three are variables containing information from MainActivity class
        val operand = intent.getIntExtra("Operand", 10)
        val operation = intent.getStringExtra("Operator") ?: "addition"
        val questionNum = intent.getIntExtra("qNum", 1)
        val done = findViewById<Button>(R.id.done)
        var num1Text = findViewById<TextView>(R.id.num1)
        var num2Text = findViewById<TextView>(R.id.num2)
        var num1 = 0
        var num2 = 0
        var count = 0
        var answer = 1.0
        var correct = 0
        var sign = findViewById<TextView>(R.id.sign)
        var userAnswer = findViewById<EditText>(R.id.editText)
        //setting up the first problem that is displayed on screen creation
        //choosing the correct operation
        if (operation == "+") {
            sign.text = "+"

        } else if (operation == "-") {
            sign.text = "-"
        } else if (operation == "/") {
            sign.text = "/"

        } else {
            sign.text = "*"

        }
        //making sure the random numbers are in the selected range
        if (operand == 10) {

            num1 = (1 until 10).random()
            num1Text.text = num1.toString()
            num2 = (1 until 10).random()
            num2Text.text = num2.toString()
        }
        if (operand == 25) {
            num1 = (10 until 25).random()
            num1Text.text = num1.toString()
            num2 = (10 until 25).random()
            num2Text.text = num2.toString()
        }
        if (operand == 50) {
            num1 = (25 until 50).random()
            num1Text.text = num1.toString()
            num2 = (25 until 50).random()
            num2Text.text = num2.toString()
        }
        //this function checks to see if the user inputted answer is correct
        fun correct(num1: Int, num2: Int): Double {
            var solution = 0
            if (operation == "+") {
                solution = num1 + num2
            } else if (operation == "-") {
                solution = num1 - num2
            } else if (operation == "/") {
                solution = num1 / num2
            } else {
                solution = num1 * num2
            }
            return solution.toDouble()

        }

        //handles what happens when the done button is clicked
        done.setOnClickListener {
            answer = userAnswer.text.toString().toDouble()
            count++
            //updating number of correct answers
            if (correct(num1, num2) == answer) {
                correct++
            }
            //checking to see if the number of answered questions
            // matched the number of problems the user chose
            //if it was the last problem, opens the result screen
            if(count == questionNum){
                val i = Intent(this, MainActivity::class.java)
                i.putExtra("Correct", correct)
                i.putExtra("qNum", count)
                startActivity(i)
            }
            //generates next problem
            else {
                if (operand == 10) {

                    num1 = (1 until 10).random()
                    num1Text.text = num1.toString()
                    num2 = (1 until 10).random()
                    num2Text.text = num2.toString()
                }
                if (operand == 25) {
                    num1 = (10 until 25).random()
                    num1Text.text = num1.toString()
                    num2 = (10 until 25).random()
                    num2Text.text = num2.toString()
                }
                if (operand == 50) {
                    num1 = (25 until 50).random()
                    num1Text.text = num1.toString()
                    num2 = (25 until 50).random()
                    num2Text.text = num2.toString()
                }
            }
            userAnswer.text.clear()
        }



    }
}

