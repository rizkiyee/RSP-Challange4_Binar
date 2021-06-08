package com.kiye.rsp.enum

enum class GameRules(val value:Int) {
    IDLE(-1),
   ROCK(0),
    PAPER(1),
    SCISSOR(2);
    companion object{
        fun fromInt(value : Int) = values().first(){
            it.value == value }
    }


}