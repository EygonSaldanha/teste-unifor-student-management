CREATE TABLE Disciplina (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    codigo VARCHAR(20) UNIQUE NOT NULL,
    carga_horaria INT
);
