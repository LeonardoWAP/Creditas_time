--Quantas pessoas com mais de 6 meses são desenvolvedoras na Creditas

SELECT count(*)
FROM people
WHERE CURRENT_DATE - hire_date > 180 and role = 'software engineer'

-- revisado

--Quantas pessoas PM’s estão a menos de 1 ano na Creditas

SELECT count (CURRENT_DATE - hire_date) AS quantidade_dias
FROM people
where role = 'Product Manager ' and CURRENT_DATE - hire_date < 360

-- não vai retornar ninguem porque nao tem no banco PM'S com menos de 1 ano 
-- revisado 

--qual a pessoa com mais tempo na Creditas e quanto tempo tem

SELECT people.name, (CURRENT_DATE - hire_date)/30 as quantos_meses FROM people
WHERE hire_date = (
	SELECT MIN(hire_date)
	from people
)
-- revisado

--Qual a pessoa com o nome mais longo na Creditas (Maior quantidade de caracteres, espaço pode contar como caracter) - Dica: User função length

SELECT people.name from people
ORDER BY length(name) desc
LIMIT 1;
-- revisado

--Qual a média de pessoas que as Squads tem

select squads.name, count(people.name)  from people
inner join people_squad
	on people.id = people_squad.people_id
inner join squads
	on squads.id = people_squad.squad_id
GROUP BY squads.name

--Para cada Squad, qual a média de quantos meses as pessoas estão na Creditas

select squads.name, AVG(CURRENT_DATE - hire_date)/30  AS quantidade_dias from people
inner join people_squad
	on people.id = people_squad.people_id
inner join squads
	on squads.id = people_squad.squad_id
GROUP BY squads.name

-- revisado


--Para cada Tribe, qual o total de pessoas trabalhando nela (Cuidado para não contas pessoas cross duas vezes)
avg (people.name)
	on people.id = people_squad.people_id
inner join squads 
	on people_squad.squad_id = squads.id
inner join tribes 
	on squads.tribes_id = tribes.id
group by tribes.name

-- revisado

--Para cada Tribe, qual o total de pessoas desenvolvedoras (Software engineer)

select tribes.name ,count (distinct people.name) from people
inner join  people_squad
	on people.id = people_squad.people_id
inner join squads 
	on people_squad.squad_id = squads.id
inner join tribes 
	on squads.tribes_id = tribes.id
where people.role = 'software engineer'
group by tribes.name

-- revisado

--Para cada Tribe, quantas pessoas desenvolvedoras estão na Creditas a mais de 1 ano

select tribes.name,count (distinct people.name) from people
inner join  people_squad
	on people.id = people_squad.people_id
inner join squads 
	on people_squad.squad_id = squads.id
inner join tribes 
	on squads.tribes_id = tribes.id
where people.role = 'software engineer' and CURRENT_DATE - hire_date > 360
group by tribes.name

-- revisado


--Para cada Tribe, qual a média de quantos meses as pessoas desenvolvedoras estão na Creditas

select tribes.name , AVG(CURRENT_DATE - hire_date)/30  AS quantidade_dias from people
inner join  people_squad
	on people.id = people_squad.people_id
inner join squads 
	on people_squad.squad_id = squads.id
inner join tribes 
	on squads.tribes_id = tribes.id
group by tribes.name

-- revisado

--Para cada Tribe, quantas séries cada squad assistiu (Cuidado para não contar a mesma série duas vezes numa mesma squad)


select tribes.name ,squads.name , count (distinct shows.name) from people
inner join people_shows
	on people.id = people_shows.people_id
inner join shows
	on shows.id = people_shows.show_id
inner join  people_squad
	on people.id = people_squad.people_id
inner join squads 
	on people_squad.squad_id = squads.id
inner join tribes 
	on squads.tribes_id = tribes.id
group by  tribes.name ,squads.name  

-- revisado


--Para cada Tribe, com exceção da Squad de Pricing, quantas séries cada squad assistiu

select tribes.name ,squads.name , count (distinct shows.name) from people
inner join people_shows
	on people.id = people_shows.people_id
inner join shows
	on shows.id = people_shows.show_id
inner join  people_squad
	on people.id = people_squad.people_id
inner join squads 
	on people_squad.squad_id = squads.id
inner join tribes 
	on squads.tribes_id = tribes.id
where not squads.name = 'Pricing'
group by  tribes.name ,squads.name 

-- revisado


--Quantas vezes cada série foi assistida por pessoas da Creditas

select shows.name ,count (distinct people.name) from people
inner join people_shows
	on people.id = people_shows.people_id
inner join shows
	on shows.id = people_shows.show_id
inner join  people_squad
	on people.id = people_squad.people_id
inner join squads 
	on people_squad.squad_id = squads.id
inner join tribes 
	on squads.tribes_id = tribes.id
group by  shows.name

-- revisado

--Quais as 3 séries mais assistidas por pessoas da Creditas e quantas vezes cada uma foi vistas

select shows.name ,count (distinct people.name) from people
inner join people_shows
	on people.id = people_shows.people_id
inner join shows
	on shows.id = people_shows.show_id
inner join  people_squad
	on people.id = people_squad.people_id
inner join squads 
	on people_squad.squad_id = squads.id
inner join tribes 
	on squads.tribes_id = tribes.id
group by  shows.name
order by count (distinct people.name) desc
limit 3;

-- revisado

--Para cada Squad, qual o cargo que assistiu a maior quantidade de séries diferentes e quantas foram(Ex: Se todas as pessoas desenvolvedoras assistiram a mesma série, então o cargo desenvolvedor só assistiu 1 série diferente)

select squads.name , people.role , count (distinct shows.name) from people
inner join people_shows
	on people.id = people_shows.people_id
inner join shows
	on shows.id = people_shows.show_id
inner join  people_squad
	on people.id = people_squad.people_id
inner join squads 
	on people_squad.squad_id = squads.id
inner join tribes 
	on squads.tribes_id = tribes.id
group by squads.name ,people.role
having count (distinct shows.name) >= 2
order by count (distinct shows.name) desc
limit 3;

-- revisado

--Quais são as séries que 2 ou mais pessoas desenvolvedoras já assistiram

select shows.name ,count (distinct people.name) from people
inner join people_shows
	on people.id = people_shows.people_id
inner join shows
	on shows.id = people_shows.show_id
inner join  people_squad
	on people.id = people_squad.people_id
inner join squads 
	on people_squad.squad_id = squads.id
inner join tribes 
	on squads.tribes_id = tribes.id
where people.role = 'software engineer' 
group by  shows.name
having count (shows.name) > 1
order by count (distinct people.name) desc

-- revisado
--Quem são as pessoas Cross da Tribe (Pessoas que atuam em mais de uma Squad)

SELECT people.name , count(squads.name)  FROM people
inner join people_squad
	on people.id = people_squad.people_id
inner join squads
	on squads.id = people_squad.squad_id
group by  people.name 
order by people.name
limit 1;

-- revisado

--Quais as pessoas que não assistiram séries na Creditas

select people.name, people_shows.people_id ,people_shows.show_id  from people
inner join people_shows
	on people.id = people_shows.people_id
where people_shows.show_id IS NULL 
group by  people.name , people_shows.people_id , people_shows.show_id , people_shows.show_id

-- revisado