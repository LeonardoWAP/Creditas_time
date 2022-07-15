--Quantas pessoas com mais de 6 meses são desenvolvedoras na Creditas
SELECT count(*)
FROM people
WHERE CURRENT_DATE - hire_date > 180 and role = 'software engineer'

--Quantas pessoas PM’s estão a menos de 1 ano na Creditas
SELECT count (CURRENT_DATE - hire_date) AS quantity_days
FROM people
where role = 'Product Manager ' and CURRENT_DATE - hire_date < 360


--qual a pessoa com mais tempo na Creditas e quanto tempo tem
SELECT people.name, (CURRENT_DATE - hire_date)/30 as quantity_months FROM people
WHERE hire_date = (
	SELECT MIN(hire_date)
	from people
)

--Qual a pessoa com o nome mais longo na Creditas (Maior quantidade de caracteres, espaço pode contar como caracter) - Dica: User função length
SELECT people.name from people
ORDER BY length(name) desc
LIMIT 1;


--Qual a média de pessoas que as Squads tem
SELECT avg(x.Counter) 
FROM 
(select squads.name , count(people.name) as Counter from people
inner join people_squad
	on people.id = people_squad.people_id
inner join squads
	on squads.id = people_squad.squad_id
GROUP BY squads.name ) x

--Para cada Squad, qual a média de quantos meses as pessoas estão na Creditas
select squads.name, AVG(CURRENT_DATE - hire_date)/30  AS quantity_days from people
inner join people_squad
	on people.id = people_squad.people_id
inner join squads
	on squads.id = people_squad.squad_id
GROUP BY squads.name

--Para cada Tribe, qual o total de pessoas trabalhando nela (Cuidado para não contas pessoas cross duas vezes)
select count (distinct people.name) , tribes.name from people
inner join  people_squad
	on people.id = people_squad.people_id
inner join squads
	on people_squad.squad_id = squads.id
inner join tribes
	on squads.tribes_id = tribes.id
group by tribes.name


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

--Para cada Tribe, qual a média de quantos meses as pessoas desenvolvedoras estão na Creditas
select tribes.name , AVG(CURRENT_DATE - hire_date)/30  AS quantidade_dias from people
inner join  people_squad
	on people.id = people_squad.people_id
inner join squads 
	on people_squad.squad_id = squads.id
inner join tribes 
	on squads.tribes_id = tribes.id
group by tribes.name

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

--Quem são as pessoas Cross da Tribe (Pessoas que atuam em mais de uma Squad)
SELECT people.name FROM people
inner join people_squad
	on people.id = people_squad.people_id
inner join squads
	on squads.id = people_squad.squad_id
group by  people.name 
having count (squads.name) > 1
order by people.name



--Quais as pessoas que não assistiram séries na Creditas
SELECT people.name , people_shows.show_id
FROM people
LEFT JOIN people_shows
ON people.id = people_shows.people_id
WHERE people_shows.show_id IS NULL

