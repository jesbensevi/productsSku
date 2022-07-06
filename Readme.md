# Challenge RestApi Products
Api que permite hacer un CRUD de productos 
--------------------------------------------------------------------------------
## Arquitectura
Esta api esta creada con Spring Boot usando el patron MVC, con una base de datos en PostgreSQL y H2 en memoria para los test.
Tambien se utiliza un diseño implementado bajo el principio HATEOAS ( Hypermedia as the engine of applicacion state ) para que los datos sean representados en formato JSON.
Esta estructura basada en hipermedia facilita a los clientes el acceso a la aplicación, puesto que de este modo no necesitan saber nada más de la interfaz para poder acceder y navegar por ella
## Tecnologias utilizadas
* [Java 11](https://openjdk.java.net/11/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Docker](https://www.docker.com/)
* [PostgreSQL](https://www.postgresql.org/)
* [Gradle](https://gradle.org/)

## Requisitos
Para poder levantar el ambiente de desarrollo, se requiere que se tenga instalado **Docker** ya que tendremos un docker-compose donde estara nuestro app de spring con nuestra base de datos de PostgreSQL.

## Instalación
Para poder instalar el ambiente de desarrollo, se debe ejecutar el siguiente comando:
con esto podremos hacer el build del proyecto y verificar que los test se ejecuten correctamente
```bash
gradle build
```
Luego de esto haremos: 
```bash
docker compose up
```
Una vez que tengamos listo nuestro despliegue podemos probar nuestros endpoints: 

### Endpoint /api/v1/products
```bash
curl -X GET http://localhost:8080/api/v1/products
```

### Endpoint /api/v1/products/{id}
```bash
curl -X GET http://localhost:8080/api/v1/products/{sku}
```

### Endpoint POST /api/v1/products
```bash
curl -X POST -H "Content-Type: application/json" -d '{
    "sku": "FAL-10000045",
    "name": "Bicicleta Baltoro Aro 219",
    "brand": "JEEP",
    "size": "ST",
    "price": 100.000,
    "principalImage": "https://falabella.scene7.com/is/image/Falabella/881952283_77",
    "otherImages":[
        "https://falabella.scene7.com/is/image/Falabella/881952283_77",
        "https://falabella.scene7.com/is/image/Falabella/881952283_77"
    ]
}' http://localhost:8080/api/v1/products
```
### Endpoint PUT /api/v1/products
```bash
curl -X PUT -H "Content-Type: application/json" -d '{
    "sku": "FAL-10000045",
    "name": "Bicicleta Baltoro Aro 219",
    "brand": "JEEP",
    "size": "ST",
    "price": 1200.000,
    "principalImage": "https://falabella.scene7.com/is/image/Falabella/881952283_77",
    "otherImages":[
        "https://falabella.scene7.com/is/image/Falabella/881952283_77",
        "https://falabella.scene7.com/is/image/Falabella/881952283_77"
    ]
}' http://localhost:8080/api/v1/products/{sku}
```
### Endpoint DELETE /api/v1/products/{sku}
```bash
curl -X DELETE http://localhost:8080/api/v1/products/{sku}
```