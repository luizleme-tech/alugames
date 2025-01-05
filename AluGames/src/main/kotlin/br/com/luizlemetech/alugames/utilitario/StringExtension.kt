import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.transformarEmIdade(): Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var idade = 0
    var dataNascimento:LocalDate? = null

    val result = runCatching {
        dataNascimento = LocalDate.parse(this, formatter)
    }

    result.onSuccess {
        val hoje = LocalDate.now()
        idade = Period.between(dataNascimento, hoje).years
    }
    return idade
}