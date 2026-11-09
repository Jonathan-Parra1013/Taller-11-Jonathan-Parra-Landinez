public class NotificacionFactory {
    public static CanalNotificacion crearCanal(String canal) {
        if (canal.equalsIgnoreCase("SMS")) {
            return new Sms();
        } else if (canal.equalsIgnoreCase("EMAIL")) {
            return new Email();
        } else if (canal.equalsIgnoreCase("PUSH")) {
            return new Push();
        } else if (canal.equalsIgnoreCase("WHATSAPP")) {
            return new WhatsApp();
        }
        throw new IllegalArgumentException("Canal de notificación no soportado: " + canal);
    }
}