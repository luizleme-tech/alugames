package br.com.luizlemetech.alugames.servicos

import br.com.luizlemetech.alugames.modelo.*
import br.com.luizlemetech.alugames.utilitario.criaGamer
import br.com.luizlemetech.alugames.utilitario.criaJogo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {

    private fun consomeDados(endereco: String): String {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()

        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        return response.body()
    }

    fun buscaJogo(id: String): InfoJogo? {
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val json = consomeDados(endereco)

        var meuInfoJogo: InfoJogo? = null

        val resultado = kotlin.runCatching {
            val gson = Gson()
            meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)
        }

        resultado.onSuccess {
            return meuInfoJogo
        }

        resultado.onFailure {
            println("Ocorreu um erro ao tratar os dados do jogo: $id")
        }
        return null
    }

    fun buscaGamers(): List<Gamer> {
        val endereco = "https://raw.githubusercontent.com/luizleme-tech/arquivosjson/refs/heads/main/gamers.json"

        val json = consomeDados(endereco)
        val gson = Gson()
        val meuGamerTipo = object : TypeToken<List<InfoGamerJson>>() {}.type
        var listaGamer: List<InfoGamerJson> = gson.fromJson(json, meuGamerTipo)

        val listaGamerConvertida = listaGamer.map { infoGamerJson -> infoGamerJson.criaGamer() }

        return listaGamerConvertida
    }

    fun buscaJogos(): List<Jogo> {
        val endereco = "https://raw.githubusercontent.com/luizleme-tech/arquivosjson/refs/heads/main/jogos.json"

        val json = consomeDados(endereco)
        val gson = Gson()
        val meuJogoTipo = object : TypeToken<List<InfoJogoJson>> () {}.type
        var listaJogos: List<InfoJogoJson> = gson.fromJson(json, meuJogoTipo)

        var listaJogoConvertida = listaJogos.map {
            infoJogoJson ->  infoJogoJson.criaJogo()
        }
        return listaJogoConvertida
    }
}