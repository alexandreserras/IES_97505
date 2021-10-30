Java Servlet is the foundation web specification in the Java Enterprise environment. 
O servlet é uma classe Java que corre do lado do servidor e trata dos requests do cliente, processa-os e responde ao pedido com a resposta.
O servlet deve ser implementado em multithread Servlet Container para ser usado.
O servlet é uma interface genérica e o tipo de Servlets mais usados é o HttpServlet que é uma extensão da interface
Quando a aplicação recebe o pedido,o server passa o pedido para o Servlet Container que passa para o Servlet selecionado.

" Servlet Containers and Docker Containers are different concepts! You use Docker Containers to
deploy virtualized runtimes, for any kind of services; Servlet Containers provide a runtime to execute
server-side web-related Java code (no virtualization)."

Temos várias aplicações que podemos utilizar como servidores vamos utilizar o Apache Tomcat

https://javaee.github.io/javaee-spec/javadocs/javax/servlet/http/HttpServlet.html -> documentação da classe HttpServlet

https://www.javatpoint.com/HttpServlet-class .> mais um link sobre a classe
Esta classe da varias funcionalidades http como doGet e doPost

https://javaee.github.io/servlet-spec/ -> quando precisar de ligar ao maven tenho aqui as dependencias que preciso


a)
Para ir para o servidor apache basta cd /apache-tomcat-9.0.54/bin
e para correr basta dar as permissoes chmod 775 ao catalina.sh e ao startup.sh
e correr o ./startup.sh
e fica http://localhost:8080/

Para parar de correr basta fazer ./catalina.sh stop 
b)
    O ambiente de manager , que pode ser usada para controlo do server e inclui implementação e desinstalação de aplicações desenvolvidas
    http://localhost:8080/manager
    Mas primeiro temos de registar a role conf/tomcat-users.xm 

    <role rolename="manager-gui"/>
    <role rolename="manager-script"/>
    <user username="admin" password="secret" roles="manager-gui,manager-script"/>

    e agora já é possivel com o utilizador admin entrar como manager

    http://localhost:8080/examples/servlets/

    http://localhost:8080/examples/servlets/reqparams.html-> exemplo do source code para o reqparams.
    Observando o código podemos ver que é estruturas html, onde tem 2 campos onde podemos inserir o nosso primeiro e ultimo nome.

    Todas as classes fazem extend  a HttpServlet

c)
 Criar a nossa primeira aplicação web com o maven
    Vou gerar com o vscode a aplicação com o maven

    archetypeGroupId=org.codehaus.mojo.archetypes
    archetypeArtifactId=webapp-javaee7
    archetypeVersion=1.1
    Com estes dados e um projeto web em vez do tipico quickstart

    mvn archetype:generate -DgroupId=com.tomcat_21.app -DartifactId=tomcat_webapp -DarchetypeArtifactId=webapp-javaee7 -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeVersion=1.1 -DinteractiveMode=false

d) Após isto podemos fazer mvn install e verificar que não houve erros
    No target temos uma pastas .war que é o package da nossa aplicação
    como arquivo WEB

e) 
    Decidi que ia usar a primeira opção, e no tomcat como manager fui a WAR file to deploy
    e dei para aqui upload dos ficheiros e com isto quando fiz deploy na parte de Applications já la tenho uma aplicação chamada /webapp-javaee7. 

f)
    http://localhost:8080/webapp-javaee7/
    Aparece aqui escrito Hello word, logo correu tudo como esperado

g)
    Dar deploy pelo página do tomcat tem algumas desvantagens, por exemplo não esta ligado ao ide e é especifico para o tomacat.
    Logo é necessário ligar a extensão para nao ter que estar sempre a dar install 
    A solução é usar o  IDE integrated deployment support. 

    Contudo neste estou a ter alguns problemas mesmo tentando isto, https://code.visualstudio.com/docs/java/java-tomcat-jetty

h)
    mvn archetype:generate -DgroupId=com.tomcat_21.app -DartifactId=tomcat_webapp -DarchetypeArtifactId=webapp-javaee7 -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeVersion=1.1 -DinteractiveMode=false
    Correndo a aplicação no tomcat na aplicação vamos para este link: http://localhost:8080/tomcat_webapp-1.0-SNAPSHOT/
        Onde é impresso na aplicação web "Hello world!"
    Adicionando ao url firstApp/ estamos a aplicar a App.java com o url que la colocamos e assim vai passar a aparecer na aplicação web:
        "Olá anónimo , bem vindo a este mundo
        Daqui para a frente já vai ser mais complexo mas vais conseguir"
    Se ao link anterior já com o firstApp adicionarmos "?username = <nome>" vamos ter um display na aplicação diferente para cada nome que é dado, neste caso se dermos ao username o nome "serras" passando a ter o link abaixo
    http://localhost:8080/tomcat_webapp-1.0-SNAPSHOT/firstApp?username=serras passando este username é apresentado na aplicação a seguinte frase :
                "Olá serras, bem vindo a este mundo
        Daqui para a frente já vai ser mais complexo mas vais conseguir"

