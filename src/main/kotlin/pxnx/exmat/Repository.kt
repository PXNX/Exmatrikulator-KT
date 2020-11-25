package pxnx.exmat

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

class Repository {
    private lateinit var con: Connection
    private lateinit var stmt: Statement
    private lateinit var rs: ResultSet

    private fun connect() {
        try {
            //    Class.forName("com.mysql.jdbc.Driver")
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exmat", "root", "")
            stmt = con.createStatement()
        } catch (e: Exception) {
            System.err.println(e.message)
        }
    }

    fun showAll() {

        try {
            connect()
            rs = stmt.executeQuery("select * from students")

            while (rs.next()) {
                // Anzeige von matnr, name, note, (nicht)/bestanden
                println(
                    rs.getInt(1).toString() + "  " + rs.getString(2) + "  " + rs.getDouble(3) + "  " + rs.getBoolean(4)
                )
            }

            // Verbindung schlie�en, damit jeder zugreifen kann
            con.close()
        } catch (e: Exception) {
            println(e.message)
        }
    }

    // query = Abfrage
    fun sql(query: String) {

        try {
            connect()
            rs = stmt.executeQuery(query)

            while (rs.next()) {
                // Anzeige von matnr, name, note, (nicht)/bestanden
                println(
                    rs.getInt(1).toString() + "  " + rs.getString(2) + "  " + rs.getDouble(3) + "  " + rs.getBoolean(4)
                )
            }

            // Verbindung schlie�en, damit jeder zugreifen kann
            con.close()
        } catch (e: Exception) {
            println(e.message)
        }
    }

    fun sqlString(query: String): String {
        var result = "name not available"

        try {
            connect()
            rs = stmt.executeQuery(query)
            while (rs.next()) {
                // Anzeige von matnr, name, note, (nicht)/bestanden
                result = rs.getString(1)
                println(result)
            }
            con.close()
        } catch (e: Exception) {
            println(e.message)
        }
        return result
    }

    fun sqlStudent(matnr: Int): Student {

        val result = Student()

        try {
            connect()
            rs = stmt.executeQuery("select name, grade, exmat from students where matnr = $matnr")

            while (rs.next()) {
                result.matnr = matnr
                result.name = rs.getString(1)
                result.grade = rs.getDouble(2)
                result.isExmat = rs.getBoolean(3)
                println(result)
            }
            con.close()
        } catch (e: Exception) {
            System.err.println(e.message)
        }
        return result
    }
}