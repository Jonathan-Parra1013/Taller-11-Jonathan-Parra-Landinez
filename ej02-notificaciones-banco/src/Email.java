public class Email implements CanalNotificacion {
    @Override
    public void enviar(String usuario, String mensaje) {
        System.out.println("  [EMAIL a " + usuario + "@correo.com] " + mensaje);
    }
}