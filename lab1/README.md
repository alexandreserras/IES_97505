
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
		Vamos usar o gson e o retrofit como essas bibliotecas externas

		Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("https://api.github.com/")
			.build();
		@GET("users/{user}/repos")
  		Call<IpmaCityForecast>  cidadeByName = service.getCidadeByName();
		Response<IpmaCityForecast> data = cidadeByName.execute();
		.body() vai buscar a informação que veio com a mensagem 
		.getData()-> Passa toda a informação que vem no campo Data da mensagem.

		"Gson is a Java library that can be used to convert Java Objects into their JSON representation."
		e assim com isto, vamos buscar a informação que esta na pagina do github, naquela pasta, para o user que é passado como argumento.
		Para ser compativel com o  programa é necessário atualizar o pom.xml no lugar das depêndencias

	Aline I)
		Ter uma noção do gráfico de depêndencias
	Alinea J)
		https://gist.github.com/icoPT/8b378e03244d07e11645a97fa1857d7c -> classe main / WeatherStart
		https://gist.github.com/icoPT/a8cf15730bb201a76b228ef3cace5908 -> outras classes
		
		Estas classes vão ser colocadas em  MyWeatherRadar/src/main/java/com/MyWeather

		mvn exec:java -Dexec.mainClass="com.MyWeatherRadar.WeatherStarter"  -Dexec.cleanupDaemonThreads=false 
		out 14, 2021 6:44:31 DA TARDE com.MyWeatherRadar.WeatherStarter main
		INFO: Temperatura máxima em Aveiro é de : 25.9

		e acertando as packages e correndo o resultado é aquele que é obtido

		"Clears the target directory and Builds the project and packages the resulting JAR file into the target directory."->mvn clean package  
		"Clears the target directory into which Maven normally builds your project." -> mvn clean
		no maven o -D é sempre muito importante, switch is used to define/pass a property to Maven in CLI. 
		Podemos utilizar vários -Dexec.algo 
			

	Alinea k)
		Tive que fazer alterações na classe WeatherStarter, CityForecast,IpmaService (tive que adicionar 1 serviço), para descobrir estes valores tive que utilizar dos dados json o globalID e o nome do local.
		Nome do local é utilizado para ver todos os nomes, e caso um deles seja igual ao input do user , uso isso para ir buscar o globalID desse local e tendo o global id sei toda a informação sobre esse local.
	para assim ser possivel que todas as localidades que estão no json podem ser passadas para o programa e assim indica qual vai ser a temperatura máxima para a zona pretendida.
	 mvn exec:java -Dexec.mainClass="com.MyWeatherRadar.WeatherStarter" -Dexec.cleanupDaemonThreads=false
	 comando para correr

	Res: Quando se pesquisa sem argumentos por default fica Aveiro
		mvn exec:java -Dexec.mainClass="com.MyWeatherRadar.WeatherStarter"  -Dexec.cleanupDaemonThreads=false 
		out 14, 2021 6:44:31 DA TARDE com.MyWeatherRadar.WeatherStarter main
		INFO: Temperatura máxima em Aveiro é de : 25.9


		 mvn exec:java -Dexec.mainClass="com.MyWeatherRadar.WeatherStarter" -Dexec.args="Viseu Aveiro China Santarém"  -Dexec.cleanupDaemonThreads=false 
		out 14, 2021 6:43:32 DA TARDE com.MyWeatherRadar.WeatherStarter main
		INFO: Temperatura máxima em Viseu é de : 23.2
		out 14, 2021 6:43:32 DA TARDE com.MyWeatherRadar.WeatherStarter main
		INFO: Temperatura máxima em Aveiro é de : 25.9
		out 14, 2021 6:43:32 DA TARDE com.MyWeatherRadar.WeatherStarter main
		INFO: China não existe na base de dados 
		out 14, 2021 6:43:32 DA TARDE com.MyWeatherRadar.WeatherStarter main
		INFO: Temperatura máxima em Santarém é de : 28.7


