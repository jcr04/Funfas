# Sistema de Gestão de Funcionários

Este é um sistema de gestão de funcionários construído com Java, Spring Boot, PostgreSQL e outras tecnologias. O sistema fornece uma API REST para realizar operações relacionadas a funcionários.

## Configurações

Antes de executar a aplicação, certifique-se de configurar corretamente o arquivo `application.properties` localizado em `src/main/resources`. Este arquivo contém as configurações do banco de dados PostgreSQL, como URL, nome de usuário e senha.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/funfa
spring.datasource.username=postgres
spring.datasource.password=12345
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
debug=true
server.port=8081
spring.jpa.show-sql=true
spring.main.allow-bean-definition-overriding=true
```
## Como Executar
Para executar a aplicação, siga os seguintes passos:
1. Certifique-se de ter o Java instalado.
2. Clone este repositório.
3. Configure o arquivo application.properties conforme as instruções acima.
4. Execute a aplicação usando sua IDE ou o Maven: mvn spring-boot:run.

Acesse a API em http://localhost:8081.
