package com.ciandt.jokenpochallengeebac.utils

class JokenpoEngine(private val availablePlays: Array<String>) {

    fun calculateResult(playerUser: String): Result {
        return when{
            playerUser == getAIPlay() -> Result.DRAW
            playerUser == "Pedra" && getAIPlay() =="Tesoura" -> Result.WIN
            playerUser == "Pedra" && getAIPlay() =="Papel" -> Result.LOSS
            playerUser == "Papel" && getAIPlay() =="Pedra" -> Result.WIN
            playerUser == "Papel" && getAIPlay() =="Tesoura" -> Result.LOSS
            playerUser == "Tesoura" && getAIPlay() =="Papel" -> Result.WIN
            else -> Result.LOSS
        }
    }

    fun getAIPlay(): String {
        val playIndex = 0..2
        return when (playIndex.random()) {
            0 -> "Pedra"
            1 -> "Papel"
            else -> "Tesoura"
        }
    }
}

fun teste() {
    val number = 0..2
    val randomValue = number.random()
    when (randomValue) {
        0 -> "Pedra"
        1 -> "Papel"
        else -> "Tesoura"
    }
}