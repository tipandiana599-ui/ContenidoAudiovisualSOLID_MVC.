# Sistema de Gestión de Contenido Audiovisual (SOLID & MVC)

Proyecto desarrollado para la asignatura de **Programación Orientada a Objetos** (Universidad Politécnica Salesiana). Consiste en la refactorización de un sistema de gestión de contenidos audiovisuales aplicando principios de **Código Limpio**, **SOLID**, persistencia en archivos **CSV**, arquitectura **MVC** y pruebas unitarias con **JUnit 5**.

## Estructura del Proyecto

El código está organizado bajo el patrón arquitectónico **Modelo - Vista - Controlador (MVC)**:

* **`ec.edu.ups.modelo`**: Entidades del dominio (`ContenidoAudiovisual`, `Pelicula`, `SerieDeTV`, `Documental`, `Actor`, `Temporada`, `Investigador`).
* **`ec.edu.ups.vista`**: Interfaz de usuario en consola (`ConsolaVista`).
* **`ec.edu.ups.controlador`**: Lógica de coordinación entre la vista, el modelo y la persistencia (`ContenidoControlador`).
* **`ec.edu.ups.persistencia`**: Interfaz (`IContenidoDAO`) e implementación (`ContenidoDAOImpl`) para la lectura y escritura de archivos CSV.
* **`ec.edu.ups.main`**: Punto de entrada e inyección de dependencias (`Main`).
* **`test/ec.edu.ups.test`**: Pruebas unitarias automatizadas con JUnit 5 (`ContenidoTest`).

## Principios SOLID Aplicados

1. **Single Responsibility (SRP):** Cada clase tiene una única responsabilidad (la vista solo imprime/lee consola, el DAO solo maneja archivos CSV, el modelo representa datos).
2. **Open/Closed (OCP):** La jerarquía de `ContenidoAudiovisual` permite agregar nuevos tipos de contenido sin modificar la lógica existente.
3. **Liskov Substitution (LSP):** Todas las subclases (`Pelicula`, `SerieDeTV`, `Documental`) sustituyen correctamente a `ContenidoAudiovisual`.
4. **Interface Segregation (ISP):** Uso de interfaces específicas como `IContenidoDAO`.
5. **Dependency Inversion (DIP):** `ContenidoControlador` depende de la abstracción `IContenidoDAO` recibida mediante inyección de dependencias en `Main`.

## Cómo Clonar, Compilar y Ejecutar

1. **Clonar el repositorio:**
   ```bash
   git clone [https://github.com/tipandiana599-ui/ContenidoAudiovisualSOLID_MVC..git](https://github.com/tipandiana599-ui/ContenidoAudiovisualSOLID_MVC..git)
