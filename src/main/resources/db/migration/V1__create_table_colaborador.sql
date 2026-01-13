CREATE TABLE colaborador (
    pk_colaborador SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    cpf VARCHAR(20) NOT NULL UNIQUE,
    data_nascimento DATE,
    cargo VARCHAR(100) NOT NULL,
    salario NUMERIC(15,2) NOT NULL,
    data_admissao DATE NOT NULL,
    ativo BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);
