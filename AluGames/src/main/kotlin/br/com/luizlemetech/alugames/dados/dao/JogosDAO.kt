package br.com.luizlemetech.alugames.dados.dao

import br.com.luizlemetech.alugames.dados.entities.JogoEntity
import br.com.luizlemetech.alugames.modelo.Jogo
import javax.persistence.EntityManager

class JogosDAO(private val entityManager: EntityManager) {

    fun getJogos(): List<Jogo> {
        val query = entityManager.createQuery("FROM JogoEntity", JogoEntity::class.java)
        return query.resultList.map { entity ->
            Jogo(
                entity.titulo,
                entity.capa,
                entity.preco,
                entity.descricao!!,
                entity.id
            )
        }
    }

    fun adicionarJogo(jogo: Jogo) {
        val entity = JogoEntity(jogo.titulo,
            jogo.capa,
            jogo.preco.toDouble(),
            jogo.descricao!!
        )
        entityManager.transaction.begin()
        entityManager.persist(entity)
        entityManager.transaction.commit()
    }
}