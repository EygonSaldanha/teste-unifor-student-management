CREATE TABLE Gerente (
    id BIGINT PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    setor VARCHAR(100),
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
);
