BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "ventas" (
	"id_venta"	INTEGER NOT NULL,
	"fch_venta"	TEXT NOT NULL,
	"num_venta"	INTEGER NOT NULL,
	"nombre_empleado"	TEXT NOT NULL,
	"nombre_tienda"	TEXT NOT NULL,
	"direccion_tienda"	TEXT NOT NULL,
	"total_venta"	INTEGER NOT NULL,
	PRIMARY KEY("id_venta")
);
INSERT INTO "ventas" VALUES (3,'Wed Nov 11 17:39:00 CST 2020',93824,'Luis','Sucursal Las Antenas','Iztapalapa,18,29',1829);
INSERT INTO "ventas" VALUES (11,'Wed Nov 11 21:42:25 CST 2020',82736,'Fabian','Sucursal Las Antenas','Iztapalapa,18,29',2921);
INSERT INTO "ventas" VALUES (12,'Wed Nov 11 21:42:25 CST 2020',29384,'Karla','Sucursal Las Antenas','Iztapalapa,18,29',9813);
COMMIT;
