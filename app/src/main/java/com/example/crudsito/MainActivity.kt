package com.example.crudsito

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.sql.PreparedStatement
import java.sql.SQLException

lateinit var CajitaNombre: EditText
lateinit var CajitaCodigo: EditText
lateinit var Boton: Button


class MainActivity : AppCompatActivity() {

    private var connectSQL = ConnectSQL()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CajitaNombre = findViewById(R.id.txtNombre)
        CajitaCodigo = findViewById(R.id.txtCodigo)
        Boton = findViewById(R.id.btnEnviar)
        Boton.setOnClickListener {
            try {
                val addJugador: PreparedStatement = connectSQL.dbConn()?.prepareStatement("insert into jugador values (?,?)")!!
                addJugador.setString(1, CajitaNombre.text.toString())
                addJugador.setString(2, CajitaCodigo.text.toString())
                addJugador.executeUpdate()
                Toast.makeText(this, "Jugador Ingresado Correctamente", Toast.LENGTH_SHORT).show()
            }catch (ex: SQLException){
                Toast.makeText(this, "Error al ingresar :(", Toast.LENGTH_SHORT).show()
            }



        }

    }
}