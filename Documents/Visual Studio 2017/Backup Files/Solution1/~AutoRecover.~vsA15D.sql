create database systems
use systems
create table employee(
ssn int primary key identity(1,1),
firstname varchar(max) not null ,
lastname varchar(max),
birthday date ,
gender char(1),
[address] varchar(max) default 'egypt',
depid int ,
superid int references employee(ssn)
)
create  table  department(
name varchar(max) not null ,
number int primary key identity (1,1),
hiringdate date ,
mangid int references employee(ssn)
)
create table deplocation(
location varchar ,
depnumber int references department(number),
primary key (location,depnumber)
)
create table projects (
number int primary key not null,
name varchar(20) not null,
city varchar ,
location varchar ,
depnumber int references department (number)
)
create table employeeproject (
empssn int not null,
pnumber int not null,
workinghours time
)