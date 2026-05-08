insert into Employee
values('yomna','mohamed',1,'2005-1-18','cairo','f', 30000,223344,10)
insert into Employee (Fname, Lname,SSN, Address)
values('yara','mohamed',2,'alex')
alter table Employee
alter column salary  decimal  null 
set identity_insert  Employee on 
update Employee 
set Salary+=500
 update Employee
 set Salary+=500
 where Address='alex'
 update Employee
 set Salary +=500 , Dno = 2
 where Address='alex'

 /* cant do update and delete in forign key o*/
 insert into Departments (Dnum)
 values(2)
 /*********************************************/
insert into Employee (Fname, Lname,SSN, Address)
values('lara','mohamed',10,'giza')
delete Employee
where Fname ='lara'

 
