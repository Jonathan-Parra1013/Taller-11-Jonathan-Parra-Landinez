# Taller 11 · Ejercicio 6 

## Descripción del Problema
El método principal del juego utilizaba una estructura condicional `if-else if` que dependía de cadenas de texto (`String`) para decidir qué enemigo instanciar. Esto generaba un alto acoplamiento y violaba el **Principio Abierto/Cerrado (Open/Closed Principle)**, ya que la llegada de un nuevo nivel (Volcán) obligaba a modificar el código base de la clase `Juego`.

## La Solución
Se aplicó el patrón de diseño creacional **Factory Method**. Este patrón define una interfaz para crear un objeto, pero delega a las subclases la decisión de qué clase instanciar. Así, cada Nivel es el único responsable de conocer y crear a su propio enemigo.

## ¿Qué se cambió?

1. **Estandarización de Enemigos:** Se creó la interfaz `Enemigo` con el método `atacar()`. Las clases `Esqueleto`, `Fantasma`, `Golem` y la nueva clase `Dragon` implementan esta interfaz.
2. **El Creador (Factory Method):** Se creó la clase abstracta `Nivel` que define el método abstracto `crearEnemigo()`.
3. **Los Creadores Concretos:** Se crearon las clases `Cripta`, `Castillo`, `Glaciar` y `Volcan` que heredan de `Nivel`. Cada una implementa `crearEnemigo()` devolviendo su enemigo correspondiente.
4. **El Consumidor (`Juego.java`):** Se eliminó el bloque `if-else if`. Ahora el método `jugarNivel` recibe un objeto de tipo `Nivel` e invoca polimórficamente a `nivel.crearEnemigo()`.
5. **Ajuste en `Main.java`:** En lugar de enviar textos ("Cripta"), ahora se envían las instancias concretas de los niveles (`new Cripta()`, `new Volcan()`).

## ¿Por qué lo cambiamos?
* **Principio Abierto/Cerrado:** Ahora el sistema está abierto a la extensión (puedes agregar 100 niveles nuevos) pero cerrado a la modificación (la clase `Juego` jamás volverá a tocarse al agregar niveles).
* **Desacoplamiento:** La clase `Juego` ya no necesita saber nada sobre esqueletos, dragones o fantasmas, solo interactúa con abstracciones (`Nivel` y `Enemigo`).

## Resultados esperados al ejecutar (`Main.java`)
* El nivel Volcán genera sus 2 Dragones que atacan quitando -25 HP.
* El código queda preparado para escalar en el futuro sin modificar su núcleo central.