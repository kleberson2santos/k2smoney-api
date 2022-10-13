CREATE TABLE pessoa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	logradouro VARCHAR(30),
	numero VARCHAR(30),
	complemento VARCHAR(30),
	bairro VARCHAR(30),
	cep VARCHAR(30),
	cidade VARCHAR(30),
	estado VARCHAR(30),
	ativo BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('João da Silva', 'Rua do Porto', '10', null, 'Brasil', '04.321-130', 'Manaus', 'AM', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Maria dos Anjos', 'Rua do 10', '110', 'Apto 101', 'Centro', '03.712-002', 'Manaus', 'AM', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Paulo Santos', 'Rua Coliseu ', '17', null, 'Villa Olímpia', '04.822-000', 'São Paulo', 'SP', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Matheus da Silva', 'Rua Afonso', '150', 'Apto 302', 'Campo Belo', '05.676-000', 'São Paulo', 'SP', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Manoel Dias', 'Rua da Mata', '1', null, 'Vila Formosa', '02.851-000', 'Rio de Janeiro', 'RJ', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Henrique Pereira', 'Rua João Bosco', '53', null, 'Centro', '02.262-170', 'Belém', 'PA', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Jéssica Lima', 'Av. Brasil', '75', 'Apto 201', 'Balneário', '08.460-157', 'Macapá', 'AP', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Pedro Antônio', 'Avenida Maceió', '42', null, 'Conjunto Vale do Sol', '04.292-010', 'Brasília', 'DF', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Adjair Bonfim', 'Rua Boa Sorte', '98', null, 'São José', '04.880-250', 'Fortaleza', 'CE', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Italo Santos', 'Avenida Central', '100', 'Apto 10', 'Retiro', '04.859-015', 'Curitiba', 'PR', true);
