/*
1. Abrir el script de la base de datos llamada “nba.sql” y ejecutarlo para crear todas las tablas e 
insertar datos en las mismas. A continuación, generar el modelo de entidad relación. Deberá 
obtener un diagrama de entidad relación igual al que se muestra a continuación: 
A continuación, se deben realizar las siguientes consultas sobre la base de datos:

1. Mostrar el nombre de todos los jugadores ordenados alfabéticamente.
*/
select j.nombre 
from jugador j
order by j.nombre asc;
/*
2. Mostrar el nombre de los jugadores que sean pivots (‘C’) y que pesen más de 200 libras, 
ordenados por nombre alfabéticamente.
*/
select j.nombre, j.posicion, j.peso
from jugador j
where j.posicion = 'C' and j.peso > 200;

/*
3. Mostrar el nombre de todos los equipos ordenados alfabéticamente.
*/
select e.nombre 
from equipo e
order by e.nombre asc;
/*
4. Mostrar el nombre de los equipos del este (East).
*/
select e.nombre
from equipo e
where conferencia = 'East';
/*
5. Mostrar los equipos donde su ciudad empieza con la letra ‘c’, ordenados por nombre.
*/
select e.ciudad
from equipo e
where e.ciudad 
like 'c%'
order by nombre asc;
/*
6. Mostrar todos los jugadores y su equipo ordenados por nombre del equipo.
*/
select *
from jugador j, equipo e
where j.nombre_equipo = e.nombre
order by e.nombre asc;
/*
7. Mostrar todos los jugadores del equipo “Raptors” ordenados por nombre.
*/
select *
from jugador j
inner join equipo e
on j.nombre_equipo = e.nombre
where e.nombre = 'raptors'
order by j.nombre asc;
/*
8. Mostrar los puntos por partido del jugador ‘Pau Gasol’.
*/
select j.nombre, es.Puntos_por_partido, es.temporada
from estadistica es, jugador j
where es.jugador = j.codigo 
and j.nombre = 'pau gasol';
/*
9. Mostrar los puntos por partido del jugador ‘Pau Gasol’ en la temporada ’04/05′.
*/
select j.nombre, es.Puntos_por_partido, es.temporada
from jugador j, estadistica es
where j.codigo = es.jugador 
and j.nombre = 'pau gasol'
and es.temporada = '04/05';
/*
10. Mostrar el número de puntos de cada jugador en toda su carrera.
*/
select j.nombre, round(sum(es.Puntos_por_partido))  Total_Puntos_Carrera 
from jugador j, estadistica es
where es.jugador = j.codigo
group by j.nombre
order by Total_Puntos_Carrera desc;
/*
11. Mostrar el número de jugadores de cada equipo.
*/
select j.nombre_equipo, count(nombre_equipo)
from jugador j, equipo e
where j.nombre_equipo = e.nombre 
group by j.nombre_equipo;
/*
12. Mostrar el jugador que más puntos ha realizado en toda su carrera.
*/

select j.nombre, round(sum(es.Puntos_por_partido),1)
from jugador j, estadistica es
where es.jugador = j.codigo 
group by j.nombre
order by sum(es.Puntos_por_partido) desc
limit 1;
/*
13. Mostrar el nombre del equipo, conferencia y división del jugador más alto de la NBA.
*/
select j.nombre, j.nombre_equipo, e.conferencia, e.division ,j.altura
from jugador j, equipo e
where j.nombre_equipo = e.nombre
group by j.codigo
order by j.altura desc
limit 1;
/*
14. Mostrar la media de puntos en partidos de los equipos de la división Pacific.
*/
select  e.division, avg(es.Puntos_por_partido) 
from estadistica es, equipo e, jugador j
where j.nombre_equipo = e.nombre 
and es.jugador = j.codigo 
and e.division = 'pacific'
group by e.division;
/*
15. Mostrar el partido o partidos (equipo_local, equipo_visitante y diferencia) con mayor 
diferencia de puntos.
*/
select p.puntos_local, p.equipo_local, p.equipo_visitante, p.puntos_visitante
from equipo e, partido p
where p.equipo_local = e.nombre
order by p.puntos_local desc, p.puntos_visitante
limit 1;
/*
16. Mostrar la media de puntos en partidos de los equipos de la división Pacific.
*/
select avg(es.Puntos_por_partido) media_div_pacific
from estadistica es, equipo e, jugador j
where es.jugador = j.codigo
and j.nombre_equipo = e.nombre
and e.division = 'pacific'
order by e.nombre;
/*
17. Mostrar los puntos de cada equipo en los partidos, tanto de local como de visitante. 
*/
select e.nombre, p.puntos_local, p.puntos_visitante
from partido p, equipo e
where p.equipo_local = e.nombre

/*
18. Mostrar quien gana en cada partido (codigo, equipo_local, equipo_visitante, 
equipo_ganador), en caso de empate sera null
*/