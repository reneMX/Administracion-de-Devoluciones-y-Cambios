SELECT * FROM lineclohtes.Ventas;
SELECT * FROM lineclohtes.Productos;
SELECT * FROM lineclohtes.Pagos;
SELECT * FROM lineclohtes.ventas_productos;
SELECT * FROM lineclohtes.Devoluciones;
SELECT * FROM Ventas WHERE num_venta =9029

SELECT id_pagos FROM Pagos ORDER BY id_pagos DESC LIMIT 1


INSERT INTO ventas_productos (id_venta, id_producto) VALUES(9029, 3)
INSERT INTO ventas_productos (id_venta, id_producto) VALUES(9029, 1)
INSERT INTO ventas_productos (id_venta, id_producto) VALUES(87323, 1)

SELECT num_venta FROM Ventas;


SELECT id_pagos FROM Pagos ORDER BY id_pagos DESC LIMIT 1


SELECT num_venta, fch_venta, total_venta, nombre_empleado, nombre_tienda FROM Ventas WHERE num_venta =9029


SELECT * FROM ventas_productos, Productos WHERE id_venta=9029  
SELECT num_venta, fch_venta, total_venta, nombre_empleado, nombre_tienda FROM Ventas WHERE num_venta = 9029


SELECT * FROM ventas_productos WHERE id_venta=9029 AND SELECT  ;


SELECT *
FROM Productos
RIGHT JOIN ventas_productos
ON Productos.id_productos = ventas_productos.id_producto WHERE ventas_productos.id_venta = 9029;

SELECT *
FROM Pagos
RIGHT JOIN ventas_productos
ON Pagos.id_pagos = ventas_productos.id_producto WHERE ventas_productos.id_venta = 9029;


SELECT nombre, monto FROM Pagos RIGHT JOIN ventas_productos ON Pagos.id_pagos = ventas_productos.id_producto WHERE ventas_productos.id_venta =9029
SELECT num_venta, fch_venta, total_venta, nombre_empleado, nombre_tienda FROM Ventas WHERE num_venta =9029

///REGRESA NOMBRES DE LOS PRODUCTOS
SELECT nom_producto
FROM Productos
RIGHT JOIN ventas_productos
ON Productos.id_productos = ventas_productos.id_producto AND ventas_productos.id_venta = 9029;

SELECT *
FROM empleados
WHERE no_dept IN (SELECT no_dept
FROM empleados
WHERE name = 'JUAN');



SELECT num_venta FROM Ventas WHERE num_venta =9029

SELECT id_productos FROM Productos WHERE id_productos=

CREATE TABLE ventas_productos(
  id_venta_producto int(6) NOT NULL,
  id_venta int(6) NOT NULL,
  id_producto int (6) NOT NULL,
  CONSTRAINT pk_ide_venta_producto PRIMARY KEY (id_venta_producto)
);


ALTER TABLE ventas_productos ADD CONSTRAINT fk_ventas FOREIGN KEY (id_venta) REFERENCES Ventas(id_ventas);VentasVentasVentas

CONSTRAINT FK_ID_PRODUCTO FOREIGN KEY (id_producto) REFERENCES Productos(id_productos),
CONSTRAINT FK_ID_VENTA FOREIGN KEY (id_venta) REFERENCES Ventas(id_ventas) ON DELETE CASCAD




INSERT