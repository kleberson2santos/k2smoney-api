CREATE TABLE lancamento_cielo (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	card_brand VARCHAR(20) NOT NULL,
	payment_type VARCHAR(20),
	channel VARCHAR(25) NOT NULL,
	date DATETIME NOT NULL,
	status VARCHAR(20) NOT NULL,
	gross_amount DECIMAL(10,2) NOT NULL,
	net_amount DECIMAL(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO lancamento_cielo (card_brand, payment_type, channel, date, status, gross_amount, net_amount) values ('Mastercard', 'Crédito à vista', 'Super Link / Digitada', '2021-05-26T12:12:55', 'Aprovada', 80.0, 57.66);
INSERT INTO lancamento_cielo (card_brand, payment_type, channel, date, status, gross_amount, net_amount) values ('Mastercard', 'Crédito à vista', 'Super Link / Digitada', '2021-05-26T12:12:55', 'Aprovada', 80.0, 76.88);
INSERT INTO lancamento_cielo (card_brand, payment_type, channel, date, status, gross_amount, net_amount) values ('Mastercard', 'Crédito à vista', 'Super Link / Digitada', '2021-05-26T12:12:55', 'Aprovada', 90.0, 86.49);
INSERT INTO lancamento_cielo (card_brand, payment_type, channel, date, status, gross_amount, net_amount) values ('Mastercard', 'Crédito à vista', 'Super Link / Digitada', '2021-05-26T12:12:55', 'Aprovada', 90.0, 86.49);
INSERT INTO lancamento_cielo (card_brand, payment_type, channel, date, status, gross_amount, net_amount) values ('Mastercard', 'Crédito à vista', 'Máquina', '2021-05-26T12:12:55', 'Aprovada', 70.0, 67.27);
INSERT INTO lancamento_cielo (card_brand, payment_type, channel, date, status, gross_amount, net_amount) values ('Mastercard', 'Crédito à vista', 'Máquina', '2021-05-26T12:12:55', 'Aprovada', 90.0, 86.49);
INSERT INTO lancamento_cielo (card_brand, payment_type, channel, date, status, gross_amount, net_amount) values ('Mastercard', 'Crédito à vista', 'Máquina', '2021-05-26T12:12:55', 'Aprovada', 90.0, 86.49);
INSERT INTO lancamento_cielo (card_brand, payment_type, channel, date, status, gross_amount, net_amount) values ('Mastercard', 'Crédito à vista', 'Máquina', '2021-05-26T12:12:55', 'Aprovada', 70.0, 67.27);
INSERT INTO lancamento_cielo (card_brand, payment_type, channel, date, status, gross_amount, net_amount) values ('Mastercard', 'Crédito à vista', 'Máquina', '2021-05-26T12:12:55', 'Aprovada', 60.0, 57.66);
INSERT INTO lancamento_cielo (card_brand, payment_type, channel, date, status, gross_amount, net_amount) values ('Mastercard', 'Crédito à vista', 'Máquina', '2021-05-26T12:12:55', 'Aprovada', 60.0, 57.66);
INSERT INTO lancamento_cielo (card_brand, payment_type, channel, date, status, gross_amount, net_amount) values ('Mastercard', 'Crédito à vista', 'Máquina', '2021-05-26T12:12:55', 'Aprovada', 50.0, 48.05);
INSERT INTO lancamento_cielo (card_brand, payment_type, channel, date, status, gross_amount, net_amount) values ('Mastercard', 'Crédito à vista', 'Máquina', '2021-05-26T12:12:55', 'Aprovada', 80.0, 76.88);
INSERT INTO lancamento_cielo (card_brand, payment_type, channel, date, status, gross_amount, net_amount) values ('Mastercard', 'Crédito à vista', 'Máquina', '2021-05-26T12:12:55', 'Aprovada', 80.0, 76.88);
INSERT INTO lancamento_cielo (card_brand, payment_type, channel, date, status, gross_amount, net_amount) values ('Mastercard', 'Crédito à vista', 'Máquina', '2021-05-26T12:12:55', 'Aprovada', 70.0, 67.27);
INSERT INTO lancamento_cielo (card_brand, payment_type, channel, date, status, gross_amount, net_amount) values ('Mastercard', 'Crédito à vista', 'Máquina', '2021-05-26T12:12:55', 'Aprovada', 70.0, 67.27);
INSERT INTO lancamento_cielo (card_brand, payment_type, channel, date, status, gross_amount, net_amount) values ('Mastercard', 'Crédito à vista', 'Máquina', '2021-05-26T12:12:55', 'Aprovada', 74.0, 71.11);
INSERT INTO lancamento_cielo (card_brand, payment_type, channel, date, status, gross_amount, net_amount) values ('Visa', 'Crédito à vista', 'Máquina', '2021-05-26T12:12:55', 'Aprovada', 64.0, 61.5);
INSERT INTO lancamento_cielo (card_brand, payment_type, channel, date, status, gross_amount, net_amount) values ('Visa', 'Crédito à vista', 'Máquina', '2021-05-26T12:12:55', 'Aprovada', 54.0, 51.89);
INSERT INTO lancamento_cielo (card_brand, payment_type, channel, date, status, gross_amount, net_amount) values ('Visa', 'Crédito à vista', 'Máquina', '2021-05-26T12:12:55', 'Aprovada', 64.0, 61.5);
INSERT INTO lancamento_cielo (card_brand, payment_type, channel, date, status, gross_amount, net_amount) values ('Visa', 'Crédito à vista', 'Máquina', '2021-05-26T12:12:55', 'Aprovada', 54.0, 51.89);
INSERT INTO lancamento_cielo (card_brand, payment_type, channel, date, status, gross_amount, net_amount) values ('Visa', 'Crédito à vista', 'Máquina', '2021-05-26T12:12:55', 'Aprovada', 54.0, 51.89);
INSERT INTO lancamento_cielo (card_brand, payment_type, channel, date, status, gross_amount, net_amount) values ('Visa', 'Crédito à vista', 'Máquina', '2021-05-26T12:12:55', 'Aprovada', 64.0, 61.5);
INSERT INTO lancamento_cielo (card_brand, payment_type, channel, date, status, gross_amount, net_amount) values ('Visa', 'Crédito à vista', 'Máquina', '2021-05-26T12:12:55', 'Aprovada', 74.0, 71.11);
INSERT INTO lancamento_cielo (card_brand, payment_type, channel, date, status, gross_amount, net_amount) values ('Visa', 'Crédito à vista', 'Máquina', '2021-05-26T12:12:55', 'Aprovada', 54.0, 51.89);
INSERT INTO lancamento_cielo (card_brand, payment_type, channel, date, status, gross_amount, net_amount) values ('Visa', 'Crédito à vista', 'Máquina', '2021-05-26T12:12:55', 'Aprovada', 54.0, 51.89);