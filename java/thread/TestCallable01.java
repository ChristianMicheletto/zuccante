import java.util.*;
import java.util.concurrent.*;



public class TestCallable01 {
    
    public static class WordLengthCallable implements Callable<Integer> {
        
        static Random ran = new Random();
        
        private String word;
        
        public WordLengthCallable(String word) {
            this.word = word;
        }
        
        @Override
        public Integer call() {
            int s = 2 + ran.nextInt(4);
            try {
                Thread.sleep(s*1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(word + " after " +s + " seconds");
            return Integer.valueOf(word.length());
        }
    }

    public static void main(String args[]) throws Exception {
        
        ExecutorService pool = Executors.newFixedThreadPool(3);
        
        Set<Future<Integer>> set = new HashSet<>();
        String[] words = {"ciao", "miao", "bau", "wow", "frrrr"};
        List<String> list = new ArrayList<String>(words.length);
        for (String s : words) {
            list.add(s);
        }
        Collections.shuffle(list);
        for (String word: list) {
            Callable<Integer> callable = new WordLengthCallable(word);
            Future<Integer> future = pool.submit(callable);
            set.add(future);
        }
        int sum = 0;
        
        for (Future<Integer> future : set) {
            sum += future.get();
        }
        System.out.printf("The sum of lengths is %s%n", sum);
        //shut down the executor service now
        pool.shutdown();
        System.exit(sum);
    }
}
