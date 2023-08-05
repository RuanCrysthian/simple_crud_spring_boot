# Projeto CRUD em Spring Boot com Banco de Dados PostgreSQL

Este é um projeto básico de CRUD (Create, Read, Update, Delete) desenvolvido em Spring Boot utilizando um banco de dados PostgreSQL. O CRUD é para a entidade Person, que possui os campos: id, name, cpf, createdAt e updatedAt.

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

- Java 17 ou superior
- PostgreSQL

## Configuração do Banco de Dados

Antes de executar o projeto, crie um banco de dados no PostgreSQL. O nome do banco pode ser configurado no arquivo `application.properties`, localizado na pasta `src/main/resources`. Você deve ajustar a propriedade `spring.datasource.url`, `spring.datasource.username` e `spring.datasource.password` conforme suas configurações do PostgreSQL.

```
spring.datasource.url=jdbc:postgresql://localhost:5432/crudspringboot?createDatabaseIfNotExist=true
spring.datasource.username=postgres
spring.datasource.password=admin

spring.jpa.hibernate.ddl-auto=none
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.show-sql=true
spring.jpa.open-in-view = true
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
```

## Executando o Projeto

Entre na pasta  `crud`:

```
cd crud/
```

Inicie a aplicação.

```
mvn spring-boot: run
```

O Spring Boot iniciará o servidor e o aplicativo estará disponível em `http://localhost:8080`.

## Endpoints da API

O projeto possui os seguintes endpoints da API:

- **POST persons**: Cria uma nova entidade Person.
- **GET persons**: Retorna a lista de todas as entidades Person.
- **GET persons/{id}**: Retorna a entidade Person correspondente ao ID fornecido.
- **PUT persons**: Atualiza a entidade Person correspondente ao ID fornecido.
- **DELETE persons/{id}**: Exclui a entidade Person correspondente ao ID fornecido.

## Formato dos Dados

A entidade Person tem o seguinte formato:

```
{
  "name": "João da Silva",
  "cpf": "123.456.789-00"
}
```

## Contribuição

Sinta-se à vontade para contribuir com melhorias, correções de bugs ou novos recursos para este projeto. Basta abrir um pull request explicando as mudanças propostas.
