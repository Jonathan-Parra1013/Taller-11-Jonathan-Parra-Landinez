public class Cripta extends Nivel {
    public Cripta() { super("Cripta"); }
    @Override
    public Enemigo crearEnemigo() { return new Esqueleto(); }
}