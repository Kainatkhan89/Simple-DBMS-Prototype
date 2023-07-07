package src;

public class User {
    private String userID;
    private String password;
    private String question;
    private String answer;

    public User(String userID, String password, String question, String answer) {
        this.userID = userID;
        this.password = password;
        this.question = question;
        this.answer = answer;
    }

    public String getUserID() {
        return userID;
    }

    public boolean authenticate(String password, String question, String answer) {
        // Implement authentication logic
        return this.password.equals(password) && this.question.equals(question) && this.answer.equals(answer);
    }
}
