# I/O Stream in Java

In questo repository sono contenuti i sorgenti per le lezioni e le esercitazioni nella programmazione con gli Stream
, programmazione di tipo ""sincrono".
```
CopyBytes.java
CopyCharacters.java
```
In questi due primi esempi vediamo come copiare byte o caratteri da file a file.
In particolare si consideri l'esempio
```
CopyCharactersBuffered.java
```
e l'uso del metodo flush. Si vada a leggere la documentazione per l'interfaccia `AutoCloseable` (Java 8) e pure l'interfaccia `Closeable`.
```
Copy.java
PipeExample.java
```
si muovono sulla stessa lunghezza d'onda.
```
TestFlushAgain.java
```
un altro esempio con `flush()`.

## Guide ed approfondimenti

[1] [Java I/O tutorial](http://tutorials.jenkov.com/java-io/index.html) di J.Jenkov.
