package br.com.luizlemetech.alugames.principal

import br.com.luizlemetech.alugames.modelo.Gamer

fun main() {
    var gamer1:Gamer? = null
    val criarGamer1 = runCatching {
        gamer1 = Gamer("Luiz", "luiz@email.com")
    }

    criarGamer1.onFailure {
        println("Erro ao criar o usuário: " + criarGamer1.exceptionOrNull()?.message)
    }

    criarGamer1.onSuccess {
        println(gamer1)

        gamer1?.let {
            it.dataNascimento = "18/09/2000"
            it.usuario ="luigi"
        }.also {
            println(gamer1?.idInterno)
        }

        println(gamer1)
        gamer1?.usuario = "luizao"
        println(gamer1)
    }


    val gamer2 = Gamer(
        "Josue",
        "josue@email.com",
        "23/01/1992",
        "ojosue")

    println(gamer2)
}