## LAB1_3
	(Duvida quanto ao que é pedido no 1.2 e se é preciso passar tudo aquilo que estava antes no lab_12  para este)
	https://www.atlassian.com/git/tutorials/learn-git-with-bitbucket-cloud -> tutorial
	Com o BitBucket é um bocadinho como utilizar o GITHUB no site, e por uma questão de ser mais familiar o github
	prefiro utilizar antes este do que o BitBucket.

	Ficheiro ".gitignore -> "Note that .gitignore provides patterns for files or folders to exclude, from the directory in which it is include.  You may create .ignore in multiple folders, but is usual  to do it in the root of a project. If you have a repository with several project subfolders, you may choose to propagate certain rules from root into the sub-folders, in the exclusion list."


	ALinea b)
		Para colocar os ficheiros no Github posso abrir o repositorio e dar clone e depois só colocar lá ou criar o repositorio localmente e depois passar o git esse repositório
		Vou fazer um pequena simulação dos comandos que preciso apesar de já ter, tudo no github nesta altura do guião visto que criei o repositório logo no inicio do lab

		NOTA FALTA O FICHEIRO DE IGNORE

	ALinea c)
	Sincronizar com a cloud, colocar aquilo que temos localmente la
	v1
		$git clone link
		$git add . -> . significa tudo
		$git commit -m " msg" 
		$git push 
	v2
	$ cd project_folder # move to the root of the working folder to be imported 
	$ git init # initialize a local git repo in this folder 
	$ git remote add origin <REMOTE_URL>  #must adapt the url for your repo 
	$ git add.   # mark all existing changes in this root to be commited 
	$ git commit -m "Initial project setup for exercise 1_3" #create the commit snapshot locally 
	$ git push -u origin main #uploads the local commit to the shared repo 

	Alinea d)
		$git clone git@github.com:alexandreserras/IES_97505.git 
	e assim fico com o repositório para poder trabalhar no local2, o link apresentado vem com SSH, o que simplifica bastante o facto de assim não ser preciso estar sempre a colocar  os dados
		
		

	Alinea e)
			https://howtodoinjava.com/log4j2/log4j2-xml-configuration-example/
			fonte utilizada, utilizando a opção de escrever o resultado dos loggs na consola
			Seguindo o tutorial é muito claro aquilo que se precisa de fazer

	Alinea f)
		Basta fazer pull no repositório que estavamos a utilizar como main e fica tudo bem
		git log --graph --oneline --decorate> lab1-2.log
		comando que pode ser utilizado para produzir os logs num ficheiro

		Ter sempre muita atenção aos commits visto que são muito importantes para se perceber o trabalho realizado e a evolução ao longo do tempo e no quê que pode ter havido trocas 


