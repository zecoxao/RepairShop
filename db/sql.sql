DROP TABLE ficha;
DROP TABLE cliente;

drop sequence cliente_seq;
drop sequence ficha_seq;

create sequence cliente_seq start with 1 increment by 1 nomaxvalue; 
create sequence ficha_seq start with 1 increment by 1 nomaxvalue; 

CREATE TABLE cliente
(
cliente_id int primary key not null,
nome varchar(255) not null,
contacto number(9) not null,
bi number(9) not null unique
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
data_entrega varchar(255) default TO_CHAR(SYSDATE, 'dd-MM-yyyy') not null 
);

create or replace trigger cliente_trigger
before insert on cliente
for each row
   begin
     select cliente_seq.nextval into :new.cliente_id from dual;
   end;
/
create or replace trigger ficha_trigger
before insert on ficha
for each row
   begin
     select ficha_seq.nextval into :new.ficha_id from dual;
   end;
/