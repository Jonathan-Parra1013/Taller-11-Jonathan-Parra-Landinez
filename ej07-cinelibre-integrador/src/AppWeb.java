public class AppWeb {

    // En AppWeb.java y TaquillaFisica.java se cambio
    private MapaSillas mapa = MapaSillas.getInstance();

    public void comprar(Boleta boleta) {
        if (mapa.reservar(boleta.getSilla())) {
            System.out.println("  [App]      VENDIDA: " + boleta);
        } else {
            System.out.println("  [App]      RECHAZADA, silla ocupada: " + boleta.getSilla());
        }
    }
}
