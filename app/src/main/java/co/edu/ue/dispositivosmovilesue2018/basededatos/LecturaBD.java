package co.edu.ue.dispositivosmovilesue2018.basededatos;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import co.edu.ue.dispositivosmovilesue2018.R;

public class LecturaBD extends Activity {
    public static final String nombreArchivo = "nombreArchivo";

    TextView vista;
    private SQLiteDatabase baseDeDatos = null;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lectura_agenda);
        String rutaBD = getIntent().getStringExtra(nombreArchivo);
        vista = (TextView)findViewById(R.id.listado);
        baseDeDatos = this.openOrCreateDatabase(rutaBD, MODE_PRIVATE, null);

        try {
            Cursor cursor = baseDeDatos.rawQuery("select * from AGENDA",null);
            int numeroColumnas = cursor.getColumnCount();
            int numeroFilas = cursor.getCount();
            vista.append("Listado de contactos:\n\n");
            cursor.moveToFirst();
            int i = 1;
            while(i <= numeroFilas){
                String nombres = cursor.getString(1);
                String telefono = cursor.getString(2);
                vista.append(nombres + " - " + telefono + "\n");
                cursor.moveToNext();
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
