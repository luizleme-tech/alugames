package br.com.luizlemetech.alugames.modelo

interface Recomendavel {
    val media: Double

    fun recomendar(nota: Int)
}