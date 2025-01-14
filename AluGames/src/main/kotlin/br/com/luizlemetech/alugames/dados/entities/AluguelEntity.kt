package br.com.luizlemetech.alugames.dados.entities

import br.com.luizlemetech.alugames.modelo.Periodo
import javax.persistence.*

@Entity
@Table(name = "aluguel")
open class AluguelEntity(
    @ManyToOne
    val gamer:GamerEntity = GamerEntity(),
    @ManyToOne
    val jogo:JogoEntity = JogoEntity(),
    @Embedded
    val periodo: Periodo = Periodo()) {
    var valorDoAluguel: Double = 0.0
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0
}