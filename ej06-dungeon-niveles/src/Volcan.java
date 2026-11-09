public class Volcan extends Nivel {
    public Volcan() { super("Volcan"); }
    @Override
    public Enemigo crearEnemigo() { return new Dragon(); }
}