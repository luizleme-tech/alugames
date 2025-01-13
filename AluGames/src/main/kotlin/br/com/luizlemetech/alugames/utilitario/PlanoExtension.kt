package br.com.luizlemetech.alugames.utilitario

import br.com.luizlemetech.alugames.dados.entities.PlanoAssinaturaEntity
import br.com.luizlemetech.alugames.dados.entities.PlanoAvulsoEntity
import br.com.luizlemetech.alugames.dados.entities.PlanoEntity
import br.com.luizlemetech.alugames.modelo.Plano
import br.com.luizlemetech.alugames.modelo.PlanoAssinatura
import br.com.luizlemetech.alugames.modelo.PlanoAvulso
import java.math.BigDecimal

fun Plano.toEntity(): PlanoEntity {
    return if (this is PlanoAssinatura) {
        PlanoAssinaturaEntity(this.tipo, this.mensalidade, this.jogosIncluidos, this.percentualDescontoReputacao.toDouble(), this.id)
    } else {
        PlanoAvulsoEntity(this.tipo, this.id)
    }
}

fun PlanoEntity.toModel(): Plano {
    return if (this is PlanoAssinaturaEntity) {
        PlanoAssinatura(this.tipo, this.mensalidade, this.jogosIncluidos, BigDecimal.valueOf(this.percentualDescontoReputacao), this.id)
    } else {
        PlanoAvulso(this.tipo, this.id)
    }
}