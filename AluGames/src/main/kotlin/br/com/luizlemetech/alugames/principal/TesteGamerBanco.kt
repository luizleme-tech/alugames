package br.com.luizlemetech.alugames.principal

import br.com.luizlemetech.alugames.dados.config.Banco
import br.com.luizlemetech.alugames.dados.dao.GamerDAO
import br.com.luizlemetech.alugames.dados.dao.PlanosDAO
import br.com.luizlemetech.alugames.modelo.Gamer

fun main() {
    val gamer = Gamer("Edmundo","edmundo@email.com","10/11/1998","ed")

    val manager = Banco.getEntityManager()
    val gamerDAO = GamerDAO(manager)
    val planosDAO = PlanosDAO(manager)
    gamer.plano = planosDAO.recuperarPeloId(5)

    gamerDAO.adicionar(gamer)

    print(gamerDAO.getLista())
    manager.close()
}