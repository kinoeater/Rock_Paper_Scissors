package com.mustafayol.task_agit_makas

import java.util.*

object Generator {

    fun generateRandomNumber(): Int = Random().nextInt(3) // 0,1,2

    fun getImage(): Int {

        val images = listOf(R.drawable.stone,R.drawable.paper,R.drawable.scissors)
        return images[generateRandomNumber()]

    }



}






















