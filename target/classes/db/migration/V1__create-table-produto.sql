CREATE TABLE produtos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    valor DECIMAL(19, 2) NOT NULL,
    categoria VARCHAR(50) NOT NULL
);