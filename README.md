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
	  <summary>Retornar um cliente específico</summary>

    - GET: http://localhost:8080/clients/{id} *(id do cliente buscado)*
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
  
- ### API de Containers:

  <details>
	  <summary>Cadastrar um containers</summary>

    - POST: http://localhost:8080/containers
      - Request:
        ```bash
          curl -X POST 'localhost:8080/containers' \
          -H 'Content-Type: application/json' \
          --data '{
              "number": "ACCU7577588",
              "containerType": "FORTY",
              "containerStatus": "FULL",
              "containerCategory": "IMPORT",
              "clientId": 2
          }'
        ```
      - Response 201:
        ```json
          {
            "id": 25,
            "number": "ACCU7577588",
            "containerType": "FORTY",
            "containerStatus": "FULL",
            "containerCategory": "IMPORT",
            "client": {
              "id": 2,
              "name": "Caleb e Rayssa Adega ME",
              "cnpj": "95550187000103"
            }
          }
        ```
      - Response 400:
        ```json
          {
            "status": 400,
            "message": "ocorreu um ou mais erros de validação",
            "timestamp": "2023-09-15T05:04:18.856523312Z",
            "path": "/containers",
            "invalidParams": [
              {
                  "field": "clientId",
                  "message": "não deve ser nulo"
              },
              {
                  "field": "containerType",
                  "message": "não deve ser nulo"
              },
              {
                  "field": "number",
                  "message": "deve corresponder ao padrão (ABCU1234567)"
              },
              {
                  "field": "number",
                  "message": "não deve estar em branco"
              },
              {
                  "field": "containerStatus",
                  "message": "não deve ser nulo"
              },
              {
                  "field": "containerCategory",
                  "message": "não deve ser nulo"
              }
            ]
          }
        ```
      - Response 404:
        ```json
          {
            "status": 404,
            "message": "Cliente não encontrado, id:200",
            "timestamp": "2023-09-15T05:10:34.289908583Z",
            "path": "/containers"
          }
        ```

  </details>

  <details>
    <summary>Buscar um container</summary>

    - GET: http://localhost:8080/containers/{id} *(id do endereço buscado)*
      - Request:
        ```bash
          curl -X GET 'localhost:8080/containers/1'
        ```
      - Response 200:
        ```json
          {
            "id": 1,
            "number": "TEMU7531669",
            "containerType": "TWENTY",
            "containerStatus": "EMPTY",
            "containerCategory": "IMPORT",
            "client": {
              "id": 2,
              "name": "Caleb e Rayssa Adega ME",
              "cnpj": "95550187000103"
            }
          }
        ```
      - Response 404:
        ```json
          {
            "status": 404,
            "message": "Container não encontrado, id:200",
            "timestamp": "2023-09-15T05:17:35.482749691Z",
            "path": "/containers/200"
          }
        ```
  </details>

  <details>
    <summary>Buscar todos os Containers</summary>

    - GET: http://localhost:8080/ccontainers
      - Request:
        ```bash
          curl -X GET 'localhost:8080/containers'
        ```
      - Response 200:
        ```json
        [
          {
            "id": 1,
            "number": "TEMU7531669",
            "containerType": "TWENTY",
            "containerStatus": "EMPTY",
            "containerCategory": "IMPORT",
            "client": {
              "id": 2,
              "name": "Caleb e Rayssa Adega ME",
              "cnpj": "95550187000103"
            }
          },
          {
            "id": 2,
            "number": "CAXU4568524",
            "containerType": "FORTY",
            "containerStatus": "EMPTY",
            "containerCategory": "EXPORT",
            "client": {
              "id": 1,
              "name": "Daniel e Heitor Telecomunicações ME",
              "cnpj": "71089937000123"
            }
          }
        ]
        ```
  </details>  

  <details>
    <summary>Atualizar um container</summary>

    - PUT: http://localhost:8080/containers/{id} *(id do container a ser atualizado)*
      - Request:
        ```bash
          curl -X PUT 'localhost:8080/containers/1' \
          -H 'Content-Type: application/json' \
          --data '{
            "number": "TEMU7531669",
            "containerType": "TWENTY",
            "containerStatus": "EMPTY",
            "containerCategory": "IMPORT"
          }'
        ```
      - Response 200:
        ```json        
          {
            "id": 1,
            "number": "TEMU7531669",
            "containerType": "TWENTY",
            "containerStatus": "EMPTY",
            "containerCategory": "IMPORT",
            "client": {
              "id": 2,
              "name": "Caleb e Rayssa Adega ME",
              "cnpj": "95550187000103"
            }
          }
        ```
      - Response 404:
        ```json
          {
            "status": 404,
            "message": "Container não encontrado, id:300",
            "timestamp": "2023-09-15T05:21:00.526648495Z",
            "path": "/containers/300"
          }
        ```
  </details>

  <details>
    <summary>Deletar um container</summary>

    - DELETE: http://localhost:8080/containers/{id} *(id do container a ser deletado)*
      - Request:
        ```bash
          curl -X DELETE 'localhost:8080/containers/1'
        ```
      - Response 204:
        ```json
          {}
        ```
      - Response 404:
        ```json
          {
            "status": 404,
            "message": "Violação de integridade da base",
            "timestamp": "2023-09-15T05:31:48.021555407Z",
            "path": "/containers/3"
          }
        ```      
  </details>  



