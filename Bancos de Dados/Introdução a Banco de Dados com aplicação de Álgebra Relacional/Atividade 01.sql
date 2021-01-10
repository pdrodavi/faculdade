set sql_safe_updates = 0; -- desativando proteção para atualizar (update) todos os valores de uma coluna inteira de uma vez
create database atividadeParaProva;
use atividadeParaProva;

create table cliente(
	idCliente int auto_increment,
    nome varchar(45) not null,
	endereco varchar(45) not null,
    telefone varchar(20),
    cpf char(11) not null,
    primary key(idCliente),
    unique key(cpf)
);

create table conta_receber(
	idConta int auto_increment,
    data_compra date not null,
    data_pagamento date,
    valor numeric(10,2),
    cliente_idCliente int,
    primary key(idConta),
    constraint fk_contaReceber_cliente foreign key (cliente_idCliente) references cliente(idCliente)
);

-- comando insert
insert into cliente values(1, "Pedro", "Rua São Sebastião", "11320808433", "81991169456"); -- se não informar os campos antes, tem que passar os campos de acordo com a tabela criada
insert into cliente(nome, endereco, cpf) values ("Davi", "Rua Santo Antonio", "11320808433"); -- passando os valores de parametro
insert into cliente(nome, endereco, cpf) values ("Davi Pedro", "Rua Santo Antonio", "3333333333");

-- comando update
-- atualizando cliente 1
update cliente set telefone = "35311626" where idCliente = 1; -- atualize o cliente modificando o telefone para o valor informado > onde o id seja igual a 1
update cliente set cpf = "11320808433" where idCliente = 1; -- atualize o cliente modificando o cpf onde o id seja igual a 1
-- atualizando cliente 2
update cliente set telefone = "991169456" where idCliente = 2; -- atualize o cliente modificando telefone para "991169456" onde id for igual a 2
update cliente set cpf = "12345678900" where idCliente = 2; -- atualize o cliente modificando cpf para "12345678900" onde id for igual a 2
-- atualizando cliente 3
update cliente set telefone = "99999999" where idCliente = 3; -- atualize o cliente modificando telefone para "99999999" onde id for igual a 3

-- update com duas condições AND, OR, E NOT
-- atualize cliente modificando endereço para "Rua São Sebastião" onde endereco for igual a "Rua santo Antonio" e telefone foi igual a "991169456"
update cliente set endereco = "Rua São Sebastião" where endereco = "Rua Santo Antonio" and telefone = "991169456";

-- comando delete
delete from cliente where idCliente = 3; -- delete da tabela cliente onde id for igual a 3

-- comando select
select * from cliente; -- comando para selecionar todos os campos da tabela cliente
select nome, cpf from cliente; -- mostrando apenas nome e cpf
select nome from cliente where idCliente = 2; -- mostrando nome do cliente onde id for igual a 3