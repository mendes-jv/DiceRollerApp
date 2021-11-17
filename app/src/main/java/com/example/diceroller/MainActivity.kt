package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll two dices and view the results
 * on the screen.
 */
class MainActivity : AppCompatActivity() {

    /**
     * This method is called when the Activity is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the Button in the layout
        val rollButton: Button = findViewById(R.id.button)

        //Find dices' image views in the layout
        val diceOne: ImageView = findViewById(R.id.imageView1)
        val diceTwo: ImageView = findViewById(R.id.imageView2)

        // Set a click listener on the button to roll the dices when the user taps the button
        rollButton.setOnClickListener {
            rollDice(diceOne)
            rollDice(diceTwo)
        }

        // Do both dice rolls when the app starts
        rollDice(diceOne)
        rollDice(diceTwo)
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice(view: ImageView) {

        // Create 2 new Dices objects with 6 sides and roll them
        val sixFacedDice = Dice(6)
        val diceRoll = sixFacedDice.roll()

        // Update the screen with the dices' images
        val image = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        view.setImageResource(image)
        view.contentDescription = diceRoll.toString()
    }
}

/**
 * Dice with a specific number of sides.
 */
class Dice(private val numSides: Int) {

    /**
     * Do a random dice roll and return the result.
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}