i) 
    Acho que neste já estou a tratar desta exceção no exercicio anterior, visto que tenho um caso que trata quando o user é null, caso não tivesse isto, acredito que seja aqui que o erro do NullPointerException iria ocorrer
    Para o erro ser gerado tive que basicamente meter fora do try e assim o erro já é gerado
    Log :
        28-Oct-2021 14:52:51.197 INFO [http-nio-8080-exec-9] org.apache.catalina.startup.HostConfig.deployWAR Deploying web application archive [/home/alexandre/apache-tomcat-9.0.54/webapps/tomcat_webapp-1.0-SNAPSHOT.war]
        28-Oct-2021 14:52:51.244 INFO [http-nio-8080-exec-9] org.apache.catalina.startup.HostConfig.deployWAR Deployment of web application archive [/home/alexandre/apache-tomcat-9.0.54/webapps/tomcat_webapp-1.0-SNAPSHOT.war] has finished in [47] ms
        28-Oct-2021 14:54:33.356 INFO [http-nio-8080-exec-12] org.apache.catalina.startup.HostConfig.undeploy Undeploying context [/tomcat_webapp-1.0-SNAPSHOT]
        28-Oct-2021 14:54:44.074 INFO [http-nio-8080-exec-14] org.apache.catalina.startup.HostConfig.deployWAR Deploying web application archive [/home/alexandre/apache-tomcat-9.0.54/webapps/tomcat_webapp-1.0-SNAPSHOT.war]
        28-Oct-2021 14:54:44.116 INFO [http-nio-8080-exec-14] org.apache.catalina.startup.HostConfig.deployWAR Deployment of web application archive [/home/alexandre/apache-tomcat-9.0.54/webapps/tomcat_webapp-1.0-SNAPSHOT.war] has finished in [42] ms
        28-Oct-2021 14:56:58.562 INFO [http-nio-8080-exec-18] org.apache.catalina.startup.HostConfig.undeploy Undeploying context [/tomcat_webapp-1.0-SNAPSHOT]
        28-Oct-2021 14:57:15.947 INFO [http-nio-8080-exec-24] org.apache.catalina.startup.HostConfig.deployWAR Deploying web application archive [/home/alexandre/apache-tomcat-9.0.54/webapps/tomcat_webapp-1.0-SNAPSHOT.war]
        28-Oct-2021 14:57:15.993 INFO [http-nio-8080-exec-24] org.apache.catalina.startup.HostConfig.deployWAR Deployment of web application archive [/home/alexandre/apache-tomcat-9.0.54/webapps/tomcat_webapp-1.0-SNAPSHOT.war] has finished in [47] ms

Exercício 2)
    Quando queremos correr o nosso web container de dentro da app devemos usar um "embedded server", desde que o seu lifecycle e deployment dos artifacts é controlado pela código da aplicação

    https://examples.javacodegeeks.com/enterprise-java/jetty/embedded-jetty-server-example/

    "Generally you write a web application and build that in a WAR file and deploy WAR file on jetty server. In Embedded Jetty, you write a web application and instantiate jetty server in the same code base."

    Isto é uma alternativa ao anterior visto que ao   fazer o deploy num container, o container pode ser incorporado
    Vamos utilizar o Jetty Server como sistema embebido

    Para isso no projeto maven temos que colocar as dependencias:
         <dependency>
            <groupId>org.eclipse.jetty</groupId>
            <artifactId>jetty-server</artifactId>
            <version>9.2.15.v20160210</version>
        </dependency>
        <dependency>
            <groupId>org.eclipse.jetty</groupId>
            <artifactId>jetty-servlet</artifactId>
            <version>9.2.15.v20160210</version>
        </dependency> 
    Criar o servidor:
        Server server = new Server(8680);       
         
        ServletHandler servletHandler = new ServletHandler();
        server.setHandler(servletHandler);
                 
        servletHandler.addServletWithMapping(HelloServlet.class, "/");
         
        server.start();
        server.join();
    O servidor fica colocado na porta 8680 e com isto basta na função de get colocamos o código da pergunta 1 e assim fica resolvido o problema e com o nosso sistema embebido a funcionar, com as mesmas condições que na pergunta anterior, ou seja, quando não é colocado ?username=<nome> no final do link dá um erro.

    Para correr :
        mvn package
        mvexec:java -Dexec.mainClass="com.javacodegeeks.EmbeddedJettyExample" -D exec.cleanupDaemonThreads=false

    http://localhost:8680/ -> isto dá um erro, porque o username é obrigatório 
    http://localhost:8680/?username=Alexandre dá um display
    http://localhost:8680/?username=<nome> dá um display diferente

    Conclusão:
        "In this example, we saw how to create an embedded jetty server, then we showed how to add a handler to an embedded jetty server. At last, we showed how to use a standard handler ServletHandler in an embedded jetty server"
    
