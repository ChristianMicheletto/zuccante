import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Phaser;


public class TestPhaser05 {
    public static void main(String[] args) {
        MyPhaser phaser = new MyPhaser();
        Student students[] = new Student[5];
        for (int i=0; i<students.length; i++){
            students[i] = new Student(phaser);
            phaser.register();
        }
        Thread threads[] = new Thread[students.length];
        for (int i=0; i<students.length; i++){
            threads[i]=new Thread(students[i],"Student "+i);
            threads[i].start();
        }
        for (int i=0; i<threads.length; i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Main: The phaser has finished: %s.\n",
          phaser.isTerminated());
    }
}
    
class MyPhaser extends Phaser{
    
    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase) {
            case 0:
                return studentsArrived();
            case 1:
                return finishFirstExercise();
            case 2:
                return finishSecondExercise();
            case 3:
                return finishExam();
            default:
                // STOP
                return true;
        }
    } 
    
    
    private boolean studentsArrived() {
        System.out.printf("Phaser: The exam are going to start. The students are ready.\n");
        System.out.printf("Phaser: We have %d students.\n", getRegisteredParties());
        System.out.printf("Phaser: fase # %d \n", getPhase());
        return false;
    }
    
    private boolean finishFirstExercise() {
        System.out.printf("Phaser: All the students have finished the first exercise.\n");
        System.out.printf("Phaser: It's time for the second one.\n");
        System.out.printf("Phaser: fase # %d \n", getPhase());
        return false;
    }
    
    private boolean finishSecondExercise() {
        System.out.printf("Phaser: All the students have finished the second exercise.\n");
        System.out.printf("Phaser: It's time for the second one.\n");
        System.out.printf("Phaser: fase # %d \n", getPhase());
        return false;
    }
    
    private boolean finishExam() {
        System.out.printf("Phaser: All the students have finished the exam.\n");
        System.out.printf("Phaser: Thank you for your time.\n");
        System.out.printf("Phaser: fase # %d \n", getPhase());
        // STOP phaser
        return true;
    }
}

class Student implements Runnable{
    
    private static Random rand = new Random((new Date()).getTime());
    private Phaser phaser;
    
    public Student(Phaser phaser) {
        this.phaser=phaser;
    }
    
    @Override
    public void run() {
        System.out.printf("%s: Has arrived to do the exam.%s\n",
          Thread.currentThread().getName(),new Date());
        // step 1
        phaser.arriveAndAwaitAdvance();
        System.out.printf("%s: Is going to do the first exercise.%s\n",
          Thread.currentThread().getName(),new Date());
        doExercise1();
        System.out.printf("%s: Has done the first exercise.%s\n",
          Thread.currentThread().getName(),new Date());
        // step 2
        phaser.arriveAndAwaitAdvance();
        System.out.printf("%s: Is going to do the second exercise.%s\n",
          Thread.currentThread().getName(),new Date());
        doExercise2();
        System.out.printf("%s: Has done the second exercise.%s\n",
          Thread.currentThread().getName(),new Date());
        // step 3
        phaser.arriveAndAwaitAdvance();
        System.out.printf("%s: Is going to do the third exercise.%s\n",
          Thread.currentThread().getName(),new Date());
        doExercise3();
        System.out.printf("%s: Has finished the exam. %s\n",
          Thread.currentThread().getName(),new Date());
        // step 4
        phaser.arriveAndAwaitAdvance();
    }
    
    private void doExercise1() {
        int sleepTime = rand.nextInt(5) + 1;
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    private void doExercise2() {
        int sleepTime = rand.nextInt(4) + 1;
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    private void doExercise3() {
        int sleepTime = rand.nextInt(6) + 1;
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
    
    
    
    
    

