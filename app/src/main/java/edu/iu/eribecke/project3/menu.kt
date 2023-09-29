package edu.iu.eribecke.project3


import android.os.Bundle
import android.annotation.SuppressLint
import android.os.Debug
import android.util.Log

import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import org.w3c.dom.Text

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
        return view
    }
    val args: menuArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var results: String? = args.result
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
        val resultDisplay = view.findViewById<TextView>(R.id.result)
        var operand = 0
        var operator = ""

        //checks to see if results is null, if not we know that results must be displayed
        if(results!=null) {
            resultDisplay.text = results.toString()
        }


        //handles start button
        startButton.setOnClickListener {
            //creating an action to switch to the question screen
            val action = menuDirections.actionMenuFragmentToQuestionsFragment(count, operand, operator)
            view.findNavController()
                .navigate(action)
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

    
