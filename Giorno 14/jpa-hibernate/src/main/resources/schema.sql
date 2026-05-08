--DROP TABLE IF EXISTS authorities;
--DROP TABLE IF EXISTS users;

--CREATE TABLE users (
--    username VARCHAR(50) NOT NULL PRIMARY KEY,
--    password VARCHAR(100) NOT NULL,
--    enabled BOOLEAN NOT NULL
--);

--CREATE TABLE authorities (
--    username VARCHAR(50) NOT NULL,
--  authority VARCHAR(50) NOT NULL,
--    CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users(username)
--);

-- CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);

CREATE TABLE account (
    email VARCHAR(100) PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    attivo BOOLEAN NOT NULL
);

CREATE TABLE permessi (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email_utente VARCHAR(100) NOT NULL,
    nome_ruolo VARCHAR(50) NOT NULL,
    CONSTRAINT fk_permessi_account FOREIGN KEY (email_utente) REFERENCES account(email)
);