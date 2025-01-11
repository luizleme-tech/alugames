package br.com.luizlemetech.alugames.dados.dao

import br.com.luizlemetech.alugames.dados.entities.GamerEntity
import br.com.luizlemetech.alugames.modelo.Gamer
import javax.persistence.EntityManager

class GamerDAO(manager: EntityManager): DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {
    override fun toEntity(objeto: Gamer): GamerEntity {
        return GamerEntity(objeto.id!!,objeto.nome, objeto.email, objeto.dataNascimento, objeto.usuario)
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return  Gamer(
            entity.nome,
            entity.email,
            entity.dataNascimento!!,
            entity.usuario!!,
            entity.id
        )
    }
}