use loja;
-- ORDER BY - COMANDO PARA ORDENAR
-- ASC: ORDENAÇÃO CRESCENTE -- DESC: ORDENAÇÃO DECRESCENTE
-- LIMIT X(LIMITE DE REGISTRO) - COMANDO PARA LIMITAR A QUANTIDADE DE REGISTRO A SER MOSTRADO
select descricao from cidade where idestado = 25 order by descricao limit 10; -- selecionando descricao
select * from cidade where idestado = 25 order by descricao limit 10; -- selecionado todos com *
select * from cidade where idestado in (23,25,26) order by descricao; -- selecionando multiplos valores com in
select * from cidade where idestado in (23,25,26,22) and descricao="Cajazeiras" order by descricao; -- selecionando multiplos valores com in onde descrição for cajazeiras
select * from cidade where idestado in (23,25,26,22) and descricao like "Cajazeiras%" order by descricao; -- selecionando multiplos valores com in onde descrição comece com cajazeiras
select * from cidade where idestado in (23,25,26,22) and descricao like "%ca" order by descricao; -- selecionando multiplos valores com in onde descrição termine com CA usando % no inicio
select * from cidade where idestado in (23,25,26,22) and descricao like "C%" order by descricao; -- selecionando multiplos valores com in onde descrição comece com C usando % no final
select * from cidade where idestado in (23,25,26,22) and descricao like "C%" order by descricao; -- selecionando multiplos valores com in onde descrição que tenha C em qualquer lugar
select count(*) from cidade where idestado in (23,25,26,22) and descricao like "Cajazeiras%" order by descricao; -- função de agregação para contar quantos registros tem na consulta com o count(*)

-- operação de junção - juntar a tabela cidade e estado, param mostrar uma coluna da tabela cidade, uma de estado e o nome do cliente
select cidade.descricao as cidade, estado.descricao as estado, cliente.nome, venda.idvenda, venda.data_venda 
	from venda 
	join cliente on cliente.idcliente=venda.idvenda
    join cidade on cliente.idcidade=cidade.idcidade 
    join estado on cidade.idestado=estado.idestado 
     
    order by venda.idvenda; -- retornando apenas dois campos -- comando as (apelidar uma coluna)
    
    