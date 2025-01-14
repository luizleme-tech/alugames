package br.com.luizlemetech.alugames.modelo

import java.math.BigDecimal

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo) {
    val valorDoAluguel: BigDecimal = gamer.plano.obterValor(this)
    var id: Int = 0

    override fun toString(): String {
        return "Aluguel do ${jogo.titulo} por ${gamer.nome} pelo valor R$$valorDoAluguel"
    }
}
