public class KioscoDigital {

    public void pedirTurno(String paciente) {
        // Se usa la instancia compartida en lugar de crear una nueva
        GeneradorTurnos generador = GeneradorTurnos.getInstance();
        System.out.println("  [Kiosco] " + paciente + " -> " + generador.siguienteTurno());
    }
}