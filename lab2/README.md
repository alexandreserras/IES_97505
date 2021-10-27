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

c) Criar a nossa primeira aplicação web com o maven
    Vou gerar com o vscode a aplicação com o maven

    archetypeGroupId=org.codehaus.mojo.archetypes
    archetypeArtifactId=webapp-javaee7
    archetypeVersion=1.1
    Com estes dados e um projeto web em vez do tipico quickstart

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

i) DUVIDA NESTE, perguntar ao stor na proxima aula
    Acho que neste já estou a tratar desta exceção no exercicio anterior, visto que tenho um caso que trata quando o user é null, caso não tivesse isto, acredito que seja aqui que o erro do NullPointerException iria ocorrer
    Mas vou tirar para forçar o erro para ver o que acontece, aparentemente não acontece nada logo idk