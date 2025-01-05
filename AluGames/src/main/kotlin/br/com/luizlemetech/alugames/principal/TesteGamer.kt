import br.com.luizlemetech.alugames.modelo.Gamer

fun main() {
    val gamer1 = Gamer("Luiz", "luiz@email.com")
    println(gamer1)

    val gamer2 = Gamer(
        "Josue",
        "josue@email.com",
        "23/01/1992",
        "ojosue")

    println(gamer2)

    gamer1.let {
        it.dataNascimento = "18/09/2000"
        it.usuario ="luigi"
    }.also {
        println(gamer1.idInterno)
    }

    println(gamer1)
    gamer1.usuario = "luizao"
    println(gamer1)
}