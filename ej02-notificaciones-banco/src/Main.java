public class Main {
    public static void main(String[] args) {
        ServicioNotificaciones servicio = new ServicioNotificaciones();

        System.out.println("=== BancoPlata: notificaciones ===");
        servicio.notificarTransferencia("SMS", "laura", 150000);
        servicio.notificarTransferencia("EMAIL", "andres", 80000);
        servicio.notificarCodigoSeguridad("PUSH", "sofia", "482913");

        // NUEVO REQUERIMIENTO: el banco quiere notificar por WhatsApp
        servicio.notificarTransferencia("WHATSAPP", "camilo", 50000);


    }
}
