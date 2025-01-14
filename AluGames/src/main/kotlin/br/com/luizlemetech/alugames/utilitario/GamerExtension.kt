package br.com.luizlemetech.alugames.utilitario

import br.com.luizlemetech.alugames.dados.entities.GamerEntity
import br.com.luizlemetech.alugames.modelo.Gamer
import br.com.luizlemetech.alugames.modelo.InfoGamerJson

fun InfoGamerJson.criaGamer(): Gamer {
    return Gamer(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario)
}

fun Gamer.toEntity(): GamerEntity {
    return GamerEntity(this.id,this.nome, this.email, this.dataNascimento, this.usuario, this.plano.toEntity())
}

fun GamerEntity.toModel(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario, this.id!!)
}