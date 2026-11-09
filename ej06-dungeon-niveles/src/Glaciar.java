public class Glaciar extends Nivel {
    public Glaciar() { super("Glaciar"); }
    @Override
    public Enemigo crearEnemigo() { return new Golem(); }
}