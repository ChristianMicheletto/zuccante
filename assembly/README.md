## Un fugace avvicinamento ad Assembly e alle chiamate a sistema

Sperimentiamo coi seguenti file in modo da vedere come un programma scritto in linguaggio di alto livello debba per forza interagire con OS.

- hello_64.c: un sorgente C che stampa "Hello World": usa le chiamate a sistema del processore INTEL a 64 bit.
- hello_64.asm: un sorgente Assembly che fa la stessa cosa del file precedente; usiamo [nasm](http://www.nasm.us/).
- hello_386.asm: con le direttive per il processore a 32 bit (non usa `syscall`.

Partiamo dall'Assembly
```
nasm -f elf64 -l hello.lst  hello_64.asm
```
otteniamo il file `hello.list`, per ottenere il modulo oggetto
```
nasm -f elf64 hello_64.asm
```
ed infine per linkare
```
ld -s -o hello hello_64.o
```

E' possibile usare il comando 
```
gcc -S -masm=intel hello_64.c
```
per tradurre in Assembly INTEL (quello del nasm) il sorgente in C. Qui apparendo l'etichetta `main` possiamo utilizzare `gcc` anche per linkare.

### Uso di gcc
- `gcc`: ottiene l'eseguibile `a.out`, per ottenere un eseguibile con nome:

`
gcc -o hello hello.c
`
- `gcc -c`: compila (ottiene il modulo oggetto)
- `gcc -o`	: ottieni l'eseguibile (linking).
- Esempio di linking del modulo oggetto:

`
gcc -o hello hello.o
`
- `gcc -S`: dal file in C a quello in assembly (sintassi ATNT, aggiungere in caso opzione `-masm=intel`.

### Documentazione

[1] Una dispensa (solo 32bit): [qui](https://pacman128.github.io/static/pcasm-book-italian.pdf).

[2] Per un'introduzione a nasm a 64 bit: [qui](http://www.lomont.org/Math/Papers/2009/Introduction%20to%20x64%20Assembly.pdf).