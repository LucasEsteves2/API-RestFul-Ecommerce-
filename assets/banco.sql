

-- Inserindo dados na tabela categoria
INSERT INTO categoria (nome, descricao)
VALUES ('Teclados', 'Teclados de várias marcas');
INSERT INTO categoria (nome, descricao)
VALUES ('Mouses', 'Mouses de vários modelos e marcas');
INSERT INTO categoria (nome, descricao)
VALUES ('Headset Gamer', 'Headset de vários modelos e marcas (específicos para jogos)');
INSERT INTO categoria (nome, descricao)
VALUES ('Webcam', 'Webcams de alta resolução');
INSERT INTO categoria (nome, descricao)
VALUES ('Gabinetes', 'Gabinetes diversos');

-- Inserindo dados na tabela produto


INSERT INTO produto (nome, descricao, qtd_estoque, data_cadastro, valor_unitario, id_categoria)
VALUES ('HyperX Mars RGB', 'Teclado Mecânico Gamer HyperX Mars, RGB, Switch Outemu Blue, US', 20, '2018-10-05', 375.00, 1);
INSERT INTO produto (nome, descricao, qtd_estoque, data_cadastro, valor_unitario, id_categoria)
VALUES ('HyperX Cloud Revolver S', 'Headset Gamer HyperX Cloud Revolver S 7.1 Dolby Digital', 7, '2018-10-05', 833.20, 3);
INSERT INTO produto (nome, descricao, qtd_estoque, data_cadastro, valor_unitario, id_categoria)
VALUES ('Webcam Logitech c922', 'Webcam Full HD Logitech C922 Pro Stream com Microfone Embutido, USB, 1080p e Tripé Incluso', 15, '2019-12-18', 788.15, 4);
INSERT INTO produto (nome, descricao, qtd_estoque, data_cadastro, valor_unitario, id_categoria)
VALUES ('Razer Deathadder V2', 'Mouse Gamer Razer Deathadder V2, Chroma, Optical Switch, 8 Botões, 20000DPI', 25, '2017-01-17', 588.30, 2);
INSERT INTO produto (nome, descricao, qtd_estoque, data_cadastro, valor_unitario, id_categoria)
VALUES ('Gabinete Sharkoon TG5', 'Gabinete Sharkoon TG5 Blue Vidro Temperado 4mm Led Fan 12cm ATX', 10, '2018-03-08', 752.80, 5);


INSERT INTO produto (nome, descricao, qtd_estoque, data_cadastro, valor_unitario, id_categoria)
VALUES ('Teclado RGB', 'Teclado Mecânico Gamer , RGB, Switch Outemu Blue, US', 20, '2018-10-05', 375.00, 1);


-- Inserindo dados na tabela pedido
INSERT INTO pedido (Data_pedido, id_cliente)
VALUES ('2020-04-14', 2);
INSERT INTO pedido (Data_pedido, id_cliente)
VALUES ('2019-12-25', 4);
INSERT INTO pedido (Data_pedido, id_cliente)
VALUES ('2020-10-01', 2);
INSERT INTO pedido (Data_pedido, id_cliente)
VALUES ('2021-07-12', 1);
INSERT INTO pedido (Data_pedido, id_cliente)
VALUES ('2018-02-28', 5);
