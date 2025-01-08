package br.com.luizlemetech.alugames.principal

import br.com.luizlemetech.alugames.modelo.Periodo
import br.com.luizlemetech.alugames.modelo.PlanoAssinatura
import br.com.luizlemetech.alugames.servicos.ConsumoApi
import com.google.gson.GsonBuilder
import java.io.File
import java.math.BigDecimal
import java.time.LocalDate

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val listaJogos = consumo.buscaJogos()

    val gamerCaroline = listaGamers.get(3)
    val jogoResidenteVillage = listaJogos.get(10)
    val jogoSpider = listaJogos.get(13)
    val jogoTheLastOfUs = listaJogos.get(2)

    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10))

    gamerCaroline.alugaJogo(jogoResidenteVillage, periodo1)
    gamerCaroline.alugaJogo(jogoSpider, periodo2)
    gamerCaroline.alugaJogo(jogoTheLastOfUs, periodo3)
    //println(gamerCaroline.jogosAlugados)

    val gamerCamila = listaGamers.get(5)
    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3, BigDecimal("0.15"))

    gamerCamila.alugaJogo(jogoResidenteVillage, periodo1)
    gamerCamila.alugaJogo(jogoSpider, periodo2)
    gamerCamila.alugaJogo(jogoTheLastOfUs, periodo3)
    gamerCamila.alugaJogo(jogoTheLastOfUs, periodo3)
//    println(gamerCamila.jogosAlugados)

    gamerCamila.recomendar(7)
    gamerCamila.recomendar(10)
    gamerCamila.recomendar(8)
//    println(gamerCamila)

    gamerCamila.alugaJogo(jogoResidenteVillage, periodo1)
//    println(gamerCamila.jogosAlugados)

    gamerCamila.recomendarJogo(jogoResidenteVillage, 7)
    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)

    gamerCaroline.recomendarJogo(jogoResidenteVillage, 8)
    gamerCaroline.recomendarJogo(jogoTheLastOfUs, 9)

    println("Recomendacoes da Caroline")
    println(gamerCaroline.jogosRecomendados)
    println("Recomendacoes da Camila")
    println(gamerCamila.jogosRecomendados)

    val gson = GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .create()
    val serializacao = gson.toJson(gamerCamila.jogosRecomendados)
    println(serializacao)

    val arquivo = File("jogosRecomendados-${gamerCamila.nome}.json")
    arquivo.writeText(serializacao)

    println(arquivo.absolutePath)
}