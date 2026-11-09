public class Main {
    public static void main(String[] args) {
        System.out.println("=== BurgerLab: pedidos del dia ===");


        Hamburguesa h1 = new Hamburguesa.Builder("res", 2)
                .conTocineta()
                .conSalsa("bbq")
                .build();


        Hamburguesa h2 = new Hamburguesa.Builder("pollo", 1)
                .conPepinillos()
                .build();


        Hamburguesa h3 = new Hamburguesa.Builder("veggie", 3)
                .conPan("integral")
                .conQueso()
                .conTocineta()
                .conCebollaCaramelizada()
                .conPepinillos()
                .conSalsa("de la casa")
                .conPapasAgrandadas()
                .build();

        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);


        try {
            Hamburguesa h4 = new Hamburguesa.Builder("res", 7)
                    .conSalsa("miel mostaza")
                    .build();
            System.out.println(h4);
        } catch (IllegalArgumentException e) {
            System.out.println("[RECHAZADO] Pedido 4: " + e.getMessage());
        }

    }
}
