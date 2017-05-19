# AUthentication

Procediamo colla creazione della tabella
```
MariaDB [fat02]> CREATE TABLE Users(id INT UNSIGNED NOT NULL AUTO_INCREMENT, username VARCHAR(45) NOT NULL, password VARCHAR(90) NOT NULL, PRIMARY KEY(id));
Query OK, 0 rows affected (0.02 sec)
```
definiamo la password per il nostro utente; entriamo con `php -a` nella "shell" di php
```
php > echo password_hash('zuccante@2017', PASSWORD_DEFAULT);
$2y$10$xo3ILZfojMg3h7AVNWw9iejE1sNaTdSmgE6xTrSDMCCNnQr4oMrOC
php > echo password_hash('zuccante@2017', PASSWORD_DEFAULT);
$2y$10$3vtcySRZBuf6XR691JrOj.f5bU4CFjUnVcg6wHTTvUMys0K6rbA5y
```
Volutamente abbiamo eseguito due vole la stessa funzione con gli stessi argomenti).
```
MariaDB [fat02]> INSERT INTO Users VALUES(NULL, 'cicci0', '$2y$10$xo3ILZfojMg3h7AVNWw9iejE1sNaTdSmgE6xTrSDMCCNnQr4oMrOC');
Query OK, 1 row affected (0.01 sec)

MariaDB [fat02]> select * FROM Users;
+----+----------+--------------------------------------------------------------+
| id | username | password                                                     |
+----+----------+--------------------------------------------------------------+
|  1 | cicci0   | $2y$10$xo3ILZfojMg3h7AVNWw9iejE1sNaTdSmgE6xTrSDMCCNnQr4oMrOC |
+----+----------+--------------------------------------------------------------+
1 row in set (0.00 sec)
```

## Note

Il nostro esempio è ovviamente semplice e gravemente insicuro, quindi un riferimento per un tutorial di approfondimento: [qui](https://www.phpclasses.org/blog/package/10087/post/1-secure-login-and-registration-system.html).

## Riferimenti

1. Bootstrap su W3school: [qui](https://www.w3schools.com/bootstrap/).
2. Bootstrap home page: [qui](http://getbootstrap.com/).

