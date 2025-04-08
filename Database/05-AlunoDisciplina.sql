CREATE TABLE ALUNO_DICIPLINA (
    ID_ALUNO_DISCIPLINA BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    ID_ALUNO BIGINT NOT NULL,
    ID_DISCIPLINA BIGINT NOT NULL,
    IS_ATIVO BOOLEAN,
    DTINSCRICAO TIMESTAMP,
    FOREIGN KEY (ID_ALUNO) REFERENCES ALUNO(ID_ALUNO),
    FOREIGN KEY (ID_DISCIPLINA) REFERENCES DISCIPLINA(ID_DISCIPLINA)
);
