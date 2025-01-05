package br.com.luizlemetech.alugames.principal

import br.com.luizlemetech.alugames.servicos.ConsumoApi

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val jogoApi = consumo.buscaJogo("151")
    val listaJogos = consumo.buscaJogos()

    println(listaGamers)
    println(jogoApi)
    println("\nJogos buscados do Json\n")
    println(listaJogos)
}