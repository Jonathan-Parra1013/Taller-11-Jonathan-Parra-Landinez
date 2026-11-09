public class GeneradorTurnos {

    private static GeneradorTurnos instancia;
    private int consecutivo = 0;


    private GeneradorTurnos() {
    }

    public static GeneradorTurnos getInstance() {
        if (instancia == null) {
            instancia = new GeneradorTurnos();
        }
        return instancia;
    }

    public String siguienteTurno() {
        consecutivo++;
        return "T-" + String.format("%03d", consecutivo);
    }
}