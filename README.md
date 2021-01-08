### PRUEBA TECNICA MASIVIAN

## Instrucciones:

#### Paso 1

Realizar una lectura de nuestras 12 reglas de Clean Code (pdf adjunto), pues esta prueba la
evaluaremos con base en estos puntos.
Si adicionalmente desea profundizar más sobre Clean Code, te recomendamos la siguiente
lectura siguiente: : https://temp.itfseafarers.org/sites/default/files/node/resources/files/Clean_CodeRobert.C.Martin.pdf
Y si desea poner en practica las lecciones aprendidas, le recomendamos revisar las siguientes Katas: https://github.com/cleancode-katas

#### Paso 2

Cuando tenga interiorizadas las reglas de Clean Code implemente un API que represente
una ruleta de apuestas online que cumpla las siguientes características:
a) tenga los siguientes endpoints (10 puntos):
1. Endpoint de creación de nuevas ruletas que devuelva el id de la nueva ruleta creada
2. Endpoint de apertura de ruleta (el input es un id de ruleta) que permita las
posteriores peticiones de apuestas, este debe devolver simplemente un estado que
confirme que la operación fue exitosa o denegada.
3. Endpoint de apuesta a un número (los números válidos para apostar son del 0 al 36)
o color (negro o rojo) de la ruleta una cantidad determinada de dinero (máximo
10.000 dólares) a una ruleta abierta.
nota: este enpoint recibe además de los parámetros de la apuesta, un id de usuario
en los HEADERS asumiendo que el servicio que haga la petición ya realizo una
autenticación y validación de que el cliente tiene el crédito necesario para realizar la
apuesta.
4. Endpoint de cierre apuestas dado un id de ruleta, este endpoint debe devolver el
resultado de las apuestas hechas desde su apertura hasta el cierre.
El número ganador se debe seleccionar automáticamente por la aplicación al cerrar
la ruleta y para las apuestas de tipo numérico se debe entregar 5 veces el dinero
apostado si atinan al número ganador, para las apuestas de color se debe entrega 1.8
veces el dinero apostado, todos los demás perderán el dinero apostado.
nota: para seleccionar el color ganador se debe tener en cuenta que los números
pares son rojos y los impares son negros.
5. Endpoint de listado de ruletas creadas con sus estados (abierta o cerrada)
b) El desarrollo debe estar pensado para escalar horizontalmente (se sugiere el uso de Redis
como persistencia de datos y herramienta para resolver posibles problemas de concurrencia
pero queda abierto a libre escogencia) (30 puntos)
c) Se debe cumplir las reglas de Clean Code, el objetivo principal de este ejercicio es
precisamente revisar clean code (60 puntos)
Puntos Extra:
• Realizar la prueba en un lenguaje fuertemente tipado (30 puntos extra)
(como framework se recomienda .Net Core 3 o Spring

## Usuarios de puebas

- Documento: 123456 - Clave: 1234

## Elaborado por:
Jimmy Armando Chirivi Nivia

## Tecnolgias de Desarrollo

- SpringBoot
- Java 8
- JavaScript
- HTML5
- Boostrap
- CSS

## Despliegue:

Heroku:  https://bd-ruleta.herokuapp.com/
