# Taxi Request Service API

Este es un proyecto Java basado en Spring Boot que proporciona una API para un servicio que implementa AI.

## Requisitos previos

- Java 22
- Maven
- Ollama

## Instalación

1. Clona el repositorio:
    ```bash
    git clone https://github.com/flpajon/ai-api.git
    cd ai-api
    ```

2. Configura la base de datos en `application.properties`:
    ```properties
    spring:
        application:
            name: ai
    ai:
        ollama:
            base-url: http://localhost:11434
            chat:
                options:
                    model: llama3
    ```

3. Compila y ejecuta la aplicación:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## Uso

La API proporciona las siguientes funcionalidades:

- Obtener información de actividad sobre un tema

### Endpoints

#### Obtener información de actividad sobre un tema

- **URL:** `/v1/chat/activity`
- **Método:** `GET`
- **Parámetros de consulta:**
  - `about`: El tema sobre el cual se quiere obtener información de actividad.
- **Ejemplo de solicitud:**
    ```bash
    curl --location 'localhost:8080/v1/chat/activity?about=futbol'
    ```
- **Respuesta exitosa:**
    ```json
    {
        "topic": "futbol",
        "activity": "Descripción de la actividad relacionada con el fútbol."
    }
    ```

## Dependencias

- **Spring Boot Starter Web:** Para crear la API REST.
- **Spring AI:** Para integración con servicios de inteligencia artificial.
- **Spring Boot DevTools:** Para el desarrollo rápido.
- **Spring Boot Configuration Processor:** Para procesamiento de configuraciones.
- **Lombok:** Para reducir el código boilerplate.
- **Spring Boot Starter Test:** Para pruebas unitarias y de integración.

## Contribuciones

Las contribuciones son bienvenidas. Por favor, envía un pull request o abre un issue para discutir los cambios que deseas realizar.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT - consulta el archivo [LICENSE](LICENSE) para más detalles.