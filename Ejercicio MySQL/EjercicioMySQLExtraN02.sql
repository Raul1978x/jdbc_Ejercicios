/*
3. Importar el script de la base de datos llamada “pokemondb.sql” y ejecutarlo para crear todas
las tablas e insertar los registros en las mismas. A continuación, generar el modelo de entidad
relación y reorganizar las tablas para mayor claridad de sus relaciones. Deberá obtener un
diagrama de entidad de relación similar al que se muestra a continuación:
A continuación, se deben realizar las siguientes consultas:
1. Mostrar el nombre de todos los pokemon.
*/
select pok.nombre
from pokemon pok;
/*
2. Mostrar los pokemon que pesen menos de 10k.
*/
select pok.nombre, pok.peso
from pokemon pok
where pok.peso < 10
order by pok.peso desc;
/*
3. Mostrar los pokemon de tipo agua.
*/
select *
from pokemon pok, pokemon_tipo p_tipo, tipo t
where pok.numero_pokedex = p_tipo.numero_pokedex 
and p_tipo.id_tipo = t.id_tipo 
and t.nombre = 'agua';
/*
4. Mostrar los pokemon de tipo agua, fuego o tierra ordenados por tipo.
*/
select *
from  pokemon pok, pokemon_tipo p_tipo, tipo t
where pok.numero_pokedex = p_tipo.numero_pokedex 
and p_tipo.id_tipo = t.id_tipo 
and t.nombre in ('agua', 'fuego', 'tierra')
order by t.id_tipo;
/*
5. Mostrar los pokemon que son de tipo fuego y volador.
*/
select *
from  pokemon pok, pokemon_tipo p_tipo, tipo t
where pok.numero_pokedex = p_tipo.numero_pokedex 
and p_tipo.id_tipo = t.id_tipo 
and t.nombre in ('fuego', 'volador')
order by t.id_tipo;
/*
6. Mostrar los pokemon con una estadística base de ps mayor que 200.
*/
select pok.nombre ,eb.ps
from estadisticas_base eb, pokemon pok
where pok.numero_pokedex = eb.numero_pokedex
and eb.ps > 200;
/*
7. Mostrar los datos (nombre, peso, altura) de la prevolución de Arbok.
*/

/*
8. Mostrar aquellos pokemon que evolucionan por intercambio.
*/
select *
from pokemon pok, pokemon_forma_evolucion pfe, forma_evolucion fe, tipo_evolucion te
where pok.numero_pokedex = pfe.numero_pokedex
and pfe.id_forma_evolucion = fe.id_forma_evolucion
and fe.tipo_evolucion = te.id_tipo_evolucion
and te.tipo_evolucion = 'intercambio';
/*
9. Mostrar el nombre del movimiento con más prioridad.
*/
select m.nombre
from pokemon pok, pokemon_movimiento_forma pmf, movimiento m
where pok.numero_pokedex = pmf.numero_pokedex
and pmf.id_movimiento = m.id_movimiento
and m.prioridad
order by m.prioridad desc
limit 1;
/*
10. Mostrar el pokemon más pesado.
*/
select *
from pokemon pok
order by pok.peso desc
limit 1;
/*
11. Mostrar el nombre y tipo del ataque con más potencia.
*/
select pok.nombre, m.nombre,m.potencia, t.nombre, ta.tipo
from pokemon pok, pokemon_movimiento_forma pmf, movimiento m, tipo t, tipo_ataque ta
where pok.numero_pokedex = pmf.numero_pokedex
and pmf.id_movimiento = m.id_movimiento 
and m.id_tipo = t.id_tipo
and ta.id_tipo_ataque = t.id_tipo_ataque
order by  m.potencia desc
limit 1;
/*
12. Mostrar el número de movimientos de cada tipo.

falta terminar!!!!

*/


select t.nombre
from pokemon pok, pokemon_movimiento_forma pmf, movimiento m, tipo t
where pok.numero_pokedex = pmf.numero_pokedex
and pmf.id_movimiento = m.id_movimiento
and m.id_tipo = t.id_tipo
group by t.nombre
order by count(t.nombre) desc;

/*
13. Mostrar todos los movimientos que puedan envenenar.
*/
select distinct m.nombre
from pokemon pok, pokemon_movimiento_forma pmf, movimiento m, movimiento_efecto_secundario mes, efecto_secundario efs
where pok.numero_pokedex = pmf.numero_pokedex
and pmf.id_movimiento = m.id_movimiento
and m.id_movimiento = mes.id_movimiento
and mes.id_efecto_secundario = efs.id_efecto_secundario
and efs.efecto_secundario = 'Envenenamiento leve';

