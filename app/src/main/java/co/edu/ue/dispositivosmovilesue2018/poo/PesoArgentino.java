package co.edu.ue.dispositivosmovilesue2018.poo;

public class PesoArgentino extends Moneda {

    public static final double VALOR_CAMBIO_DOLAR = 35.67;

    @Override
    public double convertirDeDolaresAMoneda() {
        double valorPesos = getValor();
        double valorConversion = valorPesos * VALOR_CAMBIO_DOLAR;
        return valorConversion;
    }

    @Override
    public double convertirDeMonedaADolares() {
        double valorPesos = getValor();
        double valorConversion = valorPesos/ VALOR_CAMBIO_DOLAR;
        return valorConversion;
    }

    @Override
    public String obtenerTipoMoneda() {
        return "Peso argentino";
    }
}
