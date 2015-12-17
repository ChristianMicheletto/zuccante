import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import com.google.gson.GSON;


public class ToJson {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd"); 
        User user1 = null;
        User user2 = null;
        try {
            user1 = new User(1, "Luca", "Avatar", sdf.parse("2039-04-12"));
            user2 = new User(2, "Andrea", "Morettin", sdf.parse("1971-03-17"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        
        Gson gson = new Gson();     
        String userJson = gson.toJson(user1);        
        System.out.println(userJson);
        String usersJson = gson.toJson(users);
        System.out.println(usersJson);
    }
}
