package co.edu.ue.dispositivosmovilesue2018;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import co.edu.ue.dispositivosmovilesue2018.poo.Moneda;
import co.edu.ue.dispositivosmovilesue2018.poo.PesoColombiano;
import co.edu.ue.dispositivosmovilesue2018.poo.PesoDollar;
import co.edu.ue.dispositivosmovilesue2018.poo.PesoEuro;
import co.edu.ue.dispositivosmovilesue2018.poo.PesoPeruano;
import co.edu.ue.dispositivosmovilesue2018.poo.PesoRupia;
import co.edu.ue.dispositivosmovilesue2018.poo.PesoYen;

public class ConversionMoneda extends Activity implements View.OnClickListener {

    private EditText valorCambio;
    private TextView respuesta;
    private Spinner listado;
    private String conversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_moneda);
        //Elemento utilizado para listar elementos
        listado = (Spinner)findViewById(R.id.spinner);
        String [] opciones = {"PESOPERUANO", "EURO","YEN","LIBRAS","DOLLAR","RUPIAS"};
        listado.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones));
        //cuando el usuario selecciona un registro de un spinner
        String opcion = listado.getSelectedItem().toString();
        System.out.print("Opcion es " + opcion);
        /**El metodo findView ... se usa para enlazar cada elemento de
         * la vista(xml) con esta clase, a través del id**/
        valorCambio = (EditText)findViewById(R.id.valorCambio);
        respuesta =  (TextView) findViewById(R.id.respuesta);
        View boton = findViewById(R.id.botonConversion);
        boton.setOnClickListener(this);//Se asocia un escuchador de eventos de ratón al botón
    }

    @Override
    public void onClick(View v) {
        calcularValor();
    }

    private void calcularValor(){
        double valorCambioPesos =0;
        try{
            valorCambioPesos = Double.parseDouble(valorCambio.getText().toString());
            Moneda pesoColombiano = new PesoColombiano();
            Moneda pesoDolla = new PesoDollar();
            Moneda pesoEuro = new PesoEuro();
            Moneda pesoSol = new PesoPeruano();
            Moneda pesoRupia = new PesoRupia();
            Moneda pesoYen = new PesoYen();


            pesoColombiano.setValor(valorCambioPesos);
            pesoDolla.setValor(valorCambioPesos);
            pesoEuro.setValor(valorCambioPesos);
            pesoSol.setValor(valorCambioPesos);
            pesoRupia.setValor(valorCambioPesos);
            pesoYen.setValor(valorCambioPesos);
            String opcion = listado.getSelectedItem().toString();

            String resultado = "";
            if(opcion.equals("PESOPERUANO")){
                double valorDolares = pesoSol.convertirDeMonedaADolares();
                resultado = "El valor de " + formatearValorMoneda(valorCambioPesos) + " pesos  es de $"
                        + formatearValorMoneda(valorDolares) + " pesoSol";
            }if(opcion.equals("EURO")){
                double valorDolares = pesoEuro.convertirDeDolaresAMoneda();
                resultado = "El valor de " + formatearValorMoneda(valorCambioPesos) + " pesoEuro es de $"
                        + formatearValorMoneda(valorDolares) + " " + pesoEuro.obtenerTipoMoneda();;
            }if(opcion.equals("YEN")){
                double valorDolares = pesoYen.convertirDeDolaresAMoneda();
                resultado = "El valor de " + formatearValorMoneda(valorCambioPesos) + " pesoYen es de $"
                        + formatearValorMoneda(valorDolares) + " " + pesoColombiano.obtenerTipoMoneda();;
            }if(opcion.equals("LIBRAS")){
                double valorDolares = pesoColombiano.convertirDeDolaresAMoneda();
                resultado = "El valor de " + formatearValorMoneda(valorCambioPesos) + " dólares es de $"
                        + formatearValorMoneda(valorDolares) + " " + pesoColombiano.obtenerTipoMoneda();;
            }if(opcion.equals("DOLLAR")){
                double valorDolares = pesoDolla.convertirDeDolaresAMoneda();
                resultado = "El valor de " + formatearValorMoneda(valorCambioPesos) + " dólares es de $"
                        + formatearValorMoneda(valorDolares) + " " + pesoDolla.obtenerTipoMoneda();;
            }if(opcion.equals("RUPIAS")){
                double valorDolares = pesoRupia.convertirDeDolaresAMoneda();
                resultado = "El valor de " + formatearValorMoneda(valorCambioPesos) + " pesoRupia es de $"
                        + formatearValorMoneda(valorDolares) + " " + pesoRupia.obtenerTipoMoneda();;
            }
            respuesta.setText(resultado);
        } catch (Exception e) {
            Toast.makeText(this,"Tipo de dato ingresado es inválido", Toast.LENGTH_SHORT).show();
        }
    }

    private String formatearValorMoneda(double valor) {
        DecimalFormat formateador = new DecimalFormat("###,###.##");
        return formateador.format(valor);
    }

}
