# 🛒 Spring Boot Essentials — API REST de Produtos

> API REST desenvolvida do zero com Java e Spring Boot para gerenciamento de produtos, aplicando boas práticas como DTOs, tratamento global de exceções e documentação via Swagger.

---

## 🚀 Tecnologias

- **Java 17+**
- **Spring Boot 3.x**
- **Lombok** — redução de boilerplate
- **SpringDoc OpenAPI (Swagger UI)** — documentação interativa
- **Maven** — gerenciamento de dependências

---

## 📌 Endpoints

Base URL: `http://localhost:8080/v1/products`

| Método   | Rota           | Descrição                      | Status de Sucesso |
|----------|----------------|--------------------------------|:-----------------:|
| `GET`    | `/`            | Lista todos os produtos        | `200 OK`          |
| `POST`   | `/`            | Cria um novo produto           | `201 Created`     |
| `PUT`    | `/{id}`        | Atualiza um produto pelo ID    | `201 Created`     |
| `DELETE` | `/{id}`        | Remove um produto pelo ID      | `204 No Content`  |

### Exemplo de corpo para `POST` e `PUT`

```json
{
  "name": "Notebook",
  "price": 5000.00,
  "quantity": 10
}
```

### Exemplo de resposta

```json
{
  "id": 1,
  "name": "Notebook",
  "price": 5000.00,
  "quantity": 10
}
```

### Exemplo de resposta de erro (`404 Not Found`)

```json
{
  "message": "Product not found",
  "status": 404
}
```

---

## ⚙️ Como rodar o projeto

### Pré-requisitos

- [Java JDK 17+](https://www.oracle.com/java/technologies/downloads/)
- [Maven 3.8+](https://maven.apache.org/download.cgi)

### Passo a passo

```bash
# 1. Clone o repositório
git clone https://github.com/seu-usuario/spring-boot-essencials.git

# 2. Entre na pasta do projeto
cd spring-boot-essencials

# 3. Execute a aplicação
./mvnw spring-boot:run
```

A API estará disponível em: **`http://localhost:8080`**

---

## 📖 Documentação (Swagger UI)

Com a aplicação rodando, acesse a documentação interativa em:

```
http://localhost:8080/swagger-ui.html
```

---

## 🧠 Funcionalidades e Conceitos Aplicados

- **REST Controller** com mapeamento de verbos HTTP (`GET`, `POST`, `PUT`, `DELETE`)
- **DTO Pattern** — separação entre o objeto de entrada (`ProductDto`) e o modelo interno (`ProductEntity`)
- **Tratamento global de exceções** com `@RestControllerAdvice` (`GlobalExceptionHandler`)
- **Exceção customizada** `NotFoundException` com resposta padronizada via `ErrorResponse`
- **Armazenamento em memória** com `ArrayList` estático (sem banco de dados)
- **Lombok** para geração automática de construtores, getters, setters e builders
- **Swagger/OpenAPI** para documentação automática dos endpoints

---

> Desenvolvido por **Aguiar** 🚀