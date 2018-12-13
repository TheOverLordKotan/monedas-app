package co.edu.ue.dispositivosmovilesue2018.archivos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import co.edu.ue.dispositivosmovilesue2018.R;

public class Agenda extends Activity {

    private EditText campoNombres, campoTelefono;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        File directorio = getExternalFilesDir(null);
        File agenda = new File(directorio + "/agenda", "miAgenda.txt");
    }

    public void guardarRegistro(View vista) throws IOException {

        File directorio = getExternalFilesDir(null);
        File agenda     = new File(directorio + "", "miAgenda.txt");

        try {
            FileOutputStream fos = new FileOutputStream(agenda,  true);
            PrintWriter pw =  new PrintWriter(fos, true);
            campoNombres = (EditText)findViewById(R.id.nombres);
            campoTelefono = (EditText)findViewById(R.id.telefono);
            String registro = campoNombres.getText().toString() + " - " +
            campoTelefono.getText().toString();
            pw.print(registro + "\n");
            pw.flush();
            fos.close();
            Toast.makeText(this,"Su registro ha sido guardado exitosamente", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            String error = e.getMessage();
            Toast.makeText(this,"Error al guardar su registro: " + error, Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    public void leerRegistros(View vista){

        File directorio = getExternalFilesDir(null);
        File agenda     = new File(directorio + "", "miAgenda.txt");
        Intent peticion = new Intent(this, LecturaAgenda.class);
        peticion.putExtra(LecturaAgenda.nombreArchivo, agenda.getAbsolutePath());
        startActivity(peticion);
        Toast.makeText(this,"...listar registros", Toast.LENGTH_SHORT).show();
    }

}
