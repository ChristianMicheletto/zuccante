# gradle 07
1) Per prima cosa creiamo il progetto
```
gradle init --type java-library
```
2) Come secondo passo prendiamo in mano `build.gradle` e modifichiamolo all'uopo. Dovremo toccare il task `jar` in modo da impostare gli attributi del manifest del jar come da documentazione Oracle: [qui](http://docs.oracle.com/javase/7/docs/technotes/guides/jar/jar.html).
```
jar {
    manifest {
        attributes 'Main-Class': 'HelloWorld'
    }
}
```
eseguire il task
```
gradle jar
```
ottenendo così il jar (andare a verificare al suo interno il manifest). 
3) Quindi tentare l'esecuzione
```
java -jar gradle07.jar
```
4) con
```
gradle clean
```
si cancella il tutto.
