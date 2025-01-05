package br.com.luizlemetech.alugames.servicos

import br.com.luizlemetech.alugames.modelo.Gamer
import br.com.luizlemetech.alugames.modelo.InfoGamerJson
import br.com.luizlemetech.alugames.modelo.InfoJogo
import br.com.luizlemetech.alugames.utilitario.criaGamer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {
    fun buscaJogo(id: String):InfoJogo? {
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()

        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()

        var meuInfoJogo:InfoJogo?=null

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

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()

        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()
        val gson = Gson()
        val meuGamerTipo = object : TypeToken<List<InfoGamerJson>>() {}.type
        var listaGamer:List<InfoGamerJson> = gson.fromJson(json, meuGamerTipo)

        val listaGamerConvertida = listaGamer.map { infoGamerJson -> infoGamerJson.criaGamer()}

        return listaGamerConvertida
    }
}