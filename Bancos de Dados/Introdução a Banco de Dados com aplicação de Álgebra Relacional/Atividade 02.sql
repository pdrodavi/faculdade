-- SQL > DDL > CREATE, ALTER, DROP  |  DML > INSERT, UPDATE, DELETE, SELECT 

create database aula; -- criando banco
use loja; -- usando banco
create table cliente(
	id int auto_increment, -- id de tipo inteiro com auto incremento
    nome varchar(50) not null, -- nome de tipo varchar tamanho 50 não nulo
    cpf char(11) not null, -- cpf do tipo char de tamanho 11 não nulo
    primary key(id), -- chave primeira 
    unique key(cpf) -- chave única
);

alter table cliente add column endereco varchar(50); -- alterando tabela para adicionar nova coluna
alter table cliente drop cpf; -- apagando a coluna cpf da tabela cliente
alter table cliente modify nome varchar(100) not null; -- modificando campo nome de varchar(50) para varchar(100)nome