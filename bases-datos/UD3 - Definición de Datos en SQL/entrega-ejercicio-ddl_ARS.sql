DROP TABLE departamento CASCADE CONSTRAINTS;
DROP TABLE empleado CASCADE CONSTRAINTS;
DROP TABLE empleado_departamento CASCADE CONSTRAINTS;
DROP TABLE nomina CASCADE CONSTRAINTS;
DROP TABLE linea CASCADE CONSTRAINTS;
DROP TABLE elemento_de_coste CASCADE CONSTRAINTS;
DROP TABLE concepto_retributivo CASCADE CONSTRAINTS;
DROP TABLE ingreso CASCADE CONSTRAINTS;
DROP TABLE descuento CASCADE CONSTRAINTS;


CREATE TABLE departamento(
    codigo NUMBER(3),
    nombre VARCHAR2(100)
);

CREATE TABLE empleado(
    num_mat NUMBER(5),
    nif VARCHAR2(9),
    nombre VARCHAR2(100),
    num_hijos NUMBER(2),
    retencion NUMBER(5, 2),
    cuenta_corriente VARCHAR2(24)
);

CREATE TABLE empleado_departamento(
    codigoDepartamento NUMBER(3),
    num_matEmpleado NUMBER(5),
    funcion VARCHAR2(100)
);

CREATE TABLE nomina(
    ejercicio DATE,
    mes NUMBER(2),
    numero NUMBER(6),
    num_matEmpleado NUMBER(5),
    ingreso_total NUMBER(8, 2),
    descuento_total NUMBER(8, 2)
);

CREATE TABLE linea(
    num_linea VARCHAR(200),
    ejercicioNomina DATE,
    mesNomina NUMBER(2),
    numeroNomina NUMBER(6),
    num_matEmpleado NUMBER(5),
    cantidad NUMBER(8, 2)
);

CREATE TABLE elemento_de_coste(
    codigo NUMBER(6),
    descripcion VARCHAR2(1000),
    saldo NUMBER(8, 2),
    pertenece_elemento NUMBER(6)
);

CREATE TABLE concepto_retributivo(
    codigo NUMBER(6),
    descripcion VARCHAR2(1000)
);

CREATE TABLE ingreso(
    num_lineaLinea VARCHAR2(200),
    ejercicioNomina DATE,
    mesNomina NUMBER(2),
    numeroNomina NUMBER(6),
    num_matEmpleado NUMBER(5),
    codigoConcepto_retributivo NUMBER(6)
);

CREATE TABLE descuento(
    num_lineaLinea VARCHAR2(200),
    ejercicioNomina DATE,
    mesNomina NUMBER(6),
    numeroNomina NUMBER(6),
    num_matEmpleado NUMBER(5),
    base NUMBER(8, 2),
    porcentaje NUMBER(5, 2)
);


ALTER TABLE departamento ADD CONSTRAINT pk_departamento PRIMARY KEY(codigo);
ALTER TABLE empleado ADD CONSTRAINT pk_empleado PRIMARY KEY(num_mat);
ALTER TABLE empleado_departamento ADD CONSTRAINT pk_emp_dep PRIMARY KEY(num_matEmpleado, codigoDepartamento);
ALTER TABLE nomina ADD CONSTRAINT pk_nomina PRIMARY KEY(ejercicio, mes, numero, num_matEmpleado);
ALTER TABLE linea ADD CONSTRAINT pk_linea PRIMARY KEY(num_linea, ejercicioNomina, mesNomina, numeroNomina, num_matEmpleado);
ALTER TABLE elemento_de_coste ADD CONSTRAINT pk_ele_de_cos PRIMARY KEY(codigo);
ALTER TABLE concepto_retributivo ADD CONSTRAINT pk_con_ret PRIMARY KEY(codigo);
ALTER TABLE ingreso ADD CONSTRAINT pk_ingreso PRIMARY KEY(num_lineaLinea, ejercicioNomina, mesNomina, numeroNomina, num_matEmpleado);
ALTER TABLE descuento ADD CONSTRAINT pk_descuento PRIMARY KEY(num_lineaLinea, ejercicioNomina, mesNomina, numeroNomina, num_matEmpleado);

ALTER TABLE empleado_departamento ADD CONSTRAINT fk_emp_dep_cod FOREIGN KEY(codigoDepartamento) REFERENCES departamento(codigo) ON DELETE CASCADE;
ALTER TABLE empleado_departamento ADD CONSTRAINT fk_emp_dep_num FOREIGN KEY(num_matEmpleado) REFERENCES empleado(num_mat) ON DELETE CASCADE;
ALTER TABLE nomina ADD CONSTRAINT fk_nom_num FOREIGN KEY(num_matEmpleado) REFERENCES empleado(num_mat) ON DELETE CASCADE;
ALTER TABLE linea ADD CONSTRAINT fk_lin_eje_mes_numNom_numEmp FOREIGN KEY(ejercicioNomina, mesNomina, numeroNomina, num_matEmpleado) REFERENCES nomina(ejercicio, mes, numero, num_matEmpleado) ON DELETE CASCADE;
ALTER TABLE elemento_de_coste ADD CONSTRAINT fk_ele_per FOREIGN KEY(pertenece_elemento) REFERENCES elemento_de_coste(codigo) ON DELETE CASCADE;
ALTER TABLE ingreso ADD CONSTRAINT fk_ing_num_eje_mes_numNom_numEmp FOREIGN KEY(num_lineaLinea, ejercicioNomina, mesNomina, numeroNomina, num_matEmpleado) REFERENCES linea(num_linea, ejercicioNomina, mesNomina, numeroNomina, num_matEmpleado) ON DELETE CASCADE;
ALTER TABLE ingreso ADD CONSTRAINT fk_ing_cod FOREIGN KEY(codigoConcepto_retributivo) REFERENCES concepto_retributivo(codigo) ON DELETE CASCADE;
ALTER TABLE descuento ADD CONSTRAINT fk_des_num_eje_mes_numNom_numEmp FOREIGN KEY(num_lineaLinea, ejercicioNomina, mesNomina, numeroNomina, num_matEmpleado) REFERENCES linea(num_linea, ejercicioNomina, mesNomina, numeroNomina, num_matEmpleado) ON DELETE CASCADE;

ALTER TABLE ingreso ADD CONSTRAINT ck_ing_cod_nn CHECK(codigoConcepto_retributivo IS NOT NULL);