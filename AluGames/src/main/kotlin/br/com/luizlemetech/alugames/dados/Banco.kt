package br.com.luizlemetech.alugames.dados

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object Banco {
    fun obterConexao(): Connection? {
        return try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/alugames", "alugames_user", "alugames_password")
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }
}