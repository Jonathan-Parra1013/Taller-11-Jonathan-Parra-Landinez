public class Main {
    public static void main(String[] args) {
        System.out.println("=== Viajes Andinos: paquetes vendidos ===");

        PaqueteViaje p1 = new PaqueteViaje.Builder("Cartagena", 4)
                .conVuelo()
                .conHotel("Decameron")
                .conDesayuno()
                .build();

        // p2: Solo hotel + seguro 
        PaqueteViaje p2 = new PaqueteViaje.Builder("Villa de Leyva", 2)
                .conHotel("Posada del Sol")
                .conSeguroViaje()
                .build();

        System.out.println(p1);
        System.out.println(p2);


        try {

            PaqueteViaje p3 = new PaqueteViaje.Builder("", 3)
                    .conTour("Cafe en Salento")
                    .build();
            System.out.println(p3);
        } catch (IllegalArgumentException e) {
            System.out.println("[RECHAZADO] p3: " + e.getMessage());
        }


        try {
            PaqueteViaje p4 = new PaqueteViaje.Builder("San Andres", 0).build();
            System.out.println(p4);
        } catch (IllegalArgumentException e) {
            System.out.println("[RECHAZADO] p4: " + e.getMessage());
        }

        
    }
}