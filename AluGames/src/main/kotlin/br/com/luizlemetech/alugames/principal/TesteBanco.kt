package br.com.luizlemetech.alugames.principal

import br.com.luizlemetech.alugames.dados.config.Banco
import br.com.luizlemetech.alugames.dados.dao.JogosDAO
import br.com.luizlemetech.alugames.modelo.Jogo

fun main() {

    val jogo = Jogo("The Last of Us Part I", "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554", 5.99,"Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito.")
    val jogo2 = Jogo("Dandara", "https://cdn.cloudflare.steamstatic.com/steam/apps/612390/header.jpg?t=1674055293", 9.99,"Um jogo de plataforma e ação com elementos de metroidvania, onde você controla a heroína Dandara em sua luta para libertar um mundo repleto de opressão e tirania.")

    val entityManager = Banco.getEntityManager()

    val jogoDAO = JogosDAO(entityManager)
//    jogoDAO.adicionar(jogo2)

    val jogoRecuperado = jogoDAO.recuperarPeloId(2)
    println(jogoRecuperado)

    jogoDAO.apagar(2)

    val listaJogos : List<Jogo> = jogoDAO.getLista()
    println(listaJogos)

    entityManager.close()
}