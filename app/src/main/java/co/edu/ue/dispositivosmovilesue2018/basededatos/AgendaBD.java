package co.edu.ue.dispositivosmovilesue2018.basededatos;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import co.edu.ue.dispositivosmovilesue2018.R;
import co.edu.ue.dispositivosmovilesue2018.archivos.LecturaAgenda;

public class AgendaBD extends Activity {

    private static final String RUTA_BD_EQUIPO = "testBDUE2018.db";
    private EditText campoNombres, campoTelefono;
    private SQLiteDatabase baseDeDatos;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        baseDeDatos = this.openOrCreateDatabase(RUTA_BD_EQUIPO, MODE_PRIVATE, null);
        baseDeDatos.execSQL("CREATE TABLE IF NOT EXISTS AGENDA (ID INTEGER PRIMARY KEY AUTOINCREMENT, NOMBRES TEXT, TELEFONO TEXT);");
        System.out.println("Base de datos " + baseDeDatos);
    }

    public void guardarRegistro(View vista) throws IOException {

        try {
            campoNombres = (EditText)findViewById(R.id.nombres);
            campoTelefono = (EditText)findViewById(R.id.telefono);
            String nombres = campoNombres.getText().toString();
            String telefono =  campoTelefono.getText().toString();
            baseDeDatos.execSQL("INSERT INTO AGENDA(NOMBRES,TELEFONO) " +
                    "VALUES('" + nombres + "', '" + telefono + "');");
            Toast.makeText(this,"Su registro ha sido guardado exitosamente", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            String error = e.getMessage();
            Toast.makeText(this,"Error al guardar su registro: " + error, Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    public void leerRegistros(View vista){

        Intent peticion = new Intent(this, LecturaBD.class);
        peticion.putExtra(LecturaBD.nombreArchivo, RUTA_BD_EQUIPO);
        startActivity(peticion);
        Toast.makeText(this,"...listar registros BD...", Toast.LENGTH_SHORT).show();
    }
}
