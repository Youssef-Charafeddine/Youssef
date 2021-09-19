@file:Suppress("LocalVariableName")

package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var imgDice:ImageView
    private lateinit var imgDice2:ImageView
    private lateinit var imgDice3:ImageView
    private lateinit var imgDice4:ImageView
    private val diceImages: MutableList<Int> = mutableListOf<Int>()
    var count=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val NumDice:  TextView = findViewById(R.id.NumDice)


        val PlusBtn: Button= findViewById(R.id.PlusBtn)
        PlusBtn.setOnClickListener{
            count++
            NumDice.text = count.toString()
            PlusBtn.isEnabled=count in 1..3



        }
        val MinusBtn: Button= findViewById(R.id.MinusBtn)
        MinusBtn.setOnClickListener {
            count--
            MinusBtn.isEnabled=count in 1..3
            NumDice.text=count.toString()
        }
        val resetBtn: Button=findViewById(R.id.resetBtn)
        resetBtn.setOnClickListener{
            count=1
            NumDice.text = count.toString()
            PlusBtn.isEnabled=true
            MinusBtn.isEnabled=true
            imgDice.setImageResource(R.drawable.ic_dice)
            imgDice2.setImageResource(R.drawable.ic_dice)
            imgDice3.setImageResource(R.drawable.ic_dice)
            imgDice4.setImageResource(R.drawable.ic_dice)

        }



        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()

        }




        imgDice=findViewById(R.id.imgDice)
        imgDice2=findViewById(R.id.imgDice2)
        imgDice3=findViewById(R.id.imgDice3)
        imgDice4=findViewById(R.id.imgDice4)
        diceImages.add(R.drawable.ic_dice_one)
        diceImages.add(R.drawable.ic_dice_two)
        diceImages.add(R.drawable.ic_dice_three)
        diceImages.add(R.drawable.ic_dice_four)
        diceImages.add(R.drawable.ic_dice_five)
        diceImages.add(R.drawable.ic_dice_six)


        val rollAllButton : Button=findViewById(R.id.button2)
        rollAllButton.setOnClickListener{
            rollAllDices()

        }

    }
    private fun rollDice() {
        val random=1..6
        when (setDiceImage(findViewById(R.id.imgDice), random.random())){
            
        }

    }

    private fun rollAllDices() {
            val values =1..6
            setDiceImage(findViewById(R.id.imgDice),values.random())
            setDiceImage(findViewById(R.id.imgDice2),values.random())
            setDiceImage(findViewById(R.id.imgDice3),values.random())
            setDiceImage(findViewById(R.id.imgDice4),values.random())

        }
        private fun setDiceImage(imageView: ImageView, value: Int ) {
            val drawableResource=when (value) {
                1 -> R.drawable.ic_dice_one
                2 -> R.drawable.ic_dice_two
                3 -> R.drawable.ic_dice_three
                4 -> R.drawable.ic_dice_four
                5 -> R.drawable.ic_dice_five
                else -> R.drawable.ic_dice_six
            }
            imageView.setImageResource(drawableResource)

        }
}


















