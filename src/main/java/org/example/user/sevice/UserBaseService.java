package org.example.user.sevice;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.common.service.BaseService;
import org.example.user.entity.User;
import org.example.user.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserBaseService implements BaseService<User, UUID> {
    private static UserBaseService userService = new UserBaseService();
    private static UserRepository userRepository = new UserRepository();
    @Override
    public User findById(UUID uuid) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public User add(User user) {
        return null;
    }

    public UserBaseService getUserService(){
        return userService;
    }
}
