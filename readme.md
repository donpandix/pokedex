# Pokedex Application

Esta es una aplicación web de Pokedex que muestra información sobre diferentes Pokémon utilizando la API de PokeAPI.

## Características

- Lista de Pokémon con sus nombres, imágenes, altura, peso y experiencia base.
- Manejo de errores para mostrar mensajes en caso de fallos en la obtención de datos.
- Paginación de resultados utilizando parámetros `offset` y `limit`.

## Requisitos

- Java 8 o superior
- Spring Boot
- Thymeleaf
- Jackson

## Instalación

1. Clona el repositorio:
    ```bash
    git clone https://github.com/tu-usuario/pokedex-app.git
    ```
2. Navega al directorio del proyecto:
    ```bash
    cd pokedex-app
    ```
3. Construye el proyecto con Maven:
    ```bash
    mvn clean install
    ```

## Ejecución

Para ejecutar la aplicación, usa el siguiente comando:
```bash
mvn spring-boot:run

