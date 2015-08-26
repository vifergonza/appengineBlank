# Servicio RESTful (Spring 3.2 + Google AppEngine)

Este es el proyecto básico a partir del cual construir servicios REST desplegables en la plataforma Google App Engine (GAE).
El proyecto tiene un único servicio *InfoService.java* con dos metodos GET y POST.

## Formatos admitidos en las peticiones
Ambos métodos aceptan el envío de datos en varios formatos seleccionable mediante *Headers*:

* **Content-type: application/x-www-form-urlencoded** si enviamos los datos dentro del *body* de la petición http. El formato será *param=valor1&param2=valor2*.
* **Content-type: application/json** si enviamos los datos dentro del *body* de la petición http en formato *json*. Por ejemplo *{"param":"valor1", "param2":"valor2"}*.
* **Content-type: application/xml** si enviamos los datos dentro del *body* de la petición http en formato *xml*. Por ejemplo *<nodo><param>valor1</param><param2>valor2</param2></nodo>*. Para que esto funcione correctamente, las clases recibidas por el servicio deben estar debidamente anotadas. Ver *RequestDto.java*.

## Formatos admitidos en las respuestas
Podemos elegir el formato en el cual el servidor nos retorna los datos, también mediante *Headers*:

* **Accept: application/json** para que el servidor nos retorne la información en *json*.
* **Accept: application/xml** para que el servidor nos retorne la información en *xml*. Para que esto funcione correctamente, las clases retornadas por el servicio deben estar debidamente anotadas. Ver *ResponseDto.java*.

## Seleccion de idioma
Tambien podemos establecer el idioma en el que queremos que el servidor nos responda mediante la cabecera *Accept-Language: en*

###### Otros datos
En el fichero *pruebasRest.sh* hay una bateria de pruebas *curl* con las cabeceras comentadas anteriormente.