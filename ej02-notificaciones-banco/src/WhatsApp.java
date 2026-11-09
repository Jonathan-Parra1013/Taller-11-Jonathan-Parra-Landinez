// clase nueva 
public class WhatsApp implements CanalNotificacion {
    @Override
    public void enviar(String usuario, String mensaje) {
        System.out.println("  [WHATSAPP a " + usuario + "] " + mensaje);
    }
}