package br.com.luizlemetech.alugames.modelo

import java.math.BigDecimal

abstract class Plano(val tipo: String, var id: Int = 0) {

    open fun obterValor(aluguel: Aluguel): BigDecimal {
        return aluguel.jogo.preco * aluguel.periodo.emDias.toBigDecimal()
    }
}