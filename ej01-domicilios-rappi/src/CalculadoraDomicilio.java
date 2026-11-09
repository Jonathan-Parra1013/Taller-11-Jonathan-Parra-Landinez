public class CalculadoraDomicilio {
    public double calcular(double km) {
        ConfiguracionApp config = ConfiguracionApp.getInstance();
        return config.getTarifaBase()
             + km * config.getValorPorKm()
             + config.getRecargoLluvia();
    }
}