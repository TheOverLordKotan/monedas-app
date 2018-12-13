package co.edu.ue.dispositivosmovilesue2018.poo;

public class PesoYen extends Moneda {

    public static final double VALOR_DOLAR = 27.98;

    @Override
    public double convertirDeDolaresAMoneda() {
        double valorPesos = getValor();
        double valorConversion = valorPesos * VALOR_DOLAR;
        return valorConversion;
    }

    @Override
    public double convertirDeMonedaADolares() {
        double valorPesos = getValor();
        double valorConversion = valorPesos/VALOR_DOLAR;
        return valorConversion;
    }

    @Override
    public String obtenerTipoMoneda() {
        return "Peso colombiano";
    }
}
