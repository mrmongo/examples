# Requirements
- gradle installed
- mongodb running with user `admin` and password `Passw0rd`

# Build
- `gradle build`

# Run
- `gradle bootRun`
or
- `java -jar build/libs/spring-with-auth-<$VERSION>.jar`  
(java -jar build/libs/spring-with-auth-0.0.1-SNAPSHOT.jar)

<hr/>

The server starts on port 8080 supports HAL and accepts GET/POST/DELETE commands.
(check : http://localhost:8080/)