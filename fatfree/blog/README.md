# Blog

Per prima cosa creiamo le tabelle
```
MariaDB [fatblog]> CREATE TABLE Articles (
    -> id INT NOT NULL AUTO_INCREMENT,
    -> timestamp DATETIME NOT NULL,
    -> title VARCHAR(120) NOT NULL,
    -> summary VARCHAR(120) NOT NULL,
    -> content TEXT NOT NULL,
    -> author VARCHAR(120) NOT NULL,
    -> PRIMARY KEY(id));
```
per gli utenti abbiamo
```
MariaDB [fatblog]> CREATE TABLE Users(
    -> id INT NOT NULL AUTO_INCREMENT,
    -> name VARCHAR(200) NOT NULL,
    -> password VARCHAR(20) NOT NULL,
    -> PRIMARY KEY(id));
```
Inseriamo due post
```
MariaDB [fatblog]> INSERT INTO Articles VALUES
    -> (NULL, '2011-07-28 02:03:14', 'Hello World!', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut ', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'Mr White'),
    -> (NULL, '2011-07-28 02:03:14', 'More Hello World!', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut ', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'Mr Green');
Query OK, 2 rows affected, 2 warnings (0.00 sec)
Records: 2  Duplicates: 0  Warnings: 2
```