## LAB1_4
	Utilizar containers facilita bastante a nossa vida e resolve muito os problemas de versões , com isto resolve-se aquele problema de um dado trabalho correr numa maquina e em outra não. Devido ao uso de docker vai correr na mesma forma em todas
	Vantagens de usar docker -> Facilidade de configurar,produtividade do desenvolvimento, isolar a app, server consolidado,
	capacidade de debbug e o rapido desenvolvimento
	Alinea a)
		 https://docs.docker.com/engine/install/ubuntu/ -> tutorial que segui
		5:18.09.0~3-0~ubuntu-bionic -> opção escolhida no passo 2 de instalar o docker engine

		Para não ter de estar sempre a fazer sudo segui o tutorial abaixo
		https://docs.docker.com/engine/install/linux-postinstall/
	Alinea b)
	https://docs.docker.com/get-started/-> link do tutorial para começar a mexer no docker
		Docker tutorial parte 1 -> Part 1: Getting started

		 docker/docker containers --help -> Mostram a lista de todos os CLI commands que o docker tem

		 docker run -d -p 80:80 docker/getting-started -> primeiro comando em docker
		 todos os comandos -> https://docs.docker.com/engine/reference/commandline
		  -d significa que vai correr em background
		  -p 80:80 -a porta 80 do host vai para  a porta 80 do container
		  docker/getting-started- > imagem que vai ser usada

		  docker rm -f $(docker ps -aq) -> comando que remove todos os containers
		  docker ps -> mostra toda a info acerca de containers que temos na nossa maquina
		  docker container ls/docker cp -> Copia os ficheiros entre o container e o filesystem local	
		  docker version [OPTIONS] -> da toda a info da versao  do docker que temos instalado
		  docker info-> da mais outras info do docker 
		  docker run [options] algo  [commands] [args]-> executa o docker image
		  docker image ls -> mostra a lista de docker images

		  docker image build	Constroi a imagem a partir de um docker file
		  docker image history	Mostra o historico de uma imagem 
		  docker container attach	Anexa o local standart input,output e erros a um docker a correr 
		  docker container commit	Cria uma nova imagem a partir de uma mudança de container


	
		O que é um container:
			"Container is a sandboxed process on your machine that is isolated from all other processes on the host machine.
			Docker has worked to make these capabilities approachable and easy to use."
		Quando estamos a correr um container ele usa um filesystem isolado , este custom filesystem é dado por um container image
		Desde que a imagem contenha o filesystem o container's filesystem , temos tudos o que precisamos para correr a aplicação s

		Parte 2-> https://docs.docker.com/get-started/02_our_app/

		https://github.com/docker/getting-started/tree/master/app -> link da app

		Passos:
			1-> Criar um docker file
			2-> docker build -t getting-started . -> Construir uma nova docker image , o . no fim indica que o Docker deve olhar para o dockerfile que esta nesta diretoria
			3-> Correr o programa ->  docker run -dp 3000:3000 getting-started
			4-> http://localhost:3000/ abrindo este link temos a nossa app já a funcionar

	ALinea c)
		Apesar de ser CLI por vezes da jeito uma app com interface grafica que nos ajude ,"The Portainer app is a web application that facilitates the management of Docker container"

		Instalar Portainer -> https://docs.portainer.io/v/ce-2.9/start/intro
		https://localhost:9443/ é onde ficou a app instalada
			credenciais:
				user:admin
				pass:serra****
		
		$docker volume create portainer_data
		$docker run -d -p 8000:8000 -p 9000:9000 --name=portainer --restart=always -v /var/run/docker.sock:/var/run/docker.sock -v portainer_data:/data portainer/portainer-ce
		https://www.youtube.com/watch?v=ARuyau0_j28&ab_channel=TheTinkerDad -> video com mais info sobre portainer
	Aline d)
		 Postgres Docker Image -> "Since the advent of Docker, I rarely find my self directly installing development software on my local machine. "
		 "Installing software is hard. "
		 "Docker provides a way out of this mess by reducing the task of installing and running software to as little as two commands (docker run and docker pull). In this post we will see this process in action by taking a step by step look at how easy and simple it is to setup a Postgres installation with docker."
		 docker run --rm --name pg-docker -e POSTGRES_PASSWORD=docker -d -p 5432:5432 -v $HOME/docker/volumes/postgres:/var/lib/postgresql/data postgres  mas com isto vamos utilizar uma default image

		 docker pull postgres [versão (opcional)]-> Vamos buscar a imagem mais recente estabalizada do postgres
		 fonte: https://hackernoon.com/dont-install-postgres-docker-pull-postgres-bee20e200198

		Em vez de utilizarmos a imagem que o postgres tem podemos nos próprios customizar a nossa própria imagem com certas adaptações 
		 Docker build object, onde se encontra o dockerfile- >https://docs.docker.com/samples/postgresql_service/

		O exercicio foi feito na diretoria post
		
		Primeiro método:
		Container build
		  docker build -t eg_postgresql . -> construir a imagem do dockerfile e dar lhe um nome
				
		Problema das keys ->The command '/bin/sh -c apt-key adv --keyserver hkp://p80.pool.sks-keyservers.net:80 --recv-keys B97B0AFCAA1A47F044F244A07FCC7D46ACCC4CF8' returned a non-zero code: 2

		Logo tive que fazer o tutorial -> https://dzone.com/articles/postgresql-with-docker-quick-start

		
		docker run --name pg-docker -e POSTGRES_PASSWORD=docker -e POSTGRES_DB=sampledb -e PGDATA=/tmp -d -p 5433:5432 -v ${PWD}:/var/lib/postgresql/data postgres:11 


		Ligar a partir do meu host
			docker ps -> para ver qual é o que tem a imagem com o nome:eg_postgresql
			psql -h localhost -p porta -d docker -U docker --password

		 	 
		Para conseguir persistencia dos dados da base de dados, teríamos de criar um volume e fazer link a esta imagem, usar docker-compose por exemplo. Também o podemos fazer recorrendo ao portainer,que o faz automaticamente. Uma outra opção para utilizar volumes será, seguindo a configuração atual da dockerfile existente, recorrer à flag -v, ao correr o container:

		$docker run --rm -v pgdata:/var/lib/postgresql/9.3/main -P --name pg_test eg_postgresql

		



	Alinea e)
		Docker compose-> O docker compose podemos facilmente fazer build e run de muitos  containers, pelo que se todos os componentes correrem corretamente num container, conseguimos descrever toda a app como uma compose file. 
		Instalar o Docker Compose:
		sudo curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
		sudo chmod +x /usr/local/bin/docker-compose
		Verificar se foi instalado:
		docker-compose --version

		O exercicio foi feito na diretoria composetest

		Começar o docker compose-> docker-compose up
		Começar aplicação em detached mode-> docker-compose up -d
		Para ver todos os docker compose -> docker-compose ps
		Ver as variaveis que estão na web-> docker-compose run web env
		Parar tudo do compose -> docker-compose stop
		Remover todos os containers e até a data dos volumes-> docker-compose down --volumes
		Tutorial -> https://docs.docker.com/compose/gettingstarted/
		http://127.0.0.1:5000
		Notas no desenvolvimento da app:
			Notas do que faz o dockerfile:
				"This tells Docker to:
					Build an image starting with the Python 3.7 image.
					Set the working directory to /code.
					Set environment variables used by the flask command.
					Install gcc and other dependencies
					Copy requirements.txt and install the Python dependencies.
					Add metadata to the image to describe that the container is listening on port 5000
					Copy the current directory . in the project to the workdir . in the image.
					Set the default command for the container to flask run."
			Docker compose.yml:
				Define os serviços web e redis
				"The new volumes key mounts the project directory (current directory) on the host to /code inside the container, allowing you to modify the code on the fly, without having to rebuild the image."
				e com isto não precisamos de mandar a aplicação abaixo para estar a trabalhar nela

