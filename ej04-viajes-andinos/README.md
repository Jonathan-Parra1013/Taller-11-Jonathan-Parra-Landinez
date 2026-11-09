# Viajes Andinos - Ejercicio 4

## Descripción del Problema
En la versión inicial del sistema, la clase `PaqueteViaje` utilizaba múltiples constructores sobrecargados (constructor telescópico) y métodos *setters*. Esto generaba dos grandes inconvenientes:
1. Las instancias con opciones específicas obligaban a pasar valores nulos o booleanos (`false`) difíciles de leer, perjudicando la legibilidad.
2. Al usar el constructor vacío seguido de *setters*, los asesores podían olvidar asignar campos obligatorios (como el destino) o asignar valores inválidos (0 noches) creando objetos en estado inconsistente.

## La Solución
Se aplicó el patrón de diseño creacional **Builder** en la clase `PaqueteViaje`. Este patrón permite la construcción paso a paso de objetos complejos, asegura que los campos obligatorios se establezcan primero y previene la creación de la instancia si no se cumplen las reglas de negocio.

## ¿Qué se cambió?

1. **En `PaqueteViaje.java`:**
   * Se hicieron todos los atributos inmutables (`private final`).
   * Se eliminaron todos los métodos `setters` públicos y los constructores sobrecargados.
   * Se creó un constructor privado que recibe la clase estática `Builder`.
   * Se implementó la clase estática `Builder` que recibe los parámetros obligatorios (`destino`, `noches`) en su propio constructor y lanza excepciones (`IllegalArgumentException`) si los datos son inválidos (destino vacío o noches menores a 1).
   * Se añadieron métodos de configuración fluidos (Fluent Interface) para agregar atributos opcionales (`conVuelo()`, `conHotel()`, etc.).

2. **En la clase consumidora (`Main.java`):**
   * Se modificó la instanciación de los paquetes 1 y 2 para que utilicen la sintaxis limpia y concatenada del Builder, indicando explícitamente solo lo que incluyen.
   * Se manejaron los paquetes 3 y 4 con bloques `try-catch` para capturar e imprimir las excepciones arrojadas por la validación del constructor del Builder.

## ¿Por qué lo cambiamos?

* **Inmutabilidad y Consistencia:** Al eliminar los `setters` y exigir los datos críticos desde el inicio de la construcción, garantizamos que ningún `PaqueteViaje` exista jamás en un estado inválido dentro de la memoria. 
* **Legibilidad (Clean Code):** El patrón Builder elimina la necesidad de pasar "parámetros fantasma" (`null` o `false`) en el constructor. Leer la instanciación de un objeto ahora es natural y evidente: "Construir paquete a Villa de Leyva, por 2 noches, con hotel y con seguro".

## Resultados esperados al ejecutar (`Main.java`)
* `p1` y `p2` se construyen e imprimen correctamente, mostrando con claridad qué servicios adicionales incluyen.
* `p3` es rechazado al no tener un destino válido.
* `p4` es rechazado por intentar crearse con 0 noches.