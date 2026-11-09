# Taller 11 · Ejercicio 3 — BurgerLab

Programación 1 (POO) · Universidad Libre · Docente: Andrés Castaño

## Descripción del Problema
En la versión inicial del sistema, la clase `Hamburguesa` sufría del antipatrón del "Constructor Telescópico", teniendo un constructor con 9 parámetros, muchos de ellos booleanos y sin contexto descriptivo. Esto provocaba errores humanos al momento de digitar los pedidos (por ejemplo, el cajero puso `true` en el queso y `false` en la tocineta por error en el pedido 1) y no aplicaba restricciones de negocio como el límite máximo de 3 porciones de proteína.

## La Solución
Se aplicó el patrón de diseño creacional **Builder**. Este patrón permite la creación de objetos complejos paso a paso, diferenciando claramente los parámetros obligatorios de los opcionales y logrando un código mucho más legible.

## ¿Qué se cambió?

1. **En `Hamburguesa.java`:**
   * Se cambió el constructor original a `private` para obligar a usar el Builder en lugar de instanciar directamente con `new`.
   * Se creó la clase estática interna `Builder`.
   * En el constructor del `Builder` se exigen exclusivamente los parámetros obligatorios (`proteina` y `porciones`), añadiendo una validación que lanza un `IllegalArgumentException` si las porciones superan el límite de 3 o son menores a 1.
   * Se asignaron valores por defecto directamente en los atributos de la clase Builder (`pan = "brioche"` y `salsa = "ninguna"`).
   * Se agregaron métodos encadenables y expresivos (ej. `conTocineta()`, `conSalsa(String)`) para configurar los parámetros opcionales.

2. **En la clase consumidora (`Main.java`):**
   * Se eliminaron los llamados al constructor gigante.
   * Se reemplazaron por el encadenamiento de métodos del Builder. Esto hace explícito qué ingredientes lleva cada pedido sin tener que memorizar o adivinar la posición de los `boolean` de cada ingrediente.
   * Se envolvió la creación del Pedido 4 en un bloque `try-catch` para capturar la excepción y que se imprima el mensaje de rechazo de forma controlada.

## ¿Por qué lo cambiamos?

* **Legibilidad y Mantenibilidad:** Ya no hay que adivinar qué significa el quinto `false` en un pedido. El código cliente ahora se lee de forma natural y autoexplicativa (`new Builder("res", 2).conTocineta().build()`).
* **Integridad de Datos:** Al validar la cantidad de porciones dentro de la construcción del objeto, garantizamos que el objeto nazca en un estado válido. Es imposible que circulen hamburguesas con 7 carnes por el sistema.
* **Flexibilidad:** El sistema maneja de forma automática los valores por defecto. Si un cliente no quiere salsa ni agrandar el combo, esos métodos simplemente se omiten, limpiando el código cliente de docenas de variables `false` o `null` de relleno.

## Resultados esperados al ejecutar (`Main.java`)
* El Pedido 1 sale correctamente configurado **con tocineta y sin queso**.
* Los pedidos sin pan definido toman automáticamente el **"brioche"** y los que no definen salsa toman la cadena **"ninguna"**.
* El Pedido 4 es **RECHAZADO** con un error en pantalla indicando que supera el máximo de 3 porciones.