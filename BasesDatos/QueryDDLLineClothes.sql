
CREATE TABLE Devoluciones 
    (
     id_devoluciones int  (28) NOT NULL auto_increment , 
     nom_empleaado_realizo VARCHAR (200)  NOT NULL , 
     nom_empleado_realiza VARCHAR (200)   NOT NULL , 
     nom_producto VARCHAR (150) NOT NULL , 
     numero_venta NUMERIC (28) NOT NULL , 
     talla_dev VARCHAR (50) NOT NULL , 
     precio_dev DOUBLE NOT NULL , 
     nombre_pago VARCHAR (150) NOT NULL , 
     total_dev DOUBlE NOT NULL , 
     dire_tienda VARCHAR (200) NOT NULL , 
     comentarios_dev VARCHAR (500) ,
	constraint devoluciones_pk PRIMARY KEY (id_devoluciones)
    );


CREATE TABLE Pagos 
    (
     id_pagos int (6) NOT NULL auto_increment, 
     nombre VARCHAR (50) NOT NULL , 
     monto DOUBLE NOT NULL,
     constraint pago_pk PRIMARY KEY (id_pagos)
    );
    


CREATE TABLE Productos 
    (
     id_productos int (6) NOT NULL  auto_increment, 
     nom_producto VARCHAR (150) NOT NULL , 
     talla VARCHAR (30) NOT NULL , 
     precio DOUBLE NOT NULL,
     constraint producto_pk PRIMARY KEY (id_productos)
    );

CREATE TABLE Ventas
    (
     id_ventas int(6) NOT NULL  , 
     id_pago int (6) NOT NULL , 
     id_producto int (6) NOT NULL , 
     num_venta int(10) NOT NULL , 
     fch_venta VARCHAR (100) NOT NULL , 
     nombre_empleado VARCHAR (150) NOT NULL , 
     nombre_tienda VARCHAR (150) NOT NULL , 
     direccion_tienda VARCHAR (200) NOT NULL , 
     total_venta DOUBLE NOT NULL ,
     constraint id_producto_fk FOREIGN KEY (id_producto)  REFERENCES Productos (id_productos),
     constraint id_pago_fk FOREIGN KEY (id_pago) REFERENCES Pagos(id_pagos)
    );
