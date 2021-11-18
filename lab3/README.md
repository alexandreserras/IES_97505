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
    a)
    Como não tenho mysql no computador vou utilizar o docker para me criar a instancia do mysql que eu preciso, a unica alteração que tive de fazer foi na porta porque a porta indicada ao inicio eu ja a tenho a ser utilizada e por isso tive que a alterar.
    Comando:
        docker run --name mysql5 -e MYSQL_ROOT_PASSWORD=secret1 -e MYSQL_DATABASE=demo -e MYSQL_USER=demo -e MYSQL_PASSWORD=secret2 -p 3000:3306 -d mysql/mysql-server:5.7
    
    https://hub.docker.com/_/mysql -> mais informações de como meter o mysql no docker pode dar jeito para um futuro 

    b,c,d,e,f) -> São todas feitas no tutorial logo vou incluir tudo como se fosse apenas 1 alinea
    https://www.javaguides.net/2018/09/spring-boot-2-jpa-mysql-crud-example.html -> Tutorial a seguir para resolvero exercicio

    Mais uma vez vou gerar o projeto com o start.spring.io
    O que é o trabalho: 
        We will build CRUD RESTFul APIs for a Simple Employee Management System using Spring Boot 2 JPA and MySQL.
    Dependencias necessarias de incluir : 
         Spring Web, Spring Data JPA, MySQLdriver, DevTools and Validation.
    Se incluirmos as dependencias logo no site onde gero o projeto, não preciso de mexer no pom para colocar as dependecias, as mesmas já la vão estar .
    
    Entity class, classes identificadas com um @Entity:
        Colocamos os objetos da base de dados,@Table(name = "employees") para criar uma tabela chamada
        employees
        @Id -> sabemos que é um ID
        @GeneratedValue(strategy = GenerationType.AUTO) -> gerado automaticamente
        @Column(name = "first_name", nullable = false) -> colunas da tabela, e podemos colocar a opção nullable, para saber se pode ficar a null ou não a respetiva coluna

    Repositório:
        Identificada pelo @Repository e extende a class JpaRepository

    A classe controler:
        Neste caso é um @RestController  é o que basicamente vai mexer na tabela Employee da base de dados 
        Tem o @Autowired, já explicado anteriormente 
        GetMapping("/employees/{id}") -> abordado no guião anterior também mas agora as funções deste tipo possuem  : ResourceNotFoundException, basicamente quando não encontra nada faz o indicado pela função 
        Employee employee = employeeRepository.findById(employeeId)
          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
         @PostMapping("/employees")-> abordado no guião anterior
        @PutMapping("/employees/{id}") -> "So, let’s say you want to send HTTP PUT request with JSON containing user details you want to update. Below is an example of CURL command which sends such HTTP PUT Request."
        @DeleteMapping("/employees/{id}")-> "Annotation for mapping HTTP DELETE requests onto specific handler methods."
         @Valid @RequestBody -> validações e o "aps the HttpRequest body to a transfer or domain object, enabling automatic deserialization of the inbound HttpRequest body onto a Java object"

    Exception(Error) Handling for RESTful Services:
        Spring Boot provides a good default implementation for exception handling for RESTful Services
        Dentro do diretório exception encontra-se a classe ResourceNotFoundException que é responsável por tratar dos erros
        onde sempre que o status for @ResponseStatus(value = HttpStatus.NOT_FOUND), a classe vai atuar

    Podemos também customizar os erros, isto se , acharmos que os erros fornecidos pelo SpringBoot não são os melhores ou mais adequados e isto é tratado na classe ErrorDetails

    Agora para colocar isto a funcionar é necessario uma classe que faça esta o Controlo, para ser possivel retornar os erros segundo a classe criada e é para isso que serve a classe GlobalExceptionHandler

    E no final com o comando para correr do spring boot 

    http://localhost:8080/api/v1/employees
    https://web.postman.co/workspace/My-Workspace~c217443e-1662-4aa2-8a7d-d154cbf14b4c/request/create?requestId=907d4fd7-af81-4d60-aff0-b08fca099563
    para mexer 

    Nota o postman tive que instalar mesmo pois a versão web não funcionava

    Todos estes métodos tem prints na raiz do exercicio
    POST  -> http://localhost:8080/api/v1/employees + dados na query json e com isto é criado um employee na database
    GET   ->  http://localhost:8080/api/v1/employees -> que retorna todos
              http://localhost:8080/api/v1/employees/5 -> retorna o employee com o id 5
    PUT   -> http://localhost:8080/api/v1/employees/5  + dados na query json e é alterado o employee com o id 5
    DELETE ->http://localhost:8080/api/v1/employees/5 + query json e é apagado da base de dados o employee com o id 5
    
    Source code github:
        https://github.com/RameshMF/spring-boot2-jpa-crud-example


    Alinea g)
        No repository     List<Employee> findByEmailId(String emailId) -> tive varios erros porque não estava a usar o nome correto na função
        @RequestParam(required = false) String email) -> na funçao que vai para o /employees para ter ser possivel utilizar o parametro do email e já esta
    

        http://localhost:8080/api/v1/employees?email=serras@mail.com -> aparece o utilizador que tem o email dado
        http://localhost:8080/api/v1/employees?email=serras -> nao aparece nada pois ninguem tem o mail dado

