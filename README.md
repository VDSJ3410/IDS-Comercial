📚 Sistema de Control de Acceso a Biblioteca – Microservicios

Proyecto desarrollado con Spring Boot bajo una arquitectura de microservicios, enfocado en el control de acceso de usuarios a una biblioteca, manejo de errores, tolerancia a fallos y migración de Java.

🧩 Arquitectura

El sistema está compuesto por dos microservicios:

🔹 MS1 – Biblioteca

Gestiona el acceso de usuarios a la biblioteca, aplicando reglas de negocio y validaciones.

🔹 MS2 – Consulta

Consume el MS1 mediante Feign Client, implementando control de tiempo de espera y tolerancia a fallos.

⚙️ Tecnologías utilizadas

Java 21 (migrado desde Java 8)

Spring Boot
Spring Web
OpenFeign
Resilience4j (Circuit Breaker)
H2 Database
Maven
JUnit 5 / Mockito
Configuración en YAML

✅ Funcionalidades principales

MS1 – Biblioteca

Registro y salida de usuarios
Control de aforo máximo (10 personas)
Validaciones de entrada
Manejo centralizado de excepciones
Respuestas con formato genérico
Soporte de headers para simulación de latencia

MS2 – Consulta

Comunicación entre microservicios
Propagación de headers
Timeout configurado
Circuit Breaker con fallback
Manejo de errores por latencia o indisponibilidad

🔁 Migración de Java

El proyecto fue desarrollado inicialmente en Java 8 y migrado exitosamente a Java 21, asegurando compatibilidad y estabilidad.

🧪 Pruebas

Pruebas unitarias implementadas en el MS1
Validación de servicios y manejo de excepciones

▶️ Ejecución

Ambos microservicios se ejecutan de forma independiente mediante Maven y Spring Boot.

✨ Autor: Valerian
✨ Estado: Funcional y completo
