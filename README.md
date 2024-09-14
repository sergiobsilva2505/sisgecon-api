# SISGECON - API

São requisitos funcionais da aplicação:

1. Crud de Contêiner
    1. Cliente
    2. Número do contêiner (4 letras e 7 números. Ex: TEST1234567)
    3. Tipo: 20 / 40
    4. Status: Cheio / Vazio
    5. Categoria: Importação / Exportação
2. Crud de Movimentações
    1. Tipo de Movimentação (embarque, descarga, gate in, gate out, reposicionamento, pesagem, scanner)
    2. Data e Hora do Início
    3. Data e Hora do Fim
3. Relatório com o total de movimentações agrupadas por cliente e tipo de movimentação.
    1. No ﬁnal do relatório deverá conter um sumário com o total de importação /
       exportação.

#### Algumas observações imortantes

- Não é um requisito funcional, a aplicação ter uma entidade cliente, porém achei melhor modelar porque ficaria melhor
  tanto pra gerar o relatório como pra não gerar inconsistencias.
- O inicio e o fim de uma movimentação, não estão no formulario, porque a hora de inicio é setada no construtor, e a
  finalização, quando ocorre uma requisição para o enpoint `/movements/{id}/finish`.
- Para os tipos de movimentação, o tipo `pesagem` foi dividido em dois, `pesagem de entrada` e `pesagem de saida`, pois
  acredito que o container é pesado quando chega e quando sai.
- O `Status da movimentação` foi criado para definir o inicio e o fim de uma movimentação, porque uma operação como
  reposionamento pode demorar e se alguém busca o container no sistema, já vai saber que ele está sendo movimentado.
- Na pasta `src/main/resources` se encontra o arquivo `data.sql`, com alguns inserts para o banco de dados.

## Tecnologias

