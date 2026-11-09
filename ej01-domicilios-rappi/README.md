# Domicilios Rapidito - Ejercicio 1 :b

## Descripción del Problema
En la versión inicial del sistema, el administrador activaba un recargo por lluvia, pero este no se reflejaba en el precio final del cliente ni en las ganancias del repartidor. Además, el archivo de configuración (config.properties) se leía de manera redundante cada vez que un componente requería acceder a los datos.

Esto ocurría porque las clases PanelAdmin :D, CalculadoraDomicilio y AppRepartidor estaban creando instancias independientes de la configuración mediante la instrucción new ConfiguracionApp(). 

## La Solución
Se aplicó el patrón de diseño creacional **Singleton** en la clase ConfiguracionApp. Este patrón restringe la instanciación de una clase a un solo objeto y proporciona un punto de acceso global a él.

## ¿Qué se cambió?

1. **En `ConfiguracionApp.java` (La clase de configuración):**
   * Se cambió el modificador de acceso del constructor de `public` a `private` para evitar que otras clases usen la palabra reservada `new`.
   * Se agregó un atributo privado y estático para almacenar la única instancia de la clase (`private static ConfiguracionApp instancia;`).
   * Se creó el método público y estático `getInstance()` que evalúa si la instancia ya existe; si no existe, la crea (Lazy Initialization), y finalmente la retorna.

2. **En las clases consumidoras (`PanelAdmin.java`, `CalculadoraDomicilio.java`, `AppRepartidor.java`):**
   * Se eliminaron todas las líneas donde se hacía: `ConfiguracionApp config = new ConfiguracionApp();`.
   * Se reemplazaron por el llamado al método global: `ConfiguracionApp config = ConfiguracionApp.getInstance();`.

## ¿Por qué lo cambiamos?

* **Consistencia de los datos (Estado Compartido):** Al tener una única instancia en toda la aplicación, cuando `PanelAdmin` modifica el estado interno activando el recargo (`setRecargoLluvia(2000)`), ese cambio persiste en la memoria. Así, cuando la calculadora y el repartidor solicitan los valores, leen exactamente la misma instancia actualizada.
* **Optimización de recursos:** El constructor de la clase simulaba una operación costosa (lectura de disco). Al usar Singleton, garantizamos que esta carga pesada se ejecute **una sola vez** en el ciclo de vida de la aplicación, mejorando el rendimiento. 

## Resultados esperados al ejecutar (`Main.java`)
* Configuración cargada 1 sola vez (`carga #1`).
* El domicilio de 3 km cuesta **$8.900**.
* El repartidor gana **$4.400**.