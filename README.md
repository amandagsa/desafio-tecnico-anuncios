## Desafio de Programação - Academia Capgemini

### Spring Rest API - Cadastro de Anúncios

Projeto desenvolvido para o desafio de programação da Academia Capgemini (Julho/2021).

<br>

## 📚 Índice
 1. [Sobre o Projeto](#projeto)
 2. [Tecnologias utilizadas](#tecnologias)
 3. [Pré-requisitos e como executar/testar a aplicação](#requisitos)
 4. [Autora](#autora)

<br>
<div id='projeto'/>

## 💻 Sobre o Projeto

**O problema:**  A agência Divulga Tudo precisa de um programa para gerenciar os seus anúncios online. O objetivo dos anúncios faz parte de uma campanha nas redes sociais. O sistema de gerenciamento permitirá a gestão do anúncio e o rastreio dos resultados da campanha.

Este desafio será composto de duas partes:

- 1ª Parte – **Uma calculadora de alcance de anúncio online.**
Crie um script que receba o valor investido em reais e retorne uma projeção aproximada da quantidade máxima de pessoas que visualizarão o mesmo anúncio.

- 2ª Parte - **Um sistema de cadastro de anúncios.**
Crie um sistema que permita o cadastro de anúncios e forneceça os relatórios de cada anúncio contendo: valor total investido, quantidade máxima de visualizações, quantidade máxima de cliques e quantidade máxima de compartilhamentos.

Portanto, neste projeto é possivel realizar:

- Cadastro de anúncios;
- Listagem de todos os anúncios cadastrados;
- Gerar relatório de projeção de alcance de cada anúncio;
- Gerar relatórios de projeção de alcance de anúncios de um cliente;
- Gerar relatórios de projeção de alcance de anúncios ativos em um intervalo de tempo;
- Gerar relatórios de projeção de alcance de anúncios ativos de um cliente em um intervalo de tempo.

<br>
<div id='tecnologias'/>

## 🛠 Tecnologias Utilizadas

As seguintes ferramentas foram utilizadas na construção do projeto:

&rarr; <a href="https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html">Java</a> - Linguagem de programação utilizada.<br>
&rarr; <a href="https://spring.io/">SpringBoot</a> - Frameworks java utlizada no projeto. <br>
&rarr; <a href="https://maven.apache.org/">Maven </a> - Gerenciar as dependências do projeto.<br>
&rarr; <a href="https://www.mysql.com/">Mysql</a> - Banco de dados.<br>
&rarr; <a href="https://www.postman.com/">Postman</a> - Teste local da API.<br>
&rarr; <a href="https://swagger.io/">Swagger</a> - Documentação da API.  <br>
<br>

<div id='requisitos'/>

## 👷 Pré-requisitos e como executar/testar a aplicação
### -  Pré-requisitos:

* Ter o [Java](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html) instalado (JDK e JRE).
* Ter o [Maven](https://maven.apache.org/) instalado.
* Ter o [MySQL Workbench](https://www.mysql.com/products/workbench/) instalado.

### -  Dependências do projeto:

- <a href="https://spring.io/projects/spring-data-jpa#overview">Spring Data JPA</a><br>
- <a href="https://spring.io/projects/spring-ws">Spring Web</a><br>
- <a href="https://spring.io/projects/spring-boot">Spring Boot DevTools</a><br>
- <a href="https://spring.io/guides/gs/accessing-data-mysql/">MySQL Driver </a><br>

<div id='como rodar'/>
<br>

### - Como executar e testar:


#### 1.  Faça uma copia do projeto para sua maquina:

Clone o repositório:
```bash
$ git clone https://github.com/amandagsa/anuncios
```
Entre dentro da pasta:
```bash
$ cd anuncios
```

<br>

#### 2. Conexão MySQL Workbanch


- Procure dentro da árvore do projeto (main > resources) o arquivo: **application.properties,** ele é usado para definir as configurações de acesso local ao banco. 

- Inserir neste arquivo a seguinte configuração:

```sql
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true  
spring.datasource.url=jdbc:mysql://localhost:3306/anuncios  
spring.datasource.username=root  
spring.datasource.password=  
spring.jpa.hibernate.ddl-auto=update
```

#####  Configuração do MySQL Workbanch

-  Crie uma conexão local do Mysql caso não tenha uma criada.
- Em seguida acesse a conexão e crie um database de nome '*anuncios*'.


```sql
create database anuncios;
```

- Acesse o database e a deixe selecionado.
<br>

#### 3. Compilando e executando o projeto:

- Acesse o projeto por uma IDE de sua preferência: INTELIJ, ECLIPSE, VSCODE etc.  
  
- Para compilar o projeto vá até a pasta onde se encontra o arquivo `pom.xml` e execute no terminal o comando: `mvn clean install`

- Se o resultado do build for `BUILD SUCCESS`, execute o projeto usando: `mvn exec:java`

- Logo após, abra o seu navegador e acesse a pagina: `http://localhost:8080/`


#### 4. Teste da API

- Pode ser feito pelo swagger: <a href="http://localhost:8080/swagger-ui.html">http://localhost:8080/swagger-ui.html</a><br>

- Ou importanto a collecion no Postman: <a href="https://www.getpostman.com/collections/41d06738d6317123dc75">https://www.getpostman.com/collections/41d06738d6317123dc75</a><br>

<div id='autora'/> 

<br>

## :woman_technologist:  Autora

<table>
    <td align="center"><br/>
        <a href="https://github.com/amandagsa">
            <img src="https://avatars.githubusercontent.com/u/52843599?v=4" width="100px;"
                alt="Amanda Alves" /><br><sub><b>Amanda Alves</b></sub><br></a><br/>
        <p align="center">
            <a href="https://github.com/amandagsa">
                <img src="https://user-images.githubusercontent.com/60848932/117540779-2bad0e80-afe7-11eb-8391-2b6661a3efc3.png"
                    width="30px" alt="GitHub" />
            </a>
            <a href="https://www.linkedin.com/in/amandagsalves/">
                <img src="https://user-images.githubusercontent.com/60848932/117540778-29e34b00-afe7-11eb-8a68-5916e9822145.png"
                    width="30px" alt="Linkedin" />
            </a>
            <a href="mailto:amandagsal@gmail.com">
                <img src="https://user-images.githubusercontent.com/60848932/117541013-3ddb7c80-afe8-11eb-83c2-79827e99ec59.png"
                    width="30px" alt="Email" />
            </a>
        </p>
    </td>
</table>


