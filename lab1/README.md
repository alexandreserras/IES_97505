
## LAB1_1
	Neste exercicio apenas foi instalado o maven, logo apenas segui as indicações do link indicado para ubuntu, dai a pasta do lab1_1 não existir
	Passos feitos:
		Verifiquei a minha versão do java com o comando -> javac -version
		Abri o link, https://www.baeldung.com/install-maven-on-windows-linux-mac , para instalar o maven na versão ubuntu.
		$ sudo apt-get install maven , verifiquei que basta fazer o tradicional comando, sudo apt install nome_programa, na linha de comandos de comandos
		git --version  -> permite ver a versão do git que tenho instalada 
		git config --list -> consigo ver o que tenho no computador associado ao git, em especial ,user.email=alexandreserras@ua.pt, que me garante que tenho o git bem instalado.


## LAB1_2
	Maven in 5 minutes -> https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
	Fazer uma aplicação com o Maven, 
	Nota como IDE vou utilizar o VSCODE com as extensões para Java com o Maven inclusive.	
	mvn version  -> Ver Maven Version (e verificar se está instalado)
	mvn archetype:generate -DgroupId=com.ex1_2.app -DartifactId=ex2 -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false  ->>Para criar um projeto com o Maven e com isto foi me criado um projeto maven numa subdiretoria chamada ex2 com a aplicação ex1_2 la dentro, logo alterei o groupID e o artifactId
	mvn package -> para construir o projeto
	java -cp target/ex2-1.0-SNAPSHOT.jar com.ex1_2.app.App -> para correr o projeto
	Resultado do tutorial maven in 5 minutes: Hello World 
   
        Notas do Maven in 5 minutes:
	
	Maven archetype->cria estruturas automaticamente já com algum código e que pode muito bem ser reutilizado, ou seja, permite poupar muito tempo ao utilizador, fazendo com que muito trabalho seja gerado logo automaticamente

	GroupId é o que serve para identificar o projeto entre todos os projetos que existem, deve ir ao encontro da nomenclutura tipica das packages do java ou seja em reversed domain ,ou seja, do nó para a raiz, org.apache.commons.
	Pode-se criar vários subgrupos, e de acordo com a estrutura do projeto consegue-se ver qual é subgrupo de qual, tipo , org.apache.maven e  org.apache.maven.plugins

	Artifact-> é o nome do jar sem versão, podemos escolher qualquer nome desde que seja letras minusculas e sem simbolos.
	
	version-> depois de distribuido, temos que indicar qual a versão que queremos usar.
	
	No projeto que é criado vamos ter com mais importantes:
		src/main/java directory contem o source code do projeto 
		src/test/java directory contem o test code do projeto
		pom.xml é a base de um projeto configurado com o Maven, e é este que vamos compilar.É um ficheiro fácil de configurar mas que vai ter a maioria da informação necessária para construir o projeto.
	
	Nota sobre as fases de projeto Maven :
		1-validate
		2-generate-sources
		3-process-sources
		4-generate-resources
		5-process-resources
		6-compile
		
		São todas as fases que o mvn package faz, mas que o Maven permite fazer em apenas 1 comando.
	
	Alinea d)	
		Ao correr o comando dado- >  curl http://api.ipma.pt/open-data/forecast/meteorology/cities/daily/1010500.json | json_pp 
	     É recebido, um cabeçalho, com a informação dos dados obtidos, desde o total, a percentagem que foi obtida, velocidade etc.
	     E depois é recebida a Data, onde vem toda a informação dos próximos 5 dias  
	     No final de tudo, chega um dataUpdate com dia,data e hora de quando foi recebio a data, o país , globalIdLocal e o owner
	     O resultado pode ser visto no ficheiro alineaD_output.
	Alinea e)
		Com o VSCode, clicando com o botão do lado direto do rato em cima de uma pasta, aparece a opção criar um projeto Maven, onde 
		escolhi o tipo quickstart e coloquei como groupId->com.MyWeatherRadar , com artifactId -> MyWeatherRadar e com versão 1.0-SNAPSHOT
		e o projeto MyWeatherRadar foi então criado .
	Alinea f)
		O POM que é um ficheiro em XML,onde tem os dados da versão do xml e o encoding que utiliza, logo na primeira linha.
		Depois todo o código xml exceto essa linha inical esta dentro de um elemento que é um project e dentro desse project vamos tendo vários subgrupos,
	primeiro aparece o groupId,artifactId,version, mais o name  e o url.
		<groupId>com.MyWeatherRadar.app</groupId>
		<artifactId>MyWeatherRadar</artifactId>
		<version>1.0-SNAPSHOT</version>
		<name>MyWeatherRadar</name>
		<url>http://www.example.com</url>
		Após isto temos um elemento property, que possui várias propertys dentro dele: encoding, compiler source e compiler target.
		  <properties>
		    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		    <maven.compiler.source>1.7</maven.compiler.source>
		    <maven.compiler.target>1.7</maven.compiler.target>
		  </properties>
		De seguida aparece as dependencies , que contem dependency e que dentro desta estão várias informações.
		<dependencies>
		    <dependency>
		      <groupId>junit</groupId>
		      <artifactId>junit</artifactId>
		      <version>4.11</version>
		      <scope>test</scope>
		    </dependency>
		 </dependencies>
		E por último grande grupo temos o build, que dentro dele tem imensos elementos 
		 <build>
		    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
		      <plugins>
			<!-- clean lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#clean_Lifecycle -->
			<plugin>
			</plugin> 
		      </plugins>
		    </pluginManagement>
		 </build>
		 
	Alinea G)
		Coloquei as 2 linhas de comando dadas no enunciado,para as versões de dependência do Java, a codificação de encoding ficou aquela que ja se encontrava, e adicionei um novo elemento developers, onde fui coloquei os dados relativos a: quem criou a app, user name, email, url, organização e mail da organização, através da ajuda da informação apresentada neste link https://books.sonatype.com/mvnex-book/reference/customizing-sect-customizing-project-info.html
		<developers>
			<developer>
			    <id>serras</id>
			    <name>Alexandre Serras</name>
			    <email>alexandreserras@ua.pt</email>
			    <url>http://www.sonatype.com</url>
			    <organization>universidade Aveiro</organization>
			    <organizationUrl>https://www.ua.pt/</organizationUrl>
			    <roles>
				<role>developer</role>
			    </roles>
			    <timezone>-6</timezone>
			</developer>
		</developers>

	Alinea H)
		A aplicação pretendida precisa de abrir uma ligação HTTP, criar um pedido GET, obter o JSON com a
		resposta, processar o conteúdo da resposta para usar o resultado. 
		Há vários passos envolvidos, que podem ser grandemente simplificados recorrendo a bibliotecas externas. O uso dessas bibliotecas (ou
		artifacts) dá origem a dependências e o maven facilita a sua gestão.
	

