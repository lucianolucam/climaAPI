#Correr aplicacion en local

Para ejecutar la aplicación desde Eclipse, simplemente ejecute la clase com.sistemaSolar.climaAPI.ClimaApiApplication como una aplicación Java. 
Alternativa, la aplicación puede iniciarse desde un terminal utilizando maven con mvn spring-boot:run. Después de iniciar la aplicación la misma se levanta en http://localhost:8086/api/

URLs locales

Clima de un día especifico:
GET: http://localhost:8086/api/clima?dia=30 (30 se puede modificar por cualquier dia entre 1 y 3600)

Periodos de Sequia:
GET: http://localhost:8086/api/periodos-sequia

Periodos de Lluvia:
GET: http://localhost:8086/api/periodos-lluvia

Periodos de Condiciones Optimas:
GET: http://localhost:8086/api/periodos-optimas-condiciones

Dias Más Lluviosos:
GET: http://localhost:8086/api/maxima-intensidad-lluvia


La aplicacion se encuentra disponible en Heroku

URLs heroku

Clima de un día especifico:
GET: https://infinite-bayou-09581.herokuapp.com/api/clima?dia=5 (5 se puede modificar por cualquier dia entre 1 y 3600)

Periodos de Sequia:
GET: https://infinite-bayou-09581.herokuapp.com/api/periodos-sequia

Periodos de Lluvia:
GET: https://infinite-bayou-09581.herokuapp.com/api/periodos-lluvia

Periodos de Condiciones Optimas:
GET: https://infinite-bayou-09581.herokuapp.com/api/periodos-optimas-condiciones

Dias Más Lluviosos:
GET: https://infinite-bayou-09581.herokuapp.com/api/maxima-intensidad-lluvia
