
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


-- Inserindo dados na tabela cliente
INSERT INTO cliente (nome, nome_usuario, email, cpf, data_nasc)
VALUES ('Igor','Igor1234','igor@serratec.com','123.456.852-45','1991-11-06');
INSERT INTO cliente (nome, nome_usuario, email, cpf, data_nasc)
VALUES ('Paulo','Paulo543','paulo@serratec.com','173.446.152-67','1999-01-09');
INSERT INTO cliente (nome, nome_usuario, email, cpf, data_nasc)
VALUES ('José','JoseOL','jose@serratec.com','234.968.481-14','1994-06-23');
INSERT INTO cliente (nome, nome_usuario, email, cpf, data_nasc)
VALUES ('Tiago','TiagoJS','tiago@serratec.com','488.033.574-20','1993-04-13');
INSERT INTO cliente (nome, nome_usuario, email, cpf, data_nasc)
VALUES ('Ana','Ana17','ana@serratec.com','265.169.785-33','1996-02-28');


-- Inserindo dados na tabela endereco
INSERT INTO endereco (cep, rua, numero, complemento, bairro, id_cliente)
VALUES ('25665-500', 'rua Luiz Winter', 87, 'A', 'Duarte da Silveira', 1);
INSERT INTO endereco (cep, rua, numero, complemento, bairro, id_cliente)
VALUES ('26200-563', 'rua Visconde de Souza Franco', 41, 'B', 'Alto da Serra', 2);
INSERT INTO endereco (cep, rua, numero, complemento, bairro, id_cliente)
VALUES ('36587-703', 'rua Luiz Pelegrini', 702, 'C', 'Cascatinha', 3);
INSERT INTO endereco (cep, rua, numero, complemento, bairro, id_cliente)
VALUES ('45210-224', 'rua Bartolomeu Sudre', 421, 'A', 'Caxambu', 4);
INSERT INTO endereco (cep, rua, numero, complemento, bairro, id_cliente)
VALUES ('78554-335', 'rua Cândido Portinari', 67, 'B', 'Mosela', 5);



-- Inserindo dados na tabela pedido
INSERT INTO pedido (Data_pedido, id_cliente,id_endereco)
VALUES ('2020-04-14', 2,1);
INSERT INTO pedido (Data_pedido, id_cliente,id_endereco)
VALUES ('2019-12-25', 4,2);
INSERT INTO pedido (Data_pedido, id_cliente,id_endereco)
VALUES ('2020-10-01', 2,3);
INSERT INTO pedido (Data_pedido, id_cliente,id_endereco)
VALUES ('2021-07-12', 1,4);
INSERT INTO pedido (Data_pedido, id_cliente,id_endereco)
VALUES ('2018-02-28', 5,5);


-- Inserindo dados na tabela Item_Pedido
INSERT INTO Item_Pedido (desconto,preco, quantidade, id_pedido, id_produto)
VALUES (10,150,1, 1, 1);
INSERT INTO Item_Pedido (desconto,preco, quantidade, id_pedido, id_produto)
VALUES (20,250,1, 1, 4);
INSERT INTO Item_Pedido (desconto,preco, quantidade, id_pedido, id_produto)
VALUES (50,1550,2, 2, 2);
INSERT INTO Item_Pedido (desconto,preco, quantidade, id_pedido, id_produto)
VALUES (520,5550,1, 3, 5);
INSERT INTO Item_Pedido (desconto,preco, quantidade, id_pedido, id_produto)
VALUES (530,52550,3, 4, 3);
INSERT INTO Item_Pedido (desconto,preco, quantidade, id_pedido, id_produto)
VALUES (100,5520,2, 5, 4);


-- Inserindo dados na tabela Item_Pedido
INSERT INTO PAGAMENTO (ID_PEDIDO,ESTADO) VALUES (1,1)

-- Inserindo dados na tABELA PAGAMENTO COM BOLETO
INSERT INTO PAGAMENTO_COM_BOLETO (DATA_PAGAMENTO,DATA_VENCIMENTO,ID_PEDIDO) VALUES ('2020-04-14','2020-05-14',3);

-- Inserindo dados na tABELA PAGAMENTO COM CARTAO
INSERT INTO PAGAMENTO_COM_CARTAO (NUMERO_DE_PARCELAS,ID_PEDIDO) VALUES (12,3)