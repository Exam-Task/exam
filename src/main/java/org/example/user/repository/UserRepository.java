package org.example.user.repository;

import lombok.*;
import org.example.common.entity.BaseEntity;
import org.example.user.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class UserRepository extends BaseEntity<UUID> {
    private static final UserRepository userRepository = new UserRepository();
    private static final Map<UUID, User> users = new HashMap<>();

    public UserRepository getInstance() {
        return userRepository;
    }

    public User getById(UUID userId){
        return users.get(userId);
    }
    public User getAll(UUID userId){
        return users.get(userId);
    }
    public User addUser(UUID userId){
        return users.get(userId);
    }

    public void deleteUser(UUID userId){
        users.remove(userId);
    }
}
