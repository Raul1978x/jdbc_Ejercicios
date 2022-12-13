/*
 b) Buscar y listar las casas disponibles para el periodo comprendido entre el
 * 1 de agosto de 2020 y el 31 de agosto de 2020 en Reino Unido.
*/

select * from casas where pais ='reino unido' and fecha_desde >= '2020-08-01' and fecha_hasta <= '2020-08-31';

/*
 e) Listar los datos de todos los clientes que en algún momento realizaron una
 * estancia y la descripción de la casa donde la realizaron.
*/
select es.nombre_huesped, es.fecha_desde, es.fecha_hasta, c.* 
from  estancias es, casas c
where es.id_casa = c.id_casa;

/*
f) Listar todas las estancias que han sido reservadas por un cliente, mostrar
 * el nombre, país y ciudad del cliente y además la información de la casa que
 * reservó. La que reemplazaría a la anterior
*/

/*
 g) Debido a la devaluación de la libra esterlina con respecto al euro se
 * desea incrementar el precio por día en un 5% de todas las casas del Reino
 * Unido. Mostar los precios actualizados.
 */
 
 select *, precio_habitacion + precio_habitacion*0.05 precio_con_aumento from casas where pais = 'reino unido';
 
 /*
  h) Obtener el número de casas que existen para cada uno de los países diferentes.
 */
 select pais, count(id_casa) from casas group by pais;
 
 /*
  i) Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios) que están ‘limpias’.
 */
 select * from casas ca, comentarios co where ca.id_casa = co.id_casa and co.comentario like '%limpia%';
 
 /*
 j) Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas. 
 */
 insert into estancias (id_estancia,id_cliente,id_casa,nombre_huesped, fecha_desde, fecha_hasta) values (1estancias0,10,10,'Raul Gomez','2022-12-15','2022-12-31');