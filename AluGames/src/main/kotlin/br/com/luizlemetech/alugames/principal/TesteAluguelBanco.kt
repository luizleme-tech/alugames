package br.com.luizlemetech.alugames.principal

import br.com.luizlemetech.alugames.dados.config.Banco
import br.com.luizlemetech.alugames.dados.dao.AluguelDAO
import br.com.luizlemetech.alugames.dados.dao.GamerDAO
import br.com.luizlemetech.alugames.dados.dao.JogosDAO
import br.com.luizlemetech.alugames.modelo.Periodo

fun main() {
    val manager = Banco.getEntityManager()
    val jogoDAO = JogosDAO(manager)
    val gamerDAO = GamerDAO(manager)
    val aluguelDAO = AluguelDAO(manager)

    val gamer = gamerDAO.recuperarPeloId(1)
    val jogo = jogoDAO.recuperarPeloId(1)
    val aluguel = gamer.alugaJogo(jogo, Periodo())

    aluguelDAO.adicionar(aluguel)

    val listaAluguel = aluguelDAO.getLista()
    println(listaAluguel)

    manager.close()
}