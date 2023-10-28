# Projeto TODO LIST

A proposta deste projeto simplificado é desenvolver um gerenciador com a lista de tarefas a ser executada para cada um dos usuários cadastrados.

## Tecnologias utilizadas

* Java 17
* Apache Maven
    * Tomcat Server Web Embedded
* Spring Boot for Maven
* Hierarquia de Package

### Documentação de Referência

Para consultas e referências, considere observar a documentação original como nas seções abaixo:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.4/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#web)

### Guias de Consulta

Os guias de utilização trazem ilustrações das telas, o passo-a-passo a ser seguido e as funcionalidades disponíveis em cada uma das tecnologias utilizadas:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

## Padrões de Commit

O commit contém os seguintes elementos estruturais, para comunicar a intenção ao utilizador da sua biblioteca:

fix: um commit do tipo fix soluciona um problema na sua base de código (isso se correlaciona com PATCH do versionamento semântico).
feat: um commit do tipo feat inclui um novo recurso na sua base de código (isso se correlaciona com MINOR do versionamento semântico).
BREAKING CHANGE: um commit que contém o texto BREAKING CHANGE:, no começo do texto do corpo opcional ou do rodapé opcional, inclui uma modificação que quebra a compatibilidade da API (isso se correlaciona com MAJOR do versionamento semântico). Uma BREAKING CHANGE pode fazer parte de commits de qualquer tipo.
Outros: tipos adicionais são permitidos além de fix: e feat:, por exemplo @commitlint/config-conventional (baseado na Convenção do Angular) recomenda-se chore:, docs:, style:, refactor:, perf:, test:, entre outros.