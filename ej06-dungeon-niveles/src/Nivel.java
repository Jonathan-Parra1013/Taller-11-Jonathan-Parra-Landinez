public abstract class Nivel {
    private String nombre;

    public Nivel(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // Este es Factory Method :DDD 
    public abstract Enemigo crearEnemigo();
}
