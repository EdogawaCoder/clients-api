CREATE TABLE clients
(
    id          UUID         PRIMARY KEY,
    name        VARCHAR(150) NOT NULL,
    email       VARCHAR(150) NOT NULL,
    cpf         CHAR(11)     NOT NULL UNIQUE,
    phone       VARCHAR(20)  NOT NULL,
    date_born   DATE         NOT NULL,
    date_regist TIMESTAMP    NOT NULL
);

INSERT INTO clients (id, name, email, cpf, phone, date_born, date_regist)
VALUES (gen_random_uuid(), 'Ana Maria', 'anamaria@gmail.com', '12345678900', '21998765555', '1980-05-10',
        CURRENT_TIMESTAMP);

INSERT INTO clients (id, name, email, cpf, phone, date_born, date_regist)
VALUES (gen_random_uuid(), 'Carlos Silva', 'carlos.silva@example.com', '98765432100', '21991234567', '1992-11-22',
        CURRENT_TIMESTAMP);

INSERT INTO clients (id, name, email, cpf, phone, date_born, date_regist)
VALUES (gen_random_uuid(), 'Fernanda Costa', 'fernanda.costa@example.com', '32165498700', '21999887766', '1988-07-03',
        CURRENT_TIMESTAMP);

INSERT INTO clients (id, name, email, cpf, phone, date_born, date_regist)
VALUES (gen_random_uuid(), 'Lucas Pereira', 'lucas.pereira@example.com', '45678912300', '21987654321', '1995-02-15',
        CURRENT_TIMESTAMP);

SELECT *
FROM clients;