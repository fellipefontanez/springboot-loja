CREATE TABLE pedidos_produtos (
    pedido_id BIGINT NOT NULL,
    produtos_id BIGINT NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES pedidos(id)
);
