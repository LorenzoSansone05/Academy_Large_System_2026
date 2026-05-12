--INSERT INTO users (username, password, enabled)
--VALUES ('admin', '{bcrypt}$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00zxs.7.D8O0C6', true);

--INSERT INTO users (username, password, enabled)
--VALUES ('user', '{bcrypt}$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00zxs.7.D8O0C6', true);

--INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
--INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
--INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');

-- (Password: admin123 e user123)
DELETE FROM permessi;
DELETE FROM account;

-- Nota: L'hash corrisponde esattamente a: admin123
INSERT INTO account (email, password, attivo) VALUES
('admin@test.it', '$2a$12$UiSu5DMS/3S3uvCxh3Op7.Q8AdfrIdWk4SGS.1pCLV0CkkSJQYrpG', true),
('user@test.it', '$2a$12$UiSu5DMS/3S3uvCxh3Op7.Q8AdfrIdWk4SGS.1pCLV0CkkSJQYrpG', true);

-- Inserimento Permessi
INSERT INTO permessi (email_utente, nome_ruolo) VALUES
('admin@test.it', 'ROLE_ADMIN'),
('admin@test.it', 'ROLE_USER'),
('user@test.it', 'ROLE_USER');