public class ConfiguracionApp {

    private static int vecesCargada = 0;
    private static ConfiguracionApp instancia; // ahora la instancia es privada :D

    private double tarifaBase;
    private double valorPorKm;
    private double recargoLluvia;

    // Constructor privado
    private ConfiguracionApp() {
        vecesCargada++;
        System.out.println("   >> Leyendo config.properties... (carga #" + vecesCargada + ")");
        this.tarifaBase = 4500;
        this.valorPorKm = 800;
        this.recargoLluvia = 0;
    }

    public static ConfiguracionApp getInstance() {
        if (instancia == null) {
            instancia = new ConfiguracionApp();
        }
        return instancia;
    }

    public double getTarifaBase()    { return tarifaBase; }
    public double getValorPorKm()    { return valorPorKm; }
    public double getRecargoLluvia() { return recargoLluvia; }

    public void setRecargoLluvia(double recargoLluvia) {
        this.recargoLluvia = recargoLluvia;
    }
}