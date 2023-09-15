# sisgecon-api

## Tecnologias

- Como Linguagem: Java 17 LTS.
- Spring Framework.
    - Web MVC, trata as requisições HTTP, faz o mapeamento de URLs e a comunicação entre as camadas de apresentação e de negócio.
    - Validation, para validar os dados de entrada da API e assegurar a integridade dos dados.
    - DataJPA foi utilizado para facilitar a persistência dos dados.
- Flyway, para versionamento do banco de dados.
- SQL, para buscas e ações mais avançadas não disponíveis diretamente no Spring Data JPA.

## Ferramentas

- IntelliJ IDEA
- Postman
- Git / GitHub
- Maven
- MySQL

## Documentacao das APIs

- ### API de Clientes:

  <details>
    <summary>Cadastrar um cliente</summary>

    - POST: http://localhost:8080/clients/
      - Request:
        ```bash
          curl -X POST 'localhost:8080/clients' \
            -H 'Content-Type: application/json' \
            --data '{
                "name": "Benjamin e Jorge Telecom Ltda",
                "cnpj":"73246032000145"
            }'
        ```
      - Response 201:
        ```json
          {
            "id":7,
            "name":"Benjamin e Jorge Telecom Ltda",
            "cnpj":"73246032000145"
          }
        ```
      - Response 400:
        ```json
          {
            "status": 400,
            "message": "ocorreu um ou mais erros de validação",
            "timestamp": "2023-09-15T04:28:42.950076350Z",
            "path": "/clients",
            "invalidParams": [
              {
                "field": "cnpj",
                "message": "este cnpj ja existe"
              }
            ]
          }
        ```
  </details>

  <details>
    <summary>Retornar uma lista de clientes</summary>

    - GET: http://localhost:8080/clients
      - Request:
        ```bash
          curl -X GET 'localhost:8080/clients'
        ```
      - Response 200:
        ```json
          [
            {
              "id": 1,
              "name": "Daniel e Heitor Telecomunicações ME",
              "cnpj": "71089937000123"
            },
            {
              "id": 2,
              "name": "Caleb e Rayssa Adega ME",
              "cnpj": "95550187000103"
            }
          ]
        ```
  </details>

  <details>  
	  <summary>Retornar um clientes específico</summary>

    - GET: http://localhost:8080/clients/{id} *(id do clientes buscado)*
      - Request:
        ```bash
          curl -X GET 'localhost:8080/clients/2'
        ```
      - Response 200:
        ```json
          {
            "id": 2,
            "name": "Caleb e Rayssa Adega ME",
            "cnpj": "95550187000103"
          }
        ```
      - Response 404:
        ```json
          {
            "status": 404,
            "message": "Cliente não encontrado, id:120",
            "timestamp": "2023-09-15T04:47:01.492363298Z",
            "path": "/clients/120"
          }
        ```
  </details>    
  
- ### API de Endereços:

  <details>
	  <summary>Cadastrar um cliente</summary>

    - POST: http://localhost:8080/clients
      - Request:
        ```bash
          curl -X POST 'localhost:8080/clients' \
          -H 'Content-Type: application/json' \
          --data '{
              "userId": 1,
              "street": "Rua dos Bobos",
              "number": "0",
              "neighborhood": "Vila Pompéia",
              "city": "São Paulo",
              "state": "SP"
          }'
        ```
      - Response 201:
        ```json
          {
            "id": 1,
            "street": "Rua dos Bobos",
            "number": "0",
            "neighborhood": "Vila Pompéia",
            "city": "São Paulo",
            "state": "SP",
            "user": {
                "id": 1,
                "name": "Sergio Bezerra da Silva",
                "birthDate": "1974-05-25",
                "gender": "MALE"
            },
            "people": []
          }
        ```
      - Response 400:
        ```json
          {
            "number": "Number is required",
            "city": "City is required",
            "street": "Street is mandatory",
            "state": "State is required",
            "neighborhood": "Neighborhood is required",
            "userId": "User is mandatory"
          }
        ```
      - Response 404:
        ```json
          {
            "error": "Address id: 3 not found."
          }
        ```

  </details>

  

