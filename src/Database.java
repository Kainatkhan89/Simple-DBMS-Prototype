package src;

import java.util.HashMap;
import java.util.Map;

public class Database {
    private Map<String, Table> tables;

    public Database() {
        this.tables = new HashMap<>();
    }

    public void createTable(String tableName) {
        // Implement table creation logic
    }

    public void dropTable(String tableName) {
        // Implement table dropping logic
    }

    public void insert(String tableName, Map<String, Object> values) {
        // Implement row insertion logic
    }

    public void select(String tableName) {
        // Implement table selection logic
    }
}
