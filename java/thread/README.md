#Thread

Imparare i thread leggendo i sorgenti, ecco la proposta per un percorso ...

- primi esempi (task runnable e thread)
```
HelloThread
HelloRunnable
HelloRunnable2
```
- più thread che corrono ...
```
PingPong
PingPong2
RunPingPong
```
- sleep (e interruzioni)
```
FileClock 
```
con il suo Test
- stati di un Thread
```
TestCalculator
```
- join
```
TestDataDownload
TestJoin
TestJoinAgain
Simplethread
```
- group of thread
```
TestSearchTask
```
- semafori e lock per gestire una o più risorse non condivisibili
```
TestPrintQueue
TestPrintQueueAgain
TestProducerConsumer // 
TestProducerConsumer2 // 
ThreadSafeArrayList<E>
```
- Sincronizzazione avanzata fra thread
```
TestVidecongerences
TestWorker 
TestCounting
TestPhaser01: phaser as a sort of CyclicBarrier
TestPhaser02
TestPhaser03: override onAdvance()
TestPhaser05: anothe example with onAdvance()
TestPhaser04: bulkRegister()
```
- Exchanger
```
TestProducerConsumer4
```
- block synchronizing
```
TestCinema
```
- methods synchronizing
vedi java tutorial
- Callable
```
TestCallable01.java
```
- executors
```
Executor01.java
Executor02.java
Executor03.java
```

## Materiali

[1] Java Lambda Expressions, J.Jenkov: [qui](http://tutorials.jenkov.com/java/lambda-expressions.html).  
[2] Concorrenza in java 9, un tutorial: [qui](http://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/).

