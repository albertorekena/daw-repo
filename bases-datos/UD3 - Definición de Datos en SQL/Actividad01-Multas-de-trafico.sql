DROP TABLE vehiculo CASCADE CONSTRAINTS;
DROP TABLE propietario CASCADE CONSTRAINTS;
DROP TABLE infraccion CASCADE CONSTRAINTS;
DROP TABLE vehiculo_infraccion CASCADE CONSTRAINTS;


CREATE TABLE vehiculo(
  matricula VARCHAR2(8),
  marca VARCHAR2(100),
  modelo VARCHAR2(100),
  tipo VARCHAR2(100),
  dniPropietario VARCHAR2(9)
);

CREATE TABLE propietario(
  dni VARCHAR2(9),
  nombre VARCHAR2(100),
  apellidos VARCHAR2(200),
  direccion VARCHAR2(200)
);

CREATE TABLE infraccion(
  cod VARCHAR2(100),
  descripcion VARCHAR2(1000),
  cuantia NUMBER(9, 2)
);

CREATE TABLE vehiculo_infraccion(
  matriculaVehiculo VARCHAR2(8),
  codInfraccion VARCHAR2(100),
  fecha_multa DATE,
  fecha_pago DATE
);


ALTER TABLE vehiculo ADD CONSTRAINT pk_vehiculo PRIMARY KEY(matricula);
ALTER TABLE propietario ADD CONSTRAINT pk_propietario PRIMARY KEY(dni);
ALTER TABLE infraccion ADD CONSTRAINT pk_infraccion PRIMARY KEY(cod);
ALTER TABLE vehiculo_infraccion ADD CONSTRAINT pk_matVeh_codInf PRIMARY KEY(matriculaVehiculo, codInfraccion);

ALTER TABLE vehiculo ADD CONSTRAINT ck_dniPropietario CHECK(dniPropietario IS NOT NULL);

ALTER TABLE vehiculo ADD CONSTRAINT fk_veh_dniPro FOREIGN KEY(dniPropietario) REFERENCES propietario(dni);
ALTER TABLE vehiculo_infraccion ADD CONSTRAINT fk_veh_inf_matVeh FOREIGN KEY(matriculaVehiculo) REFERENCES vehiculo(matricula);
ALTER TABLE vehiculo_infraccion ADD CONSTRAINT fk_veh_inf_codInf FOREIGN KEY(codInfraccion) REFERENCES infraccion(cod);