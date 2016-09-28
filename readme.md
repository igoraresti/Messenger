[![Build Status](https://travis-ci.org/igoraresti/Messenger.svg?branch=master)](https://travis-ci.org/igoraresti/Messenger)

# Lanzar los tests
mvn clean install

# Lanzar el servidor
mvn exec:java



#APUNTES REST
  
  Tipos de parámetros:
  
  	-@PathParam se pone en la url con '/'
  	
  	-@Queryparam se pone en la url con '?' seguido de "parametro=valor"
  	
  	-@MatrixParam se pone en la url con ';' seguido de "parametro=valor"
  	
  	-@HeaderParam se pone en el header de la petición HTTP
  	
  	-@CookieParam se pone en las cookies de la petición HTTP
  	
  	-@FormParam se utiliza para formularios de html
  	
  
  Para recursos con muchos parámetros se usará:
  
  	-@BeanParam que mapea una clase tipo Bean
  
  Anotación Context:
  
  	-@context se utiliza para clases como UriInfo o HttpHeaders para acceder a datos de la url y cabecera respectivamente
