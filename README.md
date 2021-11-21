Lightly inspired by https://reflectoring.io/spring-hexagonal/

https://www.baeldung.com/hexagonal-architecture-ddd-spring

Enable Annotation Processing in IntelliJ

Check Settings -> Build, Execution, Deployment -> Maven -> Importing -> JDK for importer
So that not a JRE is used.

Can be started with
```bash
./mvnw clean org.springframework.boot:spring-boot-maven-plugin:run -pl application -am
```