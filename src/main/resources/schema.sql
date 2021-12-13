
drop table if exists employee; 
drop table if exists department; 
drop table if exists company; 

create table employee(
id serial primary key,
name varchar(100),
surname varchar(100),
hours int,
begin int,
endwork int,
role varchar(100),
preference varchar(100),
synch boolean,
performance numeric,
percent numeric,
salary numeric
);

create table department(
id serial primary key,
name varchar(100),
change boolean,
synch boolean,
idemployee int,
performance numeric,
FOREIGN KEY (idemployee) REFERENCES employee (id),
UNIQUE(name, idemployee, change, synch)
);

create table company(
id serial primary key,
name varchar(100),
countperson int,
iddepartment int,
FOREIGN KEY (iddepartment) REFERENCES department (id),
UNIQUE(name, iddepartment, countperson)
);