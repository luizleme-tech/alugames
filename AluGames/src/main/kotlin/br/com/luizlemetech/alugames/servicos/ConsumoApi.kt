package br.com.luizlemetech.alugames.servicos

import br.com.luizlemetech.alugames.modelo.InfoJogo
import com.google.gson.Gson
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
}