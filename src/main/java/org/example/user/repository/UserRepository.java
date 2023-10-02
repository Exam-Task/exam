package org.example.user.repository;

import lombok.*;
import lombok.experimental.StandardException;
import org.example.common.entity.BaseEntity;
import org.example.common.repository.BaseRepository;
import org.example.user.entity.User;
import org.example.user.entity.UserType;

import java.sql.*;
import java.util.*;

import static org.example.user.entity.UserType.ADMIN;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString(callSuper = true)
public class UserRepository extends BaseRepository<UUID, User> {
    public static String jdbcUrl = "jdbc:postgresql://localhost:5432/questions";
    public static String username = "postgres";
    public static String password = "2211";
    private static final UserRepository userRepository = new UserRepository();

    @SneakyThrows
    public static Connection connection() {
        return DriverManager.getConnection(jdbcUrl, username, password);
    }

    {
        entities = new HashMap<>();
    }

    @SneakyThrows
    public User getByUsername(String username) {

        String getByUsernameQuery = """
                select * from "user" where name = ?;
                """;
        PreparedStatement preparedStatement = connection().prepareStatement(getByUsernameQuery);
        preparedStatement.setString(1, username);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String id = resultSet.getString("id");
            String userType = resultSet.getString("user_type");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String userName = resultSet.getString("username");
            String password = resultSet.getString("password");

            User user = new User();

            user.setUserId(UUID.fromString(id));
            user.setUserType(UserType.valueOf(userType));
            user.setUsername(username);
            user.setName(name);
            user.setSurname(surname);
            user.setPassword(password);

            connection().close();

            return user;
        }
        return null;
    }

    @SneakyThrows
    public List<User> getAll() {

        String getAllUserQuery = """
                select * from "user";
                """;
        PreparedStatement preparedStatement = connection().prepareStatement(getAllUserQuery);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String userType = resultSet.getString("user_type");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String userName = resultSet.getString("username");
            String password = resultSet.getString("password");

            User user = new User();

            user.setUserId(UUID.fromString(id));
            user.setUserType(UserType.valueOf(userType));
            user.setUsername(userName);
            user.setName(name);
            user.setSurname(surname);
            user.setPassword(password);

            entities.put(user.getUserId(), user);
        }
        return entities.values().stream().toList();

    }


    @SneakyThrows
    public void deleteUserById(UUID id) {

        String deleteUserQuery = """
                delete from "user"
                where id = ?
                """;
        PreparedStatement preparedStatement = connection().prepareStatement(deleteUserQuery);
        preparedStatement.setObject(1, id);

        preparedStatement.executeUpdate();

    }

    @SneakyThrows
    public void updateUserById(UUID id, UserType userType, String name, String surname, String username, String password) {

        String updateUserQuery = """
                update "user" 
                set user_type = cast(? as user_type),
                    name      = ?,
                    surname   = ?,
                    username  = ?,
                    password  = ?
                where id = ?;
                """;
        PreparedStatement preparedStatement = connection().prepareStatement(updateUserQuery);
        preparedStatement.setString(1, userType.name());
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, surname);
        preparedStatement.setString(4, username);
        preparedStatement.setString(5, password);
        preparedStatement.setObject(6, id);

        preparedStatement.executeUpdate();
    }


    // Create yozisk kerak
    public static UserRepository getInstance() {
        return userRepository;
    }
}
