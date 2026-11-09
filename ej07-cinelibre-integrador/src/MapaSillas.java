import java.util.ArrayList;

public class MapaSillas {

    private static MapaSillas instancia;
    private ArrayList<String> ocupadas = new ArrayList<>();

    private MapaSillas() { }

    public static MapaSillas getInstance() {
        if (instancia == null) {
            instancia = new MapaSillas();
        }
        return instancia;
    }

    public boolean reservar(String silla) {
        if (ocupadas.contains(silla)) {
            return false;
        }
        ocupadas.add(silla);
        return true;
    }
}