package br.com.luizlemetech.alugames.modelo

import java.math.BigDecimal

class PlanoAvulso(
    tipo: String): Plano(tipo) {

    override fun obterValor(aluguel: Aluguel): BigDecimal {
       var valorOriginal = super.obterValor(aluguel)
       if (aluguel.gamer.media > 8) {
           valorOriginal -= valorOriginal.multiply(BigDecimal("0.1"))
       }
        return valorOriginal
    }
}
