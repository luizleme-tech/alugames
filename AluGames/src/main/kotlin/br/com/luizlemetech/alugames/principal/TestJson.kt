package br.com.luizlemetech.alugames.principal

import br.com.luizlemetech.alugames.servicos.ConsumoApi

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    println(listaGamers)
}