public class Juego {
    // Recibe la abstracción 'Nivel' en lugar de un String
    public void jugarNivel(Nivel nivel, int cantidadEnemigos) {
        System.out.println(">> Entrando a: " + nivel.getNombre());
        for (int i = 0; i < cantidadEnemigos; i++) {
            Enemigo enemigo = nivel.crearEnemigo();
            enemigo.atacar();
        }
    }
}