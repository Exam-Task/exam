package org.example.sqlQueries;

import lombok.SneakyThrows;
import org.example.common.repository.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.UUID;

public class SqlQueries {


    public static String jdbcUrl;
    public static String username;
    public static String password;

    static {
        Property.createProperty();
        List<String> property = Property.getProperty();
        if (property != null) {
            jdbcUrl = property.get(0);
            username = property.get(1);
            password = property.get(2);

        }
    }


    @SneakyThrows
    public static Connection connection() {
        return DriverManager.getConnection(jdbcUrl, username, password);
    }














    public static String getAllQuery(){
        return """
                select * from "%s";
                """;
    }


    public static String add(){
        return """
                """;
    }

    public static String delete(){
        return """
                """;
    }

    public static String findByID(String from, String id){
        return """
                select * from "%s"
                    where id = %s
                """;
    }






}
