
# Sistema de Gerenciamento de Alunos

Este projeto é composto por um back-end desenvolvido em **Quarkus** e um front-end desenvolvido com **Angular**. Ele permite o gerenciamento de usuários, alunos e disciplinas.
# Sistema de Gerenciamento de Alunos

Este projeto é composto por um back-end desenvolvido em **Quarkus** e um front-end em **Angular**. Ele permite o gerenciamento de usuários, alunos e disciplinas, agora totalmente executável via Docker.

> ⚠️ Observação: infelizmente não consegui terminar o projeto a tempo, por isso estou desenvolvendo uma nova versão na branch `projeto-v2`.

---

## Tecnologias Utilizadas

- **Back-end**: Java, Quarkus, Hibernate ORM, Jakarta REST
- **Front-end**: Angular, PrimeNG
- **Banco de Dados**: PostgreSQL
- **Containerização**: Docker, Docker Compose

---

## Como Rodar o Projeto com Docker

### Pré-requisitos

- Docker
- Docker Compose

### Subindo o ambiente completo

1. Na raiz do projeto, execute:
   ```bash
   docker compose up --build

2. A aplicação estará disponível nos seguintes endereços:

- **Frontend**: [http://localhost:4200](http://localhost:4200)
- **Backend (API)**: [http://localhost:8080](http://localhost:8080)
- **PostgreSQL**: acessível internamente pelos containers (`postgres:5432`)

# Mapeamento de Rotas – Projeto Student Management

## Backend – Rotas JAX-RS (Java)

### Disciplina
| Método | Rota                  | Descrição                               |
|--------|-----------------------|------------------------------------------|
| GET    | `/disciplinas`        | Lista todas as disciplinas               |
| GET    | `/disciplinas/{id}`   | Busca disciplina por ID                  |
| POST   | `/disciplinas`        | Cria uma nova disciplina                 |
| PUT    | `/disciplinas/{id}`   | Atualiza uma disciplina existente        |
| DELETE | `/disciplinas/{id}`   | Deleta uma disciplina por ID             |

### Aluno
| Método | Rota                  | Descrição                                  |
|--------|-----------------------|---------------------------------------------|
| GET    | `/alunos`             | Lista todos os alunos                       |
| GET    | `/alunos/{id}`        | Retorna um aluno com dados de usuário       |
| POST   | `/alunos/create`      | Cria um novo aluno                          |
| PUT    | `/alunos/{id}`        | Atualiza dados do aluno e do usuário        |
| DELETE | `/alunos/{id}`        | Deleta um aluno                             |
| GET    | `/alunos/curso/{id}`  | Lista alunos (nome e matrícula) por curso   |

### Matrícula (Aluno x Disciplina)
| Método | Rota                         | Descrição                                       |
|--------|------------------------------|-----------------------------------------------|
| POST   | `/matriculas`                | Realiza a matrícula de um aluno em disciplinas|
| GET    | `/matriculas/aluno/{id}`     | Lista disciplinas em que o aluno está inscrito|⚠️
| GET    | `/matriculas/disciplina/{id}`| Lista alunos matriculados em uma disciplina   |⚠️

## Frontend – Angular (Rotas)

| Caminho         | Componente         | Descrição                   |
|-----------------|--------------------|-----------------------------|
| `/login`        | `LoginComponent`   | Tela de login               |
| `/menu`         | `MenuComponent`    | Menu principal pós-login    |
| `/alunos`       | `AlunoComponent`   | Tela gerencia de alunos     |
| `/disciplinas`  | (provavelmente)    | Tela gerencia de disciplinas|

## Contato

Se tiver dúvidas ou sugestões, entre em contato pelo e-mail: eygon11@gmail.com ou pelo telefone (85) 998234547.
