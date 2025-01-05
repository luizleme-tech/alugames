package br.com.luizlemetech.alugames.utilitario

import br.com.luizlemetech.alugames.modelo.Gamer
import br.com.luizlemetech.alugames.modelo.InfoGamerJson

fun InfoGamerJson.criaGamer(): Gamer {
    return Gamer(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario)
}