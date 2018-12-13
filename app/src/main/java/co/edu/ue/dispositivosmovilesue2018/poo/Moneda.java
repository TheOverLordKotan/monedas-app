package co.edu.ue.dispositivosmovilesue2018.poo;

public abstract class Moneda {

    private double valor;

    public final String DOLAR = "Dólar";

    public abstract  double convertirDeDolaresAMoneda();

    public abstract double convertirDeMonedaADolares();

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public abstract String obtenerTipoMoneda();
}
