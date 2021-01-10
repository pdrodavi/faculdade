/*
1.	Criar uma função (procedimento armazenado) para recuperar a quantidade de projetos existentes na “EmpresaFAFIC”.
2.	Criar uma função que recupere a quantidade de horas que um determinado empregado trabalha em projetos, a função deve receber como parâmetro o nome do empregado.
3.	Criar uma função que recupere a quantidade de projetos que um determinado empregado trabalha em projetos, a função deve receber como parâmetro a matricula do empregado.
4.	Criar uma função que receba a matrícula e classifique um empregado de acordo com a quantidade de projetos que ele trabalha. Considerando que se ele trabalhar menos que 2, trabalha pouco; se ele trabalha em 2 projetos, trabalha moderadamente; se não, acima de 2 projetos, trabalha muito. Para essa função use a função criada na questão anterior para recuperar a quantidade de projetos que o empregado trabalha.
5.	Criar uma função que recupere a média salarial dos empregados da “EmpresaFAFIC”.
*/

-- ATIVIDADE 3


--1. Criar uma função (procedimento armazenado) para recuperar a quantidade de projetos existentes na “EmpresaFAFIC”.
CREATE OR REPLACE FUNCTION qtdeProjetos() RETURNS INTEGER
AS $$
	DECLARE
		soma INTEGER;
	BEGIN
		SELECT INTO soma COUNT(*) FROM projeto p;
		RETURN soma;
	END $$
LANGUAGE plpgsql;

SELECT qtdeProjetos();

-- 2. Criar uma função que recupere a quantidade de horas que um determinado empregado trabalha em projetos, 
--    a função deve receber como parâmetro o nome do empregado.
CREATE OR REPLACE FUNCTION qtdeHorasEmp(VARCHAR) RETURNS INTEGER
AS $$
	DECLARE
		nomeEmp ALIAS FOR $1;
		total_horas INTEGER;
	BEGIN
		SELECT INTO total_horas SUM(tp.num_horas)
		FROM (trabalha_projeto tp JOIN empregado e ON tp.empregado = e.matricula)
		WHERE e.nome ILIKE nomeEmp;
		RETURN total_horas;
	END $$
LANGUAGE plpgsql;

SELECT qtdeHorasEmp('Pedro');

--3. Criar uma função que recupere a quantidade de projetos que um determinado empregado trabalha em projetos, 
--   a função deve receber como parâmetro a matricula do empregado.
CREATE OR REPLACE FUNCTION qtdeProjetosEmp(VARCHAR) RETURNS INTEGER
AS $$
	DECLARE
		matricula ALIAS FOR $1;
		somaProjetos INTEGER;
	BEGIN
		SELECT INTO somaProjetos count(*) FROM trabalha_projeto tp
		WHERE tp.empregado = matricula;
		RETURN somaProjetos;
	END $$
LANGUAGE plpgsql;

SELECT qtdeProjetosEmp('1111-2');

--4. Criar uma função que receba a matrícula e classifique um empregado de acordo com a quantidade de projetos que ele trabalha. 
--   Considerando que se ele trabalhar menos que 2, trabalha pouco; 
--   se ele trabalha em 2 projetos, trabalha moderadamente; 
--   se não, acima de 2 projetos, trabalha muito.
--   Para essa função use a função criada na questão anterior para recuperar a quantidade de projetos que o empregado trabalha.
CREATE OR REPLACE FUNCTION classifica_emp(VARCHAR) RETURNS VARCHAR
AS $$
	DECLARE
		matricula ALIAS FOR $1;
		somaProjetosEmp INTEGER;
	BEGIN
		SELECT INTO somaProjetosEmp qtdeProjetosEmp(matricula);
		IF somaProjetosEmp < 2 THEN RETURN 'TRABALHA POUCO';
		 ELSIF somaProjetosEmp = 2 THEN RETURN 'TRABALHA MODERADAMENTE';
		  ELSE RETURN 'TRABALHA MUITO';
		END IF;
	END $$
LANGUAGE plpgsql;

SELECT classifica_emp('1111-4');

-- 5. Criar uma função que recupere a média salarial dos empregados da “EmpresaFAFIC”.
CREATE OR REPLACE FUNCTION mediaSalarial() RETURNS DOUBLE PRECISION
AS $$
	DECLARE
		media DOUBLE PRECISION;
	BEGIN
		SELECT INTO media AVG(salario) FROM empregado;
		RETURN media;
	END $$
LANGUAGE plpgsql;

SELECT mediaSalarial();


