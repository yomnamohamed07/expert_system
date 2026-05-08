select count(St_Id) from Student 
where St_Age <> Null;
select count(Crs_Id),Top_Id
from Course
group by Top_Id

select s.St_Fname, d.Dept_Manager ,d.Manager_hiredate 
from Student  s join Department d
on( s.Dept_Id =d.Dept_Id)

select m.St_super , count (s.St_Id)
from Student s join Student m
on(s.St_Id =m.St_super)
group by m.St_super 

select Max(salary),Min(salary)
 from Instructor;
 select avg (salary)
 from Instructor