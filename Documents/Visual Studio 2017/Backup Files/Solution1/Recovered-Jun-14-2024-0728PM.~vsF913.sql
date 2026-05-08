---query 1
select Fname+' '+Lname fullname
from employee
where len(Fname)>3;
---query2

SELECT COUNT(b.id) AS "NO OF PROGRAMMING BOOKS"
FROM Book b
JOIN Category c ON b.Cat_id = c.Id
WHERE c.Cat_name LIKE 'programming';

----query 3
select count (b.id)
As "NO_OF_BOOKS"
from Book b Join publisher p
on b.Publisher_id = p.Id
where p.Name = 'HarperCollins' ;
---- query 4

select u.SSN, u.User_Name, b.Borrow_date, b.due_date
FROM Users u
join Borrowing b ON u.SSN = b.User_ssn
WHERE b.due_date < '2022-07-01';
----- query 5
select b.Title+'is written by '+ a.Name
from Book b , Author a ,Book_Author ba
where ba.Author_id =a.Id and ba.Book_id= b.id
---query 6
select u.User_Name
from users u 
where u.User_Name like '%A%'
----- query 8
select  sum (b.Amount)  AS "amount of money"  ,u.User_Name
from Borrowing b ,Users u
where b.User_ssn =u.SSN
group by u.User_Name

-----query 9
SELECT c.Cat_name
FROM Category c
JOIN Book b ON c.Id= b.Cat_id
JOIN Borrowing br ON b.Id= br.Book_id
WHERE br.Amount= (
    SELECT MIN(h.Amount)
    FROM Borrowing h
);
---query 10
select coalesce  (e.Email  ,e.Address ,cast (e.DOB as varchar(20)))

from Employee e ;
---query 11
select c.Cat_name , count (b.Id)
from book b ,category c
where b.Cat_id =c.Id
group by  c.Cat_name 
---query 12

select  b .Id from   Shelf s join Book b
on s.Code =b.Shelf_code
join Floor f
on s.Floor_num =f.Number
where f.Number <>1 and s.Code <>'A1' ;
 select * from Book;
 select * from Floor ;
 select * from Shelf ;
 --- query 13
 select f.Number ,f.Num_blocks ,count (e.Id)
 from Floor f join Employee e
 on f.Number =e.Floor_no
 group by f.Number ,f.Num_blocks
 -----query 14
 select b.Title ,u.User_Name
 from Borrowing bb join Book b
 on b.Id =bb.Book_id
 join Users u 
 on bb.User_ssn= u.SSN
 where bb.Borrow_date = '2022/03/01' and bb.Due_date='2022//10/01'  ;
 ----query 15
 select e.Fname +e.Lname  employee,m.Id ,m.Fname+m.Lname superviser
 from Employee e ,Employee m
 where e.Super_id =m.Id;
 select * from employee
 ----query 16
 select e.Fname ,coalesce( e.Salary ,e.Bouns)
 from Employee e;

 ---query 17
 select min(salary)
 ,max(salary)
 from Employee ;
 ----query18
 create Function dbo.IsEvenOrOdd(@Id int)
 returns varchar(4)
 as
 begin
 declare @result varchar(4)
 if @Id %2 = 0 
 set @result ='even'
 else
 set @Id ='odd'
 return @result 
 end
 select dbo.IsEvenOrOdd (7)

 ----query 19
  create Function dbo.CtagoryName(@id int)
 returns varchar (max)
 as 
 begin
 declare @result varchar(max)

 select @result = c.Cat_name
 from Category c join Book b
 on c.Id= b.Cat_id
 where @id = b.Id
 return @result
 end
 select dbo.CtagoryName(3)
 ------query 20
 Create Function dbo.show(@phone varchar(max))
 returns table 
  as
  return (
 select b.Title ,u.User_Name ,bb.Amount,bb.Due_date
 from Borrowing bb join Book b
 on bb.Book_id = b.Id
 join Users u
 on bb.User_ssn =u.SSN
 join User_phones uu
 on uu.User_ssn =u.SSN
 where @phone = uu.Phone_num
)
select * from dbo.show ('0123654122')
------query 21
Create Function dbo.CheckUserName(@UserName varchar(max))
returns varchar(max)
AS
BEGIN
    declare @Message varchar(max)
    declare @Count int

    -- Count the occurrences of the user name
    select @Count = count(*)
    from Users
    where User_Name = @UserName;

    -- Determine the message to return based on the count
    if @Count > 1
    begin
        set @Message = CONCAT(@UserName, ' is Repeated ', @Count, ' times');
    end
    else if @Count = 1
    begin
        set @Message = CONCAT(@UserName, ' is not duplicated');
    end
    else
    begin
        set @Message = CONCAT(@UserName, ' is Not Found');
    end

    return @Message
 end
 select dbo.CheckUserName('Amr Ahmed')
 -----query 22