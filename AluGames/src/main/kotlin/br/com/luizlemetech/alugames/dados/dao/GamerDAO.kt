package br.com.luizlemetech.alugames.dados.dao

import br.com.luizlemetech.alugames.dados.entities.GamerEntity
import br.com.luizlemetech.alugames.modelo.Gamer
import javax.persistence.EntityManager

class GamerDAO(private val entityManager: EntityManager) {
    fun getGamers(): List<Gamer> {
        val query = entityManager.createQuery("FROM GamerEntity", GamerEntity::class.java)
        return query.resultList.map { entity ->
            Gamer(
                entity.nome,
                entity.email,
                entity.dataNascimento!!,
                entity.usuario!!,
                entity.id
            )
        }
    }

    fun adicionarGamer(gamer: Gamer) {
        val entity = GamerEntity(gamer.id!!,gamer.nome, gamer.email, gamer.dataNascimento, gamer.usuario)
        entityManager.transaction.begin()
        entityManager.persist(entity)
        entityManager.transaction.commit()
    }
}