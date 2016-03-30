DROP TABLE ficha;
DROP TABLE cliente;

drop sequence cliente_seq;
drop sequence ficha_seq;

CREATE SEQUENCE  cliente_seq  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
CREATE SEQUENCE  ficha_seq  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;

CREATE TABLE cliente
(
cliente_id int primary key not null,
nome varchar(255) not null,
contacto number(9) not null,
bi number(9) not null 
);

CREATE TABLE ficha
(
ficha_id int primary key not null,
cliente int not null,
foreign key (cliente) references cliente(cliente_id),
equipamento varchar(255) not null,
avaria varchar(255) not null,
orcamento number(6,2) not null,
pagamento_caucao number(6,2) not null,
data_entrega varchar(255) default TO_CHAR(SYSDATE, 'dd-MM-yyyy') 
);