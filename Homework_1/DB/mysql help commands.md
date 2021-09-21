#help
##
# Command for  connection to mysql
mysql -P 3306 --protocol=tcp -u root -p
connect myDB
##
USE myDB;
##

#Info
SHOW TABLES;
## Get column names from a table using INFORMATION SCHEMA
SELECT COLUMN_NAME
FROM INFORMATION_SCHEMA.COLUMNS
WHERE
TABLE_SCHEMA = Database()
AND TABLE_NAME = 'users' ;