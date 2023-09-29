package edu.iu.eribecke.project3


import android.os.Bundle
import android.annotation.SuppressLint
import android.media.MediaPlayer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.findNavController


class questions : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//creating variables
        //first three are variables containing information from MainActivity class
        val view = inflater.inflate(R.layout.fragment_questions, container, false)
        val done = view.findViewById<Button>(R.id.done)
        var num1Text = view.findViewById<TextView>(R.id.num1)
        var num2Text = view.findViewById<TextView>(R.id.num2)
        var num1 = 0
        var num2 = 0
        var count = 0
        var answer = 1.0
        var correct = 0
        val questionNum = questionsArgs.fromBundle(requireArguments()).questionNum
        val operation = questionsArgs.fromBundle(requireArguments()).operator
        val operand = questionsArgs.fromBundle(requireArguments()).operand
        var sign = view.findViewById<TextView>(R.id.sign)
        var userAnswer = view.findViewById<EditText>(R.id.editText)
        var results = ""
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
                val toastT = "Correct, Good Work!"
                val toast1 = Toast.makeText(getActivity(), toastT, Toast.LENGTH_SHORT)
                toast1.show()
                var mediaPlayer = MediaPlayer.create(context, R.raw.correct)
                mediaPlayer.start()
                correct++
            }
            if(correct(num1, num2) != answer){
                val toastT2 = "Wrong."
                val toast1 = Toast.makeText(getActivity(), toastT2, Toast.LENGTH_SHORT)
                toast1.show()
                var mediaPlayer2 = MediaPlayer.create(context, R.raw.incorrect)
                mediaPlayer2.start()
            }

            //checking to see if the number of answered questions
            // matched the number of problems the user chose
            //if it was the last problem, opens the result screen
            if(count == questionNum){
                var sOperation = ""
                sOperation = if(operation == "+"){
                    "addition"
                } else if(operation == "/"){
                    "division"
                } else if(operation == "-"){
                    "subtraction"
                } else{
                    "multiplication"
                }
                results = if(correct.toDouble()/questionNum.toDouble() >= 0.8){

                    "You got " + correct + " out of " + questionNum + " in " + sOperation +
                            ". Good Work!"
                } else{
                    "You got a " + correct + " out of " + questionNum + " correct in " + sOperation +
                            ". You need to practice more!"
                }

                val action = questionsDirections.actionQuestionFragmentToMenuFragment().apply{
                    result = results
                }
                view.findNavController()
                    .navigate(action)
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


    return view
    }
    }




