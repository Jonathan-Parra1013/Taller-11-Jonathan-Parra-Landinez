public class Castillo extends Nivel {
    public Castillo() { super("Castillo"); }
    @Override
    public Enemigo crearEnemigo() { return new Fantasma(); }
}