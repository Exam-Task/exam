package org.example.user.sevice;

import lombok.*;
import org.example.common.service.BaseService;
import org.example.user.entity.User;
import org.example.user.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService implements BaseService<User, UUID> {
    private static final UserService userService = new UserService();
    private static final UserRepository userRepository = UserRepository.getInstance();
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


    public User getByUsername(String username, String password){
        User byUsername = userRepository.getByUsername(username);
        if (byUsername!=null){
            if (byUsername.getPassword().equals(password)){
                return byUsername;
            }
        }
        return null;
    }

    public static UserService getUserService(){
        return userService;
    }

}
