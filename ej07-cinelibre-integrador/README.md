# Taller 11 · Ejercicio 7 

Programación 1 (POO) · Universidad Libre · Docente: Andrés Castaño

## Descripción del Problema
Este ejercicio integrador presenta dos problemas de diseño. Primero, la `TaquillaFisica` y la `AppWeb` instanciaban sus propios objetos `MapaSillas` mediante `new MapaSillas()`, causando que el estado de los asientos vendidos no se sincronizara (permitiendo sobreventa). 

Segundo, la clase `Boleta` sufría del antipatrón **Constructor Telescópico**, teniendo un constructor con múltiples parámetros booleanos consecutivos que resultaban propensos a errores humanos, como asignar por error VIP en lugar de tarifa de estudiante en la boleta de la silla F8.

## La Solución
Se aplicaron **dos** patrones de diseño creacionales simultáneamente: **Singleton** y **Builder**.

## ¿Qué se cambió?

1. **Singleton en `MapaSillas.java`:**
   * Se modificó el constructor a `private` para impedir creaciones libres.
   * Se agregó el método estático `getInstance()` para asegurar una única instancia global de las sillas compartida entre Taquilla y App.
   * En `AppWeb` y `TaquillaFisica` se eliminó el operador `new` y se referenció la instancia global.

2. **Builder en `Boleta.java`:**
   * Se eliminó el constructor público con 6 parámetros.
   * Se implementó una clase estática interna `Builder` que exige en su constructor exclusivamente la `pelicula` y la `silla`, añadiendo una validación para evitar que nazcan nulas o vacías.
   * Se crearon métodos de interfaz fluida (Fluent Interface) para agregar de forma explícita las propiedades opcionales (`con3D()`, `conSillaVip()`, etc).

## ¿Por qué lo cambiamos?
* **Unicidad de estado:** Al unificar el mapa mediante Singleton, la segunda venta sobre la silla F7 es detectada inmediatamente como inválida.
* **Legibilidad y Seguridad:** Al utilizar Builder, se erradicó la cadena de booleanos ciegos. El código de construcción de boletas en `Main.java` pasó de ser un enjambre incomprensible a una declaración paso a paso que refleja fielmente las intenciones del usuario sin posibilidad de confundir parámetros.

## Resultados esperados al ejecutar (`Main.java`)
* La boleta F8 muestra explícitamente "tarifa estudiante" pero NO "VIP", corrigiendo el error original del programador.
* La segunda venta (la silla F7 comprada por la app) resulta en un estado **RECHAZADA**, ya que se valida exitosamente contra el mapa modificado previamente por la taquilla.