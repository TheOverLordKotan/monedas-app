package co.edu.ue.dispositivosmovilesue2018.archivos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import co.edu.ue.dispositivosmovilesue2018.R;

public class LecturaAgenda extends Activity {
    public static final String nombreArchivo = "nombreArchivo";

    TextView vista;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lectura_agenda);
        String rutaAsoluta = getIntent().getStringExtra(nombreArchivo);
        vista = (TextView)findViewById(R.id.listado);

        File archivo = new File(rutaAsoluta);
        try {
            FileInputStream fis = new FileInputStream(archivo);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader buffer = new BufferedReader(isr);
            String linea = "";
            vista.append("Listado de contactos:\n\n");
            while((linea = buffer.readLine()) != null){
                vista.append(linea + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
