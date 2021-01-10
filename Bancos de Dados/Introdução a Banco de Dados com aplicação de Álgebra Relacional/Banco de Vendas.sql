INSERT INTO nome da tabela(lista de campos) VALUES (lista de valores);
Ex: INSERT INTO cidades (idCidade, descricao, idEstado) VALUES (1, cajazeiras,1);

INSERT INTO estado (idestado, descricao) VALUES (1, "paraiba");
INSERT INTO cidade (idcidade, descricao, idestado) VALUES (1, "cajazeiras", 1);
INSERT INTO cliente (idcliente, nome, endereco, cpf, idcidade) VALUES (1, "amanda", "centro", 12456, 1 );
INSERT INTO venda (idvenda, data_venda, valor, desconto, idcliente) VALUES (1, "2017-04-20", 1.00, 0.50, 1);
INSERT INTO grupo_produto (idgrupo_produto, descricao, porcentagem_desconto) VALUES (1, "bebibas", 1.00);
INSERT INTO produto (idproduto, descricao, cod_barras, valor_unitario, quantidade, idgrupo) VALUES (1, "coca", 011123, 1.50, 2, 1);
INSERT INTO venda_has_produto (idproduto, idvenda) VALUES (1, 1);
SELECT * from venda_has_produto;


UPDATE (Atualizar reistros de uma tabela)

Ex: UPDATE cidade SET descricao = "Sao josé", idestado = 2 WHERE id = 1;
UPDATE estado SET descricao = "Ceará" WHERE idestado = 1;

UPDATE cidade SET descricao = "Sao josé" WHERE idcidade = 1;

UPDATE cliente SET nome = "Oliveira" WHERE idcliente = 1;

UPDATE venda SET data_venda = "2017-04-21", valor = 2.00 WHERE idvenda = 1;
UPDATE grupo_produto SET descricao = "Comidas" WHERE idgrupo_produto = 1;

UPDATE produto SET descricao = "Arroz" WHERE idproduto = 1;


SELECT * from produto; 	  