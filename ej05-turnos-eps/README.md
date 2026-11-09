# EPS SaludYa - Ejercicio 5

## Descripción del Problema
En la versión inicial del sistema, los turnos se repetían (varios pacientes recibían el `T-001`). Esto ocurría porque cada ventanilla y el kiosco digital instanciaban su propio generador de turnos independiente.

Esto se evidencia en las líneas:
* `private GeneradorTurnos generador = new GeneradorTurnos();` en `Ventanilla.java`.
* `GeneradorTurnos generador = new GeneradorTurnos();` en `KioscoDigital.java`.

## La Solución
Se aplicó el patrón de diseño creacional **Singleton** en la clase `GeneradorTurnos`. Este patrón garantiza que exista una única instancia global compartida que lleve la cuenta de los turnos en toda la clínica.

## ¿Qué se cambió?

1. **En `GeneradorTurnos.java` (La clase generadora):**
   * Se cambió el constructor (implícito o explícito) a `private` para impedir que se creen instancias fuera de la clase mediante el operador `new`.
   * Se agregó un atributo privado y estático para almacenar la única instancia de la clase (`private static GeneradorTurnos instancia;`).
   * Se creó el método público y estático `getInstance()` que retorna la única instancia compartida, creándola si aún no existe.

2. **En las clases consumidoras (`Ventanilla.java`, `KioscoDigital.java`):**
   * Se eliminaron las instanciaciones directas con `new GeneradorTurnos()`.
   * Se reemplazaron por el llamado al método global: `GeneradorTurnos.getInstance()`.

## ¿Por qué lo cambiamos?

* **Estado Global Centralizado (Consistencia):** Al existir un solo objeto `GeneradorTurnos` en memoria, la variable `consecutivo` se incrementa de forma secuencial sin importar qué ventanilla o kiosco llame al método `siguienteTurno()`.
* **Control de Instanciación:** Al hacer el constructor privado, garantizamos de forma segura, mediante diseño, que nadie en el equipo pueda cometer el error de crear un generador nuevo e iniciar la secuencia desde cero.

## Resultados esperados al ejecutar (`Main.java`)
* Los cinco pacientes reciben turnos en orden estricto: `T-001`, `T-002`, `T-003`, `T-004`, `T-005`.
* Nunca hay un turno repetido, independientemente de por dónde se solicite.