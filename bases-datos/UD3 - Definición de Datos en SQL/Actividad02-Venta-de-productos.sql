-- DROP TABLE cliente;
-- DROP TABLE calle;
-- DROP TABLE poblacion;


CREATE TABLE cliente(
  dni VARCHAR2(9),
  nombre VARCHAR2(100),
  apellidos VARCHAR2(200),
  fecha_nac DATE,
  nombreCalle VARCHAR2(100),
  numeroCalle NUMBER(3),
  cpPoblacion NUMBER(5)
);

CREATE TABLE calle(
  nombre VARCHAR2(100),
  numero NUMBER(3),
  cpPoblacion NUMBER(5)
);

CREATE TABLE poblacion(
  cp NUMBER(5),
  nombre VARCHAR2(100),
  codProvincia NUMBER(2)
);


ALTER TABLE cliente ADD CONSTRAINT pk_cliente PRIMARY KEY(dni);
ALTER TABLE calle ADD CONSTRAINT pk_calle PRIMARY KEY(nombre, numero, cpPoblacion);
ALTER TABLE poblacion ADD CONSTRAINT pk_poblacion PRIMARY KEY(cp);

ALTER TABLE cliente ADD CONSTRAINT ck_cli_nomCal CHECK(nombreCalle IS NOT NULL);
ALTER TABLE cliente ADD CONSTRAINT ck_cli_numCal CHECK(numeroCalle IS NOT NULL);
ALTER TABLE cliente ADD CONSTRAINT ck_cli_cpPob CHECK(cpPoblacion IS NOT NULL);

ALTER TABLE cliente ADD CONSTRAINT fk_cli_nomCal FOREIGN KEY(nombreCalle) REFERENCES calle(nombre);
ALTER TABLE cliente ADD CONSTRAINT fk_cli_numCal FOREIGN KEY(numeroCalle) REFERENCES calle(numero);
ALTER TABLE cliente ADD CONSTRAINT fk_cli_cpPob FOREIGN KEY(cpPoblacion) REFERENCES calle(cpPoblacion);