DROP TABLE avaria_cliente;
DROP TABLE avaria;
DROP TABLE cliente;

CREATE TABLE cliente
(
cliente_id int primary key not null,
nome varchar(255) not null,
equipamento varchar(255) not null,
contacto number(9) not null,
orcamento number(6,2) not null,
pagamento_caucao number(6,2) not null
);

CREATE TABLE avaria
(
avaria_id int primary key not null,
descricao varchar(255),
outro number(1) ,
descricao_outro varchar(255)
);

CREATE TABLE avaria_cliente
(
avaria int not null,
cliente int not null,
constraint PK_D primary key (avaria, cliente),
foreign key (avaria) references avaria(avaria_id),
foreign key (cliente) references cliente(cliente_id),
data_entrega date default sysdate not null,
reparacao number(1) not null,
data_reparacao date 
);

drop sequence cliente_seq;
drop sequence avaria_seq;

create sequence cliente_seq start with 1 increment by 1 nomaxvalue; 
create sequence avaria_seq start with 1 increment by 1 nomaxvalue; 

create or replace trigger cliente_trigger
before insert on cliente
for each row
   begin
     select cliente_seq.nextval into :new.cliente_id from dual;
   end;
/
create or replace trigger avaria_trigger
before insert on avaria
for each row
   begin
     select avaria_seq.nextval into :new.avaria_id from dual;
   end;
/