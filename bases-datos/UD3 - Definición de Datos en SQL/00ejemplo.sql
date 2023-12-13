DROP TABLE provincia CASCADE CONSTRAINTS;
DROP TABLE pais CASCADE CONSTRAINTS;
DROP TABLE proveedor CASCADE CONSTRAINTS;
DROP TABLE productor CASCADE CONSTRAINTS;
DROP TABLE estacion_primaria CASCADE CONSTRAINTS;
DROP TABLE hidroelectrica CASCADE CONSTRAINTS;
DROP TABLE solar CASCADE CONSTRAINTS;
DROP TABLE nuclear CASCADE CONSTRAINTS;
DROP TABLE termica CASCADE CONSTRAINTS;
DROP TABLE companyia CASCADE CONSTRAINTS;
DROP TABLE subestacion CASCADE CONSTRAINTS;
DROP TABLE red_distribucion CASCADE CONSTRAINTS;


CREATE TABLE provincia(
  cod NUMBER(2),
  nombre VARCHAR2(100)
);

CREATE TABLE pais(
  cod NUMBER(2),
  nombre VARCHAR2(100)
);

CREATE TABLE proveedor(
  nombre VARCHAR2(100)
);

CREATE TABLE productor(
  nombre VARCHAR2(100),
  prod_max NUMBER(7, 2),
  prod_media NUMBER(7, 2),
  fecha_ent DATE
);

create TABLE estacion_primaria(
  nombre VARCHAR2(100),
  num_estaciones NUMBER(6)
);

create TABLE hidroelectrica(
  nombre VARCHAR2(100) default 'Sin Nombre',
  ocupacion NUMBER(4),
  capacidad_maxima NUMBER(10),
  num_turbinas NUMBER(3)
);

create TABLE solar(
  nombre VARCHAR2(100),
  superficie NUMBER(6),
  tipo VARCHAR2(50),
  media_anual_sol NUMBER(12)
);

create TABLE nuclear(
  nombre VARCHAR2(100),
  ocupacion NUMBER(4),
  capacidad_maxima NUMBER(10),
  num_turbinas NUMBER(3)
);

create TABLE termica(
  nombre VARCHAR2(100),
  ocupacion NUMBER(4),
  capacidad_maxima NUMBER(10),
  num_turbinas NUMBER(3)
);

create TABLE companyia(
  cif VARCHAR2(9),
  nombre VARCHAR2(100)
);

create TABLE subestacion(
  cod VARCHAR2(5),
  red NUMBER (5) NOT NULL,
  num_linea NUMBER(6) NOT NULL
);

create TABLE red_distribucion(
  numero NUMBER(5),
  nombre_estacion VARCHAR2(100)
);


ALTER TABLE provincia ADD CONSTRAINT pk_provincia PRIMARY KEY (cod);
ALTER TABLE estacion_primaria ADD CONSTRAINT pk_est_prim PRIMARY KEY(nombre);
ALTER TABLE companyia ADD CONSTRAINT pk_companyia PRIMARY KEY (cif);

ALTER TABLE red_distribucion ADD CONSTRAINT ck_nom_est_nn CHECK (nombre_estacion is not null);
ALTER TABLE solar ADD CONSTRAINT ck_tipo CHECK (tipo in ('industrial','profesional','personal'));
ALTER TABLE solar ADD CONSTRAINT ck_superficio CHECK (superficie between 1000 and 5000);
ALTER TABLE productor ADD CONSTRAINT ck_fecha CHECK (fecha_ent < TO_DATE('12/12/2022','DD/MM/YYYY'));

ALTER TABLE companyia ADD CONSTRAINT uk_companyia UNIQUE (nombre);

ALTER TABLE hidroelectrica ADD CONSTRAINT fk_hid_est_pri FOREIGN KEY (nombre) REFERENCES estacion_primaria(nombre) ON DELETE CASCADE;

truncate TABLE provincia;