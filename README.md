 <p align="center"> <img src="https://github.com/LA-RESERVA/ARSW-2021-1-LaReservaFront/blob/master/css/img/Logo.png" width="100" height="100"> </p>
 
# La Reserva

## Desarrollado por
-   Federico Barrios Meneses
-   Brayan Steven Burgos Delgado
-   Andrés Jose Gutiérrez Marín
-   Jonathan Fabian Páez Torres

### Heroku
[![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)](https://cherry-surprise-79251.herokuapp.com/)

### CircleCi
[![La Reserva](https://circleci.com/gh/LA-RESERVA/ARSW-2021-1-LaReservaBackPost.svg?style=svg)](https://app.circleci.com/gh/LA-RESERVA/ARSW-2021-1-LaReservaBackPost)

### Codacy
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/1aae275dee444cefbeddd2dcc12b84de)](https://www.codacy.com/gh/LA-RESERVA/ARSW-2021-1-LaReservaBackPost/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=LA-RESERVA/ARSW-2021-1-LaReservaBackPost&amp;utm_campaign=Badge_Grade)

## Atributos no funcionales
Estos atributos son los que delimitarán las características generales, restricciones y limitaciones de nuestra aplicación.

### Seguridad

Escenario 1: Cifrar contraseñas.
-   Fuente: Usuario final.
-   Objetivo: Crear un usuario en la aplicación.
-   Infraestructura: Frontend, Backend, Base de datos.
-   Ambiente: Aplicación bajo condiciones normales.
-   Resultado esperado: Las contraseñas deben estar cifradas.
-   Medición: Las contraseñas del usuario y propietarios se cifran con Sha256.

### Usabilidad

Escenario 1: Publicar canchas.
-   Fuente: Usuario final.
-   Objetivo: Publicar una cancha en la aplicación.
-   Infraestructura: Frontend, Backend, Base de datos.
-   Ambiente: Aplicación bajo condiciones normales.
-   Resultado esperado: La publicación se realiza y se puede visualizar de manera exitosa.
-   Medición: El propietario es capáz de publiar una cancha desde la página principal de manera exitosa.

Escenario 2: Reservar Canchas.
-   Fuente: Usuario final.
-   Objetivo: El cliente puede reservar exitosamente una cancha.
-   Infraestructura: Frontend, Backend, Base de datos.
-   Ambiente: Aplicación bajo condiciones normales.
-   Resultado esperado: Aparece una notificación en pantalla confirmando la reserva, ademas de un correo electronico de confirmación.
-   Medición: El cliente puede hacer una reserva con los items que seleccione y en caso de no estar disponible, que se le notifique.

### Escalabilidad

Escenario 1: Escalabilidad vertical.
-   Fuente: Usuarios finales.
-   Objetivo: Sobrecargar la cantidad de usuarios finales.
-   Infraestructura: Azure.
-   Ambiente: Aplicación bajo estrés.
-   Resultado esperado: El dyno escala verticalmente según la sobrecarga de usuarios.
-   Medición: El tiempo de respuesta de cada usuario no aumenta, sigue siendo aproximadamente de un segundo.

Escenario 2: Escalabilidad horizontal.
-   Fuente: Usuarios finales.
-   Objetivo: Sobrecargar la cantidad de usuarios finales.
-   Infraestructura: Azure.
-   Ambiente: Aplicación bajo estrés.
-   Resultado esperado: Se escala horizontalmente según la sobrecarga de usuarios implementando otros dynos.
-   Medición: El tiempo de respuesta de cada usuario no aumenta, sigue siendo aproximadamente de un segundo.

### Rendimiento

Escenario 1: Reservar concurrentemente.
-   Fuente: Usuario final.
-   Objetivo: Más de un usuario reserva por la misma cancha al mismo tiempo.
-   Infraestructura: Frontend, Backend, caché, Base de datos.
-   Ambiente: Aplicación bajo condiciones normales.
-   Resultado esperado: Solo una persona se queda con la reserva y todas las demás son notificadas de que esa cancha, no esta disponible.
-   Medición: Se informa al cliente que reservo con exito y a todos los demas se les notifica que esa reserva ya no esta  disponible, cuando intenta reservar.

Escenario 2: Conexión a socket cuando se ve una publicación. 
-   Fuente: Usuario final.
-   Objetivo: Conocer cuantas personas estan viendo una publicacion al mismo tiempo.
-   Infraestructura: Frontend, Backend, Base de datos.
-   Ambiente: Aplicación bajo condiciones normales.
-   Resultado esperado: Todos los cliente reciben información de cuantas personas estan viendo la misma publicación al mismo tiempo.
-   Medición: Observar el numero de personas que actualmente se encuentran en esa cancha. 

### Disponibilidad

Escenario 1: Indisponibilidad máxima.
-   Fuente: Usuario final.
-   Objetivo: Verificar ante un ataque DOS la disponibilidad del sistema.
-   Infraestructura: Frontend, Backend.
-   Ambiente: Aplicación bajo peticiones automatizadas.
-   Resultado esperado: Se carga correctamente la aplicación.
-   Medición: La aplicación está disponible y carga correctamente.

https://www.youtube.com/watch?v=CIiBFYCsFaI

Escenario 2: Ingresar correctamente a la página bajo estrés.
-   Fuente: Usuario final.
-   Objetivo: Ingresar a la aplicación para poder obsrvar su funcionamiento.
-   Infraestructura: Frontend, Backend, Base de datos.
-   Ambiente: Aplicación bajo condiciones de estrés.
-   Resultado esperado: La aplicación funciona con normalidad.
-   Medición: Las canchas y su informacion correspondiente siguen cargándose en un promedio de 1 segundo.

https://www.youtube.com/watch?v=8xam_58aX6U
