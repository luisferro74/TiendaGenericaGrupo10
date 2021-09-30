#verificar las bases de datos 
show databases;

#crear una nueva bases de datos
create database tiendagenerica;

#seleccionar base de datos a usar
use tiendagenerica;


#modulo login y usuarios
create table if not exists usuarios(
cedula_usuario bigint primary key,
email_usuario varchar(255) not null,
nombre_usuario varchar(255) not null,
password varchar(255) not null,
usuario varchar(255) not null
);

#modulo clientes
create table if not exists clientes(
cedula_cliente bigint primary key,
direccion_cliente varchar(255) not null,
email_cliente varchar(255) not null,
nombre_cliente varchar(255) not null,
telefono_cliente varchar(255) not null
);

use tiendagenerica;
insert into clientes values(123, 'Bogota', 'Diego@gmail.com', 'Diego Ramirez', '310580');
insert into clientes values(456, 'Medellin', 'Valeria@gmail.com', 'Valeria Mendoza', '313348');

#modulo proveedores
create table if not exists proveedores(
nit_proveedor bigint primary key,
ciudad_proveedor varchar(255) not null,
direccion_proveedor varchar(255) not null,
nombre_proveedor varchar(255) not null,
telefono_proveedor varchar(255) not null
);
use tiendagenerica;
insert into proveedores values(123, 'Bogota', 'Ciudad Bolivar', 'Servientrega', '310580');


#modulo productos
create table if not exists productos(
codigo_producto bigint primary key,
iva_compra double not null,
nit_proveedor bigint,
nombre_producto varchar(255) not null,
precio_compra double not null,
precio_venta double not null,
foreign key (nit_proveedor) references proveedores(nit_proveedor)
);


#modulo ventas
create table if not exists ventas(
codigo_venta bigint primary key,
cedula_cliente bigint,
cedula_usuario bigint,
iva_venta double not null,
total_venta double  not null,
valor_venta double not null,
foreign key (cedula_cliente) references clientes(cedula_cliente),
foreign key (cedula_usuario) references usuarios(cedula_usuario)
);


#modulo detalle detalle_ventas
create table if not exists detalle_ventas(
codigo_detalle_venta bigint primary key,
cantidad_producto int(11),
codigo_producto bigint,
codigo_venta bigint,
valor_total double not null,
valor_venta double  not null,
valor_iva double not null,
foreign key (codigo_producto) references productos(codigo_producto),
foreign key (codigo_venta) references ventas(codigo_venta)
);



#ingreso datos
insert into usuarios values(001, 'roca230313@gmail.com', 'Diego Rodriguez', 'admin123456', 'admininicial');
insert into usuarios values(002, 'roca230313@gmail.com', 'Diego Rodriguez', 'pass', 'user');
insert into usuarios values(003, 'roca230313@gmail.com', 'Diego Rodriguez', 'pass2', 'user2');
insert into usuarios values(004, 'sebastian@gmail.com', 'SebastianMendez', 'pass3', 'user3');