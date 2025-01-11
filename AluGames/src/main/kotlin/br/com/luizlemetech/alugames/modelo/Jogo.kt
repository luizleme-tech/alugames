package br.com.luizlemetech.alugames.modelo

import br.com.luizlemetech.alugames.utilitario.formatarComDuasCasas
import com.google.gson.annotations.Expose
import java.math.BigDecimal
import java.math.RoundingMode

data class Jogo(
    @Expose
    val titulo:String,
    @Expose
    val capa:String): Recomendavel {
    var descricao:String? = null
    var preco = BigDecimal.ZERO
    private val listaNotas = mutableListOf<Int>()
    var id: Int? = null

    constructor(titulo: String, capa: String, descricao:String):this(titulo, capa){
        this.descricao = descricao
    }

    constructor(titulo: String, capa: String, preco:Double, descricao: String):this(titulo, capa){
        this.preco = BigDecimal(preco).setScale(2, RoundingMode.HALF_UP)
        this.descricao = descricao
    }

    constructor(titulo: String, capa: String, preco:Double, descricao: String, id:Int):this(titulo, capa){
        this.preco = BigDecimal(preco).setScale(2, RoundingMode.HALF_UP)
        this.descricao = descricao
        this.id = id
    }

    override val media: Double
        get() = listaNotas.average().formatarComDuasCasas()

    override fun recomendar(nota: Int) {
        if (nota < 1 || nota > 10) {
            println("Nota invalida. Insira uma nota entre 1 e 10")
        } else {
            listaNotas.add(nota)
        }
    }

    override fun toString(): String {
        return "\n[Jogo]\n" +
                "Id: $id\n" +
                "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao \n" +
                "Preco: $preco \n" +
                "Reputacao: $media\n"
    }
}