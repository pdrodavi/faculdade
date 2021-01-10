CREATE TABLE produto(
	id SERIAL NOT NULL PRIMARY KEY,
	nome VARCHAR(90) NOT NULL,
	preco FLOAT NOT NULL
);

select * from produto;

insert into produto values (default, 'Galaxy S9+', 3.500);