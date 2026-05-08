SELECT TOP (1000) [Id]
      ,[NameAr]
      ,[NameEn]
      ,[Address]
      ,[PhoneNumber]
      ,[DepartmentId]
  FROM [Skola.Api].[dbo].[Student]
SELECT * 
FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_NAME = 'Student'
