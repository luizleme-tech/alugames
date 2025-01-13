package br.com.luizlemetech.alugames.principal

import br.com.luizlemetech.alugames.dados.config.Banco
import br.com.luizlemetech.alugames.dados.dao.PlanosDAO
import br.com.luizlemetech.alugames.modelo.PlanoAssinatura
import br.com.luizlemetech.alugames.modelo.PlanoAvulso
import java.math.BigDecimal

fun main() {
    val avulso = PlanoAvulso("BRONZE")
    val prata = PlanoAssinatura("PRATA", 9.90, 3, BigDecimal.valueOf(0.15))
    val ouro = PlanoAssinatura("OURO", 19.90, 5, BigDecimal.valueOf(0.20))
    val platina = PlanoAssinatura("PLATINA", 29.90, 10, BigDecimal.valueOf(0.30))
    val diamante = PlanoAssinatura("DIAMANTE", 49.90, 20, BigDecimal.valueOf(0.50))

    val manager = Banco.getEntityManager()
    val planosDAO = PlanosDAO(manager)

//    planosDAO.adicionar(avulso)
//    planosDAO.adicionar(prata)
//    planosDAO.adicionar(ouro)
//    planosDAO.adicionar(platina)
//    planosDAO.adicionar(diamante)

    val listaPlanos = planosDAO.getLista()
    println(listaPlanos)

    manager.close()
}