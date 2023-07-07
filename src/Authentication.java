package src;

import java.util.HashMap;
import java.util.Map;

public class Authentication {
    private Map<String, User> users;

    public Authentication() {
        this.users = new HashMap<>();
    }

    public void registerUser(User user) {
        users.put(user.getUserID(), user);
    }

    public User authenticateUser(String userID, String password, String question, String answer) {
        if (users.containsKey(userID)) {
            User user = users.get(userID);
            if (user.authenticate(password, question, answer)) {
                return user;
            }
        }
        return null;
    }
}
