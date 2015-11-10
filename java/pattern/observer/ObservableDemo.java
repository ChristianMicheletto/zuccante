import java.util.Observable;

public class ObservableDemo extends Observable {

    private String weather;
	 
    public ObservableDemo(String weather) {
        this.weather = weather;
    }
	    
    public String getWeather() {
        return weather;
    }
	 
    public void setWeather(String weather) {
        this.weather = weather;
        
        // Marks this Observable object as having been changed; the hasChanged method will now return true.
        setChanged();
        
        // if this object has changed, as indicated by the hasChanged method, 
        // then notify all of its observers and then call the clearChanged method 
        // to indicate that this object has no longer changed.
        //
        // ********************************** SCHEMA ************************************************************
        // setChanged() -> hasChanged return TRUE -> notifyObservers() -> clearChanged -> hasChanged return FALSE
        // ******************************************************************************************************
        
        notifyObservers();
    }
}
