public class Main {
    public static void main(String[] args) {
        Juego juego = new Juego();

        System.out.println("=== Dungeon Libre ===");
        // Pasamos las instancias concretas de los niveles
        juego.jugarNivel(new Cripta(), 2);
        juego.jugarNivel(new Castillo(), 1);
        juego.jugarNivel(new Glaciar(), 1);

        // NUEVO NIVEL (DLC): Volcan, con enemigos tipo Dragon (-25 HP)
        juego.jugarNivel(new Volcan(), 2);

        System.out.println();
        System.out.println("ESPERADO -> el Volcan genera 2 Dragones y la clase que recorre el nivel");
        System.out.println("            NO vuelve a modificarse para agregar mas niveles");
    }
}