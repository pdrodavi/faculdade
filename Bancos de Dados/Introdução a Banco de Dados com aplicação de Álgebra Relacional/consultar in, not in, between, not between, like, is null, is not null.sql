use loja;
select * from cliente
where idcliente not between 1 and 5

-- select * from cliente
-- where idcliente in (1,4,5)

select * from cliente
where idcliente >= 1 and idcliente <= 5

select * from cidade
where descricao like "Cajazeiras"

select * from cidade
where descricao like "%Ca"

select * from cliente
where nome like 'Pedro Lui_';

select * from cliente
where nome is not null

select * from cliente cl
inner join cidade ci
		on ci.idcidade=cl.idcidade

-- distintic eliminar os repetidos        
select distinct(ci.descricao) from cliente cl
inner join cidade ci
		on ci.idcidade=cl.idcidade

select max(valor_unitario) from produto -- produto de maior valor        
select min(valor_unitario) from produto -- produto de menor valor
select avg(valor_unitario) from produto -- média dos produtos
select sum(quantidade) from produto -- sabendo a quantidade de produtos que tem
select sum(valor_unitario * quantidade) from produto

select v.idvenda, v.data_venda, count(*) as total_produtos
from venda v
inner join venda_has_produto vp
on v.idvenda=vp.idvenda
group by v.idvenda
having total_produtos>4 -- HAVING mesma coisa que WHERE > aplica a condição depois de agrupar

select v.idvenda, v.data_venda, c.nome,
			sum(p.valor_unitario) as vl_bruto,
            v.desconto,
            sum(p.valor_unitario) -v.desconto
            from venda v
inner join cliente c
	on v.idcliente=c.idcliente
inner join venda_has_produto vp
	on vp.idvenda=v.idvenda
inner join produto p
	on vp.idproduto = p.idproduto
    group by v.idvenda