package br.com.luizlemetech.alugames.utilitario

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

fun Double.formatarComDuasCasas() : Double {
    val formatador = DecimalFormat("#.00", DecimalFormatSymbols(Locale.US))
    return formatador.format(this).toDouble()
}