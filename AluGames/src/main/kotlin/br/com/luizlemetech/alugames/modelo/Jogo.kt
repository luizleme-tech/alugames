package br.com.luizlemetech.alugames.modelo

data class Jogo(val titulo:String,
           val capa:String) {
    var descricao:String? = null

    constructor(titulo: String, capa: String, descricao:String):this(titulo, capa){
        this.descricao = descricao
    }

    override fun toString(): String {
        return "\n[Jogo]\n" +
                "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao"
    }
}