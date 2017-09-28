public interface Subject { // Observable
    
    public void registerObserver(User observer);
    
    public void notifyObserver();
    
    public void unRegisterObserver(User observer);
    
    public Object getUpdate();
}
