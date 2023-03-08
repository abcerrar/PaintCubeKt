package com.example.paintcubekt

import android.util.Log

class Cube constructor(colores:IntArray){

    var colores = colores
    var currentHorizontalPos=0
    var currentVerticalPos=0
    var currentGlobalPos=1



    init {

    }

    fun getHorizontalPos():Int{
        return currentHorizontalPos
    }
    fun getColor():Int{
        Log.d("color", "estoy devolviendo el color "+currentGlobalPos)
        when(currentGlobalPos){
            1->return colores[0]
            2->return colores[1]
            3->return colores[2]
            4->return colores[3]
            5->return colores[4]
            6->return colores[5]
            else->return 0
        }
    }


    fun moveHorizontal(pos:Boolean):Boolean{
        if(pos) {
            if(currentHorizontalPos==3){
                Log.d("warning", "not enough table"+getHorizontalPos())
                return false
            }
            else {
                when(currentGlobalPos){
                    1->currentGlobalPos=2
                    2->currentGlobalPos=5
                    3->currentGlobalPos=2
                    4->currentGlobalPos=2
                    5->currentGlobalPos=6
                    6->currentGlobalPos=1
                }
                currentHorizontalPos++
                Log.d("posicion", "horizontal: "+currentHorizontalPos+", global: "+currentGlobalPos)

                return true
            }
        } else if(currentHorizontalPos==0){
            Log.d("warning", "not enough table"+getHorizontalPos())
            return false
        }
        else {
            when(currentGlobalPos){
                1->currentGlobalPos=5
                2->currentGlobalPos=1
                3->currentGlobalPos=5
                4->currentGlobalPos=5
                5->currentGlobalPos=6
                6->currentGlobalPos=2
            }
            currentHorizontalPos--
            return true
        }
    }

    fun moveVertical(pos:Boolean):Boolean{
        if(pos) {
            if(currentVerticalPos==3){
                Log.d("warning", "not enough table")
                return false
            }
            else {
                when(currentGlobalPos){
                    1->currentGlobalPos=4
                    2->currentGlobalPos=4
                    3->currentGlobalPos=1
                    4->currentGlobalPos=6
                    5->currentGlobalPos=4
                    6->currentGlobalPos=3
                }
                currentVerticalPos++
                return true
            }
        } else if(currentVerticalPos==0){
            Log.d("warning", "not enough table")
            return false
        }
        else {
            when(currentGlobalPos){
                1->currentGlobalPos=3
                2->currentGlobalPos=3
                3->currentGlobalPos=6
                4->currentGlobalPos=1
                5->currentGlobalPos=3
                6->currentGlobalPos=4
            }
            currentVerticalPos--
            return true
        }
    }



}