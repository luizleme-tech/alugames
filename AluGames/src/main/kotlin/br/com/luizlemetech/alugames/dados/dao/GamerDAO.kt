package br.com.luizlemetech.alugames.dados.dao

import br.com.luizlemetech.alugames.dados.entities.GamerEntity
import br.com.luizlemetech.alugames.modelo.Gamer
import br.com.luizlemetech.alugames.utilitario.toEntity
import br.com.luizlemetech.alugames.utilitario.toModel
import javax.persistence.EntityManager

class GamerDAO(manager: EntityManager): DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {
    override fun toEntity(gamer: Gamer): GamerEntity {
        return GamerEntity(gamer.id,gamer.nome, gamer.email, gamer.dataNascimento, gamer.usuario, gamer.plano.toEntity())
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return  Gamer(
            entity.nome,
            entity.email,
            entity.dataNascimento!!,
            entity.usuario!!,
            entity.id!!
        ).apply { plano = entity.plano.toModel()}
    }
}