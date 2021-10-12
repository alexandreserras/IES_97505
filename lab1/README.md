
LAB1_1
	-> Neste exercicio apenas foi instalado o maven, logo apenas segui as indicações do link indicado para ubuntu, dai a pasta do lab1_1 não existir

LAB1_2
	Nota como IDE vou utilizar o VSCODE com as extensões para Java com o Maven inclusive.	
	->Inicio da utilização do Maven.
	->Para criar um projeto com o Maven, utilizei a linha de código,
	mvn archetype:generate -DgroupId=com.ex1_2.app -DartifactId=ex2 -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false 
	, e com isto foi me criado um projeto maven numa subdiretoria chamada ex2 com a aplicação ex1_2 la dentro, logo alterei o groupID e o artifactId
	
	Maven archetype->cria estruturas automaticamente já com algum código e que pode muito bem ser reutilizado, ou seja, permite poupar muito tempo ao utilizador, fazendo com que muito trabalho seja gerado logo automaticamente

	GroupId é o que serve para identificar o projeto entre todos os projetos que existem, deve ir ao encontro da nomenclutura tipica das packages do java ou seja em reversed domain ,ou seja, do nó para a raiz, org.apache.commons.
	Pode-se criar vários subgrupos, e de acordo com a estrutura do projeto consegue-se ver qual é subgrupo de qual, tipo , org.apache.maven e  org.apache.maven.plugins

	Artifact-> é o nome do jar sem versão, depois para usar podemos escolher o nome que quisermos.
	
	version-> depois de distribuido, temos que indicar qual a versão que queremos usar.
	
	src/main/java directory contem o source code do projeto 
	src/test/java directory contem o test code do projeto
	pom.xml file is the project's Project Object Model, or POM,file is the core of a project's configuration in Maven., é o que vamos compilar
	It is a single configuration file that contains the majority of information required to build a project in just the way you want.

	
	Correndo este projeto com a linha de codigo:
		mvn package
		java -cp target/ex2-1.0-SNAPSHOT.jar com.ex1_2.app.App
	é dado print ao Hello World no terminal, nota , ter em atenção os group id etc

	
	Alinea d)	
		Ao correr o comando dado.
	     É recebido, um cabeçalho, com a informação dos dados obtidos, desde o total, a percentagem que foi obtida, velocidade etc.
	     E depois é recebida a Data, onde vem toda a informação dos próximos 5 dias  
	     No final de tudo, chega um dataUpdate com dia,data e hora de quando foi recebio a data, o país , globalIdLocal e o owner

	Alinea e)
		
	
	

