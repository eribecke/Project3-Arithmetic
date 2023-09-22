package edu.iu.eribecke.project3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class end : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.results)
        //getting information from questions class
        val correct = intent.getIntExtra("Correct", 1)
        val questionNum = intent.getIntExtra("qNum", 1)
        val again = findViewById<Button>(R.id.again)
        //creating variables for score
        var score = findViewById<TextView>(R.id.score)
        var displayScore = "$correct out of $questionNum"
        //displaying the user's score
        score.text = displayScore

        //handles what happens when the "DO IT AGAIN" button is clicked
        //Will bring user back to the menu screen
        again.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }
}