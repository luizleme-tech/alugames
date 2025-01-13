package br.com.luizlemetech.alugames.dados.dao

import br.com.luizlemetech.alugames.dados.entities.JogoEntity
import br.com.luizlemetech.alugames.modelo.Jogo
import javax.persistence.EntityManager

class JogosDAO(manager: EntityManager) : DAO<Jogo, JogoEntity>(manager, JogoEntity::class.java) {
    override fun toEntity(jogo: Jogo): JogoEntity {
        return JogoEntity(jogo.titulo, jogo.capa, jogo.preco.toDouble(), jogo.descricao, jogo.id!!)
    }

    override fun toModel(entity: JogoEntity): Jogo {
        return Jogo(
            entity.titulo,
            entity.capa,
            entity.preco,
            entity.descricao!!,
            entity.id
        )
    }
}