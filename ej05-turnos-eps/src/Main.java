public class Main {
    public static void main(String[] args) {
        Ventanilla v1 = new Ventanilla("Ventanilla 1");
        Ventanilla v2 = new Ventanilla("Ventanilla 2");
        KioscoDigital kiosco = new KioscoDigital();

        System.out.println("=== EPS SaludYa: lunes 7:00 a.m. ===");
        v1.asignarTurno("Martha");
        v2.asignarTurno("Jorge");
        kiosco.pedirTurno("Valentina");
        v1.asignarTurno("Luis");
        kiosco.pedirTurno("Camila");


    }
}
