CREATE TABLE clients(
    id          UUID                PRIMARY KEY,
    name            VARCHAR(150)    NOT NULL,
    email           VARCHAR(150)    NOT NULL,
    cpf             CHAR(11)        NOT NULL   UNIQUE,
    phone           VARCHAR(20)     NOT NULL,
    born_date       DATE            NOT NULL,
    register_date   TIMESTAMP       NOT NULL
);