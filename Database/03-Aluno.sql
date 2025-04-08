CREATE TABLE Aluno (
    id BIGINT PRIMARY KEY,
    matricula VARCHAR(20) UNIQUE NOT NULL,
    usuario_id BIGINT,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
);
