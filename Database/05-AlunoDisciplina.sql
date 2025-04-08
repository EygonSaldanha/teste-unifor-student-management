CREATE TABLE AlunoDisciplina (
    id BIGINT PRIMARY KEY,
    aluno_id BIGINT NOT NULL,
    disciplina_id BIGINT NOT NULL,
    FOREIGN KEY (aluno_id) REFERENCES Aluno(id),
    FOREIGN KEY (disciplina_id) REFERENCES Disciplina(id)
);
