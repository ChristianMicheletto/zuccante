import java.io.Serializable;
import java.util.Date;
 
public class User implements Serializable {
    private Integer id;
    private String name;
    private String surname;
    private Date birtday;
    
    public User(Integer id, String name, String surname, Date birtday){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birtday = birtday;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirtday() {
        return birtday;
    }

    public void setBirtday(Date birtday) {
        this.birtday = birtday;
    }

    @Override
    public String toString() {
        return String.format("User [id=%s, name=%s, surname=%s, birtday=%s]", id, name, surname, birtday);
    }
}
