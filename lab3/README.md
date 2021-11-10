# LAB3

Leitura recomendada antes de começar / ou durante a resolução do guião:
    https://dzone.com/articles/7-things-to-know-getting-started-with-spring-boot


# EX1
https://www.infoworld.com/article/3379043/what-is-jpa-introduction-to-the-java-persistence-api.html
The Java ORM standard for storing, accessing, and managing Java objects in a relational database
Java Persistence API (ou simplesmente JPA) é uma API padrão da linguagem Java que descreve uma interface comum para frameworks de persistência de dados. A JPA define um meio de mapeamento objeto-relacional para objetos Java simples e comuns (POJOs), denominados beans de entidade. Diversos frameworks de mapeamento objeto/relacional como o Hibernate implementam a JPA. Também gerencia o desenvolvimento de entidades do Modelo Relacional usando a plataforma nativa Java SE e Java EE.
    a)
        Tutorial a fazer : https://www.baeldung.com/spring-boot-crud-thymeleaf
        A implementação de camadas DAO  fornece funcionalidades CRUD em entidades JPA,isto pode ser uma tarefa repetitiva e demorada que desejamos evitar na maioria dos casos. Felizmente, o Spring Boot facilita a criação de aplicações CRUD por meio de uma camada de repositórios CRUD padrão baseados em JPA.

        https://start.spring.io/ Para criar o projeto Spring
        Escolhas feitas na criação do projeto Spring:   
            Spring Web, Thymeleaf, Spring Data JPA, H2 database, and Validation.

        Na classe User colocamos uma nota na classe que ela é @Entity e com isso.
        Logo, a implementação com o JPA, que é Hibernate é capaz de fazer operações de CRUD, nos dominios classificados como entities
        O @NotBlank faz com que exista uma validação onde os campos que tem isto não podem ir em branco para a base de dados

        "Spring Data JPA allows us to implement JPA-based repositories (a fancy name for the DAO pattern implementation) with minimal fuss"
        O Spring Data JPA é um componente chave do Spring Boot,spring-boot-starter-data-jpa , que torna mais facil a adição de funcionalidades, através de uma camada de abrastação colocada no topo da implemetanção JPA. Esta camada permite-nos aceder à layer persistente sem ter que dar as nossas implemetanções DAO  desde o inicio.
        Para dar à aplicação basicas funcionalidades  CRUD, no objeto User , temos que extender a interface CrudRepository, e já esta. Com isto o Spring Data JPA vai dar nos implemetanções para os métodos CRUD do repositório, para o nosso projeto.

        @Repository
        public interface UserRepository extends CrudRepository<User, Long> {}


        "Thanks to the layer of abstraction that spring-boot-starter-data-jpa places on top of the underlying JPA implementation, we can easily add some CRUD functionality to our web application through a basic web tier."

        No caso que estamos a desenvolver, basta uma classe controller para tratar dos pedidos GET e POST HTTP requests  e mapea-los para chamar a implementação do UserRepository


        The controller class relies on some of Spring MVC's key features

        Alguns dos métodos que o controller vai ter é por exemplo a addUser() e o showSignUpForm()

        A parte da visualização é feita numa página html, logo vai ter o html normal, que vai ficar na pasta templates , e nesta parte é onde entra o thymeleaf
        "Notice how we've used the @{/adduser} URL expression to specify the form's action attribute and the ${} variable expressions for embedding dynamic content in the template, such as the values of the name and email fields and the post-validation errors."


        Para correr basta ir ao VSCODE e correr por la e o projeto fica : http://localhost:8080/
        o podemos também ir para a diretoria que tem o ficheiro pom.xml e fazer ./mvnw spring-boot:run

        https://github.com/eugenp/tutorials/tree/master/spring-boot-modules/spring-boot-crud , github seguido para implementar o resto da aplicação que nao estava no tutorial 

        b)
            The “UserController” class gets an instance of “userRepository” through its constructor; how is this new repository instantiated?
                Na classe UserController  no construtor colocamos a anotação    @Autowired,
            Autowiring feature of spring framework enables you to inject the object dependency implicitly. It internally uses setter or constructor injection.

            List the methods invoked in the “userRepository” object by the “UserController”. Where are these methods defined?
               Os métodos são definidos na classe CrudRepository, classe esta que é extendida por userRepository e os métodos são save(),findAll(),  findById() e delete().

            Where is the data being saved?
                Nas depêndencias está la um h2database. Os dados estão a ser guardados nesta base de dados. Que por defeito é uma base de dados "in-memory".

            Where is the rule for the “not empty” email address defined?
                A regra para o campo email não puder ser vazio é definido em User, onde colocamos 
                @NotBlank  na declaração do atributo e assim não da para ficar vazio.



        C)
            Para adicionar o número de telemóvel é muito simples, basta na classe user colocar mais um atributo que vai ser uma String com o numero de telemóvel e depois alterar os gets sets e contrutor e basta nos templates , colocar o código que existia para mail e nome para phone também.
# EX2


# EX3


# QUESTÕES

    a)

    b)

    c)

    d)
    