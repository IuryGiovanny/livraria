
# Livraria API

Projeto backend em Java com Spring Boot, Maven e Jakarta EE para gerenciamento de livros e autores.

---

## Sumário

- [Descrição](#descrição)
- [Tecnologias](#tecnologias)
- [Pré-requisitos](#pré-requisitos)
- [Como rodar](#como-rodar)
- [Endpoints da API](#endpoints-da-api)
  - [Autores](#autores)
  - [Livros](#livros)
- [Exemplos de requisição (Postman / cURL)](#exemplos-de-requisição-postman--curl)
- [Validações e tratamento de erros](#validações-e-tratamento-de-erros)

---

## Descrição

API REST para gerenciamento de uma livraria. Permite criar, listar, atualizar e deletar autores (`Escritor`) e livros (`Livro`), incluindo relacionamentos entre eles.

---

## Tecnologias

- Java 22
- Spring Boot
- Maven
- Jakarta Persistence (JPA)
- Hibernate Validator (Bean Validation)
- Banco de dados H2 (em memória) ou configure seu banco favorito

---

## Pré-requisitos

- JDK 22 instalado
- Maven instalado
- IDE recomendada: IntelliJ IDEA (ou outra de sua preferência)

---

## Como rodar

1. Clone o repositório  
```bash
git clone https://github.com/seuusuario/livraria.git
```

2. Navegue até a pasta do projeto  
```bash
cd livraria
```

3. Rode o projeto com Maven  
```bash
mvn spring-boot:run
```

O servidor vai iniciar na porta padrão `http://localhost:8080`

---

## Endpoints da API

### Autores (`Escritor`)

| Método | Endpoint           | Descrição                     |
|--------|--------------------|------------------------------|
| GET    | /autores           | Lista todos os autores        |
| GET    | /autores/{id}      | Busca autor por ID            |
| POST   | /autores           | Cria novo autor              |
| PUT    | /autores/{id}      | Atualiza autor existente     |
| DELETE | /autores/{id}      | Remove autor                 |

---

### Livros (`Livro`)

| Método | Endpoint              | Descrição                       |
|--------|-----------------------|--------------------------------|
| GET    | /livros               | Lista todos os livros           |
| GET    | /livros/{id}          | Busca livro por ID              |
| POST   | /livros               | Cria novo livro               |
| PUT    | /livros/{id}          | Atualiza livro existente        |
| DELETE | /livros/{id}          | Remove livro                  |
| GET    | /livros/autor/{nome}  | Busca livros pelo nome do autor |

---

## Exemplos de requisição (Postman / cURL)

### Criar um autor (POST `/autores`)

```json
{
  "nome": "José da Silva",
  "cpf": "12345678901",
  "email": "jose.silva@email.com",
  "idade": 45
}
```

cURL:
```bash
curl -X POST http://localhost:8080/autores \
 -H "Content-Type: application/json" \
 -d '{"nome":"José da Silva","cpf":"12345678901","email":"jose.silva@email.com","idade":45}'
```

---

### Criar um livro (POST `/livros`)

```json
{
  "nome": "Aprendendo Java",
  "preco": 59.90,
  "editora": "Editora XPTO",
  "ano_publicacao": 2023,
  "autor": {
    "id_autor": 1
  }
}
```

cURL:
```bash
curl -X POST http://localhost:8080/livros \
 -H "Content-Type: application/json" \
 -d '{"nome":"Aprendendo Java","preco":59.90,"editora":"Editora XPTO","ano_publicacao":2023,"autor":{"id_autor":1}}'
```

---

### Atualizar livro (PUT `/livros/{id}`)

```json
{
  "nome": "Aprendendo Java - Edição Atualizada",
  "preco": 64.90,
  "editora": "Editora XPTO",
  "ano_publicacao": 2024,
  "autor": {
    "id_autor": 1
  }
}
```

cURL:
```bash
curl -X PUT http://localhost:8080/livros/1 \
 -H "Content-Type: application/json" \
 -d '{"nome":"Aprendendo Java - Edição Atualizada","preco":64.90,"editora":"Editora XPTO","ano_publicacao":2024,"autor":{"id_autor":1}}'
```

---

### Listar livros (GET `/livros`)

cURL:
```bash
curl http://localhost:8080/livros
```

---

## Validações e tratamento de erros

- O backend valida os campos obrigatórios usando anotações como `@NotBlank`, `@Email`, `@Size` e retorna erros com código 400 em caso de dados inválidos.
- Respostas 404 são retornadas se recursos não forem encontrados para update ou delete.
- Requisições inválidas (ex: método não suportado) retornam códigos HTTP apropriados.

---

## Contato

Qualquer dúvida, abra uma issue ou me contate:  
**Seu Nome** - seuemail@exemplo.com

---

**Licença**: MIT License
