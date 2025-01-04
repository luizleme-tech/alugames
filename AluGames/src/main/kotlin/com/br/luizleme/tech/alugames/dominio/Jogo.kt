package com.br.luizleme.tech.alugames.dominio

data class Jogo(val titulo:String,
           val capa:String) {
    val descricao = ""

    override fun toString(): String {
        return "Meu Jogo:\n" +
                "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao"
    }
}