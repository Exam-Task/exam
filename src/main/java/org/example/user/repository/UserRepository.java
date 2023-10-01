package org.example.user.repository;

import lombok.*;
import org.example.common.entity.BaseEntity;
import org.example.common.repository.BaseRepository;
import org.example.user.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class UserRepository extends BaseRepository<UUID, User> {
    private static final UserRepository userRepository = new UserRepository();

    {
        entities = new HashMap<>();
    }
    public UserRepository getInstance() {
        return userRepository;
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
}
