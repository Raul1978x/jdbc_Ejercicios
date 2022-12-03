/*
1. Lista el nombre de todos los productos que hay en la tabla producto.
*/
select * 
from producto;
/*
2. Lista los nombres y los precios de todos los productos de la tabla producto.
*/
select nombre, precio 
from producto;
/*
3. Lista todas las columnas de la tabla producto.
*/
select codigo, nombre, precio, codigo_fabricante 
from producto;
/*
4. Lista los nombres y los precios de todos los productos de la tabla producto, redondeando
el valor del precio.
*/
select nombre, round(precio) from producto;
/*
5. Lista el código de los fabricantes que tienen productos en la tabla producto.
*/
select *
from producto p, fabricante f
where p.codigo_fabricante = f.codigo;
/*
6. Lista el código de los fabricantes que tienen productos en la tabla producto, sin mostrar
los repetidos.
*/
SELECT DISTINCT p.codigo_fabricante, f.nombre 
FROM producto p, fabricante f
where p.codigo_fabricante = f.codigo;
/*
7. Lista los nombres de los fabricantes ordenados de forma ascendente.
*/
select nombre, precio 
from producto 
order by nombre asc;
/*
8. Lista los nombres de los productos ordenados en primer lugar por el nombre de forma
ascendente y en segundo lugar por el precio de forma descendente.
*/
select nombre, precio 
from producto 
order by nombre asc, precio desc;
/*
9. Devuelve una lista con las 5 primeras filas de la tabla fabricante.
*/
SELECT * 
FROM fabricante 
WHERE codigo < 6;
/*
10. Lista el nombre y el precio del producto más barato. (Utilice solamente las cláusulas
ORDER BY y LIMIT)
*/
select nombre, precio 
from producto 
order by precio 
limit 1;
/*
11. Lista el nombre y el precio del producto más caro. (Utilice solamente las cláusulas ORDER
BY y LIMIT)
*/
select nombre, precio 
from producto 
order by precio desc 
limit 1;
/*
12. Lista el nombre de los productos que tienen un precio menor o igual a $120.
*/
select nombre, precio 
from producto 
where precio <= 120;
/*
13. Lista todos los productos que tengan un precio entre $60 y $200. Utilizando el operador
BETWEEN.
*/
select nombre, precio 
from producto 
where precio 
between 60 and 200;
/*
14. Lista todos los productos donde el código de fabricante sea 1, 3 o 5. Utilizando el operador
IN.
*/
SELECT * 
FROM producto 
WHERE codigo_fabricante 
IN (1, 3, 5);
/*
15. Devuelve una lista con el nombre de todos los productos que contienen la cadena Portátil
en el nombre.
*/
select * 
from producto 
where nombre like '%Portatil%';
/*
Consultas Multitabla
1. Devuelve una lista con el código del producto, nombre del producto, código del fabricante
y nombre del fabricante, de todos los productos de la base de datos.
*/
select p.codigo ,p.nombre ,f.codigo, f.nombre 
from producto p, fabricante f
where p.codigo_fabricante = f.codigo ;
/*
2. Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos
los productos de la base de datos. Ordene el resultado por el nombre del fabricante, por
orden alfabético.
*/
select p.nombre, p.precio, f.nombre nom_fab
from producto p, fabricante f
where p.codigo_fabricante = f.codigo
order by f.nombre asc;
/*
3. Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto
más barato.
*/
select p.nombre, f.nombre, p.precio
from fabricante f, producto p
where p.codigo_fabricante = f.codigo
order by p.precio asc
limit 1;
/*
4. Devuelve una lista de todos los productos del fabricante Lenovo.
*/
select * 
from producto p, fabricante f 
where p.codigo_fabricante = f.codigo
and f.nombre = 'lenovo';
/*
5. Devuelve una lista de todos los productos del fabricante Crucial que tengan un precio
mayor que $200.
*/
select * 
from producto p, fabricante f 
where p.codigo_fabricante = f.codigo
and f.nombre = 'crucial' 
and p.precio < 200;
/*
6. Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packard.
Utilizando el operador IN.
*/
select * 
from producto p, fabricante f
where p.codigo_fabricante = f.codigo
and f.nombre in ('asus','Hewlett-Packard');
/*
7. Devuelve un listado con el nombre de producto, precio y nombre de fabricante, de todos
los productos que tengan un precio mayor o igual a $180. Ordene el resultado en primer
lugar por el precio (en orden descendente) y en segundo lugar por el nombre (en orden
ascendente)
*/
select p.nombre, p.precio, f.nombre  as nombre_fabricante 
from producto p, fabricante f 
where p.codigo_fabricante = f.codigo
and p.precio >= 180 
order by p.precio desc, p.nombre asc;
/*
Consultas Multitabla
Resuelva todas las consultas utilizando las cláusulas LEFT JOIN y RIGHT JOIN.
1. Devuelve un listado de todos los fabricantes que existen en la base de datos, junto con los
productos que tiene cada uno de ellos. El listado deberá mostrar también aquellos
fabricantes que no tienen productos asociados.
*/
SELECT * 
FROM producto p 
right JOIN fabricante f 
ON p.codigo_fabricante = f.codigo;
/*
2. Devuelve un listado donde sólo aparezcan aquellos fabricantes que no tienen ningún
producto asociado.
*/
select *
from fabricante f
left join producto p
on p.codigo_fabricante = f.codigo
where not exists (select p.codigo_fabricante
from producto p
where p.codigo_fabricante = f.codigo
);
/*
Subconsultas (En la cláusula WHERE)
Con operadores básicos de comparación
1. Devuelve todos los productos del fabricante Lenovo. (Sin utilizar INNER JOIN).
*/
select * 
from producto p, fabricante f 
where p.codigo_fabricante = f.codigo
and f.nombre = 'Lenovo';
/*
2. Devuelve todos los datos de los productos que tienen el mismo precio que el producto
más caro del fabricante Lenovo. (Sin utilizar INNER JOIN). 
*/
insert into producto (codigo, nombre, precio, codigo_fabricante) values (12, 'Monitor 32 LED Full HD', 559, 1);
select *
from producto pr
where precio = (select max(p.precio) 
				from producto p, fabricante f
				where p.codigo_fabricante = f.codigo
				and f.nombre = 'lenovo');
