public class Main {
    public static void main(String[] args) {
        TaquillaFisica taquilla = new TaquillaFisica();
        AppWeb app = new AppWeb();

        System.out.println("=== CineLibre: estreno, funcion 7:00 p.m., sala 1 ===");

        // Boleta 3D, silla VIP, combo nachos, sin descuento
        Boleta b1 = new Boleta.Builder("Amazonas Perdido", "F7")
                .con3D()
                .conSillaVip()
                .conCombo("nachos")
                .build();
        taquilla.vender(b1);

        // Boleta 2D, silla normal, sin combo, CON descuento estudiante (Corregido con Builder)
        Boleta b2 = new Boleta.Builder("Amazonas Perdido", "F8")
                .conTarifaEstudiante()
                .build();
        app.comprar(b2);

        // Alguien compra por la app la misma silla que ya vendio la taquilla
        Boleta b3 = new Boleta.Builder("Amazonas Perdido", "F7")
                .conCombo("crispetas")
                .build();
        app.comprar(b3);

        System.out.println();
        System.out.println("ESPERADO -> la boleta F8 sale con tarifa estudiante y sin VIP,");
        System.out.println("            y la segunda venta de F7 debe ser RECHAZADA");
    }
}