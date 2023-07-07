package src;

import java.util.Scanner;

public class DBMSConsole {
    private QueryProcessor queryProcessor;
    private ERDGenerator erdGenerator;
    private User currentUser;

    public DBMSConsole(QueryProcessor queryProcessor, ERDGenerator erdGenerator, User currentUser) {
        this.queryProcessor = queryProcessor;
        this.erdGenerator = erdGenerator;
        this.currentUser = currentUser;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter SQL query (or 'EXIT' to quit): ");
            String query = scanner.nextLine();

            if (query.equalsIgnoreCase("EXIT")) {
                break;
            }

            if (queryProcessor.isTransaction(query)) {
                Transaction transaction = queryProcessor.processTransaction(query);
                if (transaction != null) {
                    System.out.println("Transaction processed successfully.");
                    transaction.commit();
                } else {
                    System.out.println("Transaction processing failed.");
                }
            } else {
                boolean success = queryProcessor.processQuery(query);
                if (success) {
                    System.out.println("Query processed successfully.");
                } else {
                    System.out.println("Query processing failed.");
                }
            }
        }

        scanner.close();
    }
}
