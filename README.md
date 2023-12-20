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

## Objetivo futuro

o objetivo final dessa API e ter esse retorno na API de Employee

```json
{
  "id": "string",
  "contractType": "EMPLOYEE",
  "hireDate": "2023-12-20",
  "dismissalDate": "2023-12-20",
  "employeeType": "EMPLOYEE",
  "registerNumber": 0,
  "employmentrelationshiptype": "EMPREGADO_GERAL",
  "jobPosition": {
    "id": "string",
    "name": "string",
    "codcar": "string"
  },
  "department": {
    "id": "string",
    "tableCode": 0,
    "position": "string",
    "address": {
      "id": "string",
      "additional": "string",
      "neighborhood": "string",
      "address": "string",
      "city": {
        "id": "string",
        "name": "string",
        "state": {
          "id": "string",
          "abbreviation": "string",
          "name": "string",
          "code": 0
        },
        "code": 0
      }
    },
    "code": "string",
    "name": "string",
    "creationDate": "2023-12-20",
    "expirationDate": "2023-12-20",
    "historicExpirationDate": "2023-12-20"
  },
  "costCenter": {
    "id": "string",
    "name": "string",
    "codccu": "string",
    "descriptionCode": "string",
    "creationDate": "2023-12-20",
    "expirationDate": "2023-12-20",
    "company": {
      "id": "string",
      "numemp": 0,
      "tradingName": "string",
      "companyName": "string",
      "cnpj": "string",
      "companyType": "BRANCH_OFFICE",
      "cnae": "string",
      "address": {
        "id": "string",
        "additional": "string",
        "neighborhood": "string",
        "address": "string",
        "city": {
          "id": "string",
          "name": "string",
          "state": {
            "id": "string",
            "abbreviation": "string",
            "name": "string",
            "code": 0
          },
          "code": 0
        }
      }
    }
  },
  "workShift": {
    "id": "string",
    "name": "string",
    "codesc": 0,
    "workload": 0
  },
  "employer": {
    "id": "string",
    "numemp": 0,
    "tradingName": "string",
    "companyName": "string",
    "cnpj": "string",
    "companyType": "BRANCH_OFFICE",
    "cnae": "string",
    "address": {
      "id": "string",
      "additional": "string",
      "neighborhood": "string",
      "address": "string",
      "city": {
        "id": "string",
        "name": "string",
        "state": {
          "id": "string",
          "abbreviation": "string",
          "name": "string",
          "code": 0
        },
        "code": 0
      }
    }
  },
  "person": {
    "id": "string",
    "firstname": "string",
    "middlename": "string",
    "lastname": "string",
    "socialName": "string",
    "nickname": "string",
    "fullName": "string",
    "birthday": "2023-12-20",
    "gender": "MALE",
    "maritalstatus": "SINGLE",
    "race": "NOT_INFORMED",
    "cpf": "string",
    "nis": [
      {
        "id": "string",
        "number": "string",
        "registrationDate": "2023-12-20"
      }
    ],
    "emails": [
      {
        "id": "string",
        "email": "string",
        "emailType": "PERSONAL"
      }
    ],
    "nationality": {
      "id": "string",
      "name": "string",
      "code": 0
    },
    "naturality": {
      "id": "string",
      "name": "string",
      "state": {
        "id": "string",
        "abbreviation": "string",
        "name": "string",
        "code": 0
      },
      "code": 0
    },
    "educationDegree": {
      "id": "string",
      "name": "string",
      "code": 0
    },
    "phoneContact": [
      {
        "id": "string",
        "carrier": "string",
        "countryCode": 0,
        "localCode": 0,
        "number": "string",
        "extention": "string",
        "phoneContactType": "PERSONAL"
      }
    ],
    "address": [
      {
        "id": "string",
        "additional": "string",
        "neighborhood": "string",
        "address": "string",
        "city": {
          "id": "string",
          "name": "string",
          "state": {
            "id": "string",
            "abbreviation": "string",
            "name": "string",
            "code": 0
          },
          "code": 0
        }
      }
    ],
    "disabilities": [
      {
        "id": "string",
        "disability": {
          "id": "string",
          "code": 0,
          "name": "string",
          "type": "PHYSICAL"
        },
        "mainDisability": true,
        "isRehabilitated": true,
        "dateWhen": "2023-12-20"
      }
    ]
  },
  "phoneContact": [
    {
      "id": "string",
      "carrier": "string",
      "countryCode": 0,
      "localCode": 0,
      "number": "string",
      "extention": "string",
      "phoneContactType": "PERSONAL"
    }
  ],
  "emails": [
    {
      "id": "string",
      "email": "string"
    }
  ],
  "workstation": {
    "id": "string",
    "workstationGroup": {
      "id": "string",
      "name": "string",
      "postra": "string"
    },
    "hierarchyItem": {
      "id": "string"
    }
  },
  "historicStability": [
    {
      "id": "string",
      "startDate": "2023-12-20",
      "endDate": "2023-12-20",
      "stabilityType": "NOT_STABLE"
    }
  ]
}
```
