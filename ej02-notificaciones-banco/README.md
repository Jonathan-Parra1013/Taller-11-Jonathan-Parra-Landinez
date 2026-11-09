# BancoPlata - Ejercicio 2 :D

## Descripción del Problema
El banco digital notifica transferencias y códigos de seguridad por SMS, correo y push. El área de producto solicitó agregar el canal de WhatsApp, pero la notificación simplemente no salía. 

Esto ocurría porque la lógica para decidir qué objeto de notificación crear (un bloque `if / else if`) estaba fuertemente acoplada y duplicada en los métodos `notificarTransferencia` y `notificarCodigoSeguridad` de la clase `ServicioNotificaciones`. Agregar WhatsApp implicaba repetir código y modificar una clase de negocio agregando más bloques `else if`.

## La Solución
Se aplicó el patrón de diseño creacional **Factory Method** (en su variante de *Simple Factory*) combinado con **Polimorfismo**. Este patrón delega la responsabilidad de la creación de los objetos a una clase especializada (fábrica) y los devuelve a través de una interfaz común.

## ¿Qué se cambió?

1. **Se extrajo el comportamiento común (Nueva Interfaz y Clases):**
   * Se creó la interfaz `CanalNotificacion` con el método común `void enviar(String usuario, String mensaje);`.
   * Se ajustaron las clases `Sms`, `Email` y `Push` para que implementaran esta interfaz.
   * Se creó la nueva clase `WhatsApp` implementando también la misma interfaz.

2. **Se creó la fábrica (`NotificacionFactory.java`):**
   * Se creó una nueva clase con un método estático `crearCanal(String canal)` que evalúa el texto recibido y retorna una instancia del canal correspondiente (de tipo `CanalNotificacion`).

3. **En `ServicioNotificaciones.java` (La clase consumidora):**
   * Se eliminaron todos los bloques `if/else if` duplicados.
   * Se reemplazaron por el llamado a la fábrica: `CanalNotificacion notificacion = NotificacionFactory.crearCanal(canal);`.
   * Se utilizó polimorfismo para enviar el mensaje: `notificacion.enviar(usuario, mensaje);`.

## ¿Por qué lo cambiamos?

* **Desacoplamiento y Responsabilidad Única:** La clase `ServicioNotificaciones` ya no necesita conocer los detalles de cómo instanciar un canal de SMS o WhatsApp; solo se enfoca en su lógica de negocio (construir el texto del mensaje y solicitar el envío).
* **Principio Abierto/Cerrado (Open/Closed Principle):** Si el banco decide agregar un quinto canal (ej. Telegram), ya no hay que modificar ni alterar el servicio principal. Solo se crea la clase nueva y se añade a la fábrica.
* **Reutilización de código:** Se eliminó la duplicación masiva de condicionales, dejando los métodos mucho más limpios.

## Resultados esperados al ejecutar (`Main.java`)
* La línea de notificación de WhatsApp aparece correctamente en consola.
* Los cuatro canales de notificación funcionan utilizando el mismo método polimórfico sin agregar ningún otro `else if`.