## LAB1_5
	Neste exercicio é pedido para agarrar no exercicio 2 e tranforma-lo em 2 projetos separados
	A parte da API vai ficar no projeto api e a parte da interação do user fica no projeto main
	Para ligar os projetos basta:
		mvn package no projeto api  e com isto vou obter o jar
		Ir ao projeto main e no pom adicionar 
		<dependency>
		<groupId>com.api.app</groupId>
		<artifactId>api</artifactId>
		<version>1.0</version>
		
		</dependency>
	
	mvn install:install-file -Dfile="/home/alexandre/ies/IES_97505/lab1/lab1_5/subCla/target/subCla-1.0-SNAPSHOT.jar" -DgroupId="com.subCla.app" -DartifactId="subCla" -Dversion="1.0-SNAPSHOT" -Dpackaging=jar
	mvn package
	exec:java -Dexec.mainClass="com.user.app.App" -Dexec.args="Viseu Aveiro China Santarém"  -Dexec.cleanupDaemonThreads=false 
	E já está a funcionar
## Reniew questions

	A)
		Maven main phases no ciclo default:
			validate - Verifica se toda a informação disponivel para o projeto está "available" e valida se o projeto esta correto 
			compile - Compila o source code 
			test -Testa o source code compilado  
			package - Leva o código compilado e "package" numa forma distribuivel como por exemplo um jar 
			verify -Corre os unit tests, para garantir que os critérios de qualidade estão todos
			install - instala o package no repositorio local 
			deploy - Feito no ambiente de construção , copia o package final para o repositório remoto para ser possivel partilha-lo 
	B) 
		Sim, o maven pode ser util para correr o nosso projeto , como utilizamos na pergunta 1.2 para o correr ou em   uma aplicação web e pode fazer muitas outras tarefas através de plug-ins
		O Maven pode ativar diferentes plug-ins, incluindo plug-ins para executar uma classe específica


	C)
		git pull
		(FAZER A ADIÇÃO DA FUNCIONALIDADE)
		git add . 
		git commit -m "Adição da funcionalidade"
		git push

	D)
		->Em alturas que estamos a fazer debug de por exemplo 3 bugs, é melhor dar commit 1 a 1 da resolução dos bugs , porque assim vamos ficar com uma muito melhor organização
		->A mensagem deve ser o mais especifica possivel daquilo que foi alterado/removido /adicionado
		->Fazer commits pequenos, vai um bocado ao encontro dos bugs
		-> Quando estamos a fazer tentativas, não devemos 
		-> Não dar commit de trabalhos a meio, devemos acabar e só depois dar commit
		-> Usar uma linguagem que todos os membros da equipa vão perceber, para que caso alguem pegue no trabalho perceba
		o que foi feito
		->Usar o "body" para explicar o que foi feito e porquê
		-> Não dar commit diretamente no master, fazer branch primeiro, para termos segurança que se alguem da nossa equipa mexeu no trabalho não vamos estar a dar overwrite no dele.
		-> Evitar reescrever o historico do master



	E)
		
		Ao configurar volumes, como se pode ver pelos apontamentos, vamos fazer com que exista persistencia dos dados na base de dados e assim caso se apague o container , os dados vão continuar la
		E caso exista reboot do sistema , os dados também se vão manter


