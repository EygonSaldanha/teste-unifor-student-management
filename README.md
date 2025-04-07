
# Sistema de Gerenciamento de Alunos

Este projeto é composto por um back-end desenvolvido em **Quarkus** e um front-end desenvolvido com **Angular**. Ele permite o gerenciamento de usuários, alunos e disciplinas.

---

## Tecnologias Utilizadas

- **Back-end**: Java, Quarkus, Hibernate ORM, Jakarta REST
- **Front-end**: Angular, PrimeNG
- **Banco de Dados**: PostgreSQL

---

## Como Rodar o Projeto

### Back-End

#### Pré-requisitos

- Java 17+
- Maven
- PostgreSQL

#### Configuração do Banco de Dados

1. Navegue até a pasta do projeto back-end:
   ```bash
   cd student-manager-backend
   ```

2. Compile e execute com:
   ```bash
   ./mvnw quarkus:dev
   ```

3. O back-end estará disponível em: `http://localhost:8080`

---

### Front-End

#### Pré-requisitos

- Node.js (v18+)
- Angular CLI (`npm install -g @angular/cli`)

#### Rodando o front-end

1. Navegue até a pasta do projeto front-end:
   ```bash
   cd frontend
   ```

2. Instale as dependências:
   ```bash
   npm install
   ```

3. Inicie o servidor Angular:
   ```bash
   ng serve
   ```

4. Acesse a aplicação em: `http://localhost:4200`

---

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

> ⚠️ Observação: as alterações que não foram concluídas estão disponíveis na branch .

## Contato

Se tiver dúvidas ou sugestões, entre em contato pelo e-mail: eygon11@gmail.com ou pelo telefone (85) 998234547.