SELECT TOP (1000) [Id]
      ,[NameAr]
      ,[NameEn]
      ,[Address]
      ,[PhoneNumber]
      ,[DepartmentId]
  FROM [Skola.Api].[dbo].[Student]
  ALTER TABLE Student DROP COLUMN DepartmentId1;
SELECT 
    fk.name AS ForeignKeyName,
    tp.name AS TableName,
    ref.name AS RefTableName
FROM 
    sys.foreign_keys fk
    INNER JOIN sys.tables tp ON fk.parent_object_id = tp.object_id
    INNER JOIN sys.tables ref ON fk.referenced_object_id = ref.object_id
WHERE 
    tp.name = 'Student';
	SELECT 
    fk.name AS ForeignKeyName,
    tp.name AS TableName,
    ref.name AS RefTableName,
    c.name AS ColumnName
FROM 
    sys.foreign_keys fk
    INNER JOIN sys.tables tp ON fk.parent_object_id = tp.object_id
    INNER JOIN sys.tables ref ON fk.referenced_object_id = ref.object_id
    INNER JOIN sys.foreign_key_columns fkc ON fkc.constraint_object_id = fk.object_id
    INNER JOIN sys.columns c ON fkc.parent_column_id = c.column_id AND fkc.parent_object_id = c.object_id
WHERE 
    tp.name = 'Student' AND fk.name = 'FK_Student_Department_DepartmentId';
	ALTER TABLE Student DROP COLUMN DepartmentId1;


