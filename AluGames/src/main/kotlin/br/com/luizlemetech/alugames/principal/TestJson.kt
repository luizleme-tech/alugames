package br.com.luizlemetech.alugames.principal

import br.com.luizlemetech.alugames.servicos.ConsumoApi

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val listaJogos = consumo.buscaJogos()

    val gamerCaroline = listaGamers.get(3)
    val jogoResidenteVillage = listaJogos.get(10)

    println(gamerCaroline)
    println(jogoResidenteVillage)

    val aluguel = gamerCaroline.alugaJogo(jogoResidenteVillage)

    println(aluguel)
}