package br.com.luizlemetech.alugames.utilitario

import br.com.luizlemetech.alugames.modelo.InfoJogoJson
import br.com.luizlemetech.alugames.modelo.Jogo

fun InfoJogoJson.criaJogo(): Jogo {
    return Jogo(
        this.titulo,
        this.capa,
        this.preco,
        this.descricao
    )
}