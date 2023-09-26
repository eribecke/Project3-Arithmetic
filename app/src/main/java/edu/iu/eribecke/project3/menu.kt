package edu.iu.eribecke.project3


import android.os.Bundle
import android.annotation.SuppressLint

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class menu: Fragment() {
    //creating private variables
    private lateinit var selDif: RadioButton
    private lateinit var selOp: RadioButton
    private var questionNum = ""
    private var count = 1;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_menu, container, false)
        val startButton = view.findViewById<Button>(R.id.start)
        val plusButton = view.findViewById<Button>(R.id.plus)
        val minusButton = view.findViewById<Button>(R.id.minus)
        var numOfQ = view.findViewById<TextView>(R.id.num)
        val easy = view.findViewById<RadioButton>(R.id.easy)
        val med = view.findViewById<RadioButton>(R.id.medium)
        val hard = view.findViewById<RadioButton>(R.id.hard)
        val add = view.findViewById<RadioButton>(R.id.addition)
        val sub = view.findViewById<RadioButton>(R.id.subtraction)
        val mult = view.findViewById<RadioButton>(R.id.multiply)
        val div = view.findViewById<RadioButton>(R.id.division)
        val results = view.findViewById<TextView>(R.id.results)
        var operand = 0
        var operator = ""


        startButton.setOnClickListener {
            //creating an action to switch to the question screen
            view.findNavController()
                .navigate(R.id.action_menuFragment_to_questionsFragment)
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
        return view
    }
}

    
