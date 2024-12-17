# Validación de Formulario con Spring Boot y Thymeleaf

Este proyecto implementa la validación de formularios web utilizando **Spring Boot** y **Thymeleaf**. Actualmente, se está trabajando en la transición hacia una **API REST** que emula una base de datos de empleados. La implementación de la API REST se ha realizado en un controlador independiente dentro del mismo proyecto, permitiendo mantener ambas funcionalidades (interfaz web y API REST) en paralelo. Además, se han implementado **pruebas unitarias** utilizando **JUnit** para garantizar la calidad del código.

## Características

- **Validación del lado del servidor**: Uso de las anotaciones de validación de Spring (`@Valid`, `@NotNull`, `@Size`, etc.) para asegurar la integridad de los datos.
- **Integración con Thymeleaf**: Renderizado de vistas dinámicas y presentación de mensajes de error directamente en las plantillas.
- **Transición a API REST**: Desarrollo de servicios REST que gestionan una base de datos simulada de empleados y devuelven respuestas en formato JSON. Esta funcionalidad se encuentra en un controlador independiente.
- **Pruebas unitarias**: Uso de **JUnit** para verificar el correcto funcionamiento de los componentes principales del proyecto.

## Tecnologías Utilizadas

- **Spring Boot**: Framework para el desarrollo de aplicaciones Java.
- **Thymeleaf**: Motor de plantillas para vistas web.
- **Gradle**: Herramienta de automatización para gestionar dependencias y la construcción del proyecto.
- **JUnit**: Framework para pruebas unitarias.
- **JSON**: Formato para la estructura de datos en las respuestas de la API REST.

## Estructura del Proyecto

- `src/main/java`: Código fuente principal, incluyendo controladores, modelos, servicios y la simulación de la base de datos de empleados.
- `src/main/resources/templates`: Plantillas Thymeleaf para las vistas.
- `src/main/resources/static`: Archivos estáticos (CSS, imágenes, etc.).
- `src/test/java`: Pruebas unitarias implementadas con JUnit.

