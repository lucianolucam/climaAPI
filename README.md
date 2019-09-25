<h2>Ejercicio</h2>
https://github.com/lucianolucam/climaAPI/blob/master/src/main/resources/Ejercicio.pdf

<h1>Resolución</h1>

Básicamente se tiene un método llamado ***SimulacionSistemaSolar*** que lo que hace es simular el paso de los 10 años. Dentro del mismo se calcula la posición de cada planeta día a día y luego se llama al método ***CalcularClima*** que calcula el clima para cada día y lo guarda en la BD.
Luego tenemos una controller llamado ***PronosticoController*** que es quien maneja los Request.


Para calcular si un punto está dentro de un triángulo se usó la siguiente función:

det = (bx - ax) * (cy - ay) - (by - ay) * (cx - ax)
	
det * ((bx - ax) * (y - ay) - (by - ay) * (x - ax)) > 0 &&
det * ((cx - bx) * (y - by) - (cy - by) * (x - bx)) > 0 &&
det * ((ax - cx) * (y - cy) - (ay - cy) * (x - cx)) > 0

Obtenida de la siguiente página:
https://jsfiddle.net/jniac/rctb3gfL/

Y para calcular si los planetas están alineados entre si, y entre si con el sol, se toman de a 3 y se utiliza la formula de calcular la pendiente entre 2 puntos, si son iguales, es porque pertenecen a la misma recta:

private double calcularPendiente (Point2D planetaA, Point2D planetaB){
    	return Math.round( (planetaB.getY()-planetaA.getY()) / (planetaB.getX()-planetaA.getX()) );
    }

<h2>Correr aplicacion en local</h2>

Para ejecutar la aplicación desde Eclipse, simplemente ejecute la clase com.sistemaSolar.climaAPI.ClimaApiApplication como una aplicación Java. 
Alternativa, la aplicación puede iniciarse desde un terminal utilizando maven con mvn spring-boot:run. Después de iniciar la aplicación la misma se levanta en http://localhost:8086/api/

<h3>URLs locales</h3>

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


<h2>La aplicacion se encuentra disponible en Heroku</h2>

<h3>URLs heroku</h3>

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

<h1>Tecnologías utilizadas</h1>
* spring-boot
* java 1.8
* h2database
* maven
* Junit
* log4j
* heroku
