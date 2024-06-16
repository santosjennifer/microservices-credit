![Last Commit](https://img.shields.io/github/last-commit/santosjennifer/microservices-credit)

### Sistema para emissão, controle e avaliação de limite para cartão

Responsável por cadastrar clientes, cartões e liberar limite de crédito.

#### Repositório com os serviços eureka-server, ms-gateway, ms-customer, ms-card e ms-credit-appraiser.

- **ms-eureka-server:** responsável por registrar e gerenciar a comunicação dos demais microserviços (ms-gateway, ms-customer, ms-card e ms-credit-appraiser) com spring security.
- **ms-gateway:** responsável gerenciar as rotas do API Gateway, utilizando o Keycloak como gerenciador de autenticação.
- **ms-customer:** responsável cadastrar e retornar os clientes.
- **ms-card:** responsável por cadastrar os cartões e vincular ao clientes consumindo eventos publicados no RabbitMQ.
- **ms-credit-appraiser:** responsável por aprovar limite e solicitar emissão do cartão para o cliente, publicando eventos no RabbitMQ.

### Tecnologia

- Java 21
- Maven
- Spring Boot 3.2.4
- Rabbit MQ
- Keycloak
- Docker
