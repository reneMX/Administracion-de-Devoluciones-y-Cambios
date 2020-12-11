-- Generado por Oracle SQL Developer Data Modeler 20.3.0.283.0710
--   en:        2020-12-10 12:30:43 CST
--   sitio:      SQL Server 2012
--   tipo:      SQL Server 2012



CREATE TABLE Devoluciones 
    (
     id_devoluciones NUMERIC (28) NOT NULL , 
     nom_empleaado_realizo VARCHAR (200) NOT NULL , 
     nom_empleado_realiza VARCHAR (200) NOT NULL , 
     nom_producto VARCHAR (150) NOT NULL , 
     numero_venta NUMERIC (28) NOT NULL , 
     talla_dev VARCHAR (50) NOT NULL , 
     precio_dev BIGINT NOT NULL , 
     nombre_pago VARCHAR (150) NOT NULL , 
     total_dev BIGINT NOT NULL , 
     dire_tienda VARCHAR (200) NOT NULL , 
     comentarios_dev VARCHAR (500) 
    )
GO

ALTER TABLE Devoluciones ADD CONSTRAINT Devoluciones_PK PRIMARY KEY CLUSTERED (id_devoluciones)
     WITH (
     ALLOW_PAGE_LOCKS = ON , 
     ALLOW_ROW_LOCKS = ON )
GO

CREATE TABLE Pago 
    (
     id_pago NUMERIC (28) NOT NULL , 
     nombre VARCHAR (50) NOT NULL , 
     monto BIGINT NOT NULL 
    )
GO

ALTER TABLE Pago ADD CONSTRAINT Pago_PK PRIMARY KEY CLUSTERED (id_pago)
     WITH (
     ALLOW_PAGE_LOCKS = ON , 
     ALLOW_ROW_LOCKS = ON )
GO

CREATE TABLE Producto 
    (
     id_producto NUMERIC (28) NOT NULL , 
     nom_producto VARCHAR (150) NOT NULL , 
     talla NUMERIC (28) NOT NULL , 
     precio BIGINT NOT NULL 
    )
GO

ALTER TABLE Producto ADD CONSTRAINT Producto_PK PRIMARY KEY CLUSTERED (id_producto)
     WITH (
     ALLOW_PAGE_LOCKS = ON , 
     ALLOW_ROW_LOCKS = ON )
GO

CREATE TABLE Venta 
    (
     id_venta NUMERIC (28) NOT NULL , 
     Pago_id_pago NUMERIC (28) NOT NULL , 
     id_producto NUMERIC (28) NOT NULL , 
     num_venta BIGINT NOT NULL , 
     fch_venta VARCHAR (100) NOT NULL , 
     nombre_empleado VARCHAR (150) NOT NULL , 
     nombre_tienda VARCHAR (150) NOT NULL , 
     direccion_tienda VARCHAR (200) NOT NULL , 
     total_venta BIGINT NOT NULL 
    )
GO

ALTER TABLE Venta ADD CONSTRAINT Venta_PK PRIMARY KEY CLUSTERED (id_venta)
     WITH (
     ALLOW_PAGE_LOCKS = ON , 
     ALLOW_ROW_LOCKS = ON )
GO

ALTER TABLE Venta 
    ADD CONSTRAINT Venta_Pago_FK FOREIGN KEY 
    ( 
     Pago_id_pago
    ) 
    REFERENCES Pago 
    ( 
     id_pago 
    ) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION 
GO

ALTER TABLE Venta 
    ADD CONSTRAINT Venta_Producto_FK FOREIGN KEY 
    ( 
     id_producto
    ) 
    REFERENCES Producto 
    ( 
     id_producto 
    ) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION 
GO



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             4
-- CREATE INDEX                             0
-- ALTER TABLE                              6
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE DATABASE                          0
-- CREATE DEFAULT                           0
-- CREATE INDEX ON VIEW                     0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE ROLE                              0
-- CREATE RULE                              0
-- CREATE SCHEMA                            0
-- CREATE SEQUENCE                          0
-- CREATE PARTITION FUNCTION                0
-- CREATE PARTITION SCHEME                  0
-- 
-- DROP DATABASE                            0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
