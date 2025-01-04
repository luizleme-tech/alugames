package com.br.luizleme.tech.alugames

import com.br.luizleme.tech.alugames.dominio.Jogo

class InfoJogo(val info: Jogo) {

    override fun toString(): String {
        return info.toString()
    }
}