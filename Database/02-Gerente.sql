CREATE TABLE GERENTE (
    ID_GERENTE BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    ID_USUARIO BIGINT NOT NULL,
    MATRICULA VARCHAR(100),
    FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID_USUARIO)
);
