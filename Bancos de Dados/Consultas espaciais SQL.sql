--01. Consulte o nome de todas as mesorregiões da PB;
SELECT m.nm_meso, e.nm_estado
FROM mesorregioes m, estados e
WHERE ST_Within(m.geom, e.geom) 
AND e.nm_estado = 'PARAÍBA' ;

--02. Recupere os estados do Brasil localizados estritamente abaixo de Brasília.
select distinct e.nm_estado
from municipios m, estados e
where e.geom <<| (select geom from municipios where nm_municip ilike 'Brasília')

--03. Encontre os estados geograficamente dentro do Nordeste que fazem divisa com Tocantins.
SELECT ne.nm_estado
FROM estados ne
WHERE ne.nm_regiao = 'NORDESTE' 
AND ST_Touches(ne.geom,
 (select toc.geom from estados toc where toc.nm_estado='TOCANTINS') )
 
--04. Localize os estados geograficamente dentro do Nordeste que fazem divisa com Tocantins e Pará.
SELECT ne.nm_estado
FROM estados ne
WHERE ne.nm_regiao = 'NORDESTE' 
AND ST_Touches(ne.geom,
 (select toc.geom from estados toc where toc.nm_estado='TOCANTINS') )
AND ST_Touches(ne.geom,
 (select par.geom from estados par where par.nm_estado='PARÁ') )
 
--05. Recupere o nome e a quantidade de estados vizinhos de cada estado do Brasil. Ordene pelo total de estados em modo decrescente.
SELECT e.nm_estado, count(*) as estados_vizinhos
FROM estados e, estados e_viz
WHERE ST_Touches(e.geom, e_viz.geom)
GROUP BY e.nm_estado
ORDER BY estados_vizinhos DESC

--06. Localize o nome e a área dos 20 menores municípios do Brasil.
SELECT m.nm_municip, ST_Area(geom) AS area
FROM municipios m
ORDER BY area
LIMIT 20;

--07. Encontre os estados que possuem o perímetro maior que o perímetro da cidade de "Altamira", cidade do Pará.
SELECT e.nm_estado, ST_Perimeter(e.geom) as perimetro
FROM estados e
WHERE ST_Perimeter(e.geom) >
	ST_Perimeter((SELECT m.geom FROM municipios m where m.nm_municip='ALTAMIRA') )
ORDER BY perimetro desc

--08. Obtenha os estados do Nordeste que geograficamente fazem divisa com a região Norte.
SELECT distinct e.nm_estado as estado, e.nm_regiao as regiao
FROM estados e
WHERE e.NM_regiao ilike 'Nordeste' 
AND ST_Touches(e.geom, (select st_union(no.geom) from estados no where no.nm_regiao='NORTE') ) ;
 
--09. Recupere o ponto central, no formato textual, de todos os estados do Brasil.
SELECT e.nm_estado, ST_AsEWKT(ST_Centroid(e.geom)) 
FROM estados e
order by e.nm_estado

--10. Recupere a distância entre os municípios: Cajazeiras e Sousa.
SELECT a.nm_municip,b.nm_municip, ST_Distance(ST_centroid(a.geom), ST_centroid(b.geom)) * (40075/360) as distancia
FROM municipios a, municipios b
WHERE a.nm_municip = 'CAJAZEIRAS'
AND b.nm_municip ilike 'Sousa'