/*
14. Mostrar todos los movimientos que causan daño, ordenados alfabéticamente por nombre.
*/
select distinct m.nombre, m.descripcion
from pokemon pok, pokemon_movimiento_forma pmf, movimiento m
where pok.numero_pokedex = pmf.numero_pokedex
and pmf.id_movimiento = m.id_movimiento
and m.descripcion like 'Causa daño%';
/*
15. Mostrar todos los movimientos que aprende pikachu.
*/
select pok.nombre, m.nombre, tfa.tipo_aprendizaje
from pokemon pok, pokemon_movimiento_forma pmf, movimiento m, forma_aprendizaje fa, tipo_forma_aprendizaje tfa
where pok.numero_pokedex = pmf.numero_pokedex
and pmf.id_movimiento = m.id_movimiento
and pmf.id_forma_aprendizaje = fa.id_forma_aprendizaje
and fa.id_tipo_aprendizaje = tfa.id_tipo_aprendizaje
and pok.nombre = 'pikachu';

/*
16. Mostrar todos los movimientos que aprende pikachu por MT (tipo de aprendizaje).
*/
select pok.nombre, m.nombre, tfa.tipo_aprendizaje
from pokemon pok, pokemon_movimiento_forma pmf, movimiento m, forma_aprendizaje fa, tipo_forma_aprendizaje tfa
where pok.numero_pokedex = pmf.numero_pokedex
and pmf.id_movimiento = m.id_movimiento
and pmf.id_forma_aprendizaje = fa.id_forma_aprendizaje
and fa.id_tipo_aprendizaje = tfa.id_tipo_aprendizaje
and pok.nombre = 'pikachu'
and tfa.tipo_aprendizaje = 'mt';
/*
17. Mostrar todos los movimientos de tipo normal que aprende pikachu por nivel.
*/
select pok.nombre, m.nombre, tfa.tipo_aprendizaje, t.nombre
from pokemon pok, pokemon_movimiento_forma pmf, movimiento m, forma_aprendizaje fa, tipo_forma_aprendizaje tfa, tipo t
where pok.numero_pokedex = pmf.numero_pokedex
and pmf.id_movimiento = m.id_movimiento
and m.id_tipo = t.id_tipo
and pmf.id_forma_aprendizaje = fa.id_forma_aprendizaje
and fa.id_tipo_aprendizaje = tfa.id_tipo_aprendizaje
and pok.nombre = 'pikachu'
and t.nombre = 'normal'
and tfa.tipo_aprendizaje = 'nivel';
/*
18. Mostrar todos los movimientos de efecto secundario cuya probabilidad sea mayor al 30%.
*/
select distinct m.nombre nombre_mov, mes.probabilidad
from pokemon pok, pokemon_movimiento_forma pmf, movimiento m, movimiento_efecto_secundario mes
where pok.numero_pokedex = pmf.numero_pokedex
and pmf.id_movimiento = m.id_movimiento
and m.id_movimiento = mes.id_movimiento
and mes.probabilidad > 30
order by mes.probabilidad desc;

/*
19. Mostrar todos los pokemon que evolucionan por piedra.
*/
select pok.nombre, te.tipo_evolucion
from pokemon pok, pokemon_forma_evolucion pfe, forma_evolucion fe, tipo_evolucion te
where pok.numero_pokedex = pfe.numero_pokedex
and pfe.id_forma_evolucion = fe.id_forma_evolucion
and fe.tipo_evolucion = te.id_tipo_evolucion
and te.tipo_evolucion = 'piedra';
/*
20. Mostrar todos los pokemon que no pueden evolucionar.
*/
select pok.nombre, ed.pokemon_evolucionado
from pokemon pok
left join evoluciona_de ed
on ed.pokemon_evolucionado = pok.numero_pokedex
order by ed.pokemon_evolucionado;
/*
21. Mostrar la cantidad de los pokemon de cada tipo.
*/
select t.nombre, count(t.id_tipo)
from pokemon pok, pokemon_tipo pt, tipo t
where pok.numero_pokedex = pt.numero_pokedex
and pt.id_tipo = t.id_tipo
group by t.id_tipo
order by count(t.id_tipo) desc;
