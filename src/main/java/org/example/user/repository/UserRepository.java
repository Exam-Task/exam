package org.example.user.repository;

import lombok.*;
import lombok.experimental.StandardException;
import org.example.common.entity.BaseEntity;
import org.example.common.repository.BaseRepository;
import org.example.user.entity.User;
import org.example.user.entity.UserType;

import java.sql.*;
import java.util.*;


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

    public User findByUserName(String userName) {
        ArrayList<User> users = new ArrayList<>(entities.values());
        for (User user : users) {
            if (user.getUsername().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    @SneakyThrows
    private void putAllUserToMap() {
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
            user.setName(name);
            user.setSurname(surname);
            user.setUsername(userName);
            user.setPassword(password);

            entities.put(user.getId(), user);
        }
    }

    public User getByUsername(String username){
        return null;
    }


    public static UserRepository getInstance() {
        return userRepository;
    }
}