SELECT * 
FROM producto 
WHERE precio = ( SELECT MAX(precio)
				FROM producto 
                WHERE codigo_fabricante = (SELECT codigo 
										FROM fabricante 
                                        WHERE nombre="Lenovo"));            
/*
3. Lista el nombre del producto más caro del fabricante Lenovo.
*/
select *
from producto pr, fabricante fa
where pr.codigo_fabricante = fa.codigo
and fa.nombre = 'lenovo' 
and pr.precio = (select max(p.precio) 
from producto p, fabricante f
where p.codigo_fabricante = f.codigo
and f.nombre = 'lenovo');
/*
4. Lista todos los productos del fabricante Asus que tienen un precio superior al precio
medio de todos sus productos.
*/

select * 
from producto p, fabricante f 
where p.codigo_fabricante = f.codigo
and f.nombre = 'asus' 
and precio > (select avg(precio) 
from producto);
/*
Subconsultas con IN y NOT IN
1. Devuelve los nombres de los fabricantes que tienen productos asociados. (Utilizando IN o
NOT IN).
*/
select f.nombre, p.nombre, p.precio  
from fabricante f, producto p 
where p.codigo_fabricante = f.codigo;
/*
2. Devuelve los nombres de los fabricantes que no tienen productos asociados. (Utilizando
IN o NOT IN).
*/


/*
Subconsultas (En la cláusula HAVING)
1. Devuelve un listado con todos los nombres de los fabricantes que tienen el mismo número
de productos que el fabricante Lenovo.
*/

SELECT * 
FROM producto 
WHERE precio=(SELECT MAX(precio) 
				FROM producto 
                WHERE codigo_fabricante= (SELECT codigo 
											FROM fabricante 
                                            WHERE nombre="Lenovo"))
               