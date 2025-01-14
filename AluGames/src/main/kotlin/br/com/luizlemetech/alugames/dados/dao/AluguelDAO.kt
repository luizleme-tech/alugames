package br.com.luizlemetech.alugames.dados.dao

import br.com.luizlemetech.alugames.dados.entities.AluguelEntity
import br.com.luizlemetech.alugames.modelo.Aluguel
import br.com.luizlemetech.alugames.utilitario.toEntity
import br.com.luizlemetech.alugames.utilitario.toModel
import javax.persistence.EntityManager

class AluguelDAO(manager: EntityManager): DAO<Aluguel, AluguelEntity>(manager, AluguelEntity::class.java) {
    override fun toEntity(objeto: Aluguel): AluguelEntity {
        return AluguelEntity(objeto.gamer.toEntity(), objeto.jogo.toEntity(), objeto.periodo)
            .apply { valorDoAluguel = objeto.valorDoAluguel.toDouble()
                    id = objeto.id}
    }

    override fun toModel(entity: AluguelEntity): Aluguel {
        return Aluguel(entity.gamer.toModel(), entity.jogo.toModel(), entity.periodo)
            .apply { id = entity.id }
    }
}