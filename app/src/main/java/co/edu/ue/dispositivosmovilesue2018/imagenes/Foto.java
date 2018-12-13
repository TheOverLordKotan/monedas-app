package co.edu.ue.dispositivosmovilesue2018.imagenes;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import co.edu.ue.dispositivosmovilesue2018.R;


public class Foto extends Activity implements View.OnClickListener {

    private ImageView foto;

    private TextView tv;

    private MediaPlayer mplayer;

    int [] fotoID = {R.drawable.foto1, R.drawable.foto2, R.drawable.foto3, R.drawable.foto4};
    String[] texto = {"Foto", "Foto 2","Foto 3","Foto 4"};
    int i = 0;
    int total ;

    @Override
    public void onCreate(Bundle instancia){
        super.onCreate(instancia);
        setContentView(R.layout.activity_foto);

        Button anterior = (Button)findViewById(R.id.button1foto);
        Button siguiente = (Button)findViewById(R.id.button2foto);
        ImageButton botonFoto = (ImageButton) findViewById(R.id.botonImagen);
        anterior.setOnClickListener(this);
        siguiente.setOnClickListener(this);
        botonFoto.setOnClickListener(this);

        tv = (TextView)findViewById(R.id.textViewFoto);
        foto = (ImageView)findViewById(R.id.imageView);
        total = fotoID.length;
        reproducirCancionFondo();
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        if(id == R.id.button2foto) {
            i++;
            if(i == total){
                i =0;
            }
        }

        if(id == R.id.button1foto){
            i--;
            if(i == -1){
                i =total -1;
            }
        }

        foto.setImageResource(fotoID[i]);
        tv.setText("Mi " + texto[i]);
    }

    public void reproducirCancionFondo(){
        if(mplayer  != null){
            mplayer.release();
        }

        mplayer = MediaPlayer.create(this, R.raw.cancion_fondo);
        mplayer.seekTo(0)   ;
        mplayer.start();
    }
}
