# Esempio con un db

In questo esempio proponiamo un accesso l'interazione fra framework `fatfree` e `MariaDB` ovvero `MySQL`. Qui di seguito i passi con la shell.
```
MariaDB [(none)]> create database fat01;
Query OK, 1 row affected (0.00 sec)
```
QUindi diamo i diritti a `fat`:
```
MariaDB [(none)]> grant all on fat01.* to fat@localhost identified by 'fat@2017';
Query OK, 0 rows affected (0.00 sec)

MariaDB [(none)]> 
```
Ricordiamo che
```
grant all on fat01.* to fat@'%' identified by 'fat@2017'
```
non include `localhost`.

Una volta creato il db seguiamo l'esempio del tutorial seguente: [link](http://www.ntu.edu.sg/home/ehchua/programming/sql/mysql_beginner.html).

## connessione al db
```
genji@mymachine:~$ mysql -u fat -p
Enter password: 
Welcome to the MariaDB monitor.  Commands end with ; or \g.
Your MariaDB connection id is 8
Server version: 10.0.29-MariaDB-0ubuntu0.16.04.1 Ubuntu 16.04

Copyright (c) 2000, 2016, Oracle, MariaDB Corporation Ab and others.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

MariaDB [(none)]> show databases;
+--------------------+
| Database           |
+--------------------+
| fat01              |
| information_schema |
+--------------------+
2 rows in set (0.00 sec)

MariaDB [(none)]> use fat01;
Database changed
```

## Creiamo la tabella.
```
MariaDB [fat01]> CREATE TABLE Products (
    -> productID INT UNSIGNED NOT NULL AUTO_INCREMENT,
    -> productCode CHAR(3) NOT NULL DEFAULT '',
    -> name VARCHAR(30) NOT NULL DEFAULT '',
    -> quantity INT UNSIGNED NOT NULL DEFAULT 0,
    -> price DECIMAL(7,2) NOT NULL DEFAULT 99999.99,
    -> PRIMARY KEY(productID)
    -> );
Query OK, 0 rows affected (0.02 sec)

MariaDB [fat01]> describe Products;
+-------------+------------------+------+-----+----------+----------------+
| Field       | Type             | Null | Key | Default  | Extra          |
+-------------+------------------+------+-----+----------+----------------+
| productID   | int(10) unsigned | NO   | PRI | NULL     | auto_increment |
| productCode | char(3)          | NO   |     |          |                |
| name        | varchar(30)      | NO   |     |          |                |
| quantity    | int(10) unsigned | NO   |     | 0        |                |
| price       | decimal(7,2)     | NO   |     | 99999.99 |                |
+-------------+------------------+------+-----+----------+----------------+
5 rows in set (0.00 sec)

MariaDB [fat01]> 
```

## Inserimenti

Tentiamo un primo inserimento
```
MariaDB [fat01]> INSERT INTO Products(productCode, name, quantity, price) VALUES ('PEN', 'Pen Red', 5000, 1.23);
Query OK, 1 row affected (0.01 sec)
```
Verifichiamo
```
MariaDB [fat01]> SELECT * FROM Products;
+-----------+-------------+---------+----------+-------+
| productID | productCode | name    | quantity | price |
+-----------+-------------+---------+----------+-------+
|         1 | PEN         | Pen Red |     5000 |  1.23 |
+-----------+-------------+---------+----------+-------+
1 row in set (0.00 sec)
```
Vediamo un doppio inserimento
```
MariaDB [fat01]> INSERT INTO Products VALUES
    -> (NULL, 'PEN', 'Pen Blue',  8000, 1.25),
    -> (NULL, 'PEN', 'Pen Black', 2000, 1.25);
Query OK, 2 rows affected (0.00 sec)
Records: 2  Duplicates: 0  Warnings: 0

MariaDB [fat01]> SELECT * FROM Products;+-----------+-------------+-----------+----------+-------+
| productID | productCode | name      | quantity | price |
+-----------+-------------+-----------+----------+-------+
|         1 | PEN         | Pen Red   |     5000 |  1.23 |
|         2 | PEN         | Pen Blue  |     8000 |  1.25 |
|         3 | PEN         | Pen Black |     2000 |  1.25 |
+-----------+-------------+-----------+----------+-------+
3 rows in set (0.00 sec)
```