# EX3
    https://vladmihalcea.com/manytoone-jpa-hibernate/
    https://www.baeldung.com/hibernate-one-to-many

    docker run --name mysql5 -e MYSQL_ROOT_PASSWORD=secret1 -e MYSQL_DATABASE=demo -e MYSQL_USER=demo -e MYSQL_PASSWORD=secret2 -p 3000:3306 -d mysql/mysql-server:5.7

    Precisei de criar 2 entidades e com isto criei 2 serviço , 2 repositórios e 1 controller 

    Problemas principais foi erros com as foreign keys que me ia tendo.
    Depois de ter tudo conectado corretamente entre as 2 entidades torna-se relativamente simples, fazer o resto que era apenas passar os dados de um lado para o outro.
    Os inserts na base de dados vi-los através de metodos posts disponvieis no controller e é possivel fazer com o postman , que torna bastante mais pratico.

    http://localhost:8080/shows
    http://localhost:8080/quote
    http://localhost:8080/quotes?show=4

    
    Docker )
        Como o docker estava-me a dar muitos erros, decidi fazer uma pasta nova, onde coloquei ex3_with_docker e foi lá que fiz a implementação do exercicio com docker
        
        Criei os 2 ficheiros dockerfile e o docker-compose up 

        Correr:
              ./mvnw install -DskipTests
              docker-compose up
            
            Contudo tenho algo mal na ligação para com a db
            


    

# QUESTÕES

    a)
    As classe que possui a anotação @RestController , retorna Json Data.
    As classes que tem a anotação @Controller renderiza o template do Thymeleaf.
    "The @RestController annotation in Spring MVC/Spring BOOT is nothing but a combination of @Controller and @ResponseBody annotation."
    "The @Controller annotation indicates that the class is controller like web Controller while @RestController annotation indicates that the class is controller where @RequestMapping Method assume @ResponseBody by Default(i.e REST APIs)."


    b)
        A imagem está em anexo nesta diretoria com o nome perguntas_b
    c)
        @Id ->Serve para especificar a chave primária de uma entidade
        @Column ->É uma anotação opcional que permite personalizar o mapeamento entre o atributo da entidade e a coluna da base de dados
        @Table -> Esta anotação permite especificar os detalhes da tabela que vai ser usada para guardar a entidade na base de dados de forma persistente
            


    d)
        Explain the use of the annotation @AutoWired (in the Rest Controller class).
         "The Spring framework enables automatic dependency injection. In other words, by declaring all the bean dependencies in a Spring configuration file, Spring container can autowire relationships between collaborating beans. This is called Spring bean autowiring."
         Na classe UserController é utilizado para marcar a instância de UserRepository