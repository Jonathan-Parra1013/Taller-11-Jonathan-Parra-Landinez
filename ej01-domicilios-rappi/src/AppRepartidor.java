public class AppRepartidor {
    public void mostrarGanancia(double km) {
        ConfiguracionApp config = ConfiguracionApp.getInstance();
        double ganancia = km * config.getValorPorKm() + config.getRecargoLluvia();
        System.out.println("[Repartidor] Ganancia por " + km + " km: $" + ganancia);
    }
}