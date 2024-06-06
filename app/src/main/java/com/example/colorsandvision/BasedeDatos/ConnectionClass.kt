package com.example.colorsandvision.BasedeDatos

import android.util.Log
import java.sql.Connection
import java.sql.DriverManager
import java.util.Objects

class ConnectionClass {
    companion object {
        protected const val db: String = "INTEF_SQL"
        protected const val ip: String = "bvfmo3g7csbyblhrgbbh-mysql.services.clever-cloud.com"
        protected const val port: String = "3306"
        protected const val username: String = "ud338dlnvyvxpqbr"
        protected const val password: String = "vUsUfq8ZhiGa2ifjzbiy"

        fun CONN(): Connection? {
            var conn: Connection? = null
            try {
                Class.forName("com.mysql.jdbc.Driver")
                val connectionString = "jdbc:mysql://$ip:$port/$db"
                conn = DriverManager.getConnection(connectionString, username, password)
            } catch (e: Exception) {
                Objects.requireNonNull(e.message)?.let { Log.e("ERRO", it) }
            }
            return conn
        }
    }
}