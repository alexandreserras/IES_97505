# LAB3

Leitura recomendada antes de começar / ou durante a resolução do guião:
    https://dzone.com/articles/7-things-to-know-getting-started-with-spring-boot


# EX1
https://www.infoworld.com/article/3379043/what-is-jpa-introduction-to-the-java-persistence-api.html
The Java ORM standard for storing, accessing, and managing Java objects in a relational database

    a)
        Tutorial a fazer : https://www.baeldung.com/spring-boot-crud-thymeleaf

        https://start.spring.io/ Para criar o projeto Spring
        Escolhas feitas na criação do projeto Spring:   
            Spring Web, Thymeleaf, Spring Data JPA, H2 database, and Validation.

        Na classe User colocamos uma nota na classe que ela é @Entity e com isso.
        Logo, a implementação com o JPA, que é Hibernate é capaz de fazer operações de CRUD, nos dominios classificados como entities
        O @NotBlank faz com que exista uma validação onde os campos que tem isto não podem ir em branco para a base de dados

        
        Traduzir:
        Spring Data JPA is a key component of Spring Boot's spring-boot-starter-data-jpa that makes it easy to add CRUD functionality through a powerful layer of abstraction placed on top of a JPA implementation. This abstraction layer allows us to access the persistence layer without having to provide our own DAO implementations from scratch.

        To provide our application with basic CRUD functionality on User objects all that we need to do is to extend the CrudRepository interface:
        And that's it! By just extending the CrudRepository interface, Spring Data JPA will provide implementations for the repository's CRUD methods for us.
        ..
    


# EX2


# EX3


# QUESTÕES

    a)

    b)

    c)

    d)
    