public class Push implements CanalNotificacion {
    @Override
    public void enviar(String usuario, String mensaje) {
        System.out.println("  [PUSH al celular de " + usuario + "] " + mensaje);
    }
}
