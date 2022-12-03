
select * from empleado;
select * from departamento;
select nombre_depto from departamento;
select nombre, salario from empleado;
select comision from empleado;
select * from empleado where cargo='secretaria';
select * from empleado where cargo='vendedor' order by nombre;
select nombre, cargo, salario from empleado order by salario desc;
select salario, comision from empleado where id_depto=2000 order by comision;
/*
Obtener el valor total a pagar que resulta de sumar el salario y la comisión de los
empleados del departamento 3000 una bonificación de 500, en orden alfabético del
empleado.
*/
select nombre, salario, comision, (salario+comision+500) liquidacion  from empleado where id_depto=3000 order by nombre;
select nombre from empleado WHERE nombre LIKE 'j%';
/*
Listar el salario, la comisión, el salario total (salario + comisión) y nombre, de aquellos
empleados que tienen comisión superior a 1000.
*/
select nombre, salario, comision, (salario+comision) total from empleado where comision>1000;
select nombre, salario, comision, (salario+comision) total from empleado where comision=0;
select nombre, salario, comision, (salario+comision) total from empleado where comision>salario;
/*
Listar los empleados cuya comisión es menor o igual que el 30% de su sueldo
*/
select nombre, salario, comision, (salario*0.3) porc from empleado where comision<(salario*0.3);
select nombre from empleado WHERE not nombre like '%MA%';
select salario from empleado WHERE salario > 200000;
/*
. Obtener los nombres de los departamentos que sean ni “Ventas” ni “Investigación” ni
‘Mantenimiento.
*/
select nombre_depto from departamento where not nombre_depto ='ventas' and not nombre_depto ='investigacion' and not nombre_depto ='mantenimiento';

select * from empleado;
select * from departamento;
select nombre_depto from departamento;
select nombre, salario from empleado;
select comision from empleado;
select * from empleado where cargo='secretaria';
select * from empleado where cargo='vendedor' order by nombre;
select nombre, cargo, salario from empleado order by salario desc;
select salario, comision from empleado where id_depto=2000 order by comision;
/*
Obtener el valor total a pagar que resulta de sumar el salario y la comisión de los
empleados del departamento 3000 una bonificación de 500, en orden alfabético del
empleado.
*/
select nombre, salario, comision, (salario+comision+500) liquidacion  from empleado where id_depto=3000 order by nombre;
select nombre from empleado WHERE nombre LIKE 'j%';
/*
Listar el salario, la comisión, el salario total (salario + comisión) y nombre, de aquellos
empleados que tienen comisión superior a 1000.
*/
select nombre, salario, comision, (salario+comision) total from empleado where comision>1000;
select nombre, salario, comision, (salario+comision) total from empleado where comision=0;
select nombre, salario, comision, (salario+comision) total from empleado where comision>salario;
/*
Listar los empleados cuya comisión es menor o igual que el 30% de su sueldo
*/
select nombre, salario, comision, (salario*0.3) porc from empleado where comision<(salario*0.3);
select nombre from empleado WHERE not nombre like '%MA%';
select salario from empleado WHERE salario > 200000;
/*
. Obtener los nombres de los departamentos que sean ni “Ventas” ni “Investigación” ni
‘Mantenimiento.
*/
select nombre_depto from departamento where nombre_depto ='ventas' or nombre_depto ='investigacion' or nombre_depto ='mantenimiento';
select nombre_depto from departamento where not nombre_depto ='ventas' and not 'investigacion' and not 'mantenimiento';
select max(salario) from empleado;
select max(nombre) from empleado ;
select max(salario), min(salario), (max(salario) - min(salario)) AS diferencia from empleado;
select avg(salario) Promedio from empleado;
/*
24. Hallar los departamentos que tienen más de tres empleados. Mostrar el número de
empleados de esos departamentos.
*/
SELECT d.nombre_depto, count(*)
FROM departamento d, empleado e 
where d.id_depto = e.id_depto
GROUP BY d.nombre_depto 
HAVING count(*) > 3;
/*
25. Mostrar el código y nombre de cada jefe, junto al número de empleados que dirige.
Solo los que tengan más de dos empleados (2 incluido).
*/
SELECT e.cod_jefe, count(e.nombre)
FROM departamento d, empleado e 
where e.cod_jefe = d.codigo_director
and d.codigo_director like '%e.id_empleado%' 
GROUP BY  e.cod_jefe
HAVING count(e.nombre) > 1;




select count(nombre), cod_jefe, substr(COD_JEFE,length(COD_JEFE)-2,3) AS CODIGO, (Select nombre from empleado where id_empleado = CODIGO) 
from empleado group by cod_jefe having count(nombre) > 1;

/*
26. Hallar los departamentos que no tienen empleados
*/
select e.nombre, count(e.cod_jefe)
from departamento d, empleado e
where e.id_depto = d.id_depto
group by e.cod_jefe, e.nombre
having count(e.cod_jefe) = 0;


/*
Consulta con Subconsulta
27. Mostrar la lista de los empleados cuyo salario es mayor o igual que el promedio de la
empresa. Ordenarlo por departamento.
*/
select e.nombre, e.salario, d.nombre_depto 
    from empleado as e, departamento d 
    where e.id_depto = d.id_depto 
    and e.salario >= (select round(avg(salario)) from empleado)
	order by d.nombre_depto;
