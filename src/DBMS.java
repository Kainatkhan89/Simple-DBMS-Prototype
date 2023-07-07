package src;

import java.util.Scanner;

public class DBMS {
    public static void main(String[] args) {
        // Initialize dependencies
        Authentication authenticationModule = new Authentication();
        Database database = new Database();
        QueryProcessor queryProcessor = new QueryProcessor(database);
        ERDGenerator erdGenerator = new ERDGenerator(database);

        // Initialize users
        User user1 = new User("user1", "password1", "Question 1", "Answer 1");
        User user2 = new User("user2", "password2", "Question 2", "Answer 2");
        authenticationModule.registerUser(user1);
        authenticationModule.registerUser(user2);

        // Perform user authentication
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user ID: ");
        String userID = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter security question: ");
        String question = scanner.nextLine();
        System.out.print("Enter security question answer: ");
        String answer = scanner.nextLine();

        User authenticatedUser = authenticationModule.authenticateUser(userID, password, question, answer);
        if (authenticatedUser != null) {
            System.out.println("User authentication successful.");

            // User is authenticated, perform database operations here
            DBMSConsole console = new DBMSConsole(queryProcessor, erdGenerator, authenticatedUser);
            console.start();
        } else {
            System.out.println("User authentication failed. Exiting the application.");
        }

        scanner.close();
    }
}
