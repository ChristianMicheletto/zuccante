
public class Rx001 {
    
    public static void main(Atring[] args){
        
        Observable<String> myObservable = Observable.create(
            new Observable.OnSubscribe<String>() {
        
            @Override
            public void call(Subscriber<? super String> sub) {
                sub.onNext("Hello, world!");
                sub.onCompleted();
            }
        }
    );
}

