# golden-rasp-awards-api

API criada para retornar os produtores com maior e menor intervalos entre dois premios.

## Dependencias

O projeto foi criado em Java 11 e utilizando o framework Spring Boot

* Java 11
* maven

## How to Run

* A aplicacao ao ser executada, carrega o file **movielist.csv**, que esta localizado na pasta **/src/main/resources**. 
* Para carregar um outro file, basta substituir o arquivo existente.
* Os atributos do arquivo sao separados pelo **caracter ;** e a lista de studios e producers sao separadas pelo **caracter ,**.

### Para Executar o projeto, executar o comando:

`./mvnw spring-boot:run`

### Para acessar a API, executar no browser a URL:

http://localhost:8080/premiados

### Para Executar o teste, executar o comando:

`mvn test`


