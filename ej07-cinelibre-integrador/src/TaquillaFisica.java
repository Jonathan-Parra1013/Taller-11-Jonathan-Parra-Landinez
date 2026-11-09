public class TaquillaFisica {

    // En AppWeb.java y TaquillaFisica.java se cambio
    private MapaSillas mapa = MapaSillas.getInstance();

    public void vender(Boleta boleta) {
        if (mapa.reservar(boleta.getSilla())) {
            System.out.println("  [Taquilla] VENDIDA: " + boleta);
        } else {
            System.out.println("  [Taquilla] RECHAZADA, silla ocupada: " + boleta.getSilla());
        }
    }
}
