package com.mustafayol.task_agit_makas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var mFirstImage: ImageView
    private lateinit var mSecondImage: ImageView
    private lateinit var mFirstScore: TextView
    private lateinit var mSecondScore: TextView
    private var mFirstPlayerScore = 0
    private var mSecondPlayerScore = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()

    }

    fun setupView() {

/*      mFirstImage = findViewById(R.id.first_img)
        mSecondImage = findViewById(R.id.imageView2)
        mFirstScore = findViewById(R.id.first_Score_tv)
        mSecondScore = findViewById(R.id.second_Score_tv) */

        // let's benefit Kotlin
        mFirstImage = first_img
        mSecondImage = imageView2
        mFirstScore = first_Score_tv
        mSecondScore = second_Score_tv


    }

    fun playGame(view: View) {
        var firstImage: Int = 0
        var secondImage: Int = 0
        var result: Winner = Winner.DRAW

        when(view.id) {

            R.id.rock_btn -> {
                firstImage = R.drawable.stone
                secondImage = Generator.getImage()

                setImageResource(firstImage,secondImage)

                result =  Versus.compare(firstImage, secondImage)
                write_score(result)
            }

            R.id.paper_btn -> {

                firstImage = R.drawable.paper
                secondImage = Generator.getImage()

                setImageResource(firstImage,secondImage)

                result =  Versus.compare(firstImage, secondImage)
                write_score(result)

            }

            R.id.scissors_btn -> {
                firstImage = R.drawable.scissors
                secondImage = Generator.getImage()

                setImageResource(firstImage,secondImage)

                result =  Versus.compare(firstImage, secondImage)
                write_score(result)

            }

        }

    }

    fun setImageResource(firstImage: Int,secondImage: Int) {

        mFirstImage.setImageResource(firstImage)
        mSecondImage.setImageResource(secondImage)
    }


    fun write_score(winner: Winner) {
        when(winner) {

            Winner.DRAW -> Toast.makeText(this,"Berabere",Toast.LENGTH_SHORT).show()
            Winner.FIRST -> {
                Toast.makeText(this,"Sen Kazandın",Toast.LENGTH_SHORT).show()
                mFirstPlayerScore++
                mFirstScore.text = mFirstPlayerScore.toString()
            }
            Winner.SECOND -> {
                Toast.makeText(this,"Rakip Kazandı",Toast.LENGTH_SHORT).show()
                mSecondPlayerScore++
                mSecondScore.text = mSecondPlayerScore.toString()
            }

        }

    }

    fun reset(view: View) {

        mFirstPlayerScore = 0
        mSecondPlayerScore = 0

        mFirstScore.text = mFirstPlayerScore.toString()
        mSecondScore.text = mSecondPlayerScore.toString()
        setImageResource(R.drawable.uclu,R.drawable.uclu)

    }
}
