Exercício 3)
    Spring Boot,full-featured framework, é uma plataforma   de desenvolvimento rápido de aplicações contruida sobre o famoso Spring Framework.
    Ao assumir escolhas "opinioted" por default, assume opções de configurações comuns sem ser necessário dizer tudo.
    O Spring Boot é uma adição de convenção sobre a configuração para Spring.
    Muito útil para começar a aplicação com pouco trabalho e criação autônoma.
    https://spring.io/projects/spring-boot
    Spring Boot, torna fácil criar um "stand-alone", "production-grade"  Spring based aplications que nos podemos apenas correr.

    Features:
        Criar "stand-alone " Spring Aplications
        Embed Tomcat, Jetty diretamente -> não é preciso deploy ao WAR files.
        Dá um "opinionated" started dependencies para simplificar a nossa configuração de construção.
        Configura automaticamente Spring and bibliotecas terceiras quando possivel.
        Não tem code genereation e não requer uma configuração XML

    Alinea A)
        
        https://start.spring.io/ -> neste link indicamos os dados de criação do projeto que queremos, tudo o que antes era necessário fazer à mão no maven, basicamente, adicionando o Spring Web como dependencia.
            ->Alterei também o artifact id e o group id
        Depois de termos feito o download do starter pack gerado pelo Spring Initializr, devemos conseguir construir a aplicação com os tipicos comandos Maven.
        O projeto gerado contem um Maven Wrapper Script (mvnw)
        Formas de correr:
            $ mvn install -DskipTests && java -jar target\webapp1-0.0.1-SNAPSHOT.jar
            or
            $ ./mvnw spring-boot:run

        Apesar de estar tudo bem feito e o projeto estar em https://localhost:8080/ , ele dá um erro visto que ainda não foi configurado qualquer página.
        Nota: Com a mistura dos diversos exercícios não esquecer que o TOMCAT também usa a porta 8080 por default por tanto se alguma fez tiver problemas com portas muitas vezes pode ser por causa disso.

    Alinea B)

        https://spring.io/guides/gs/serving-web-content/ -> Construir a nossa primeira aplicação com Spring Boot a partir daqui.

        Vamos criar a aplicação de forma scrath  -> https://spring.io/guides/gs/serving-web-content/#scratch

        Boas práticas  de um projeto spring boot:
            1-Definir o package em todas as classes 
            2- MAnter a classe principal (base) numa pasta raiz e as outras classes em pastas separadas
        Fazendo isto facilita a legibilidade do código mas também a sua organização uma vez que a a classe raiz é identificada por @SpringBootAplication

        Spring Boot Tools-> Provides fast application restarts, LiveReload, and configurations for enhanced development experience.
        Thymeleaf->A modern server-side Java template engine for both web and standalone environments. Allows HTML to be correctly displayed in browsers and as static prototypes.

        Neste tipo de aplicações os HTTP Requests são manipulados por um controller, por  @Controller,conseguimos saber quem é o controller
        A VIEW é quem é responsabilidade por dar render o conteúdo HTML

        Na classe GreetingController num primeiro momento, temos la o controller:
            @GetMapping -> annotation ensures that HTTP GET requests to /greeting are mapped to the greeting() method.
            @RequestParam -> Liga o valor do parametro da query name  ao parametro name de greeting().O parametro não é obrigatório, quando não é passado usa-se por default a string Worlds. O valor do campo nome é passado para a Model, que o torna acessível para a view 

        Na pasta dos templates é onde colocamos o nosso HTML, onde esta parte é gerida pelo Thymeleaf

        O Spring Boot DevTools-> É o que vai fazer com que não precisemos de perder tempo, a ter que reinciar a aplicação sempre que seja feita uma troca no código.

        Correr a aplicação:
            Temos a classe FirstAppApplication, que foi criada automaticamente com o projeto e é esta a nossa classe raiz
                @SpringBootApplication is a convenience annotation that adds all of the following:

                    @Configuration: Tags the class as a source of bean definitions for the application context.

                    @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. For example, if spring-webmvc is on the classpath, this annotation flags the application as a web application and activates key behaviors, such as setting up a DispatcherServlet.

                    @ComponentScan: Tells Spring to look for other components, configurations, and services in the com/example package, letting it find the controllers.

        SpringApplication.run() method to launch an application. 

        http://localhost:9000/greeting -> retorn Hello,World
        http://localhost:9000/greeting?name=Alex -> retorna Hello, Alex!


        Indo ao apliccation.properties que se encontra em  resources  e colocando server.port=9000
        Passo a ter em vez da porta 8080 que era a porta para onde ia por default agora passo a correr o projeto na porta 9000

        A página index.html é apenas para dar uma home page para a nossa aplicação

        Nota importante: Ter atenção as packages do vscode, pois ele colocou uma por default em uma classe e estava errada e com isso tive bastante tempo a tentar resolver o problema quando o mesmo era apenas a package que aparentemente estava correta


        https://code.visualstudio.com/docs/java/java-spring-boot -> link para integrar com o vsCode

    C)
        