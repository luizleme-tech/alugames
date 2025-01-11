package br.com.luizlemetech.alugames.principal

import br.com.luizlemetech.alugames.dados.Banco
import br.com.luizlemetech.alugames.modelo.Jogo

fun main() {



    val listaJogos : List<Jogo> = Banco.getJogos()
    println(listaJogos)
}