- Como Linguagem: Java 17 LTS.
- Spring Framework.
    - Web MVC, trata as requisições HTTP, faz o mapeamento de URLs e a comunicação entre as camadas de apresentação e de
      negócio.
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

    - GET: http://localhost:8080/ccontainers?page={page}&size={size} *com paginação de tamanho opcional*
        - Request:
          ```bash
            curl -X GET 'localhost:8080/containerspage=1&size=5'
          ```
        - Response 200:
          ```json
          {
            "content": [
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
              ],
              "pageable": {
                "pageNumber": 0,
                "pageSize": 2,
                "sort": {
                  "sorted": false,
                  "unsorted": true,
                  "empty": true
                },
                "offset": 0,
                "paged": true,
                "unpaged": false
              },
              "totalPages": 13,
              "totalElements": 26,
              "last": false,
              "first": true,
              "size": 2,
              "number": 0,
              "sort": {
                "sorted": false,
                "unsorted": true,
                "empty": true
              },
              "numberOfElements": 2,
              "empty": false
            }
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

- ### API de Movimentações:

  <details>
    <summary>Cadastrar um movimentação</summary>

    - POST: http://localhost:8080/movements/
        - Request:
          ```bash
            curl -X POST 'localhost:8080/movements' \
            -H 'Content-Type: application/json' \
            --data '{
              "movementType": "GATE_IN",
              "containerId": 15
            }'
          ```
        - Response 201:
          ```json
          {
            "id": 192,
            "movementType": "GATE_IN",
            "initialDate": "2023-09-15T02:42:38.370812847",
            "finishDate": null,
            "movementStatus": "IN_PROGRESS",
            "containerNumber": "ASQU1478963",
            "containerType": "TWENTY",
            "containerStatus": "FULL",
            "containerCategory": "EXPORT",
            "clientName": "Vitor e Regina Financeira ME"
          }
          ```
        - Response 400
          ```json
            {
              "status": 400,
              "message": "ocorreu um ou mais erros de validação",
              "timestamp": "2023-09-15T05:47:00.537266568Z",
              "path": "/movements",
              "invalidParams": [
                {
                    "field": "containerId",
                    "message": "não deve ser nulo"
                },
                {
                    "field": "movementType",
                    "message": "não deve ser nulo"
                }
              ]
            }
          ```
  </details>
  <details>
    <summary>Buscar uma movimentação</summary>

    - GET: http://localhost:8080/movements/{id} *(id da movimentação buscado)*
        - Request
          ```bash
            curl -X GET 'localhost:8080/movements/3'
          ```
        - Response 200
          ```json
            {
              "id": 3,
              "movementType": "GATE_IN",
              "initialDate": "2023-09-12T20:37:58",
              "finishDate": "2023-09-12T20:37:58",
              "movementStatus": "FINISHED",
              "containerNumber": "TEMU9871236",
              "containerType": "TWENTY",
              "containerStatus": "FULL",
              "containerCategory": "IMPORT",
              "clientName": "César e Pedro Henrique Casa Noturna Ltda"
            }
          ```
        - Response 404
          ```json
            {
              "status": 404,
              "message": "Container não encontrado, id:300",
              "timestamp": "2023-09-15T05:51:45.656093892Z",
              "path": "/movements/300"
            }
          ```
  </details>
  <details>
    <summary>Buscar todos os Movimentações</summary>

    - GET: http://localhost:8080/movements?page={page}&size={size} *com paginação de tamando opcional*
        - Request:
          ```bash
            curl -X GET 'localhost:8080/movements?page=1&size=6'
          ```
        - Response 200
          ```json
            {
              "content": [
                {
                  "id": 1,
                  "movementType": "GATE_IN",
                  "initialDate": "2023-09-12T20:37:58",
                  "finishDate": "2023-09-12T20:37:58",
                  "movementStatus": "FINISHED",
                  "containerNumber": "TEMU7531669",
                  "containerType": "TWENTY",
                  "containerStatus": "EMPTY",
                  "containerCategory": "IMPORT",
                  "clientName": "Caleb e Rayssa Adega ME"
                },
                {
                  "id": 3,
                  "movementType": "GATE_IN",
                  "initialDate": "2023-09-12T20:37:58",
                  "finishDate": "2023-09-12T20:37:58",
                  "movementStatus": "FINISHED",
                  "containerNumber": "TEMU9871236",
                  "containerType": "TWENTY",
                  "containerStatus": "FULL",
                  "containerCategory": "IMPORT",
                  "clientName": "César e Pedro Henrique Casa Noturna Ltda"
                }
              ],
              "pageable": {
                "pageNumber": 0,
                "pageSize": 2,
                "sort": {
                  "sorted": false,
                  "unsorted": true,
                  "empty": true
                },
                "offset": 0,
                "paged": true,
                "unpaged": false
              },
              "totalPages": 95,
              "totalElements": 190,
              "last": false,
              "first": true,
              "size": 2,
              "number": 0,
              "sort": {
                "sorted": false,
                "unsorted": true,
                "empty": true
              },
              "numberOfElements": 2,
              "empty": false
            }
          ```
  </details>
  <details>
    <summary>Atualizar um movimentação</summary>

    - PUT: http://localhost:8080/movements/{id} *(id da movimentação a ser atualizado)*
        - Request:
          ```bash
            curl -X PUT 'localhost:8080/movements/192/finish' \
            -H 'Content-Type: application/json' \
            --data ''
          ```
        - Response 200:
          ```json
            {
              "id": 192,
              "movementType": "GATE_IN",
              "initialDate": "2023-09-15T02:42:38",
              "finishDate": "2023-09-15T02:55:55.648013882",
              "movementStatus": "FINISHED",
              "containerNumber": "ASQU1478963",
              "containerType": "TWENTY",
              "containerStatus": "FULL",
              "containerCategory": "EXPORT",
              "clientName": "Vitor e Regina Financeira ME"
            }
          ```
        - Response 404
          ```json
            {
              "status": 404,
              "message": "Container não encontrado, id:392",
              "timestamp": "2023-09-15T05:56:45.346566111Z",
              "path": "/movements/392/finish"
            }
          ```
  </details>
  <details>
    <summary>Deletar um movimentação</summary>

    - DELETE: http://localhost:8080/movements/{id} *(id da movimentação a ser deletado)*
        - Exemplo de requisição:
          ```bash
            curl -X DELETE 'localhost:8080/movements/1'
          ```
        - Exemplo de retorno em caso de sucesso:
          ```json
            {}
          ```
        - Response 404
          ```json
            {
              "status": 404,
              "message": "Movimentação não encontrada, id:2",
              "timestamp": "2023-09-15T06:00:17.613353786Z",
              "path": "/movements/2"
            }
          ```
  </details>
  <details>
    <summary>Buscar movimentações de um container</summary>

    - POST: http://localhost:8080/containers/{number}/movements *(number do container a ser buscado)*
        - Request:
          ```bash
            curl -X POST 'localhost:8080/containers/TGBU9873214/movements' \
            -H 'Content-Type: application/json' \
            --data ''
          ```
        - Response 201:
          ```json
            {
              "id": 21,
              "number": "TGBU9873214",
              "containerType": "TWENTY",
              "containerStatus": "FULL",
              "containerCategory": "EXPORT",
              "movements": [
                {
                  "id": 21,
                  "movementType": "GATE_IN",
                  "initialDate": "2023-09-12T20:37:58",
                  "finishDate": "2023-09-12T20:37:58",
                  "movementStatus": "FINISHED"
                },
                {
                  "id": 42,
                  "movementType": "GATE_OUT",
                  "initialDate": "2023-10-12T15:27:58",
                  "finishDate": "2023-10-12T19:45:58",
                  "movementStatus": "FINISHED"
                },
                {
                  "id": 63,
                  "movementType": "REPOSITIONING",
                  "initialDate": "2023-10-12T15:27:58",
                  "finishDate": "2023-10-12T19:45:58",
                  "movementStatus": "FINISHED"
                },
                {
                  "id": 84,
                  "movementType": "IN_WEIGHING",
                  "initialDate": "2023-09-12T20:37:58",
                  "finishDate": "2023-09-12T21:45:58",
                  "movementStatus": "FINISHED"
                },
                {
                  "id": 105,
                  "movementType": "OUT_WEIGHING",
                  "initialDate": "2023-09-13T09:37:58",
                  "finishDate": "2023-09-13T10:45:58",
                  "movementStatus": "FINISHED"
                },
                {
                  "id": 126,
                  "movementType": "SCANNER",
                  "initialDate": "2023-10-12T11:27:58",
                  "finishDate": "2023-10-12T11:45:58",
                  "movementStatus": "FINISHED"
                },
                {
                  "id": 147,
                  "movementType": "LOADING",
                  "initialDate": "2023-10-12T15:27:58",
                  "finishDate": "2023-10-12T19:45:58",
                  "movementStatus": "FINISHED"
                },
                {
                  "id": 168,
                  "movementType": "SHIPPING",
                  "initialDate": "2023-10-12T15:27:58",
                  "finishDate": "2023-10-12T19:45:58",
                  "movementStatus": "FINISHED"
                },
                {
                  "id": 189,
                  "movementType": "UNLOAD",
                  "initialDate": "2023-10-12T15:27:58",
                  "finishDate": "2023-10-12T19:45:58",
                  "movementStatus": "FINISHED"
                }
              ]
            }
          ```
        - Response 400
          ```json
           {
              "status": 404,
              "message": "Container não encontrado, number:TGBU6663214",
              "timestamp": "2023-09-15T06:13:11.556314911Z",
              "path": "/containers/TGBU6663214/movements"
            }
          ```
  </details>
