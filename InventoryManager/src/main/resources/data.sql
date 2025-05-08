DELETE FROM stock_movement;
DELETE FROM users;
DELETE FROM product;
DELETE FROM category;

INSERT INTO category (name, description) VALUES ('Eletrônicos', 'Dispositivos eletrônicos e acessórios');
INSERT INTO category (name, description) VALUES ('Alimentos', 'Comidas e bebidas em geral');

INSERT INTO supplier (name, email, phone, registration) VALUES ('Tech Supply', 'contato@techsupply.com', '11999999999', 'TS123456');
INSERT INTO supplier (name, email, phone, registration) VALUES ('Food Distribuidora', 'vendas@fooddist.com', '11988888888', 'FD654321');


INSERT INTO product (name, description, price, quantity, category_id, supplier_id) VALUES
('Notebook Lenovo', 'Notebook com 8GB RAM e 256GB SSD', 3500.00, 10, 1, 1),
('Café Torrado', 'Pacote de café 500g', 18.90, 100, 2, 2);

INSERT INTO users (name, email, password) VALUES
('Administrador', 'admin@sistema.com', 'admin123'),
('João Silva', 'joao@empresa.com', 'senha123');

INSERT INTO stock_movement (movement_type, quantity, product_id, user_id, observations) VALUES
('INPUT', 5, 1, 1, 'Reposição de estoque inicial'),
('OUTPUT', 2, 2, 2, 'Venda realizada ao cliente final');
