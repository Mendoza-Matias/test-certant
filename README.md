# 🏥 Gestión de consultorio médico - API

---

## Sobre el proyecto

Esta API RESTful ha sido diseñada para representar el funcionamiento convencional de una clínica médica, buscando satisfacer todas las necesidades requeridas. Permite la gestión de pacientes, profesionales, turnos, horarios de atención, consultorios y especialidades. Además, ofrece la opción de crear cada uno de estos elementos, así como también filtrarlos por especialidad, profesional, paciente, entre otras características. También cuenta con una validación a través del correo electrónico para evitar el acceso de los pacientes a ciertas partes del sistema.

## Deploy

- Link del despliegue : https://test-certant.onrender.com/

👆👆👆 En el siguiente enlace puedes probar los endpoints de la API junto con su documentación.

## Herramientas utilizadas para el despliegue

- Render
- Docker
- Clever Cloud

## Tecnologías utilizadas en la API🤖

- Spring Boot
- Spring Data JPA + Hibernate
- Spring Security
- MySQL

## Roles

- PROFESIONAL: Vista general de los pacientes, creación de horarios de atención, especialidades, profesionales, consultorios, entre otros.
- PACIENTE: Vista de sus turnos, profesionales, especialidades, consultorios, creación de paciente, entre otras funcionalidades.

## Documentación

![documentacion](/imagedoc/docu1.jpg)

![documentacion](/imagedoc/docu2.jpg)

## MER

![MER](/imagedoc/certant%20tecnico.jpg)

## Instalación

1. Descargar el proyecto.
2. Instalar dependencias:

`````shell
    //1
    mvn clean

    //2 
    mvn install
`````
3. Configurar variables de entorno en el application.properties:

````properties
  
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://b1zuqzthl7uivq2tusnm-mysql.services.clever-cloud.com:3306/b1zuqzthl7uivq2tusnm
spring.datasource.username=upc4qmfn7j3kuq9o
spring.datasource.password=VQ5BQvoIN1M1k7VNnrWf
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

````
4. Cargar las especialidades iniciales desde la base de datos:

````shell
    INSERT INTO especialidades (nombre) VALUES ('Clínica Médica');
    INSERT INTO especialidades (nombre) VALUES ('Dermatología');
    INSERT INTO especialidades (nombre) VALUES ('Pediatría');
    INSERT INTO especialidades (nombre) VALUES ('Cardiología');
````

## Nota sobre documentación
Para acceder a un endpoint privado, el profesional deberá ingresar su correo electrónico y la clave.Los pacientes no podrán acceder a dichos endpoints.
La clave de todos los profesionales es clave 123

````shell
    nombre de usuario : ana.martinez@example.com
    clave : clave123
````





